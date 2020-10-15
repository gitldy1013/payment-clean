package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.annotation.EncrField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/** 扩展BeanUtils.copyProperties支持data类型 */
@Slf4j
public class BeanUtilsEx extends BeanUtils {

  static {
    ConvertUtils.register(new DateConvert(), java.util.Date.class);
    ConvertUtils.register(new DateConvert(), String.class);
  }

  public static void copyProperties(Object target, Object source) {
    // 支持对日期copy
    try {
      org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
    } catch (IllegalAccessException | InvocationTargetException e) {
      log.error("扩展BeanUtils.copyProperties支持data类型出错:" + e.getMessage());
      log.error("异常:" + e);
    }
  }

  public static <T> T getEncrBean(T bean, byte[] symmetricKeyEncoded) {
    Field[] fields = bean.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.getType().equals(List.class)) {
        // List集合
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
          if (!field.isAccessible()) {
            field.setAccessible(true);
          }
          // 获取到属性值的字节码
          try {
            Class<?> clzz = field.get(bean).getClass();
            // 反射调用获取到list的size方法来获取到集合的大小
            Method sizeMethod = clzz.getDeclaredMethod("size");
            if (!sizeMethod.isAccessible()) {
              sizeMethod.setAccessible(true);
            }
            // 集合长度
            int size = (int) sizeMethod.invoke(field.get(bean));
            // 循环遍历获取到数据
            for (int i = 0; i < size; i++) {
              // 反射获取到list的get方法
              Method getMethod = clzz.getDeclaredMethod("get", int.class);
              // 调用get方法获取数据
              if (!getMethod.isAccessible()) {
                getMethod.setAccessible(true);
              }
              getEncrBean(getMethod.invoke(field.get(bean), i), symmetricKeyEncoded);
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      } else if (field.isAnnotationPresent(EncrField.class)) {
        try {
          String fieldName = field.getName();
          String setMethodName =
              "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
          Method setMethod = bean.getClass().getMethod(setMethodName, String.class);
          String getMethodName =
              "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
          doEncrField(
              bean, symmetricKeyEncoded, field, field.getAnnotation(EncrField.class).value());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          log.error("反射加密信息异常", e);
        }
      } else if (field.getType().getName().startsWith("com.cmcc.paymentclean.entity.dto")
          || "body".equals(field.getName())) {
        try {
          getEncrBean(field.get(bean), symmetricKeyEncoded);
        } catch (IllegalAccessException e) {
          log.error("反射加密信息异常", e);
        }
      }
    }
    return bean;
  }

  /** 加密 */
  private static <T> void doEncrField(
      T bean, byte[] symmetricKeyEncoded, Field field, String getDocType)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    String fieldName = field.getName();
    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    Method setMethod = bean.getClass().getMethod(setMethodName, String.class);
    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    if (getDocType == null) {
      Method getMethod = bean.getClass().getMethod(getMethodName);
      Object getValue = getMethod.invoke(bean);
      setMethod.invoke(bean, CFCACipherUtils.encrypt(symmetricKeyEncoded, getValue.toString()));
    } else {
      Method getDocTypeMethod = bean.getClass().getMethod(getDocType);
      Object getDocTypeValue = getDocTypeMethod.invoke(bean);
      Method getMethod = bean.getClass().getMethod(getMethodName);
      Object getValue = getMethod.invoke(bean);
      setMethod.invoke(
          bean,
          CFCACipherUtils.getInnerToCFCA(
              getDocTypeValue.toString(), getValue.toString(), symmetricKeyEncoded));
    }
  }
}

package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.annotation.EncrField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
      source = checkNull(source);
      org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
    } catch (IllegalAccessException | InvocationTargetException e) {
      log.error("扩展BeanUtils.copyProperties支持data类型出错:" + e.getMessage());
      log.error("异常:" + e);
    }
  }

  public static Object checkNull(Object obj) {
    Class<? extends Object> clazz = obj.getClass();
    // 获取实体类的所有属性，返回Field数组
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      // 可访问私有变量
      ReflectionUtils.makeAccessible(field);
      // 获取属性类型
      String type = field.getGenericType().toString();
      if (!Modifier.toString(field.getModifiers()).contains("static")) {
        // 将属性的首字母大写
        String methodName =
            field
                .getName()
                .replaceFirst(
                    field.getName().substring(0, 1), field.getName().substring(0, 1).toUpperCase());
        try {
          Method methodGet = clazz.getMethod("get" + methodName);
          // 调用getter方法获取属性值
          Object o = methodGet.invoke(obj);
          if (o == null) {
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if ("class java.lang.String".equals(type)) {
              field.set(obj, field.getType().getConstructor(field.getType()).newInstance(""));
            } else if ("class java.util.Date".equals(type)) {
              field.set(obj, field.getType().getConstructor().newInstance());
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return obj;
  }

  public static <T> T getEncrBean(T bean, byte[] symmetricKeyEncoded) {
    Field[] fields = bean.getClass().getDeclaredFields();
    for (Field field : fields) {
      ReflectionUtils.makeAccessible(field);
      if (field.getType().equals(List.class)) {
        // List集合
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
          if (!field.isAccessible()) {
            ReflectionUtils.makeAccessible(field);
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
  private static <T> void doEncrField(T bean, byte[] symmetricKeyEncoded, Field field, String flag)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    String fieldName = field.getName();
    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    Method setMethod = bean.getClass().getMethod(setMethodName, String.class);
    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    if (StringUtils.isEmpty(flag)) {
      Method getMethod = bean.getClass().getMethod(getMethodName);
      Object getValue = getMethod.invoke(bean);
      setMethod.invoke(bean, CFCACipherUtils.encrypt(symmetricKeyEncoded, getValue.toString()));
    } else {
      /*Method getDocTypeMethod = bean.getClass().getMethod("get" + flag);
      Object getDocTypeValue = getDocTypeMethod.invoke(bean);*/
      Method getMethod = bean.getClass().getMethod(getMethodName);
      Object getValue = getMethod.invoke(bean);
      if ("BankNo".equals(flag)){
        setMethod.invoke(bean,
                CFCACipherUtils.getInnerByBankNoToCFCA(getValue.toString(), symmetricKeyEncoded));
      }else {
        setMethod.invoke(bean,
                // CFCACipherUtils.getInnerToCFCA(getDocTypeValue.toString(), getValue.toString(), symmetricKeyEncoded));
                CFCACipherUtils.getInnerToCFCA(getValue.toString(), symmetricKeyEncoded));
      }

    }
  }

  /**
   * 检查对象字段 全部不为空返回true 否则返回false
   *
   * @param obj
   * @return
   */
  public static boolean checkObjFieldIsNotNull(Object obj) {
    try {
      for (Field f : obj.getClass().getDeclaredFields()) {
        f.setAccessible(true);
        if (f.get(obj) == null || StringUtils.isEmpty(f.get(obj).toString().trim())) {
          return false;
        }
      }
    } catch (IllegalAccessException e) {
      log.error("错误:", e);
    }
    return true;
  }
}

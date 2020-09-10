package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 封装了XML转换成object，object转换成XML的代码
 */
@Slf4j
public class BeanUtils {

    /*
    什么是JAXB
    1、JDK中JAXB相关的重要Class和Interface

    JAXBContext类，是应用的入口，用于管理XML/Java绑定信息。
    Marshaller接口，将Java对象序列化为XML数据。
    Unmarshaller接口，将XML数据反序列化为Java对象。

    2、JDK中JAXB相关的重要Annotation

    @XmlType，
    将Java类或枚举类型映射到XML模式类型

    @XmlAccessorType(XmlAccessType.FIELD) ，
    控制字段或属性的序列化。FIELD表示JAXB将自动绑定Java类中的每个非静态的（static）、非瞬态的（由@XmlTransient标注）字段到XML。其他值还有XmlAccessType.PROPERTY和XmlAccessType.NONE。

    @XmlAccessorOrder，
    控制JAXB 绑定类中属性和字段的排序。

    @XmlJavaTypeAdapter，
    使用定制的适配器（即扩展抽象类XmlAdapter并覆盖marshal()和unmarshal()方法），以序列化Java类为XML。

    @XmlElementWrapper ，
    对于数组或集合（即包含多个元素的成员变量），生成一个包装该数组或集合的XML元素（称为包装器）。

    @XmlRootElement，
    将Java类或枚举类型映射到XML元素。

    @XmlElement，
    将Java类的一个属性映射到与属性同名的一个XML元素。

    @XmlAttribute，
    将Java类的一个属性映射到与属性同名的一个XML属性。

    在以上的注解中，用的最多的是@XMLType，@XmlAccessorType，@XmlRootElement。
     */

    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     */
    public static String convertToXml(Object obj, String path) {
        FileWriter fw = null;
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            // 创建输出流
            fw = new FileWriter(path);
            marshaller.marshal(obj, fw);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        assert fw != null;
        return fw.toString();
    }

    /**
     * 将String类型的xml转换成对象
     *
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     *
     * @param clazz
     * @param xmlPath
     * @return
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            fr = new FileReader(xmlPath);
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }
}

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.13 时间 05:20:27 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "docCode",
    "regName"
})
@XmlRootElement(name = "BaseInfo")
public class BaseInfo {

    @XmlElement(name = "DocCode", required = true)
    protected String docCode;
    @XmlElement(name = "RegName", required = true)
    protected String regName;

    /**
     * 获取docCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * 设置docCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocCode(String value) {
        this.docCode = value;
    }

    /**
     * 获取regName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegName() {
        return regName;
    }

    /**
     * 设置regName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegName(String value) {
        this.regName = value;
    }

}

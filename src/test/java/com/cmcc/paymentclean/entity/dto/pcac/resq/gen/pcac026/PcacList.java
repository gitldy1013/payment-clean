//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.15 时间 09:05:55 AM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}BaseInfo"/>
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
    "count",
    "baseInfo"
})
@XmlRootElement(name = "PcacList")
public class PcacList {

    @XmlElement(name = "Count", required = true)
    protected String count;
    @XmlElement(name = "BaseInfo", required = true)
    protected BaseInfo baseInfo;

    /**
     * 获取count属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置count属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCount(String value) {
        this.count = value;
    }

    /**
     * 获取baseInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseInfo }
     *     
     */
    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    /**
     * 设置baseInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseInfo }
     *     
     */
    public void setBaseInfo(BaseInfo value) {
        this.baseInfo = value;
    }

}

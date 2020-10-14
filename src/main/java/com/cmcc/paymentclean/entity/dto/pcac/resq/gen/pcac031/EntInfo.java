//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.14 时间 10:31:22 AM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac031;

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
 *         &lt;element name="CusType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CheckState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CheckDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cusType",
    "regName",
    "cusCode",
    "docType",
    "docCode",
    "checkState",
    "checkDesc"
})
@XmlRootElement(name = "EntInfo")
public class EntInfo {

    @XmlElement(name = "CusType", required = true)
    protected String cusType;
    @XmlElement(name = "RegName", required = true)
    protected String regName;
    @XmlElement(name = "CusCode", required = true)
    protected String cusCode;
    @XmlElement(name = "DocType", required = true)
    protected String docType;
    @XmlElement(name = "DocCode", required = true)
    protected String docCode;
    @XmlElement(name = "CheckState", required = true)
    protected String checkState;
    @XmlElement(name = "CheckDesc", required = true)
    protected String checkDesc;

    /**
     * 获取cusType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusType() {
        return cusType;
    }

    /**
     * 设置cusType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusType(String value) {
        this.cusType = value;
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

    /**
     * 获取cusCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusCode() {
        return cusCode;
    }

    /**
     * 设置cusCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusCode(String value) {
        this.cusCode = value;
    }

    /**
     * 获取docType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 设置docType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
    }

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
     * 获取checkState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckState() {
        return checkState;
    }

    /**
     * 设置checkState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckState(String value) {
        this.checkState = value;
    }

    /**
     * 获取checkDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckDesc() {
        return checkDesc;
    }

    /**
     * 设置checkDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckDesc(String value) {
        this.checkDesc = value;
    }

}

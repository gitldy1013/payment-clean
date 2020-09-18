//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 12:44:26 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046;

import lombok.Data;

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
 *         &lt;element ref="{}CusType"/>
 *         &lt;element ref="{}RegName"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}HandleResult"/>
 *         &lt;element ref="{}HandleTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cusType",
    "regName",
    "currency",
    "amount",
    "docType",
    "docCode",
    "handleResult",
    "handleTime"
})
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

    @XmlElement(name = "CusType", required = true)
    protected String cusType;
    @XmlElement(name = "RegName", required = true)
    protected String regName;
    @XmlElement(name = "Currency", required = true)
    protected Object currency;
    @XmlElement(name = "Amount", required = true)
    protected Object amount;
    @XmlElement(name = "DocType", required = true)
    protected String docType;
    @XmlElement(name = "DocCode", required = true)
    protected String docCode;
    @XmlElement(name = "HandleResult", required = true)
    protected String handleResult;
    @XmlElement(name = "HandleTime", required = true)
    protected String handleTime;

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
     * 获取currency属性的值。
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getCurrency() {
        return currency;
    }

    /**
     * 设置currency属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setCurrency(Object value) {
        this.currency = value;
    }

    /**
     * 获取amount属性的值。
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setAmount(Object value) {
        this.amount = value;
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
     * 获取handleResult属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHandleResult() {
        return handleResult;
    }

    /**
     * 设置handleResult属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHandleResult(String value) {
        this.handleResult = value;
    }

    /**
     * 获取handleTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHandleTime() {
        return handleTime;
    }

    /**
     * 设置handleTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHandleTime(String value) {
        this.handleTime = value;
    }

}

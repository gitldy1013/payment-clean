//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:52 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045;

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
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CusType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HandleResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HandleTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HandleNote" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "cusType",
    "handleResult",
    "handleTime",
    "handleNote",
    "currency",
    "amount"
})
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "CusType", required = true)
    protected String cusType;
    @XmlElement(name = "HandleResult", required = true)
    protected String handleResult;
    @XmlElement(name = "HandleTime", required = true)
    protected String handleTime;
    @XmlElement(name = "HandleNote", required = true)
    protected String handleNote;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Amount", required = true)
    protected String amount;

    /**
     * 获取id属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

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

    /**
     * 获取handleNote属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHandleNote() {
        return handleNote;
    }

    /**
     * 设置handleNote属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHandleNote(String value) {
        this.handleNote = value;
    }

    /**
     * 获取currency属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置currency属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * 获取amount属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmount(String value) {
        this.amount = value;
    }

}

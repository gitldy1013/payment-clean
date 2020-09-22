//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 11:15:58 AM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028;

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
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}LegDocName"/>
 *         &lt;element ref="{}LegDocType"/>
 *         &lt;element ref="{}LegDocCode"/>
 *         &lt;element ref="{}Level"/>
 *         &lt;element ref="{}RiskType"/>
 *         &lt;element ref="{}ValidDate"/>
 *         &lt;element ref="{}ValidStatus"/>
 *         &lt;element name="CusType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Occurarea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BankNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisteredCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cusCode",
    "regName",
    "legDocName"

})
@XmlRootElement(name = "Differents")
public class Differents {

    @XmlElement(name = "CusCode", required = true)
    protected String cusCode;
    @XmlElement(name = "RegName", required = true)
    protected String regName;
    @XmlElement(name = "LegDocName", required = true)
    protected String legDocName;

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getLegDocName() {
        return legDocName;
    }

    public void setLegDocName(String legDocName) {
        this.legDocName = legDocName;
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

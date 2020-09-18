//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 12:21:11 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac032;

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
 *         &lt;element name="SignNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignCurrentNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignCurrentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BlackNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RiskNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
import lombok.Data;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signNum",
    "signCurrentNum",
    "signCurrentState",
    "blackNum",
    "riskNum"
})
@XmlRootElement(name = "BaseInfo")
public class BaseInfo {

    @XmlElement(name = "SignNum", required = true)
    protected String signNum;
    @XmlElement(name = "SignCurrentNum", required = true)
    protected String signCurrentNum;
    @XmlElement(name = "SignCurrentState", required = true)
    protected String signCurrentState;
    @XmlElement(name = "BlackNum", required = true)
    protected String blackNum;
    @XmlElement(name = "RiskNum", required = true)
    protected String riskNum;

    /**
     * 获取signNum属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSignNum() {
        return signNum;
    }

    /**
     * 设置signNum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSignNum(String value) {
        this.signNum = value;
    }

    /**
     * 获取signCurrentNum属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSignCurrentNum() {
        return signCurrentNum;
    }

    /**
     * 设置signCurrentNum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSignCurrentNum(String value) {
        this.signCurrentNum = value;
    }

    /**
     * 获取signCurrentState属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSignCurrentState() {
        return signCurrentState;
    }

    /**
     * 设置signCurrentState属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSignCurrentState(String value) {
        this.signCurrentState = value;
    }

    /**
     * 获取blackNum属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBlackNum() {
        return blackNum;
    }

    /**
     * 设置blackNum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBlackNum(String value) {
        this.blackNum = value;
    }

    /**
     * 获取riskNum属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRiskNum() {
        return riskNum;
    }

    /**
     * 设置riskNum属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRiskNum(String value) {
        this.riskNum = value;
    }

}

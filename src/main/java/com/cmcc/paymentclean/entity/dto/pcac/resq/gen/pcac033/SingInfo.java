//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 12:21:11 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033;

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
 *         &lt;element name="OrgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RiskStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OpenType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "orgName",
        "status",
        "startTime",
        "endTime",
        "riskStatus",
        "openType"
})
@XmlRootElement(name = "SingInfo")
public class SingInfo {

    @XmlElement(name = "OrgName", required = true)
    protected String orgName;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "StartTime", required = true)
    protected String startTime;
    @XmlElement(name = "EndTime", required = true)
    protected String endTime;
    @XmlElement(name = "RiskStatus", required = true)
    protected String riskStatus;
    @XmlElement(name = "OpenType", required = true)
    protected String openType;

    /**
     * 获取orgName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置orgName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * 获取status属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取startTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置startTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * 获取endTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置endTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * 获取riskStatus属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRiskStatus() {
        return riskStatus;
    }

    /**
     * 设置riskStatus属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRiskStatus(String value) {
        this.riskStatus = value;
    }

    /**
     * 获取openType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * 设置openType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpenType(String value) {
        this.openType = value;
    }

}


//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:51 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025;

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
 *         &lt;element ref="{}Version"/>
 *         &lt;element ref="{}Identification"/>
 *         &lt;element ref="{}OrigSender"/>
 *         &lt;element ref="{}OrigSenderSID"/>
 *         &lt;element ref="{}RecSystemId"/>
 *         &lt;element ref="{}TrnxCode"/>
 *         &lt;element ref="{}TrnxTime"/>
 *         &lt;element name="UserToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}SecretKey"/>
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
    "version",
    "identification",
    "origSender",
    "origSenderSID",
    "recSystemId",
    "trnxCode",
    "trnxTime",
    "userToken",
    "secretKey"
})
@XmlRootElement(name = "Head")
public class Head {

    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "Identification", required = true)
    protected String identification;
    @XmlElement(name = "OrigSender", required = true)
    protected String origSender;
    @XmlElement(name = "OrigSenderSID", required = true)
    protected String origSenderSID;
    @XmlElement(name = "RecSystemId", required = true)
    protected String recSystemId;
    @XmlElement(name = "TrnxCode", required = true)
    protected String trnxCode;
    @XmlElement(name = "TrnxTime", required = true)
    protected String trnxTime;
    @XmlElement(name = "UserToken", required = true)
    protected String userToken;
    @XmlElement(name = "SecretKey", required = true)
    protected String secretKey;

    /**
     * 获取version属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置version属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * 获取identification属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * 设置identification属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentification(String value) {
        this.identification = value;
    }

    /**
     * 获取origSender属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigSender() {
        return origSender;
    }

    /**
     * 设置origSender属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigSender(String value) {
        this.origSender = value;
    }

    /**
     * 获取origSenderSID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigSenderSID() {
        return origSenderSID;
    }

    /**
     * 设置origSenderSID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigSenderSID(String value) {
        this.origSenderSID = value;
    }

    /**
     * 获取recSystemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecSystemId() {
        return recSystemId;
    }

    /**
     * 设置recSystemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecSystemId(String value) {
        this.recSystemId = value;
    }

    /**
     * 获取trnxCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrnxCode() {
        return trnxCode;
    }

    /**
     * 设置trnxCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrnxCode(String value) {
        this.trnxCode = value;
    }

    /**
     * 获取trnxTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrnxTime() {
        return trnxTime;
    }

    /**
     * 设置trnxTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrnxTime(String value) {
        this.trnxTime = value;
    }

    /**
     * 获取userToken属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * 设置userToken属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserToken(String value) {
        this.userToken = value;
    }

    /**
     * 获取secretKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 设置secretKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecretKey(String value) {
        this.secretKey = value;
    }

}

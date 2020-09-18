//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 10:51:08 AM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029;

import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.BaseBody;
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
 *         &lt;element ref="{}RiskType"/>
 *         &lt;element ref="{}ReqDate"/>
 *         &lt;element ref="{}ReqDateEnd"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "riskType",
    "reqDate",
    "reqDateEnd"
})
@XmlRootElement(name = "Body")
public class Body extends BaseBody {

    @XmlElement(name = "RiskType", required = true)
    protected String riskType;
    @XmlElement(name = "ReqDate", required = true)
    protected String reqDate;
    @XmlElement(name = "ReqDateEnd", required = true)
    protected String reqDateEnd;

    /**
     * 获取riskType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRiskType() {
        return riskType;
    }

    /**
     * 设置riskType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRiskType(String value) {
        this.riskType = value;
    }

    /**
     * 获取reqDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReqDate() {
        return reqDate;
    }

    /**
     * 设置reqDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReqDate(String value) {
        this.reqDate = value;
    }

    /**
     * 获取reqDateEnd属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReqDateEnd() {
        return reqDateEnd;
    }

    /**
     * 设置reqDateEnd属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReqDateEnd(String value) {
        this.reqDateEnd = value;
    }

}

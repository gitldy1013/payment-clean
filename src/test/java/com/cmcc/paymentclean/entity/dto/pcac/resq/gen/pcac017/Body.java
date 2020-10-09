//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:12 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}RiskType"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}LegRepName"/>
 *         &lt;element ref="{}LegDocCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"riskType", "cusName", "docType", "docCode", "legRepName", "legDocCode"})
@XmlRootElement(name = "Body")
public class Body {

  @XmlElement(name = "RiskType", required = true)
  protected String riskType;

  @XmlElement(name = "CusName", required = true)
  protected String cusName;

  @XmlElement(name = "DocType", required = true)
  protected String docType;

  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @XmlElement(name = "LegRepName", required = true)
  protected String legRepName;

  @XmlElement(name = "LegDocCode", required = true)
  protected String legDocCode;

  /**
   * 获取riskType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRiskType() {
    return riskType;
  }

  /**
   * 设置riskType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRiskType(String value) {
    this.riskType = value;
  }

  /**
   * 获取cusName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusName() {
    return cusName;
  }

  /**
   * 设置cusName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusName(String value) {
    this.cusName = value;
  }

  /**
   * 获取docType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getDocType() {
    return docType;
  }

  /**
   * 设置docType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setDocType(String value) {
    this.docType = value;
  }

  /**
   * 获取docCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getDocCode() {
    return docCode;
  }

  /**
   * 设置docCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setDocCode(String value) {
    this.docCode = value;
  }

  /**
   * 获取legRepName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegRepName() {
    return legRepName;
  }

  /**
   * 设置legRepName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegRepName(String value) {
    this.legRepName = value;
  }

  /**
   * 获取legDocCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegDocCode() {
    return legDocCode;
  }

  /**
   * 设置legDocCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegDocCode(String value) {
    this.legDocCode = value;
  }
}

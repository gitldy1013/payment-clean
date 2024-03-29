//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 11:15:58 AM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027;

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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "regName",
      "cusName",
      "docType",
      "docCode",
      "legDocName",
      "legDocType",
      "legDocCode",
      "level",
      "riskType",
      "validDate",
      "validStatus",
      "cusType",
      "occurarea",
      "bankNo",
      "url",
      "registeredCode"
    })
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

  @XmlElement(name = "RegName", required = true)
  protected String regName;

  @XmlElement(name = "CusName", required = true)
  protected String cusName;

  @XmlElement(name = "DocType", required = true)
  protected String docType;

  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @XmlElement(name = "LegDocName", required = true)
  protected String legDocName;

  @XmlElement(name = "LegDocType", required = true)
  protected String legDocType;

  @XmlElement(name = "LegDocCode", required = true)
  protected String legDocCode;

  @XmlElement(name = "Level", required = true)
  protected String level;

  @XmlElement(name = "RiskType", required = true)
  protected String riskType;

  @XmlElement(name = "ValidDate", required = true)
  protected String validDate;

  @XmlElement(name = "ValidStatus", required = true)
  protected String validStatus;

  @XmlElement(name = "CusType", required = true)
  protected String cusType;

  @XmlElement(name = "Occurarea", required = true)
  protected String occurarea;

  @XmlElement(name = "BankNo", required = true)
  protected String bankNo;

  @XmlElement(name = "Url", required = true)
  protected String url;

  @XmlElement(name = "RegisteredCode", required = true)
  protected String registeredCode;

  /**
   * 获取regName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRegName() {
    return regName;
  }

  /**
   * 设置regName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRegName(String value) {
    this.regName = value;
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
   * 获取legDocName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegDocName() {
    return legDocName;
  }

  /**
   * 设置legDocName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegDocName(String value) {
    this.legDocName = value;
  }

  /**
   * 获取legDocType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegDocType() {
    return legDocType;
  }

  /**
   * 设置legDocType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegDocType(String value) {
    this.legDocType = value;
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

  /**
   * 获取level属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLevel() {
    return level;
  }

  /**
   * 设置level属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLevel(String value) {
    this.level = value;
  }

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
   * 获取validDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getValidDate() {
    return validDate;
  }

  /**
   * 设置validDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setValidDate(String value) {
    this.validDate = value;
  }

  /**
   * 获取validStatus属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getValidStatus() {
    return validStatus;
  }

  /**
   * 设置validStatus属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setValidStatus(String value) {
    this.validStatus = value;
  }

  /**
   * 获取cusType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusType() {
    return cusType;
  }

  /**
   * 设置cusType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusType(String value) {
    this.cusType = value;
  }

  /**
   * 获取occurarea属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOccurarea() {
    return occurarea;
  }

  /**
   * 设置occurarea属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOccurarea(String value) {
    this.occurarea = value;
  }

  /**
   * 获取bankNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getBankNo() {
    return bankNo;
  }

  /**
   * 设置bankNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setBankNo(String value) {
    this.bankNo = value;
  }

  /**
   * 获取url属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getUrl() {
    return url;
  }

  /**
   * 设置url属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setUrl(String value) {
    this.url = value;
  }

  /**
   * 获取registeredCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRegisteredCode() {
    return registeredCode;
  }

  /**
   * 设置registeredCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRegisteredCode(String value) {
    this.registeredCode = value;
  }
}

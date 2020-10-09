//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:10 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015;

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
 *         &lt;element ref="{}CusNature"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}CusCode"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}LegRepName"/>
 *         &lt;element ref="{}LegDocCode"/>
 *         &lt;element ref="{}BankNo"/>
 *         &lt;element ref="{}OpenBank"/>
 *         &lt;element ref="{}Url"/>
 *         &lt;element ref="{}ServerIp"/>
 *         &lt;element ref="{}MobileNo"/>
 *         &lt;element ref="{}Address"/>
 *         &lt;element ref="{}Icp"/>
 *         &lt;element ref="{}Level"/>
 *         &lt;element ref="{}Occurtimeb"/>
 *         &lt;element ref="{}Occurtimee"/>
 *         &lt;element ref="{}Occurchan"/>
 *         &lt;element ref="{}Occurarea"/>
 *         &lt;element ref="{}Scope"/>
 *         &lt;element ref="{}ValidStatus"/>
 *         &lt;element ref="{}RegisteredArea"/>
 *         &lt;element ref="{}RegisteredCode"/>
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
    propOrder = {
      "riskType",
      "cusNature",
      "cusName",
      "regName",
      "cusCode",
      "docType",
      "docCode",
      "legRepName",
      "legDocCode",
      "bankNo",
      "openBank",
      "url",
      "serverIp",
      "mobileNo",
      "address",
      "icp",
      "level",
      "occurtimeb",
      "occurtimee",
      "occurchan",
      "occurarea",
      "scope",
      "validStatus",
      "registeredArea",
      "registeredCode"
    })
@XmlRootElement(name = "Body")
public class Body {

  @XmlElement(name = "RiskType", required = true)
  protected String riskType;

  @XmlElement(name = "CusNature", required = true)
  protected String cusNature;

  @XmlElement(name = "CusName", required = true)
  protected String cusName;

  @XmlElement(name = "RegName", required = true)
  protected String regName;

  @XmlElement(name = "CusCode", required = true)
  protected String cusCode;

  @XmlElement(name = "DocType", required = true)
  protected String docType;

  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @XmlElement(name = "LegRepName", required = true)
  protected String legRepName;

  @XmlElement(name = "LegDocCode", required = true)
  protected String legDocCode;

  @XmlElement(name = "BankNo", required = true)
  protected String bankNo;

  @XmlElement(name = "OpenBank", required = true)
  protected String openBank;

  @XmlElement(name = "Url", required = true)
  protected String url;

  @XmlElement(name = "ServerIp", required = true)
  protected String serverIp;

  @XmlElement(name = "MobileNo", required = true)
  protected String mobileNo;

  @XmlElement(name = "Address", required = true)
  protected String address;

  @XmlElement(name = "Icp", required = true)
  protected String icp;

  @XmlElement(name = "Level", required = true)
  protected String level;

  @XmlElement(name = "Occurtimeb", required = true)
  protected String occurtimeb;

  @XmlElement(name = "Occurtimee", required = true)
  protected String occurtimee;

  @XmlElement(name = "Occurchan", required = true)
  protected String occurchan;

  @XmlElement(name = "Occurarea", required = true)
  protected String occurarea;

  @XmlElement(name = "Scope", required = true)
  protected String scope;

  @XmlElement(name = "ValidStatus", required = true)
  protected String validStatus;

  @XmlElement(name = "RegisteredArea", required = true)
  protected String registeredArea;

  @XmlElement(name = "RegisteredCode", required = true)
  protected String registeredCode;

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
   * 获取cusNature属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusNature() {
    return cusNature;
  }

  /**
   * 设置cusNature属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusNature(String value) {
    this.cusNature = value;
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
   * 获取cusCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusCode() {
    return cusCode;
  }

  /**
   * 设置cusCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusCode(String value) {
    this.cusCode = value;
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
   * 获取openBank属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOpenBank() {
    return openBank;
  }

  /**
   * 设置openBank属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOpenBank(String value) {
    this.openBank = value;
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
   * 获取serverIp属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getServerIp() {
    return serverIp;
  }

  /**
   * 设置serverIp属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setServerIp(String value) {
    this.serverIp = value;
  }

  /**
   * 获取mobileNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMobileNo() {
    return mobileNo;
  }

  /**
   * 设置mobileNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMobileNo(String value) {
    this.mobileNo = value;
  }

  /**
   * 获取address属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getAddress() {
    return address;
  }

  /**
   * 设置address属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setAddress(String value) {
    this.address = value;
  }

  /**
   * 获取icp属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIcp() {
    return icp;
  }

  /**
   * 设置icp属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIcp(String value) {
    this.icp = value;
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
   * 获取occurtimeb属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOccurtimeb() {
    return occurtimeb;
  }

  /**
   * 设置occurtimeb属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOccurtimeb(String value) {
    this.occurtimeb = value;
  }

  /**
   * 获取occurtimee属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOccurtimee() {
    return occurtimee;
  }

  /**
   * 设置occurtimee属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOccurtimee(String value) {
    this.occurtimee = value;
  }

  /**
   * 获取occurchan属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOccurchan() {
    return occurchan;
  }

  /**
   * 设置occurchan属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOccurchan(String value) {
    this.occurchan = value;
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
   * 获取scope属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getScope() {
    return scope;
  }

  /**
   * 设置scope属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setScope(String value) {
    this.scope = value;
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
   * 获取registeredArea属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRegisteredArea() {
    return registeredArea;
  }

  /**
   * 设置registeredArea属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRegisteredArea(String value) {
    this.registeredArea = value;
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

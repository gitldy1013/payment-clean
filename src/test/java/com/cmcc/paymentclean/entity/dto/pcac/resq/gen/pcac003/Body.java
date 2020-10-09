//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:09 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac003;

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
 *         &lt;element ref="{}MobileNo"/>
 *         &lt;element ref="{}Mac"/>
 *         &lt;element ref="{}Imei"/>
 *         &lt;element ref="{}BankNo"/>
 *         &lt;element ref="{}OpenBank"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}Ip"/>
 *         &lt;element ref="{}Address"/>
 *         &lt;element ref="{}Telephone"/>
 *         &lt;element ref="{}RecBankNo"/>
 *         &lt;element ref="{}RecOpenBank"/>
 *         &lt;element ref="{}Email"/>
 *         &lt;element ref="{}Occurtimeb"/>
 *         &lt;element ref="{}Occurtimee"/>
 *         &lt;element ref="{}Occurchan"/>
 *         &lt;element ref="{}Occurarea"/>
 *         &lt;element ref="{}RecHostArea"/>
 *         &lt;element ref="{}Scope"/>
 *         &lt;element ref="{}ValidStatus"/>
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
      "riskType",
      "mobileNo",
      "mac",
      "imei",
      "bankNo",
      "openBank",
      "cusName",
      "docType",
      "docCode",
      "ip",
      "address",
      "telephone",
      "recBankNo",
      "recOpenBank",
      "email",
      "occurtimeb",
      "occurtimee",
      "occurchan",
      "occurarea",
      "recHostArea",
      "scope",
      "validStatus"
    })
@Data
@XmlRootElement(name = "Body")
public class Body {

  @XmlElement(name = "RiskType", required = true)
  protected String riskType;

  @XmlElement(name = "MobileNo", required = true)
  protected String mobileNo;

  @XmlElement(name = "Mac", required = true)
  protected String mac;

  @XmlElement(name = "Imei", required = true)
  protected String imei;

  @XmlElement(name = "BankNo", required = true)
  protected String bankNo;

  @XmlElement(name = "OpenBank", required = true)
  protected String openBank;

  @XmlElement(name = "CusName", required = true)
  protected String cusName;

  @XmlElement(name = "DocType", required = true)
  protected String docType;

  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @XmlElement(name = "Ip", required = true)
  protected String ip;

  @XmlElement(name = "Address", required = true)
  protected String address;

  @XmlElement(name = "Telephone", required = true)
  protected String telephone;

  @XmlElement(name = "RecBankNo", required = true)
  protected String recBankNo;

  @XmlElement(name = "RecOpenBank", required = true)
  protected String recOpenBank;

  @XmlElement(name = "Email", required = true)
  protected String email;

  @XmlElement(name = "Occurtimeb", required = true)
  protected String occurtimeb;

  @XmlElement(name = "Occurtimee", required = true)
  protected String occurtimee;

  @XmlElement(name = "Occurchan", required = true)
  protected String occurchan;

  @XmlElement(name = "Occurarea", required = true)
  protected String occurarea;

  @XmlElement(name = "RecHostArea", required = true)
  protected String recHostArea;

  @XmlElement(name = "Scope", required = true)
  protected String scope;

  @XmlElement(name = "ValidStatus", required = true)
  protected String validStatus;

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
   * 获取mac属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMac() {
    return mac;
  }

  /**
   * 设置mac属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMac(String value) {
    this.mac = value;
  }

  /**
   * 获取imei属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getImei() {
    return imei;
  }

  /**
   * 设置imei属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setImei(String value) {
    this.imei = value;
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
   * 获取ip属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIp() {
    return ip;
  }

  /**
   * 设置ip属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIp(String value) {
    this.ip = value;
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
   * 获取telephone属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * 设置telephone属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setTelephone(String value) {
    this.telephone = value;
  }

  /**
   * 获取recBankNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecBankNo() {
    return recBankNo;
  }

  /**
   * 设置recBankNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecBankNo(String value) {
    this.recBankNo = value;
  }

  /**
   * 获取recOpenBank属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecOpenBank() {
    return recOpenBank;
  }

  /**
   * 设置recOpenBank属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecOpenBank(String value) {
    this.recOpenBank = value;
  }

  /**
   * 获取email属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getEmail() {
    return email;
  }

  /**
   * 设置email属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setEmail(String value) {
    this.email = value;
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
   * 获取recHostArea属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecHostArea() {
    return recHostArea;
  }

  /**
   * 设置recHostArea属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecHostArea(String value) {
    this.recHostArea = value;
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
}

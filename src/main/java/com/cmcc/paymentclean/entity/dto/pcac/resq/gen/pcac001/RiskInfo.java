//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:49 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001;

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
 *         &lt;element ref="{}CusProperty"/>
 *         &lt;element name="RiskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element ref="{}BankList"/>
 *         &lt;element ref="{}RecHostArea"/>
 *         &lt;element ref="{}Email"/>
 *         &lt;element ref="{}ValidDate"/>
 *         &lt;element ref="{}Occurtimeb"/>
 *         &lt;element ref="{}Occurtimee"/>
 *         &lt;element ref="{}Occurchan"/>
 *         &lt;element ref="{}Occurarea"/>
 *         &lt;element ref="{}Note"/>
 *         &lt;element ref="{}OrgId"/>
 *         &lt;element ref="{}RepDate"/>
 *         &lt;element ref="{}RepType"/>
 *         &lt;element ref="{}RepPerson"/>
 *         &lt;element name="SourceChannel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DiskNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RiskFindTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
      "cusProperty",
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
      "bankList",
      "recHostArea",
      "email",
      "validDate",
      "occurtimeb",
      "occurtimee",
      "occurchan",
      "occurarea",
      "note",
      "orgId",
      "repDate",
      "repType",
      "repPerson",
      "sourceChannel",
      "diskNumber",
      "currency",
      "amount",
      "riskFindTime"
    })
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

  @XmlElement(name = "CusProperty", required = true)
  protected String cusProperty;

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

  @XmlElement(name = "BankList", required = true)
  protected BankList bankList;

  @XmlElement(name = "RecHostArea", required = true)
  protected String recHostArea;

  @XmlElement(name = "Email", required = true)
  protected String email;

  @XmlElement(name = "ValidDate", required = true)
  protected String validDate;

  @XmlElement(name = "Occurtimeb", required = true)
  protected String occurtimeb;

  @XmlElement(name = "Occurtimee", required = true)
  protected String occurtimee;

  @XmlElement(name = "Occurchan", required = true)
  protected String occurchan;

  @XmlElement(name = "Occurarea", required = true)
  protected String occurarea;

  @XmlElement(name = "Note", required = true)
  protected String note;

  @XmlElement(name = "OrgId", required = true)
  protected String orgId;

  @XmlElement(name = "RepDate", required = true)
  protected String repDate;

  @XmlElement(name = "RepType", required = true)
  protected String repType;

  @XmlElement(name = "RepPerson", required = true)
  protected String repPerson;

  @XmlElement(name = "SourceChannel", required = true)
  protected String sourceChannel;

  @XmlElement(name = "DiskNumber", required = true)
  protected String diskNumber;

  @XmlElement(name = "Currency", required = true)
  protected String currency;

  @XmlElement(name = "Amount", required = true)
  protected String amount;

  @XmlElement(name = "RiskFindTime", required = true)
  protected String riskFindTime;

  /**
   * 获取cusProperty属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusProperty() {
    return cusProperty;
  }

  /**
   * 设置cusProperty属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusProperty(String value) {
    this.cusProperty = value;
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
   * 获取bankList属性的值。
   *
   * @return possible object is {@link BankList }
   */
  public BankList getBankList() {
    return bankList;
  }

  /**
   * 设置bankList属性的值。
   *
   * @param value allowed object is {@link BankList }
   */
  public void setBankList(BankList value) {
    this.bankList = value;
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
   * 获取note属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getNote() {
    return note;
  }

  /**
   * 设置note属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setNote(String value) {
    this.note = value;
  }

  /**
   * 获取orgId属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOrgId() {
    return orgId;
  }

  /**
   * 设置orgId属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgId(String value) {
    this.orgId = value;
  }

  /**
   * 获取repDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRepDate() {
    return repDate;
  }

  /**
   * 设置repDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRepDate(String value) {
    this.repDate = value;
  }

  /**
   * 获取repType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRepType() {
    return repType;
  }

  /**
   * 设置repType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRepType(String value) {
    this.repType = value;
  }

  /**
   * 获取repPerson属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRepPerson() {
    return repPerson;
  }

  /**
   * 设置repPerson属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRepPerson(String value) {
    this.repPerson = value;
  }

  /**
   * 获取sourceChannel属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSourceChannel() {
    return sourceChannel;
  }

  /**
   * 设置sourceChannel属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSourceChannel(String value) {
    this.sourceChannel = value;
  }

  /**
   * 获取diskNumber属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getDiskNumber() {
    return diskNumber;
  }

  /**
   * 设置diskNumber属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setDiskNumber(String value) {
    this.diskNumber = value;
  }

  /**
   * 获取currency属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * 设置currency属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCurrency(String value) {
    this.currency = value;
  }

  /**
   * 获取amount属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getAmount() {
    return amount;
  }

  /**
   * 设置amount属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setAmount(String value) {
    this.amount = value;
  }

  /**
   * 获取riskFindTime属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRiskFindTime() {
    return riskFindTime;
  }

  /**
   * 设置riskFindTime属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRiskFindTime(String value) {
    this.riskFindTime = value;
  }
}

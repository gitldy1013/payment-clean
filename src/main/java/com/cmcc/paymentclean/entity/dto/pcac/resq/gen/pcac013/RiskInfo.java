//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:50 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013;

import com.cmcc.paymentclean.annotation.EncrField;
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
 *         &lt;element ref="{}CusType"/>
 *         &lt;element ref="{}CusProperty"/>
 *         &lt;element ref="{}RiskType"/>
 *         &lt;element ref="{}CusNature"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}CusCode"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}LegRepName"/>
 *         &lt;element ref="{}LegDocType"/>
 *         &lt;element ref="{}LegDocCode"/>
 *         &lt;element ref="{}BankList"/>
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
 *         &lt;element ref="{}Note"/>
 *         &lt;element ref="{}ValidDate"/>
 *         &lt;element ref="{}OrgId"/>
 *         &lt;element ref="{}RepDate"/>
 *         &lt;element ref="{}RepType"/>
 *         &lt;element ref="{}RepPerson"/>
 *         &lt;element ref="{}RegisteredArea"/>
 *         &lt;element ref="{}RegisteredCode"/>
 *         &lt;element ref="{}SourceChannel"/>
 *         &lt;element ref="{}Currency"/>
 *         &lt;element ref="{}Amount"/>
 *         &lt;element ref="{}RiskFindTime"/>
 *         &lt;element ref="{}LegControlName"/>
 *         &lt;element ref="{}LegControlCardType"/>
 *         &lt;element ref="{}LegControlCardCode"/>
 *         &lt;element ref="{}Remarks"/>
 *         &lt;element ref="{}BenList"/>
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
      "cusType",
      "cusProperty",
      "riskType",
      "cusNature",
      "cusName",
      "regName",
      "cusCode",
      "docType",
      "docCode",
      "legRepName",
      "legDocType",
      "legDocCode",
      "bankList",
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
      "note",
      "validDate",
      "orgId",
      "repDate",
      "repType",
      "repPerson",
      "registeredArea",
      "registeredCode",
      "sourceChannel",
      "currency",
      "amount",
      "riskFindTime",
      "legControlName",
      "legControlCardType",
      "legControlCardCode",
      "remarks",
      "benList"
    })
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

  @XmlElement(name = "CusType", required = true)
  protected String cusType;

  @XmlElement(name = "CusProperty", required = true)
  protected String cusProperty;

  @XmlElement(name = "RiskType", required = true)
  protected String riskType;

  @XmlElement(name = "CusNature", required = true)
  protected String cusNature;

  @EncrField
  @XmlElement(name = "CusName", required = true)
  protected String cusName;

  @EncrField
  @XmlElement(name = "RegName", required = true)
  protected String regName;

  @EncrField
  @XmlElement(name = "CusCode", required = true)
  protected String cusCode;

  @XmlElement(name = "DocType", required = true)
  protected String docType;

  @EncrField("DocType")
  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @EncrField
  @XmlElement(name = "LegRepName", required = true)
  protected String legRepName;

  @XmlElement(name = "LegDocType", required = true)
  protected String legDocType;

  @EncrField
  @XmlElement(name = "LegDocCode", required = true)
  protected String legDocCode;

  @XmlElement(name = "BankList", required = true)
  protected BankList bankList;

  @EncrField
  @XmlElement(name = "Url", required = true)
  protected String url;

  @EncrField
  @XmlElement(name = "ServerIp", required = true)
  protected String serverIp;

  @EncrField
  @XmlElement(name = "MobileNo", required = true)
  protected String mobileNo;

  @XmlElement(name = "Address", required = true)
  protected String address;

  @EncrField
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

  @XmlElement(name = "Note", required = true)
  protected String note;

  @XmlElement(name = "ValidDate", required = true)
  protected String validDate;

  @XmlElement(name = "OrgId", required = true)
  protected String orgId;

  @XmlElement(name = "RepDate", required = true)
  protected String repDate;

  @XmlElement(name = "RepType", required = true)
  protected String repType;

  @XmlElement(name = "RepPerson", required = true)
  protected String repPerson;

  @XmlElement(name = "RegisteredArea", required = true)
  protected String registeredArea;

  @EncrField
  @XmlElement(name = "RegisteredCode", required = true)
  protected String registeredCode;

  @XmlElement(name = "SourceChannel", required = true)
  protected String sourceChannel;

  @XmlElement(name = "Currency", required = true)
  protected String currency = "CNY";

  @XmlElement(name = "Amount", required = true)
  protected String amount;

  @XmlElement(name = "RiskFindTime", required = true)
  protected String riskFindTime;

  @XmlElement(name = "LegControlName", required = true)
  protected String legControlName;

  @XmlElement(name = "LegControlCardType", required = true)
  protected String legControlCardType;

  @EncrField
  @XmlElement(name = "LegControlCardCode", required = true)
  protected String legControlCardCode;

  @XmlElement(name = "Remarks", required = true)
  protected String remarks;

  @XmlElement(name = "BenList", required = true)
  protected BenList benList;

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

  /**
   * 获取legControlName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegControlName() {
    return legControlName;
  }

  /**
   * 设置legControlName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegControlName(String value) {
    this.legControlName = value;
  }

  /**
   * 获取legControlCardType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegControlCardType() {
    return legControlCardType;
  }

  /**
   * 设置legControlCardType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegControlCardType(String value) {
    this.legControlCardType = value;
  }

  /**
   * 获取legControlCardCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegControlCardCode() {
    return legControlCardCode;
  }

  /**
   * 设置legControlCardCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegControlCardCode(String value) {
    this.legControlCardCode = value;
  }

  /**
   * 获取remarks属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRemarks() {
    return remarks;
  }

  /**
   * 设置remarks属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRemarks(String value) {
    this.remarks = value;
  }

  /**
   * 获取benList属性的值。
   *
   * @return possible object is {@link BenList }
   */
  public BenList getBenList() {
    return benList;
  }

  /**
   * 设置benList属性的值。
   *
   * @param value allowed object is {@link BenList }
   */
  public void setBenList(BenList value) {
    this.benList = value;
  }
}

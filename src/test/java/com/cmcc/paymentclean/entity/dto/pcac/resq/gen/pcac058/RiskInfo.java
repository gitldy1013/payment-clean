//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:15 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058;

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
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}Currency"/>
 *         &lt;element ref="{}Amount"/>
 *         &lt;element ref="{}LegDocName"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}BankNo"/>
 *         &lt;element ref="{}Url"/>
 *         &lt;element ref="{}RegisteredCode"/>
 *         &lt;element ref="{}HandleResult"/>
 *         &lt;element ref="{}HandleTime"/>
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
      "regName",
      "currency",
      "amount",
      "legDocName",
      "docCode",
      "bankNo",
      "url",
      "registeredCode",
      "handleResult",
      "handleTime"
    })
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

  @XmlElement(name = "RegName", required = true)
  protected String regName;

  @XmlElement(name = "Currency", required = true)
  protected String currency;

  @XmlElement(name = "Amount", required = true)
  protected String amount;

  @XmlElement(name = "LegDocName", required = true)
  protected String legDocName;

  @XmlElement(name = "DocCode", required = true)
  protected String docCode;

  @XmlElement(name = "BankNo", required = true)
  protected String bankNo;

  @XmlElement(name = "Url", required = true)
  protected String url;

  @XmlElement(name = "RegisteredCode", required = true)
  protected String registeredCode;

  @XmlElement(name = "HandleResult", required = true)
  protected String handleResult;

  @XmlElement(name = "HandleTime", required = true)
  protected String handleTime;

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

  /**
   * 获取handleResult属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getHandleResult() {
    return handleResult;
  }

  /**
   * 设置handleResult属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setHandleResult(String value) {
    this.handleResult = value;
  }

  /**
   * 获取handleTime属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getHandleTime() {
    return handleTime;
  }

  /**
   * 设置handleTime属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setHandleTime(String value) {
    this.handleTime = value;
  }
}

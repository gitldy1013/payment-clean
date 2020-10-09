//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:12 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011;

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
 *         &lt;element ref="{}IsTransfer"/>
 *         &lt;element ref="{}RecName"/>
 *         &lt;element ref="{}RecDocType"/>
 *         &lt;element ref="{}RecDocCode"/>
 *         &lt;element ref="{}RecBankNo"/>
 *         &lt;element ref="{}RecOpenBank"/>
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
    propOrder = {"isTransfer", "recName", "recDocType", "recDocCode", "recBankNo", "recOpenBank"})
@XmlRootElement(name = "BankInfo")
public class BankInfo {

  @XmlElement(name = "IsTransfer", required = true)
  protected String isTransfer;

  @XmlElement(name = "RecName", required = true)
  protected String recName;

  @XmlElement(name = "RecDocType", required = true)
  protected String recDocType;

  @XmlElement(name = "RecDocCode", required = true)
  protected String recDocCode;

  @XmlElement(name = "RecBankNo", required = true)
  protected String recBankNo;

  @XmlElement(name = "RecOpenBank", required = true)
  protected String recOpenBank;

  /**
   * 获取isTransfer属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIsTransfer() {
    return isTransfer;
  }

  /**
   * 设置isTransfer属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIsTransfer(String value) {
    this.isTransfer = value;
  }

  /**
   * 获取recName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecName() {
    return recName;
  }

  /**
   * 设置recName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecName(String value) {
    this.recName = value;
  }

  /**
   * 获取recDocType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecDocType() {
    return recDocType;
  }

  /**
   * 设置recDocType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecDocType(String value) {
    this.recDocType = value;
  }

  /**
   * 获取recDocCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRecDocCode() {
    return recDocCode;
  }

  /**
   * 设置recDocCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRecDocCode(String value) {
    this.recDocCode = value;
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
}

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:14 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019;

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
 *         &lt;element name="IsTransfer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BankNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OpenBank" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    propOrder = {"isTransfer", "bankNo", "openBank"})
@XmlRootElement(name = "BankInfo")
public class BankInfo {

  @XmlElement(name = "IsTransfer", required = true)
  protected String isTransfer;

  @XmlElement(name = "BankNo", required = true)
  protected String bankNo;

  @XmlElement(name = "OpenBank", required = true)
  protected String openBank;

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
}

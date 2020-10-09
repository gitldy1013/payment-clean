//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:11 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009;

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
 *         &lt;element name="RiskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}MobileNo"/>
 *         &lt;element ref="{}Mac"/>
 *         &lt;element ref="{}Imei"/>
 *         &lt;element ref="{}BankNo"/>
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
    propOrder = {"riskType", "mobileNo", "mac", "imei", "bankNo"})
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
}

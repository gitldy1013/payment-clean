//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 01:20:41 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059;

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
 *         &lt;element ref="{}LegBenName"/>
 *         &lt;element ref="{}LegBenCardType"/>
 *         &lt;element ref="{}LegBenCardCode"/>
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
    propOrder = {"legBenName", "legBenCardType", "legBenCardCode"})
@XmlRootElement(name = "BenInfo")
public class BenInfo {

  @XmlElement(name = "LegBenName", required = true)
  protected String legBenName;

  @XmlElement(name = "LegBenCardType", required = true)
  protected String legBenCardType;

  @XmlElement(name = "LegBenCardCode", required = true)
  protected String legBenCardCode;

  /**
   * 获取legBenName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegBenName() {
    return legBenName;
  }

  /**
   * 设置legBenName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegBenName(String value) {
    this.legBenName = value;
  }

  /**
   * 获取legBenCardType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegBenCardType() {
    return legBenCardType;
  }

  /**
   * 设置legBenCardType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegBenCardType(String value) {
    this.legBenCardType = value;
  }

  /**
   * 获取legBenCardCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getLegBenCardCode() {
    return legBenCardCode;
  }

  /**
   * 设置legBenCardCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setLegBenCardCode(String value) {
    this.legBenCardCode = value;
  }
}

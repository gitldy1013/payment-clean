//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.23 时间 06:02:15 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028;

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
 *         &lt;element ref="{}CusCode"/>
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}LegDocName"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"cusCode", "regName", "legDocName"})
@XmlRootElement(name = "Differents")
public class Differents {

  @XmlElement(name = "CusCode", required = true)
  protected String cusCode;

  @XmlElement(name = "RegName", required = true)
  protected String regName;

  @XmlElement(name = "LegDocName", required = true)
  protected String legDocName;

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
}

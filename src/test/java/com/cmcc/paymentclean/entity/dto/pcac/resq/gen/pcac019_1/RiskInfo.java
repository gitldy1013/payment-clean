//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:13 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1;

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
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}UpdateType"/>
 *         &lt;element ref="{}CaseDesc"/>
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
    propOrder = {"id", "updateType", "caseDesc"})
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

  @XmlElement(name = "Id", required = true)
  protected String id;

  @XmlElement(name = "UpdateType", required = true)
  protected String updateType;

  @XmlElement(name = "CaseDesc", required = true)
  protected String caseDesc;

  /**
   * 获取id属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getId() {
    return id;
  }

  /**
   * 设置id属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * 获取updateType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getUpdateType() {
    return updateType;
  }

  /**
   * 设置updateType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setUpdateType(String value) {
    this.updateType = value;
  }

  /**
   * 获取caseDesc属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCaseDesc() {
    return caseDesc;
  }

  /**
   * 设置caseDesc属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCaseDesc(String value) {
    this.caseDesc = value;
  }
}

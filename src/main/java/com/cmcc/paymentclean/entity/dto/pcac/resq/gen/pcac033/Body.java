//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 12:21:11 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033;

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
 *         &lt;element ref="{}ConditionList"/>
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
    propOrder = {"conditionList"})
@XmlRootElement(name = "Body")
public class Body {

  @XmlElement(name = "ConditionList", required = true)
  protected ConditionList conditionList;

  /**
   * 获取conditionList属性的值。
   *
   * @return possible object is {@link ConditionList }
   */
  public ConditionList getConditionList() {
    return conditionList;
  }

  /**
   * 设置conditionList属性的值。
   *
   * @param value allowed object is {@link ConditionList }
   */
  public void setConditionList(ConditionList value) {
    this.conditionList = value;
  }
}

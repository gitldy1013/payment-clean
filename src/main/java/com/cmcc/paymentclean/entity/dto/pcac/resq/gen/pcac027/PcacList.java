//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.18 时间 11:15:58 AM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element ref="{}Count"/>
 *         &lt;element ref="{}UpDate"/>
 *         &lt;element ref="{}RiskInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"count", "upDate", "riskInfo"})
@XmlRootElement(name = "PcacList")
public class PcacList {

  @XmlElement(name = "Count")
  protected int count;

  @XmlElement(name = "UpDate", required = true)
  protected String upDate;

  @XmlElement(name = "RiskInfo")
  protected List<RiskInfo> riskInfo;

  /** 获取count属性的值。 */
  public int getCount() {
    return count;
  }

  /** 设置count属性的值。 */
  public void setCount(int value) {
    this.count = value;
  }

  /**
   * 获取upDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getUpDate() {
    return upDate;
  }

  /**
   * 设置upDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setUpDate(String value) {
    this.upDate = value;
  }

  /**
   * Gets the value of the riskInfo property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the riskInfo property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getRiskInfo().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link RiskInfo }
   */
  public List<RiskInfo> getRiskInfo() {
    if (riskInfo == null) {
      riskInfo = new ArrayList<RiskInfo>();
    }
    return this.riskInfo;
  }
}

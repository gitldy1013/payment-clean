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
 *         &lt;element ref="{}BaseInfo"/>
 *         &lt;element ref="{}HisSignList" maxOccurs="unbounded"/>
 *         &lt;element ref="{}CurSignList" maxOccurs="unbounded"/>
 *         &lt;element ref="{}BlackList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}WarningList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}LegBlackList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}LegWarningList" maxOccurs="unbounded" minOccurs="0"/>
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
      "baseInfo",
      "hisSignList",
      "curSignList",
      "blackList",
      "warningList",
      "legBlackList",
      "legWarningList"
    })
@XmlRootElement(name = "ResultInfo")
public class ResultInfo {

  @XmlElement(name = "BaseInfo", required = true)
  protected BaseInfo baseInfo;

  @XmlElement(name = "HisSignList", required = true)
  protected List<HisSignList> hisSignList;

  @XmlElement(name = "CurSignList", required = true)
  protected List<CurSignList> curSignList;

  @XmlElement(name = "BlackList")
  protected List<BlackList> blackList;

  @XmlElement(name = "WarningList")
  protected List<WarningList> warningList;

  @XmlElement(name = "LegBlackList")
  protected List<LegBlackList> legBlackList;

  @XmlElement(name = "LegWarningList")
  protected List<LegWarningList> legWarningList;

  /**
   * 获取baseInfo属性的值。
   *
   * @return possible object is {@link BaseInfo }
   */
  public BaseInfo getBaseInfo() {
    return baseInfo;
  }

  /**
   * 设置baseInfo属性的值。
   *
   * @param value allowed object is {@link BaseInfo }
   */
  public void setBaseInfo(BaseInfo value) {
    this.baseInfo = value;
  }

  /**
   * Gets the value of the hisSignList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the hisSignList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getHisSignList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link HisSignList }
   */
  public List<HisSignList> getHisSignList() {
    if (hisSignList == null) {
      hisSignList = new ArrayList<HisSignList>();
    }
    return this.hisSignList;
  }

  /**
   * Gets the value of the curSignList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the curSignList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getCurSignList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link CurSignList }
   */
  public List<CurSignList> getCurSignList() {
    if (curSignList == null) {
      curSignList = new ArrayList<CurSignList>();
    }
    return this.curSignList;
  }

  /**
   * Gets the value of the blackList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the blackList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getBlackList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link BlackList }
   */
  public List<BlackList> getBlackList() {
    if (blackList == null) {
      blackList = new ArrayList<BlackList>();
    }
    return this.blackList;
  }

  /**
   * Gets the value of the warningList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the warningList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getWarningList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link WarningList }
   */
  public List<WarningList> getWarningList() {
    if (warningList == null) {
      warningList = new ArrayList<WarningList>();
    }
    return this.warningList;
  }

  /**
   * Gets the value of the legBlackList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the legBlackList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLegBlackList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LegBlackList }
   */
  public List<LegBlackList> getLegBlackList() {
    if (legBlackList == null) {
      legBlackList = new ArrayList<LegBlackList>();
    }
    return this.legBlackList;
  }

  /**
   * Gets the value of the legWarningList property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the legWarningList property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLegWarningList().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LegWarningList }
   */
  public List<LegWarningList> getLegWarningList() {
    if (legWarningList == null) {
      legWarningList = new ArrayList<LegWarningList>();
    }
    return this.legWarningList;
  }
}

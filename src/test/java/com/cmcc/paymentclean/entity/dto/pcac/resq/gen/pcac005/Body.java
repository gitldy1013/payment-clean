//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:11 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005;

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
 *         &lt;element ref="{}CusProperty"/>
 *         &lt;element name="KeyWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}Infos"/>
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
    propOrder = {"cusProperty", "keyWord", "infos"})
@XmlRootElement(name = "Body")
public class Body {

  @XmlElement(name = "CusProperty", required = true)
  protected String cusProperty;

  @XmlElement(name = "KeyWord", required = true)
  protected String keyWord;

  @XmlElement(name = "Infos", required = true)
  protected String infos;

  /**
   * 获取cusProperty属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCusProperty() {
    return cusProperty;
  }

  /**
   * 设置cusProperty属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCusProperty(String value) {
    this.cusProperty = value;
  }

  /**
   * 获取keyWord属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getKeyWord() {
    return keyWord;
  }

  /**
   * 设置keyWord属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setKeyWord(String value) {
    this.keyWord = value;
  }

  /**
   * 获取infos属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInfos() {
    return infos;
  }

  /**
   * 设置infos属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInfos(String value) {
    this.infos = value;
  }
}

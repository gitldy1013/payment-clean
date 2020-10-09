//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:52 PM CST
//

package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 *         &lt;element ref="{}Head"/>
 *         &lt;element ref="{}Body"/>
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
    propOrder = {"head", "body"})
@XmlRootElement(name = "Request")
@XmlSeeAlso(
    value = {
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.Body.class,
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.Body.class,
    })
public class Request<T> {

  @XmlElement(name = "Head", required = true)
  protected Head head;

  @XmlAnyElement(lax = true)
  protected T body;

  /**
   * 获取head属性的值。
   *
   * @return possible object is {@link Head }
   */
  public Head getHead() {
    return head;
  }

  /**
   * 设置head属性的值。
   *
   * @param value allowed object is {@link Head }
   */
  public void setHead(Head value) {
    this.head = value;
  }

  /**
   * 获取body属性的值。
   *
   * @return possible object is {@link T }
   */
  public T getBody() {
    return body;
  }

  /**
   * 设置body属性的值。
   *
   * @param value allowed object is {@link T }
   */
  public void setBody(T value) {
    this.body = value;
  }
}

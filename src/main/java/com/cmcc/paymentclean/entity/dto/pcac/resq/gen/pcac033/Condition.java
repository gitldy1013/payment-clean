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
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}QueryInfo"/>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}ResultCondition"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "queryInfo",
    "count",
    "resultCondition"
})
@XmlRootElement(name = "Condition")
public class Condition {

    @XmlElement(name = "QueryInfo", required = true)
    protected QueryInfo queryInfo;
    @XmlElement(name = "Count", required = true)
    protected String count;
    @XmlElement(name = "ResultCondition", required = true)
    protected ResultCondition resultCondition;

    /**
     * 获取queryInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link QueryInfo }
     *
     */
    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    /**
     * 设置queryInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link QueryInfo }
     *
     */
    public void setQueryInfo(QueryInfo value) {
        this.queryInfo = value;
    }

    /**
     * 获取count属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置count属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCount(String value) {
        this.count = value;
    }

    /**
     * 获取resultCondition属性的值。
     *
     * @return
     *     possible object is
     *     {@link ResultCondition }
     *
     */
    public ResultCondition getResultCondition() {
        return resultCondition;
    }

    /**
     * 设置resultCondition属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ResultCondition }
     *
     */
    public void setResultCondition(ResultCondition value) {
        this.resultCondition = value;
    }

}

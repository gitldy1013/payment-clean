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
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ResultQueryInfo"/>
 *         &lt;element ref="{}ResultInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resultQueryInfo",
    "resultInfo"
})
@XmlRootElement(name = "ResultCondition")
public class ResultCondition {

    @XmlElement(name = "ResultQueryInfo", required = true)
    protected ResultQueryInfo resultQueryInfo;
    @XmlElement(name = "ResultInfo", required = true)
    protected List<ResultInfo> resultInfo;

    /**
     * 获取resultQueryInfo属性的值。
     *
     * @return
     *     possible object is
     *     {@link ResultQueryInfo }
     *
     */
    public ResultQueryInfo getResultQueryInfo() {
        return resultQueryInfo;
    }

    /**
     * 设置resultQueryInfo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ResultQueryInfo }
     *
     */
    public void setResultQueryInfo(ResultQueryInfo value) {
        this.resultQueryInfo = value;
    }

    /**
     * Gets the value of the resultInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultInfo }
     *
     *
     */
    public List<ResultInfo> getResultInfo() {
        if (resultInfo == null) {
            resultInfo = new ArrayList<ResultInfo>();
        }
        return this.resultInfo;
    }

}

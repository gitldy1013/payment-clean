//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:50 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}Count"/>
 *         &lt;element ref="{}BenInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
import lombok.Data;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "count",
    "benInfo"
})
@XmlRootElement(name = "BenList")
public class BenList {

    @XmlElement(name = "Count", required = true)
    protected String count;
    @XmlElement(name = "BenInfo", required = true)
    protected List<BenInfo> benInfo;

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
     * Gets the value of the benInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the benInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBenInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BenInfo }
     *
     *
     */
    public List<BenInfo> getBenInfo() {
        if (benInfo == null) {
            benInfo = new ArrayList<BenInfo>();
        }
        return this.benInfo;
    }

}

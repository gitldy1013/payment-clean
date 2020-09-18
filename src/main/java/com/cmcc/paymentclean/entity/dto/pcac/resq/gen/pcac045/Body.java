//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:52 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045;

import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.BaseBody;
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
 *         &lt;element ref="{}PcacList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pcacList"
})
@XmlRootElement(name = "Body")
public class Body extends BaseBody {

    @XmlElement(name = "PcacList", required = true)
    protected PcacList pcacList;

    /**
     * 获取pcacList属性的值。
     *
     * @return
     *     possible object is
     *     {@link PcacList }
     *
     */
    public PcacList getPcacList() {
        return pcacList;
    }

    /**
     * 设置pcacList属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link PcacList }
     *
     */
    public void setPcacList(PcacList value) {
        this.pcacList = value;
    }

}

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.13 时间 05:13:13 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac032;

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
 *         &lt;element ref="{}BaseInfo"/>
 *         &lt;element ref="{}HisSignList" maxOccurs="unbounded"/>
 *         &lt;element ref="{}CurSignList" maxOccurs="unbounded"/>
 *         &lt;element ref="{}BlackList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}WarningList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "baseInfo",
    "hisSignList",
    "curSignList",
    "blackList",
    "warningList"
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

    /**
     * 获取baseInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseInfo }
     *     
     */
    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    /**
     * 设置baseInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseInfo }
     *     
     */
    public void setBaseInfo(BaseInfo value) {
        this.baseInfo = value;
    }

    /**
     * Gets the value of the hisSignList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hisSignList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHisSignList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HisSignList }
     * 
     * 
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the curSignList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurSignList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurSignList }
     * 
     * 
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blackList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlackList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlackList }
     * 
     * 
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warningList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarningList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WarningList }
     * 
     * 
     */
    public List<WarningList> getWarningList() {
        if (warningList == null) {
            warningList = new ArrayList<WarningList>();
        }
        return this.warningList;
    }

}

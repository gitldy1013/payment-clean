//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.25 时间 02:37:14 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019;

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
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}UpdateType"/>
 *         &lt;element ref="{}CusType"/>
 *         &lt;element ref="{}CusNature"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}BankList" maxOccurs="unbounded"/>
 *         &lt;element ref="{}Url"/>
 *         &lt;element ref="{}ServerIp"/>
 *         &lt;element ref="{}MobileNo"/>
 *         &lt;element ref="{}Address"/>
 *         &lt;element ref="{}Icp"/>
 *         &lt;element ref="{}Occurtimeb"/>
 *         &lt;element ref="{}Occurtimee"/>
 *         &lt;element ref="{}Occurchan"/>
 *         &lt;element ref="{}Occurarea"/>
 *         &lt;element ref="{}Note"/>
 *         &lt;element ref="{}ValidDate"/>
 *         &lt;element ref="{}OrgId"/>
 *         &lt;element ref="{}RepDate"/>
 *         &lt;element ref="{}RepType"/>
 *         &lt;element ref="{}RepPerson"/>
 *         &lt;element name="RegisteredArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisteredCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SourceChannel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RiskFindTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LegControlName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LegControlCardType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LegControlCardCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}BenList" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "updateType",
    "cusType",
    "cusNature",
    "cusName",
    "bankList",
    "url",
    "serverIp",
    "mobileNo",
    "address",
    "icp",
    "occurtimeb",
    "occurtimee",
    "occurchan",
    "occurarea",
    "note",
    "validDate",
    "orgId",
    "repDate",
    "repType",
    "repPerson",
    "registeredArea",
    "registeredCode",
    "sourceChannel",
    "currency",
    "amount",
    "riskFindTime",
    "legControlName",
    "legControlCardType",
    "legControlCardCode",
    "remarks",
    "benList"
})
@XmlRootElement(name = "RiskInfo")
public class RiskInfo {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "UpdateType", required = true)
    protected String updateType;
    @XmlElement(name = "CusType", required = true)
    protected String cusType;
    @XmlElement(name = "CusNature", required = true)
    protected String cusNature;
    @XmlElement(name = "CusName", required = true)
    protected String cusName;
    @XmlElement(name = "BankList", required = true)
    protected List<BankList> bankList;
    @XmlElement(name = "Url", required = true)
    protected String url;
    @XmlElement(name = "ServerIp", required = true)
    protected String serverIp;
    @XmlElement(name = "MobileNo", required = true)
    protected String mobileNo;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "Icp", required = true)
    protected String icp;
    @XmlElement(name = "Occurtimeb", required = true)
    protected String occurtimeb;
    @XmlElement(name = "Occurtimee", required = true)
    protected String occurtimee;
    @XmlElement(name = "Occurchan", required = true)
    protected String occurchan;
    @XmlElement(name = "Occurarea", required = true)
    protected String occurarea;
    @XmlElement(name = "Note", required = true)
    protected String note;
    @XmlElement(name = "ValidDate", required = true)
    protected String validDate;
    @XmlElement(name = "OrgId", required = true)
    protected String orgId;
    @XmlElement(name = "RepDate", required = true)
    protected String repDate;
    @XmlElement(name = "RepType", required = true)
    protected String repType;
    @XmlElement(name = "RepPerson", required = true)
    protected String repPerson;
    @XmlElement(name = "RegisteredArea", required = true)
    protected String registeredArea;
    @XmlElement(name = "RegisteredCode", required = true)
    protected String registeredCode;
    @XmlElement(name = "SourceChannel", required = true)
    protected String sourceChannel;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Amount", required = true)
    protected String amount;
    @XmlElement(name = "RiskFindTime", required = true)
    protected String riskFindTime;
    @XmlElement(name = "LegControlName", required = true)
    protected String legControlName;
    @XmlElement(name = "LegControlCardType", required = true)
    protected String legControlCardType;
    @XmlElement(name = "LegControlCardCode", required = true)
    protected String legControlCardCode;
    @XmlElement(name = "Remarks", required = true)
    protected String remarks;
    @XmlElement(name = "BenList", required = true)
    protected List<BenList> benList;

    /**
     * 获取id属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取updateType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUpdateType() {
        return updateType;
    }

    /**
     * 设置updateType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUpdateType(String value) {
        this.updateType = value;
    }

    /**
     * 获取cusType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusType() {
        return cusType;
    }

    /**
     * 设置cusType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusType(String value) {
        this.cusType = value;
    }

    /**
     * 获取cusNature属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusNature() {
        return cusNature;
    }

    /**
     * 设置cusNature属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusNature(String value) {
        this.cusNature = value;
    }

    /**
     * 获取cusName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * 设置cusName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusName(String value) {
        this.cusName = value;
    }

    /**
     * Gets the value of the bankList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankList }
     *
     *
     */
    public List<BankList> getBankList() {
        if (bankList == null) {
            bankList = new ArrayList<BankList>();
        }
        return this.bankList;
    }

    /**
     * 获取url属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * 获取serverIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 设置serverIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServerIp(String value) {
        this.serverIp = value;
    }

    /**
     * 获取mobileNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置mobileNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMobileNo(String value) {
        this.mobileNo = value;
    }

    /**
     * 获取address属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * 获取icp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIcp() {
        return icp;
    }

    /**
     * 设置icp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIcp(String value) {
        this.icp = value;
    }

    /**
     * 获取occurtimeb属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOccurtimeb() {
        return occurtimeb;
    }

    /**
     * 设置occurtimeb属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOccurtimeb(String value) {
        this.occurtimeb = value;
    }

    /**
     * 获取occurtimee属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOccurtimee() {
        return occurtimee;
    }

    /**
     * 设置occurtimee属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOccurtimee(String value) {
        this.occurtimee = value;
    }

    /**
     * 获取occurchan属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOccurchan() {
        return occurchan;
    }

    /**
     * 设置occurchan属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOccurchan(String value) {
        this.occurchan = value;
    }

    /**
     * 获取occurarea属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOccurarea() {
        return occurarea;
    }

    /**
     * 设置occurarea属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOccurarea(String value) {
        this.occurarea = value;
    }

    /**
     * 获取note属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置note属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * 获取validDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValidDate() {
        return validDate;
    }

    /**
     * 设置validDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValidDate(String value) {
        this.validDate = value;
    }

    /**
     * 获取orgId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置orgId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrgId(String value) {
        this.orgId = value;
    }

    /**
     * 获取repDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRepDate() {
        return repDate;
    }

    /**
     * 设置repDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRepDate(String value) {
        this.repDate = value;
    }

    /**
     * 获取repType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRepType() {
        return repType;
    }

    /**
     * 设置repType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRepType(String value) {
        this.repType = value;
    }

    /**
     * 获取repPerson属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRepPerson() {
        return repPerson;
    }

    /**
     * 设置repPerson属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRepPerson(String value) {
        this.repPerson = value;
    }

    /**
     * 获取registeredArea属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegisteredArea() {
        return registeredArea;
    }

    /**
     * 设置registeredArea属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegisteredArea(String value) {
        this.registeredArea = value;
    }

    /**
     * 获取registeredCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegisteredCode() {
        return registeredCode;
    }

    /**
     * 设置registeredCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegisteredCode(String value) {
        this.registeredCode = value;
    }

    /**
     * 获取sourceChannel属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSourceChannel() {
        return sourceChannel;
    }

    /**
     * 设置sourceChannel属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSourceChannel(String value) {
        this.sourceChannel = value;
    }

    /**
     * 获取currency属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置currency属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * 获取amount属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * 获取riskFindTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRiskFindTime() {
        return riskFindTime;
    }

    /**
     * 设置riskFindTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRiskFindTime(String value) {
        this.riskFindTime = value;
    }

    /**
     * 获取legControlName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegControlName() {
        return legControlName;
    }

    /**
     * 设置legControlName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegControlName(String value) {
        this.legControlName = value;
    }

    /**
     * 获取legControlCardType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegControlCardType() {
        return legControlCardType;
    }

    /**
     * 设置legControlCardType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegControlCardType(String value) {
        this.legControlCardType = value;
    }

    /**
     * 获取legControlCardCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegControlCardCode() {
        return legControlCardCode;
    }

    /**
     * 设置legControlCardCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegControlCardCode(String value) {
        this.legControlCardCode = value;
    }

    /**
     * 获取remarks属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置remarks属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the benList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the benList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBenList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BenList }
     *
     *
     */
    public List<BenList> getBenList() {
        if (benList == null) {
            benList = new ArrayList<BenList>();
        }
        return this.benList;
    }

}

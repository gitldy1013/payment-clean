//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:51 PM CST
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025;

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
 *         &lt;element ref="{}CusType"/>
 *         &lt;element ref="{}CusNature"/>
 *         &lt;element ref="{}RegName"/>
 *         &lt;element ref="{}CusName"/>
 *         &lt;element ref="{}CusNameEn"/>
 *         &lt;element ref="{}DocType"/>
 *         &lt;element ref="{}DocCode"/>
 *         &lt;element ref="{}LegDocName"/>
 *         &lt;element ref="{}LegDocType"/>
 *         &lt;element ref="{}LegDocCode"/>
 *         &lt;element ref="{}CusCode"/>
 *         &lt;element ref="{}InduType"/>
 *         &lt;element ref="{}BankNo"/>
 *         &lt;element ref="{}OpenBank"/>
 *         &lt;element ref="{}RegAddrProv"/>
 *         &lt;element ref="{}RegAddrDetail"/>
 *         &lt;element ref="{}AddrProv"/>
 *         &lt;element ref="{}AddrDetail"/>
 *         &lt;element ref="{}Url"/>
 *         &lt;element ref="{}ServerIp"/>
 *         &lt;element ref="{}Icp"/>
 *         &lt;element ref="{}ContName"/>
 *         &lt;element ref="{}ContPhone"/>
 *         &lt;element ref="{}CusEmail"/>
 *         &lt;element ref="{}Occurarea"/>
 *         &lt;element ref="{}NetworkType"/>
 *         &lt;element ref="{}Status"/>
 *         &lt;element ref="{}StartTime"/>
 *         &lt;element ref="{}EndTime"/>
 *         &lt;element ref="{}RiskStatus"/>
 *         &lt;element ref="{}ShareHolder"/>
 *         &lt;element ref="{}OpenType"/>
 *         &lt;element ref="{}ChageType"/>
 *         &lt;element ref="{}AccountType"/>
 *         &lt;element ref="{}ExpandType"/>
 *         &lt;element ref="{}OutServiceName"/>
 *         &lt;element ref="{}OutServiceCardType"/>
 *         &lt;element ref="{}OutServiceCardCode"/>
 *         &lt;element ref="{}OutServiceLegCardType"/>
 *         &lt;element ref="{}OutServiceLegCardCode"/>
 *         &lt;element ref="{}OrgId"/>
 *         &lt;element ref="{}RepDate"/>
 *         &lt;element ref="{}RepType"/>
 *         &lt;element ref="{}RepPerson"/>
 *         &lt;element ref="{}UnitProp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cusType",
    "cusNature",
    "regName",
    "cusName",
    "cusNameEn",
    "docType",
    "docCode",
    "legDocName",
    "legDocType",
    "legDocCode",
    "cusCode",
    "induType",
    "bankNo",
    "openBank",
    "regAddrProv",
    "regAddrDetail",
    "addrProv",
    "addrDetail",
    "url",
    "serverIp",
    "icp",
    "contName",
    "contPhone",
    "cusEmail",
    "occurarea",
    "networkType",
    "status",
    "startTime",
    "endTime",
    "riskStatus",
    "shareHolder",
    "openType",
    "chageType",
    "accountType",
    "expandType",
    "outServiceName",
    "outServiceCardType",
    "outServiceCardCode",
    "outServiceLegCardType",
    "outServiceLegCardCode",
    "orgId",
    "repDate",
    "repType",
    "repPerson",
    "unitProp"
})
@XmlRootElement(name = "BaseInfo")
public class BaseInfo {

    @XmlElement(name = "CusType", required = true)
    protected String cusType;
    @XmlElement(name = "CusNature", required = true)
    protected String cusNature;
    @XmlElement(name = "RegName", required = true)
    protected String regName;
    @XmlElement(name = "CusName", required = true)
    protected String cusName;
    @XmlElement(name = "CusNameEn", required = true)
    protected String cusNameEn;
    @XmlElement(name = "DocType", required = true)
    protected String docType;
    @XmlElement(name = "DocCode", required = true)
    protected String docCode;
    @XmlElement(name = "LegDocName", required = true)
    protected String legDocName;
    @XmlElement(name = "LegDocType", required = true)
    protected String legDocType;
    @XmlElement(name = "LegDocCode", required = true)
    protected String legDocCode;
    @XmlElement(name = "CusCode", required = true)
    protected String cusCode;
    @XmlElement(name = "InduType", required = true)
    protected String induType;
    @XmlElement(name = "BankNo", required = true)
    protected String bankNo;
    @XmlElement(name = "OpenBank", required = true)
    protected String openBank;
    @XmlElement(name = "RegAddrProv", required = true)
    protected String regAddrProv;
    @XmlElement(name = "RegAddrDetail", required = true)
    protected String regAddrDetail;
    @XmlElement(name = "AddrProv", required = true)
    protected String addrProv;
    @XmlElement(name = "AddrDetail", required = true)
    protected String addrDetail;
    @XmlElement(name = "Url", required = true)
    protected String url;
    @XmlElement(name = "ServerIp", required = true)
    protected String serverIp;
    @XmlElement(name = "Icp", required = true)
    protected String icp;
    @XmlElement(name = "ContName", required = true)
    protected String contName;
    @XmlElement(name = "ContPhone", required = true)
    protected String contPhone;
    @XmlElement(name = "CusEmail", required = true)
    protected String cusEmail;
    @XmlElement(name = "Occurarea", required = true)
    protected String occurarea;
    @XmlElement(name = "NetworkType", required = true)
    protected String networkType;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "StartTime", required = true)
    protected String startTime;
    @XmlElement(name = "EndTime", required = true)
    protected String endTime;
    @XmlElement(name = "RiskStatus", required = true)
    protected String riskStatus;
    @XmlElement(name = "ShareHolder", required = true)
    protected String shareHolder;
    @XmlElement(name = "OpenType", required = true)
    protected String openType;
    @XmlElement(name = "ChageType", required = true)
    protected String chageType;
    @XmlElement(name = "AccountType", required = true)
    protected String accountType;
    @XmlElement(name = "ExpandType", required = true)
    protected String expandType;
    @XmlElement(name = "OutServiceName", required = true)
    protected String outServiceName;
    @XmlElement(name = "OutServiceCardType", required = true)
    protected String outServiceCardType;
    @XmlElement(name = "OutServiceCardCode", required = true)
    protected String outServiceCardCode;
    @XmlElement(name = "OutServiceLegCardType", required = true)
    protected String outServiceLegCardType;
    @XmlElement(name = "OutServiceLegCardCode", required = true)
    protected String outServiceLegCardCode;
    @XmlElement(name = "OrgId", required = true)
    protected String orgId;
    @XmlElement(name = "RepDate", required = true)
    protected String repDate;
    @XmlElement(name = "RepType", required = true)
    protected String repType;
    @XmlElement(name = "RepPerson", required = true)
    protected String repPerson;
    @XmlElement(name = "UnitProp", required = true)
    protected String unitProp;

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
     * 获取regName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegName() {
        return regName;
    }

    /**
     * 设置regName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegName(String value) {
        this.regName = value;
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
     * 获取cusNameEn属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusNameEn() {
        return cusNameEn;
    }

    /**
     * 设置cusNameEn属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusNameEn(String value) {
        this.cusNameEn = value;
    }

    /**
     * 获取docType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 设置docType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * 获取docCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * 设置docCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDocCode(String value) {
        this.docCode = value;
    }

    /**
     * 获取legDocName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegDocName() {
        return legDocName;
    }

    /**
     * 设置legDocName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegDocName(String value) {
        this.legDocName = value;
    }

    /**
     * 获取legDocType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegDocType() {
        return legDocType;
    }

    /**
     * 设置legDocType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegDocType(String value) {
        this.legDocType = value;
    }

    /**
     * 获取legDocCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLegDocCode() {
        return legDocCode;
    }

    /**
     * 设置legDocCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLegDocCode(String value) {
        this.legDocCode = value;
    }

    /**
     * 获取cusCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusCode() {
        return cusCode;
    }

    /**
     * 设置cusCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusCode(String value) {
        this.cusCode = value;
    }

    /**
     * 获取induType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInduType() {
        return induType;
    }

    /**
     * 设置induType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInduType(String value) {
        this.induType = value;
    }

    /**
     * 获取bankNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置bankNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBankNo(String value) {
        this.bankNo = value;
    }

    /**
     * 获取openBank属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * 设置openBank属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpenBank(String value) {
        this.openBank = value;
    }

    /**
     * 获取regAddrProv属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegAddrProv() {
        return regAddrProv;
    }

    /**
     * 设置regAddrProv属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegAddrProv(String value) {
        this.regAddrProv = value;
    }

    /**
     * 获取regAddrDetail属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegAddrDetail() {
        return regAddrDetail;
    }

    /**
     * 设置regAddrDetail属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegAddrDetail(String value) {
        this.regAddrDetail = value;
    }

    /**
     * 获取addrProv属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddrProv() {
        return addrProv;
    }

    /**
     * 设置addrProv属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddrProv(String value) {
        this.addrProv = value;
    }

    /**
     * 获取addrDetail属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddrDetail() {
        return addrDetail;
    }

    /**
     * 设置addrDetail属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddrDetail(String value) {
        this.addrDetail = value;
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
     * 获取contName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContName() {
        return contName;
    }

    /**
     * 设置contName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContName(String value) {
        this.contName = value;
    }

    /**
     * 获取contPhone属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContPhone() {
        return contPhone;
    }

    /**
     * 设置contPhone属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContPhone(String value) {
        this.contPhone = value;
    }

    /**
     * 获取cusEmail属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCusEmail() {
        return cusEmail;
    }

    /**
     * 设置cusEmail属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCusEmail(String value) {
        this.cusEmail = value;
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
     * 获取networkType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNetworkType() {
        return networkType;
    }

    /**
     * 设置networkType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNetworkType(String value) {
        this.networkType = value;
    }

    /**
     * 获取status属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取startTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置startTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * 获取endTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置endTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * 获取riskStatus属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRiskStatus() {
        return riskStatus;
    }

    /**
     * 设置riskStatus属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRiskStatus(String value) {
        this.riskStatus = value;
    }

    /**
     * 获取shareHolder属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShareHolder() {
        return shareHolder;
    }

    /**
     * 设置shareHolder属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShareHolder(String value) {
        this.shareHolder = value;
    }

    /**
     * 获取openType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * 设置openType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpenType(String value) {
        this.openType = value;
    }

    /**
     * 获取chageType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getChageType() {
        return chageType;
    }

    /**
     * 设置chageType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setChageType(String value) {
        this.chageType = value;
    }

    /**
     * 获取accountType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置accountType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * 获取expandType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpandType() {
        return expandType;
    }

    /**
     * 设置expandType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpandType(String value) {
        this.expandType = value;
    }

    /**
     * 获取outServiceName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutServiceName() {
        return outServiceName;
    }

    /**
     * 设置outServiceName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutServiceName(String value) {
        this.outServiceName = value;
    }

    /**
     * 获取outServiceCardType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutServiceCardType() {
        return outServiceCardType;
    }

    /**
     * 设置outServiceCardType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutServiceCardType(String value) {
        this.outServiceCardType = value;
    }

    /**
     * 获取outServiceCardCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutServiceCardCode() {
        return outServiceCardCode;
    }

    /**
     * 设置outServiceCardCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutServiceCardCode(String value) {
        this.outServiceCardCode = value;
    }

    /**
     * 获取outServiceLegCardType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutServiceLegCardType() {
        return outServiceLegCardType;
    }

    /**
     * 设置outServiceLegCardType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutServiceLegCardType(String value) {
        this.outServiceLegCardType = value;
    }

    /**
     * 获取outServiceLegCardCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOutServiceLegCardCode() {
        return outServiceLegCardCode;
    }

    /**
     * 设置outServiceLegCardCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOutServiceLegCardCode(String value) {
        this.outServiceLegCardCode = value;
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
     * 获取unitProp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnitProp() {
        return unitProp;
    }

    /**
     * 设置unitProp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnitProp(String value) {
        this.unitProp = value;
    }

}

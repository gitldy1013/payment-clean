//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:50 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DocCode_QNAME = new QName("", "DocCode");
    private final static QName _Address_QNAME = new QName("", "Address");
    private final static QName _SourceChannel_QNAME = new QName("", "SourceChannel");
    private final static QName _LegControlCardCode_QNAME = new QName("", "LegControlCardCode");
    private final static QName _Count_QNAME = new QName("", "Count");
    private final static QName _Occurarea_QNAME = new QName("", "Occurarea");
    private final static QName _ValidDate_QNAME = new QName("", "ValidDate");
    private final static QName _Version_QNAME = new QName("", "Version");
    private final static QName _RegisteredArea_QNAME = new QName("", "RegisteredArea");
    private final static QName _Remarks_QNAME = new QName("", "Remarks");
    private final static QName _LegControlName_QNAME = new QName("", "LegControlName");
    private final static QName _BankNo_QNAME = new QName("", "BankNo");
    private final static QName _Currency_QNAME = new QName("", "Currency");
    private final static QName _CusType_QNAME = new QName("", "CusType");
    private final static QName _RiskType_QNAME = new QName("", "RiskType");
    private final static QName _RiskFindTime_QNAME = new QName("", "RiskFindTime");
    private final static QName _LegBenName_QNAME = new QName("", "LegBenName");
    private final static QName _RepDate_QNAME = new QName("", "RepDate");
    private final static QName _TrnxCode_QNAME = new QName("", "TrnxCode");
    private final static QName _CusName_QNAME = new QName("", "CusName");
    private final static QName _OrgCode_QNAME = new QName("", "OrgCode");
    private final static QName _SecretKey_QNAME = new QName("", "SecretKey");
    private final static QName _LegRepName_QNAME = new QName("", "LegRepName");
    private final static QName _TrnxTime_QNAME = new QName("", "TrnxTime");
    private final static QName _IsTransfer_QNAME = new QName("", "IsTransfer");
    private final static QName _Note_QNAME = new QName("", "Note");
    private final static QName _OrigSenderSID_QNAME = new QName("", "OrigSenderSID");
    private final static QName _Level_QNAME = new QName("", "Level");
    private final static QName _RepType_QNAME = new QName("", "RepType");
    private final static QName _CusProperty_QNAME = new QName("", "CusProperty");
    private final static QName _Occurchan_QNAME = new QName("", "Occurchan");
    private final static QName _Identification_QNAME = new QName("", "Identification");
    private final static QName _LegControlCardType_QNAME = new QName("", "LegControlCardType");
    private final static QName _CusNature_QNAME = new QName("", "CusNature");
    private final static QName _Url_QNAME = new QName("", "Url");
    private final static QName _LegBenCardCode_QNAME = new QName("", "LegBenCardCode");
    private final static QName _LegDocType_QNAME = new QName("", "LegDocType");
    private final static QName _DocType_QNAME = new QName("", "DocType");
    private final static QName _MobileNo_QNAME = new QName("", "MobileNo");
    private final static QName _Occurtimeb_QNAME = new QName("", "Occurtimeb");
    private final static QName _Occurtimee_QNAME = new QName("", "Occurtimee");
    private final static QName _ServerIp_QNAME = new QName("", "ServerIp");
    private final static QName _Amount_QNAME = new QName("", "Amount");
    private final static QName _RecSystemId_QNAME = new QName("", "RecSystemId");
    private final static QName _LegBenCardType_QNAME = new QName("", "LegBenCardType");
    private final static QName _OrgId_QNAME = new QName("", "OrgId");
    private final static QName _OrigSender_QNAME = new QName("", "OrigSender");
    private final static QName _CusCode_QNAME = new QName("", "CusCode");
    private final static QName _RegisteredCode_QNAME = new QName("", "RegisteredCode");
    private final static QName _RepPerson_QNAME = new QName("", "RepPerson");
    private final static QName _RegName_QNAME = new QName("", "RegName");
    private final static QName _Icp_QNAME = new QName("", "Icp");
    private final static QName _Signature_QNAME = new QName("", "Signature");
    private final static QName _OpenBank_QNAME = new QName("", "OpenBank");
    private final static QName _LegDocCode_QNAME = new QName("", "LegDocCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Head }
     * 
     */
    public Head createHead() {
        return new Head();
    }

    /**
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link PcacList }
     * 
     */
    public PcacList createPcacList() {
        return new PcacList();
    }

    /**
     * Create an instance of {@link RiskInfo }
     * 
     */
    public RiskInfo createRiskInfo() {
        return new RiskInfo();
    }

    /**
     * Create an instance of {@link BankList }
     * 
     */
    public BankList createBankList() {
        return new BankList();
    }

    /**
     * Create an instance of {@link BankInfo }
     * 
     */
    public BankInfo createBankInfo() {
        return new BankInfo();
    }

    /**
     * Create an instance of {@link BenList }
     * 
     */
    public BenList createBenList() {
        return new BenList();
    }

    /**
     * Create an instance of {@link BenInfo }
     * 
     */
    public BenInfo createBenInfo() {
        return new BenInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DocCode")
    public JAXBElement<String> createDocCode(String value) {
        return new JAXBElement<String>(_DocCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Address")
    public JAXBElement<String> createAddress(String value) {
        return new JAXBElement<String>(_Address_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SourceChannel")
    public JAXBElement<String> createSourceChannel(String value) {
        return new JAXBElement<String>(_SourceChannel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegControlCardCode")
    public JAXBElement<String> createLegControlCardCode(String value) {
        return new JAXBElement<String>(_LegControlCardCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Count")
    public JAXBElement<String> createCount(String value) {
        return new JAXBElement<String>(_Count_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Occurarea")
    public JAXBElement<String> createOccurarea(String value) {
        return new JAXBElement<String>(_Occurarea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ValidDate")
    public JAXBElement<String> createValidDate(String value) {
        return new JAXBElement<String>(_ValidDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Version")
    public JAXBElement<String> createVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegisteredArea")
    public JAXBElement<String> createRegisteredArea(String value) {
        return new JAXBElement<String>(_RegisteredArea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Remarks")
    public JAXBElement<String> createRemarks(String value) {
        return new JAXBElement<String>(_Remarks_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegControlName")
    public JAXBElement<String> createLegControlName(String value) {
        return new JAXBElement<String>(_LegControlName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BankNo")
    public JAXBElement<String> createBankNo(String value) {
        return new JAXBElement<String>(_BankNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Currency")
    public JAXBElement<String> createCurrency(String value) {
        return new JAXBElement<String>(_Currency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusType")
    public JAXBElement<String> createCusType(String value) {
        return new JAXBElement<String>(_CusType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RiskType")
    public JAXBElement<String> createRiskType(String value) {
        return new JAXBElement<String>(_RiskType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RiskFindTime")
    public JAXBElement<String> createRiskFindTime(String value) {
        return new JAXBElement<String>(_RiskFindTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegBenName")
    public JAXBElement<String> createLegBenName(String value) {
        return new JAXBElement<String>(_LegBenName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RepDate")
    public JAXBElement<String> createRepDate(String value) {
        return new JAXBElement<String>(_RepDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TrnxCode")
    public JAXBElement<String> createTrnxCode(String value) {
        return new JAXBElement<String>(_TrnxCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusName")
    public JAXBElement<String> createCusName(String value) {
        return new JAXBElement<String>(_CusName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OrgCode")
    public JAXBElement<String> createOrgCode(String value) {
        return new JAXBElement<String>(_OrgCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SecretKey")
    public JAXBElement<String> createSecretKey(String value) {
        return new JAXBElement<String>(_SecretKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegRepName")
    public JAXBElement<String> createLegRepName(String value) {
        return new JAXBElement<String>(_LegRepName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TrnxTime")
    public JAXBElement<String> createTrnxTime(String value) {
        return new JAXBElement<String>(_TrnxTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsTransfer")
    public JAXBElement<String> createIsTransfer(String value) {
        return new JAXBElement<String>(_IsTransfer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Note")
    public JAXBElement<String> createNote(String value) {
        return new JAXBElement<String>(_Note_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OrigSenderSID")
    public JAXBElement<String> createOrigSenderSID(String value) {
        return new JAXBElement<String>(_OrigSenderSID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Level")
    public JAXBElement<String> createLevel(String value) {
        return new JAXBElement<String>(_Level_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RepType")
    public JAXBElement<String> createRepType(String value) {
        return new JAXBElement<String>(_RepType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusProperty")
    public JAXBElement<String> createCusProperty(String value) {
        return new JAXBElement<String>(_CusProperty_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Occurchan")
    public JAXBElement<String> createOccurchan(String value) {
        return new JAXBElement<String>(_Occurchan_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Identification")
    public JAXBElement<String> createIdentification(String value) {
        return new JAXBElement<String>(_Identification_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegControlCardType")
    public JAXBElement<String> createLegControlCardType(String value) {
        return new JAXBElement<String>(_LegControlCardType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusNature")
    public JAXBElement<String> createCusNature(String value) {
        return new JAXBElement<String>(_CusNature_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Url")
    public JAXBElement<String> createUrl(String value) {
        return new JAXBElement<String>(_Url_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegBenCardCode")
    public JAXBElement<String> createLegBenCardCode(String value) {
        return new JAXBElement<String>(_LegBenCardCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegDocType")
    public JAXBElement<String> createLegDocType(String value) {
        return new JAXBElement<String>(_LegDocType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DocType")
    public JAXBElement<String> createDocType(String value) {
        return new JAXBElement<String>(_DocType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MobileNo")
    public JAXBElement<String> createMobileNo(String value) {
        return new JAXBElement<String>(_MobileNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Occurtimeb")
    public JAXBElement<String> createOccurtimeb(String value) {
        return new JAXBElement<String>(_Occurtimeb_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Occurtimee")
    public JAXBElement<String> createOccurtimee(String value) {
        return new JAXBElement<String>(_Occurtimee_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServerIp")
    public JAXBElement<String> createServerIp(String value) {
        return new JAXBElement<String>(_ServerIp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Amount")
    public JAXBElement<String> createAmount(String value) {
        return new JAXBElement<String>(_Amount_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RecSystemId")
    public JAXBElement<String> createRecSystemId(String value) {
        return new JAXBElement<String>(_RecSystemId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegBenCardType")
    public JAXBElement<String> createLegBenCardType(String value) {
        return new JAXBElement<String>(_LegBenCardType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OrgId")
    public JAXBElement<String> createOrgId(String value) {
        return new JAXBElement<String>(_OrgId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OrigSender")
    public JAXBElement<String> createOrigSender(String value) {
        return new JAXBElement<String>(_OrigSender_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusCode")
    public JAXBElement<String> createCusCode(String value) {
        return new JAXBElement<String>(_CusCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegisteredCode")
    public JAXBElement<String> createRegisteredCode(String value) {
        return new JAXBElement<String>(_RegisteredCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RepPerson")
    public JAXBElement<String> createRepPerson(String value) {
        return new JAXBElement<String>(_RepPerson_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegName")
    public JAXBElement<String> createRegName(String value) {
        return new JAXBElement<String>(_RegName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Icp")
    public JAXBElement<String> createIcp(String value) {
        return new JAXBElement<String>(_Icp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Signature")
    public JAXBElement<String> createSignature(String value) {
        return new JAXBElement<String>(_Signature_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OpenBank")
    public JAXBElement<String> createOpenBank(String value) {
        return new JAXBElement<String>(_OpenBank_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LegDocCode")
    public JAXBElement<String> createLegDocCode(String value) {
        return new JAXBElement<String>(_LegDocCode_QNAME, String.class, null, value);
    }

}

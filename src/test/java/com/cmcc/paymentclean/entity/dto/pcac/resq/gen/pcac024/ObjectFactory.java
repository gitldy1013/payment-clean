//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.10.14 时间 04:25:43 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024 package. 
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
    private final static QName _ContName_QNAME = new QName("", "ContName");
    private final static QName _OpenType_QNAME = new QName("", "OpenType");
    private final static QName _OutServiceCardCode_QNAME = new QName("", "OutServiceCardCode");
    private final static QName _EndTime_QNAME = new QName("", "EndTime");
    private final static QName _RegAddrDetail_QNAME = new QName("", "RegAddrDetail");
    private final static QName _Identification_QNAME = new QName("", "Identification");
    private final static QName _CusNature_QNAME = new QName("", "CusNature");
    private final static QName _Url_QNAME = new QName("", "Url");
    private final static QName _Occurarea_QNAME = new QName("", "Occurarea");
    private final static QName _InduType_QNAME = new QName("", "InduType");
    private final static QName _Version_QNAME = new QName("", "Version");
    private final static QName _NetworkType_QNAME = new QName("", "NetworkType");
    private final static QName _BankNo_QNAME = new QName("", "BankNo");
    private final static QName _OutServiceLegCardCode_QNAME = new QName("", "OutServiceLegCardCode");
    private final static QName _OutServiceName_QNAME = new QName("", "OutServiceName");
    private final static QName _CusType_QNAME = new QName("", "CusType");
    private final static QName _DocType_QNAME = new QName("", "DocType");
    private final static QName _OutServiceCardType_QNAME = new QName("", "OutServiceCardType");
    private final static QName _CusEmail_QNAME = new QName("", "CusEmail");
    private final static QName _Status_QNAME = new QName("", "Status");
    private final static QName _ServerIp_QNAME = new QName("", "ServerIp");
    private final static QName _StartTime_QNAME = new QName("", "StartTime");
    private final static QName _RepDate_QNAME = new QName("", "RepDate");
    private final static QName _ExpandType_QNAME = new QName("", "ExpandType");
    private final static QName _TrnxCode_QNAME = new QName("", "TrnxCode");
    private final static QName _RiskStatus_QNAME = new QName("", "RiskStatus");
    private final static QName _AccountType_QNAME = new QName("", "AccountType");
    private final static QName _CusName_QNAME = new QName("", "CusName");
    private final static QName _AddrDetail_QNAME = new QName("", "AddrDetail");
    private final static QName _ChageType_QNAME = new QName("", "ChageType");
    private final static QName _RecSystemId_QNAME = new QName("", "RecSystemId");
    private final static QName _OrgId_QNAME = new QName("", "OrgId");
    private final static QName _SecretKey_QNAME = new QName("", "SecretKey");
    private final static QName _CusCode_QNAME = new QName("", "CusCode");
    private final static QName _OrigSender_QNAME = new QName("", "OrigSender");
    private final static QName _OutServiceLegCardType_QNAME = new QName("", "OutServiceLegCardType");
    private final static QName _TrnxTime_QNAME = new QName("", "TrnxTime");
    private final static QName _CusNameEn_QNAME = new QName("", "CusNameEn");
    private final static QName _AddrProv_QNAME = new QName("", "AddrProv");
    private final static QName _RepPerson_QNAME = new QName("", "RepPerson");
    private final static QName _RegName_QNAME = new QName("", "RegName");
    private final static QName _Icp_QNAME = new QName("", "Icp");
    private final static QName _OrigSenderSID_QNAME = new QName("", "OrigSenderSID");
    private final static QName _OpenBank_QNAME = new QName("", "OpenBank");
    private final static QName _RepType_QNAME = new QName("", "RepType");
    private final static QName _RegAddrProv_QNAME = new QName("", "RegAddrProv");
    private final static QName _ContPhone_QNAME = new QName("", "ContPhone");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BaseInfo }
     * 
     */
    public BaseInfo createBaseInfo() {
        return new BaseInfo();
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
    @XmlElementDecl(namespace = "", name = "ContName")
    public JAXBElement<String> createContName(String value) {
        return new JAXBElement<String>(_ContName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OpenType")
    public JAXBElement<String> createOpenType(String value) {
        return new JAXBElement<String>(_OpenType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OutServiceCardCode")
    public JAXBElement<String> createOutServiceCardCode(String value) {
        return new JAXBElement<String>(_OutServiceCardCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EndTime")
    public JAXBElement<String> createEndTime(String value) {
        return new JAXBElement<String>(_EndTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegAddrDetail")
    public JAXBElement<String> createRegAddrDetail(String value) {
        return new JAXBElement<String>(_RegAddrDetail_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "Occurarea")
    public JAXBElement<String> createOccurarea(String value) {
        return new JAXBElement<String>(_Occurarea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "InduType")
    public JAXBElement<String> createInduType(String value) {
        return new JAXBElement<String>(_InduType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "NetworkType")
    public JAXBElement<String> createNetworkType(String value) {
        return new JAXBElement<String>(_NetworkType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "OutServiceLegCardCode")
    public JAXBElement<String> createOutServiceLegCardCode(String value) {
        return new JAXBElement<String>(_OutServiceLegCardCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OutServiceName")
    public JAXBElement<String> createOutServiceName(String value) {
        return new JAXBElement<String>(_OutServiceName_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "DocType")
    public JAXBElement<String> createDocType(String value) {
        return new JAXBElement<String>(_DocType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OutServiceCardType")
    public JAXBElement<String> createOutServiceCardType(String value) {
        return new JAXBElement<String>(_OutServiceCardType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CusEmail")
    public JAXBElement<String> createCusEmail(String value) {
        return new JAXBElement<String>(_CusEmail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Status")
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "StartTime")
    public JAXBElement<String> createStartTime(String value) {
        return new JAXBElement<String>(_StartTime_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "ExpandType")
    public JAXBElement<String> createExpandType(String value) {
        return new JAXBElement<String>(_ExpandType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RiskStatus")
    public JAXBElement<String> createRiskStatus(String value) {
        return new JAXBElement<String>(_RiskStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AccountType")
    public JAXBElement<String> createAccountType(String value) {
        return new JAXBElement<String>(_AccountType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "AddrDetail")
    public JAXBElement<String> createAddrDetail(String value) {
        return new JAXBElement<String>(_AddrDetail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ChageType")
    public JAXBElement<String> createChageType(String value) {
        return new JAXBElement<String>(_ChageType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "OrgId")
    public JAXBElement<String> createOrgId(String value) {
        return new JAXBElement<String>(_OrgId_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "CusCode")
    public JAXBElement<String> createCusCode(String value) {
        return new JAXBElement<String>(_CusCode_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "OutServiceLegCardType")
    public JAXBElement<String> createOutServiceLegCardType(String value) {
        return new JAXBElement<String>(_OutServiceLegCardType_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "CusNameEn")
    public JAXBElement<String> createCusNameEn(String value) {
        return new JAXBElement<String>(_CusNameEn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AddrProv")
    public JAXBElement<String> createAddrProv(String value) {
        return new JAXBElement<String>(_AddrProv_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "OrigSenderSID")
    public JAXBElement<String> createOrigSenderSID(String value) {
        return new JAXBElement<String>(_OrigSenderSID_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RepType")
    public JAXBElement<String> createRepType(String value) {
        return new JAXBElement<String>(_RepType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegAddrProv")
    public JAXBElement<String> createRegAddrProv(String value) {
        return new JAXBElement<String>(_RegAddrProv_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ContPhone")
    public JAXBElement<String> createContPhone(String value) {
        return new JAXBElement<String>(_ContPhone_QNAME, String.class, null, value);
    }

}

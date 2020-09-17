//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:49 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001 package. 
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
    private final static QName _Email_QNAME = new QName("", "Email");
    private final static QName _Telephone_QNAME = new QName("", "Telephone");
    private final static QName _Address_QNAME = new QName("", "Address");
    private final static QName _RecDocType_QNAME = new QName("", "RecDocType");
    private final static QName _Ip_QNAME = new QName("", "Ip");
    private final static QName _CusProperty_QNAME = new QName("", "CusProperty");
    private final static QName _Occurchan_QNAME = new QName("", "Occurchan");
    private final static QName _RecDocCode_QNAME = new QName("", "RecDocCode");
    private final static QName _Imei_QNAME = new QName("", "Imei");
    private final static QName _Identification_QNAME = new QName("", "Identification");
    private final static QName _Count_QNAME = new QName("", "Count");
    private final static QName _Occurarea_QNAME = new QName("", "Occurarea");
    private final static QName _ValidDate_QNAME = new QName("", "ValidDate");
    private final static QName _Version_QNAME = new QName("", "Version");
    private final static QName _BankNo_QNAME = new QName("", "BankNo");
    private final static QName _RecBankNo_QNAME = new QName("", "RecBankNo");
    private final static QName _RecOpenBank_QNAME = new QName("", "RecOpenBank");
    private final static QName _DocType_QNAME = new QName("", "DocType");
    private final static QName _MobileNo_QNAME = new QName("", "MobileNo");
    private final static QName _Occurtimeb_QNAME = new QName("", "Occurtimeb");
    private final static QName _Occurtimee_QNAME = new QName("", "Occurtimee");
    private final static QName _RepDate_QNAME = new QName("", "RepDate");
    private final static QName _RecName_QNAME = new QName("", "RecName");
    private final static QName _TrnxCode_QNAME = new QName("", "TrnxCode");
    private final static QName _RecSystemId_QNAME = new QName("", "RecSystemId");
    private final static QName _Mac_QNAME = new QName("", "Mac");
    private final static QName _CusName_QNAME = new QName("", "CusName");
    private final static QName _OrgId_QNAME = new QName("", "OrgId");
    private final static QName _OrigSender_QNAME = new QName("", "OrigSender");
    private final static QName _TrnxTime_QNAME = new QName("", "TrnxTime");
    private final static QName _RepPerson_QNAME = new QName("", "RepPerson");
    private final static QName _IsTransfer_QNAME = new QName("", "IsTransfer");
    private final static QName _Note_QNAME = new QName("", "Note");
    private final static QName _Signature_QNAME = new QName("", "Signature");
    private final static QName _OrigSenderSID_QNAME = new QName("", "OrigSenderSID");
    private final static QName _OpenBank_QNAME = new QName("", "OpenBank");
    private final static QName _RecHostArea_QNAME = new QName("", "RecHostArea");
    private final static QName _RepType_QNAME = new QName("", "RepType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001
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
    @XmlElementDecl(namespace = "", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Telephone")
    public JAXBElement<String> createTelephone(String value) {
        return new JAXBElement<String>(_Telephone_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RecDocType")
    public JAXBElement<String> createRecDocType(String value) {
        return new JAXBElement<String>(_RecDocType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ip")
    public JAXBElement<String> createIp(String value) {
        return new JAXBElement<String>(_Ip_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RecDocCode")
    public JAXBElement<String> createRecDocCode(String value) {
        return new JAXBElement<String>(_RecDocCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Imei")
    public JAXBElement<String> createImei(String value) {
        return new JAXBElement<String>(_Imei_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "BankNo")
    public JAXBElement<String> createBankNo(String value) {
        return new JAXBElement<String>(_BankNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RecBankNo")
    public JAXBElement<String> createRecBankNo(String value) {
        return new JAXBElement<String>(_RecBankNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RecOpenBank")
    public JAXBElement<String> createRecOpenBank(String value) {
        return new JAXBElement<String>(_RecOpenBank_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RepDate")
    public JAXBElement<String> createRepDate(String value) {
        return new JAXBElement<String>(_RepDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RecName")
    public JAXBElement<String> createRecName(String value) {
        return new JAXBElement<String>(_RecName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TrnxCode")
    public JAXBElement<Object> createTrnxCode(Object value) {
        return new JAXBElement<Object>(_TrnxCode_QNAME, Object.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "Mac")
    public JAXBElement<String> createMac(String value) {
        return new JAXBElement<String>(_Mac_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "TrnxTime")
    public JAXBElement<String> createTrnxTime(String value) {
        return new JAXBElement<String>(_TrnxTime_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "Signature")
    public JAXBElement<String> createSignature(String value) {
        return new JAXBElement<String>(_Signature_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "RecHostArea")
    public JAXBElement<String> createRecHostArea(String value) {
        return new JAXBElement<String>(_RecHostArea_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RepType")
    public JAXBElement<String> createRepType(String value) {
        return new JAXBElement<String>(_RepType_QNAME, String.class, null, value);
    }

}

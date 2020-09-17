//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.09.17 时间 06:12:52 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045 package. 
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

    private final static QName _Amount_QNAME = new QName("", "Amount");
    private final static QName _Identification_QNAME = new QName("", "Identification");
    private final static QName _Count_QNAME = new QName("", "Count");
    private final static QName _TrnxCode_QNAME = new QName("", "TrnxCode");
    private final static QName _RecSystemId_QNAME = new QName("", "RecSystemId");
    private final static QName _SecretKey_QNAME = new QName("", "SecretKey");
    private final static QName _OrigSender_QNAME = new QName("", "OrigSender");
    private final static QName _Version_QNAME = new QName("", "Version");
    private final static QName _TrnxTime_QNAME = new QName("", "TrnxTime");
    private final static QName _Signature_QNAME = new QName("", "Signature");
    private final static QName _Currency_QNAME = new QName("", "Currency");
    private final static QName _OrigSenderSID_QNAME = new QName("", "OrigSenderSID");
    private final static QName _RiskType_QNAME = new QName("", "RiskType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Head }
     * 
     */
    public Head createHead() {
        return new Head();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
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
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
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
    @XmlElementDecl(namespace = "", name = "TrnxCode")
    public JAXBElement<String> createTrnxCode(String value) {
        return new JAXBElement<String>(_TrnxCode_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "SecretKey")
    public JAXBElement<String> createSecretKey(String value) {
        return new JAXBElement<String>(_SecretKey_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "Version")
    public JAXBElement<String> createVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "Signature")
    public JAXBElement<String> createSignature(String value) {
        return new JAXBElement<String>(_Signature_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "OrigSenderSID")
    public JAXBElement<String> createOrigSenderSID(String value) {
        return new JAXBElement<String>(_OrigSenderSID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RiskType")
    public JAXBElement<String> createRiskType(String value) {
        return new JAXBElement<String>(_RiskType_QNAME, String.class, null, value);
    }

}

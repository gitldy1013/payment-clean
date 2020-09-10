package com.cmcc.paymentclean.utils;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @ jaxb/Jaxp工具类  schema验证
 */
public class ValidateUtils {
    //validate xml using xsd file
    public static boolean validate(InputStream isXml, InputStream isXsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            //System.out.println("xml:"+IOUtil.Stream2String(isXml));
            //System.out.println("xsd:"+IOUtil.Stream2String(isXsd));
            Source xsd = new StreamSource(isXsd);
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;

        } catch (SAXException e) {
            flag = false;
            throw new SAXException(e.getMessage());

        } catch (IOException e) {
            flag = false;
            throw new IOException(e.getMessage());
        } finally {
            //释放流
            if (isXml != null) {
                isXml.close();
            }
            if (isXsd != null) {
                isXsd.close();
            }
        }
        return flag;
    }

    //	validate xml using xsd file
    public static boolean validate(InputStream isXml, File isXsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            //System.out.println("xml:"+IOUtil.Stream2String(isXml));
            //System.out.println("xsd:"+IOUtil.Stream2String(isXsd));
            Source xsd = new StreamSource(isXsd);
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;
        } catch (SAXException e) {
            //e.printStackTrace();
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            throw new IOException(e.getMessage());
        } finally {
            //释放流
            if (isXml != null) {
                isXml.close();
            }
        }
        return flag;
    }

    //validate xml using xsd file
    public static boolean validate(InputStream isXml, URL xsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Source g = new StreamSource();
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(isXml));
            flag = true;
        } catch (SAXException e) {
            //e.printStackTrace();
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            // e.printStackTrace();
            throw new IOException(e.getMessage());
        } finally {
            //释放流
            if (isXml != null) {
                isXml.close();
            }
        }
        return flag;
    }

    //	validate xml using xsd file
    public static boolean validate(File xml, File xsd) throws SAXException, IOException {
        boolean flag = false;
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = sf.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            flag = true;
        } catch (SAXException e) {
            //e.printStackTrace();
            throw new SAXException(e.getMessage());
        } catch (IOException e) {
            //e.printStackTrace();
            throw new IOException(e.getMessage());
        }
        return flag;
    }

    public static boolean validateXml(InputStream inXml, InputStream inXsd) throws ParserConfigurationException, SAXException, IOException {
        boolean flag = false;
        try {//xml   dom     builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            //w3c  dom
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(inXml);//读取inputstream

            //handle  schema  validation
            SchemaFactory constraintFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source constraints = new StreamSource(inXsd);
            Schema schema = constraintFactory.newSchema(constraints);
            Validator validator = schema.newValidator();
            // validator.setErrorHandler();
            // validate  the  dom  tree
            validator.validate(new DOMSource(doc));
            flag = true;

        } finally {
            inXml.close();
            inXsd.close();
        }
        ;
        return flag;
    }

    public static void main(String[] args) throws IOException, SAXException {
        // InputStream is = new ByteArrayInputStream("".getBytes());
        boolean isPassed = false;
        isPassed = validate(new FileInputStream("C:\\GG.XML"), new FileInputStream("/xsds/pcac.ries.001.xsd"));//validate(new File("C:\\GG.XML"), new File(xsd));
        if (isPassed) {
            System.out.println("通过");
        } else {
            System.out.println("没有通过");
        }
    }

}

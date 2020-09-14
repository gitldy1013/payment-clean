package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

import static com.cmcc.paymentclean.utils.CodeGenerator.BASE_MAPPER_ROOT;
import static com.cmcc.paymentclean.utils.CodeGenerator.PROJECT_PATH;

/**
 * xml校验工具类  schema验证
 */
@Slf4j
public class ValidateUtils {

    public static final String XSD_DIR = PROJECT_PATH + BASE_MAPPER_ROOT + "xsds/";


    /**
     * 通过XSD(XML Schema)校验XML PCAC
     */
    public static boolean validateXMLByXSD(String xml, String xsdpath) {
        try {
            //建立schema工厂
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //建立验证文档文件对象，利用此文件对象所封装的文件进行schema验证
            log.info("文件路径：{}", xsdpath + ".xsd");
            File schemaFile = new File(xsdpath + ".xsd");
            //利用schema工厂，接收验证文档文件对象生成Schema对象
            Schema schema = schemaFactory.newSchema(schemaFile);
            //通过Schema产生针对于此Schema的验证器，利用schenaFile进行验证
            Validator validator = schema.newValidator();
            //得到验证的数据源
            Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
            //开始验证，成功输出success!!!，失败输出fail
            validator.validate(source);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 通过XSD(XML Schema)校验XML
     */
    public static boolean validateXML(String xml, String xsd) {
        try {
            //创建默认的XML错误处理器
            XMLErrorHandler errorHandler = new XMLErrorHandler();
            //获取基于 SAX 的解析器的实例
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //解析器在解析时验证 XML 内容。
            factory.setValidating(true);
            //指定由此代码生成的解析器将提供对 XML 名称空间的支持。
            factory.setNamespaceAware(true);
            //使用当前配置的工厂参数创建 SAXParser 的一个新实例。
            SAXParser parser = factory.newSAXParser();
            //创建一个读取工具
            SAXReader xmlReader = new SAXReader();
            //获取要校验xml文档实例
            Document xmlDocument = xmlReader.read(new ByteArrayInputStream(xml.getBytes()));
            parser.setProperty(
                    "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema");
            parser.setProperty(
                    "http://java.sun.com/xml/jaxp/properties/schemaSource",
                    "file:" + xsd + ".xsd");
            //创建一个SAXValidator校验工具，并设置校验工具的属性
            SAXValidator validator = new SAXValidator(parser.getXMLReader());
            //设置校验工具的错误处理器，当发生错误时，可以从处理器对象中得到错误信息。
            validator.setErrorHandler(errorHandler);
            //校验
            validator.validate(xmlDocument);
            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            //如果错误信息不为空，说明校验失败，打印错误信息
            if (errorHandler.getErrors().hasContent()) {
                log.info("XML文件通过XSD文件校验失败！");
                writer.write(errorHandler.getErrors());
                return false;
            } else {
                log.info("Good! XML文件通过XSD文件校验成功！");
            }
            return true;
        } catch (Exception ex) {
            log.info("XML通过XSD文件:" + xsd + "检验失败： " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }


}

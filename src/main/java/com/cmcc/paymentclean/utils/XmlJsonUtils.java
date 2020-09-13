package com.cmcc.paymentclean.utils;

import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlJsonUtils {

    /**
     * JSON(数组)字符串转换成XML字符串
     */
    public static String json2xml4pcac(String jsonString) {
        String enter = System.getProperty("line.separator");//换行
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);
        xmlSerializer.isTrimSpaces();
        xmlSerializer.setRootName("Document");
        String xml = xmlSerializer.write(JSONSerializer.toJSON(jsonString), "utf-8");
        String resXml = xml.replaceAll("<o>", "")
                .replaceAll("</o>", "")
                .replaceAll("<e>", "")
                .replaceAll("</e>", "")
                .replaceAll("<a>", "")
                .replaceAll("</a>", "")
                .replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>\r\n", "");
        return formatXml(resXml);
    }

    /**
     * XML字符串转换成JSON(数组)字符串
     */
    public static String xml2pcac4pcac(String xmlString) {
        //创建 XMLSerializer对象
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setRootName("Body");
        //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）
        String result = xmlSerializer.read(xmlString).toString();
        result = result.substring(1, result.length() - 1);
        //输出json内容
        return result;
    }

    /**
     * 格式化xml字符串
     *
     * @param str
     * @return
     */
    public static String formatXml(String str) {

        try {
            if (!isXmlDocument(str)) {
                return str;
            }
            Document document = DocumentHelper.parseText(str);
            // 格式化输出格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndent("    ");
            format.setEncoding("UTF-8");
            StringWriter writer = new StringWriter();
            // 格式化输出流
            XMLWriter xmlWriter = new XMLWriter(writer, format);
            // 将document写入到输出流
            xmlWriter.write(document);
            xmlWriter.close();
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断字符串是否为xml字符串
     *
     * @param rtnMsg
     * @return
     */
    public static boolean isXmlDocument(String rtnMsg) {

        boolean flag = true;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(rtnMsg)));
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }
}
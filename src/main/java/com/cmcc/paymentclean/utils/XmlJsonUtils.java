package com.cmcc.paymentclean.utils;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Random;

@Slf4j
public class XmlJsonUtils {

    /**
     * JSON(数组)字符串转换成XML字符串
     */
    public static String json2xml4pcac(String jsonString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);
        xmlSerializer.isTrimSpaces();
        xmlSerializer.setRootName("Document");
        String xml = xmlSerializer.write(JSONSerializer.toJSON(jsonString), "UTF-8");
        String resXml = xml.replaceAll("<o>", "")
                .replaceAll("</o>", "")
                .replaceAll("<e>", "")
                .replaceAll("</e>", "")
                .replaceAll("<a>", "")
                .replaceAll("</a>", "");
        return formatXml(resXml).replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>\r\n", "");
    }

    /**
     * XML字符串转换成JSON(数组)字符串
     */
    public static String xml2pcac4pcac(String xmlString) {
        log.info("格式化之前的XML:{}", xmlString);
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

    /**
     * 将对象直接转换成String类型的 XML输出
     */
    public static String convertObjectToXmlStr(Object obj) {
        String enter = System.getProperty("line.separator");//换行
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
            log.info("解析对象为xml报文出错");
        }
        return (convertFromXml(sw.toString())).replaceAll(" standalone=\"yes\"", "");
    }

    /**
     * 将String类型的xml转换成对象
     */
    @SafeVarargs
    public static<T> Object convertXmlStrToObject(String xmlStr, Class<T>... clazz) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
            log.info("解析xml报文为对象出错");
        }
        return xmlObject;
    }

    /**
     * 生成指定位数随机数
     * @param card_len 位数
     * @return 随机数
     */
    public static String genRandomNum(int card_len){
        //35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuilder pwd = new StringBuilder("");
        Random r = new Random();
        while(count < card_len){
            //生成随机数，取绝对值，防止生成负数
            i = Math.abs(r.nextInt(maxNum)); //生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }
        return pwd.toString();
    }

    public static<T> Request<T> getRequest(byte[] symmetricKeyEncoded, com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document<T> document, PcacConfig pcacConfig, String trnxCode) {
        document.setSignature(null);
        Request<T> request = new Request<T>();
        Head head = new Head();
        head.setVersion(pcacConfig.getVersion());
        head.setIdentification(DateUtils.formatTime(new Date(System.currentTimeMillis()), DateUtils.FORMAT_DATE_PCAC + genRandomNum(10)));
        head.setOrigSender(pcacConfig.getOrigSender());
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        head.setRecSystemId("R0001");
        head.setTrnxCode(trnxCode);
        head.setTrnxTime(DateUtils.formatTime(new Date(System.currentTimeMillis()), DateUtils.FORMAT_TIME_PCAC));
        head.setUserToken(pcacConfig.getUserToken());
        head.setSecretKey(CFCACipherUtils.getSecretKey(symmetricKeyEncoded));
        request.setHead(head);
        return request;
    }

    public static<T> void doSignature(com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document<T> document) {
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("加签之前的XML数据: {}",xml);
        //加签
        String doSignature = CFCACipherUtils.doSignature(xml);
        document.setSignature(doSignature);
    }

    private static String convertFromXml(String str) {
        boolean flag = true;
        boolean quotesFlag = true;
        StringBuilder ans = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            if ('"' == str.charAt(i)) {
                ans.append(str.charAt(i));
                quotesFlag = !quotesFlag;
            } else if ('<' == str.charAt(i)) {
                tmp = tmp.trim();
                ans.append(tmp);
                flag = true;
                ans.append(str.charAt(i));
            } else if ('>' == str.charAt(i)) {
                if (quotesFlag) {
                    flag = false;
                    ans.append(str.charAt(i));
                    tmp = "";
                } else {
                    ans.append(">");
                }
            } else if (flag) {
                ans.append(str.charAt(i));
            } else {
                tmp += str.charAt(i);
            }
        }
        return ans.toString();
    }

    public static com.cmcc.paymentclean.entity.dto.pcac.resp.Document getRespDocument(PcacConfig pcacConfig) {
        Body body = new Body();
        RespInfo respInfo = new RespInfo();
        //返回成功的状态码
        respInfo.setResultStatus("01");
        respInfo.setResultCode("S00000");
        body.setRespInfo(respInfo);
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document document = new com.cmcc.paymentclean.entity.dto.pcac.resp.Document();
        Respone respone = new Respone();
        respone.setBody(body);
        String trnxCode = "";
        com.cmcc.paymentclean.entity.dto.pcac.resp.Head head = getRespHead(trnxCode,pcacConfig);
        respone.setHead(head);
        document.setRespone(respone);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        return document;
    }

    /**
     * 组装响应报文头的信息
     */
    public static com.cmcc.paymentclean.entity.dto.pcac.resp.Head getRespHead(String trnxCode, PcacConfig pcacConfig) {
        Date date = new Date();
        com.cmcc.paymentclean.entity.dto.pcac.resp.Head head = new com.cmcc.paymentclean.entity.dto.pcac.resp.Head();
        head.setVersion(pcacConfig.getVersion());
        //报文唯一标识（8 位日期+10 顺序号）
        int random = new Random().nextInt(1000) + 1000;
        String identification = DateUtils.formatTime(date, "yyyyMMdd") + "100000" + random;
        head.setIdentification(identification);
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender(pcacConfig.getOrigSender());
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）-----商户信息比对协查推送响应TrnxCode为空
        head.setTrnxCode(trnxCode);
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        head.setSecretKey("");
        return head;
    }

}

package com.cmcc.paymentclean;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac003.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class PcacTest<T> {
    @Autowired
    private PcacConfig pcacConfig;

    @Test
    void pcacTest() {
        //拼装Body QR0001-个人风险信息查询
        Body body = new Body();
        body.setRiskType("123");
        body.setMobileNo("123");
        body.setMac("123");
        body.setImei("123");
        body.setBankNo("123");
        body.setOpenBank("123");
        body.setCusName("123");
        body.setDocType("123");
        body.setDocCode("123");
        body.setIp("123");
        body.setAddress("123");
        body.setTelephone("123");
        body.setRecBankNo("123");
        body.setRecOpenBank("123");
        body.setEmail("123");
        body.setOccurtimeb("123");
        body.setOccurtimee("123");
        body.setOccurchan("123");
        body.setOccurarea("123");
        body.setRecHostArea("123");
        body.setScope("123");
        body.setValidStatus("123");
        pushPcac((T) body, "003", "QR0001");

    }

    public void pushPcac(T body, String code, String trnxCode) {

        Document<T> document = getDocument(body, trnxCode);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries." + code);
        log.info("请求报文: {}", XmlJsonUtils.formatXml(xml));
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        log.info("协会返回数据字符串:{}", XmlJsonUtils.formatXml(post));
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        log.info("协会返回数据对象:{}", doc);
        log.info("返回状态码及信息：{}:{}", doc.getRespone().getBody().getRespInfo().getResultCode(), doc.getRespone().getBody().getRespInfo().getMsgDetail());
    }

    private Document<T> getDocument(T body, String trnxCode) {
        //拼装报文
        Document<T> document = new Document<>();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request<T> request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, trnxCode);
        //设置报文体
        request.setBody(body);
        document.setRequest(request);
        XmlJsonUtils.doSignature(document);
        return document;
    }
}

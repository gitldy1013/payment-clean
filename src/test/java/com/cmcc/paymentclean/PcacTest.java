package com.cmcc.paymentclean;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
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
        //拼装Body
        Body body = new Body();
        body.setRiskType("");
        body.setMobileNo("");
        body.setMac("");
        body.setImei("");
        body.setBankNo("");
        body.setOpenBank("");
        body.setCusName("");
        body.setDocType("");
        body.setDocCode("");
        body.setIp("");
        body.setAddress("");
        body.setTelephone("");
        body.setRecBankNo("");
        body.setRecOpenBank("");
        body.setEmail("");
        body.setOccurtimeb("");
        body.setOccurtimee("");
        body.setOccurchan("");
        body.setOccurarea("");
        body.setRecHostArea("");
        body.setScope("");
        body.setValidStatus("");
        pushPcac((T)body,"003");

    }

    public void pushPcac(T body, String code) {

        Document<T> document = getDocument(body);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries."+code);
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

    private Document<T> getDocument(T body) {
        //拼装报文
        Document<T> document = new Document<>();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request<T> request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, TrnxCodeEnum.MERCHANT_RISK_INFO_SUBMIT.getCode());
        //设置报文体
        request.setBody(body);
        document.setRequest(request);
        XmlJsonUtils.doSignature(document);
        return document;
    }
}

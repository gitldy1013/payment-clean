package com.cmcc.paymentclean;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac003.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class PcacTest<T> {
    @Autowired
    private PcacConfig pcacConfig;

    @Test
    void QR0001() {
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
        String QR0001 = pushPcac((T) body, "003", "QR0001");
        log.info(QR0001);
    }

    @Test
    void QR0002() {
        //拼装Body QR0002-商户风险信息查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body();
        body.setRiskType("");
        body.setCusNature("");
        body.setCusName("");
        body.setRegName("");
        body.setCusCode("");
        body.setDocType("");
        body.setDocCode("");
        body.setLegRepName("");
        body.setLegDocCode("");
        body.setBankNo("");
        body.setOpenBank("");
        body.setUrl("");
        body.setServerIp("");
        body.setMobileNo("");
        body.setAddress("");
        body.setIcp("");
        body.setLevel("");
        body.setOccurtimeb("");
        body.setOccurtimee("");
        body.setOccurchan("");
        body.setOccurarea("");
        body.setScope("");
        body.setValidStatus("");
        body.setRegisteredArea("");
        body.setRegisteredCode("");
        String QR0002 = pushPcac((T) body, "015", "QR0002");
        log.info(QR0002);
    }

    @Test
    void QR0003() {
        //拼装Body QR0003-风险信息批量导入查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
        body.setCusProperty("");
        body.setKeyWord("");
        body.setInfos("");
        String QR0003 = pushPcac((T) body, "005", "QR0003");
        log.info(QR0003);
    }

    @Test
    void UP0001() {
        //拼装Body UP0001-个人风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body();
        body.setRiskType("");
        body.setMobileNo("");
        body.setMac("");
        body.setImei("");
        body.setBankNo("");
        String UP0001 = pushPcac((T) body, "009", "UP0001");
        log.info(UP0001);
    }

    @Test
    void UP0002BG() {
        //拼装Body UP0002-个人风险信息变更
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String UP0002BG = pushPcac((T) body, "011", "UP0002");
        log.info(UP0002BG);
    }

    @Test
    void UP0002SX() {
        //拼装Body UP0002-个人风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        ArrayList<RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String UP0002SX = pushPcac((T) body, "011", "UP0002");
        log.info(UP0002SX);
    }

    @Test
    void UP0003() {
        //拼装Body UP0003-商户风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body();
        body.setRiskType("");
        body.setCusName("");
        body.setDocType("");
        body.setDocCode("");
        body.setLegRepName("");
        body.setLegDocCode("");
        String UP0003 = pushPcac((T) body, "017", "UP0003");
        log.info(UP0003);
    }

    @Test
    void UP0004SX() {
        //拼装Body UP0004-商户风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo();
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String UP0004 = pushPcac((T) body, "019-1", "UP0004");
        log.info(UP0004);
    }

    @Test
    void UP0004BL() {
        //拼装Body UP0004-商户风险信息补录
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.PcacList();
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo();
        riskInfo.setId("");
        riskInfo.setUpdateType("");
        riskInfo.setCusType("");
        riskInfo.setCusNature("");
        riskInfo.setCusName("");
        riskInfo.setUrl("");
        riskInfo.setServerIp("");
        riskInfo.setMobileNo("");
        riskInfo.setAddress("");
        riskInfo.setIcp("");
        riskInfo.setOccurtimeb("");
        riskInfo.setOccurtimee("");
        riskInfo.setOccurchan("");
        riskInfo.setOccurarea("");
        riskInfo.setNote("");
        riskInfo.setValidDate("");
        riskInfo.setOrgId("");
        riskInfo.setRepDate("");
        riskInfo.setRepType("");
        riskInfo.setRepPerson("");
        riskInfo.setRegisteredArea("");
        riskInfo.setRegisteredCode("");
        riskInfo.setSourceChannel("");
        riskInfo.setCurrency("");
        riskInfo.setAmount("");
        riskInfo.setRiskFindTime("");
        riskInfo.setLegControlName("");
        riskInfo.setLegControlCardType("");
        riskInfo.setLegControlCardCode("");
        riskInfo.setRemarks("");
        riskInfo.setBankList(Lists.newArrayList());
        riskInfo.setBenList(Lists.newArrayList());
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String UP0004 = pushPcac((T) body, "019", "UP0004");
        log.info(UP0004);
    }

    @Test
    void UP0004JJ() {
        //拼装Body UP0004-商户风险信息降级
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo();
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String UP0004 = pushPcac((T) body, "019-2", "UP0004");
        log.info(UP0004);
    }

    @Test
    void UP0005() {
        //拼装Body UP0005-风险信息查询使用反馈-个人
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
        body.setCusProperty("");
        body.setKeyWord("");
        body.setInfos("");
        String UP0005 = pushPcac((T) body, "005", "UP0005");
        log.info(UP0005);
    }

    @Test
    void UP0011() {
        //拼装Body UP0011-跨境商户黑名单信息反馈
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body();
        PcacList pcacList = new PcacList();
        pcacList.setCount("");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo();
        riskInfo.setRegName("");
        riskInfo.setCurrency("");
        riskInfo.setAmount("");
        riskInfo.setLegDocName("");
        riskInfo.setDocCode("");
        riskInfo.setBankNo("");
        riskInfo.setUrl("");
        riskInfo.setRegisteredCode("");
        riskInfo.setHandleResult("");
        riskInfo.setHandleTime("");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String UP0005 = pushPcac((T) body, "005", "UP0005");
        log.info(UP0005);
    }

    public String pushPcac(T body, String code, String trnxCode) {

        Document<T> document = getDocument(body, trnxCode);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("请求xml数据: {}", XmlJsonUtils.formatXml(xml));
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return "";
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries." + code);
        if (!validate) {
            log.info("XML校验失败");
            return "";
        }
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        String formatXml = XmlJsonUtils.formatXml(XmlJsonUtils.convertObjectToXmlStr(doc));
        log.info("协会返回数据对象:{}", formatXml);
        return formatXml;
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

package com.cmcc.paymentclean;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac003.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList;
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
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static com.cmcc.paymentclean.utils.CodeGenerator.PROJECT_PATH;

@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
public class PcacTest<T> {
    @Autowired
    private PcacConfig pcacConfig;

    private byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();

    public static void creatFile(String xml, String fileName) {
        Writer write;
        try {
            write = new FileWriter(new File(PROJECT_PATH + "/bw/" + fileName + ".txt"));
            FileCopyUtils.copy(xml, write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void QR0001() {
        //拼装Body QR0001-个人风险信息查询
        Body body = new Body();
        body.setRiskType("01");
        body.setMobileNo("01");
        body.setMac("01:01:01:01:01:01");
        body.setImei("01");
        body.setBankNo("01");
        body.setOpenBank("01");
        body.setCusName("01");
        body.setDocType("01");
        body.setDocCode("211324199110105617");
        body.setIp("https://localhost:80801/zfqs");
        body.setAddress("01");
        body.setTelephone("0421-12341234");
        body.setRecBankNo("01");
        body.setRecOpenBank("01");
        body.setEmail("123@183.com");
        body.setOccurtimeb("2011-01-01");
        body.setOccurtimee("2020-09-09");
        body.setOccurchan("01");
        body.setOccurarea("659000");
        body.setRecHostArea("AD");
        body.setScope("01");
        body.setValidStatus("01");
        String[] QR0001 = pushPcac((T) body, "003", "QR0001");
        creatFile(QR0001[0], "QR0001-个人风险信息查询-请求");
        creatFile(QR0001[1], "QR0001-个人风险信息查询-响应");
    }

    @Test
    void QR0002() {
        //拼装Body QR0002-商户风险信息查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body();
        body.setRiskType("01");
        body.setCusNature("01");
        body.setCusName("01");
        body.setRegName("01");
        body.setCusCode("01");
        body.setDocType("01");
        body.setDocCode("01");
        body.setLegRepName("01");
        body.setLegDocCode("01");
        body.setBankNo("01");
        body.setOpenBank("01");
        body.setUrl("https://localhost:9080/zfqs");
        body.setServerIp("https://localhost:9080/zfqs");
        body.setMobileNo("01");
        body.setAddress("01");
        body.setIcp("01");
        body.setLevel("01");
        body.setOccurtimeb("2011-01-01");
        body.setOccurtimee("2020-09-09");
        body.setOccurchan("01");
        body.setOccurarea("659000");
        body.setScope("01");
        body.setValidStatus("01");
        body.setRegisteredArea("AD");
        body.setRegisteredCode("AD");
        String[] QR0002 = pushPcac((T) body, "015", "QR0002");
        creatFile(QR0002[0], "QR0002-商户风险信息查询-请求");
        creatFile(QR0002[1], "QR0002-商户风险信息查询-响应");
    }

    @Test
    void QR0003() {
        //拼装Body QR0003-风险信息批量导入查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
        body.setCusProperty("01");
        body.setKeyWord("01");
        body.setInfos("123");
        String[] QR0003 = pushPcac((T) body, "005", "QR0003");
        creatFile(QR0003[0], "QR0003-风险信息批量导入查询-请求");
        creatFile(QR0003[1], "QR0003-风险信息批量导入查询-响应");
    }

    @Test
    void UP0001() {
        //拼装Body UP0001-个人风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body();
        body.setRiskType("01");
        body.setMobileNo("13566666666");
        body.setMac("XX:XX:XX:XX:XX:XX");
        body.setImei("01");
        body.setBankNo("01");
        String[] UP0001 = pushPcac((T) body, "009", "UP0001");
        creatFile(UP0001[0], "UP0001-个人风险信息变更查询-请求");
        creatFile(UP0001[1], "UP0001-个人风险信息变更查询-响应");
    }

    @Test
    void UP0002BG() {
        //拼装Body UP0002-个人风险信息变更
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        riskInfo.setId("01");
        riskInfo.setUpdateType("01");
        riskInfo.setCusProperty("01");
        riskInfo.setRiskType("01");
        riskInfo.setMobileNo("13422222222");
        riskInfo.setMac("XX.XX.XX.XX.XX.XX");
        riskInfo.setImei("01");
        riskInfo.setBankNo("01");
        riskInfo.setOpenBank("01");
        riskInfo.setCusName("01");
        riskInfo.setDocType("01");
        riskInfo.setDocCode("211324100110135617");
        riskInfo.setIp("https://localhost:8090/zfqs");
        riskInfo.setAddress("01");
        riskInfo.setTelephone("13411111111");
        riskInfo.setRecHostArea("6401102");
        BankList bankList = new BankList();
        bankList.setCount("1");
        List<BankInfo> bankInfos = new ArrayList<>();
        BankInfo bankInfo = new BankInfo();
        bankInfo.setIsTransfer("01");
        bankInfo.setRecName("01");
        bankInfo.setRecDocType("01");
        bankInfo.setRecDocCode("01");
        bankInfo.setRecBankNo("01");
        bankInfo.setRecOpenBank("01");
        bankInfos.add(bankInfo);
        bankList.setBankInfo(bankInfos);
        riskInfo.setBankList(bankList);
        riskInfo.setEmail("112@123.com");
        riskInfo.setValidDate("2019-01-01");
        riskInfo.setOccurtimeb("2019-01-01");
        riskInfo.setOccurtimee("2019-01-01");
        riskInfo.setOccurchan("01");
        riskInfo.setOccurarea("AG");
        riskInfo.setNote("01");
        riskInfo.setOrgId("01");
        riskInfo.setRepDate("01");
        riskInfo.setRepType("01");
        riskInfo.setRepPerson("01");
        riskInfo.setSourceChannel("01");
        riskInfo.setDiskNumber("01");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("12.12");
        riskInfo.setRiskFindTime("2019-01-01");
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String[] UP0002BG = pushPcac((T) body, "011", "UP0002");
//        creatFile(UP0002BG[0], "UP0002-个人风险信息变更-请求");
//        creatFile(UP0002BG[1], "UP0002-个人风险信息变更-响应");
    }

    @Test
    void UP0002SX() {
        //拼装Body UP0002-个人风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        ArrayList<RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        riskInfo.setId("");
        riskInfo.setUpdateType("");
        riskInfo.setCusProperty("");
        riskInfo.setRiskType("");
        riskInfo.setMobileNo("");
        riskInfo.setMac("");
        riskInfo.setImei("");
        riskInfo.setBankNo("");
        riskInfo.setOpenBank("");
        riskInfo.setCusName("");
        riskInfo.setDocType("");
        riskInfo.setDocCode("");
        riskInfo.setIp("");
        riskInfo.setAddress("");
        riskInfo.setTelephone("");
        riskInfo.setRecHostArea("");
        riskInfo.setBankList(new BankList());
        riskInfo.setEmail("");
        riskInfo.setValidDate("");
        riskInfo.setOccurtimeb("");
        riskInfo.setOccurtimee("");
        riskInfo.setOccurchan("");
        riskInfo.setOccurarea("");
        riskInfo.setNote("");
        riskInfo.setOrgId("");
        riskInfo.setRepDate("");
        riskInfo.setRepType("");
        riskInfo.setRepPerson("");
        riskInfo.setSourceChannel("");
        riskInfo.setDiskNumber("");
        riskInfo.setCurrency("");
        riskInfo.setAmount("");
        riskInfo.setRiskFindTime("");
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String[] UP0002SX = pushPcac((T) body, "011", "UP0002");
    }

    @Test
    void UP0003() {
        //拼装Body UP0003-商户风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body();
        body.setRiskType("01");
        body.setCusName("01");
        body.setDocType("01");
        body.setDocCode("211333222211114321");
        body.setLegRepName("01");
        body.setLegDocCode("233222333212342314");
        String[] UP0003 = pushPcac((T) body, "017", "UP0003");
        creatFile(UP0003[0], "UP0003-商户风险信息变更查询-请求");
        creatFile(UP0003[1], "UP0003-商户风险信息变更查询-响应");
    }

    @Test
    void UP0004SX() {
        //拼装Body UP0004-商户风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo();
        riskInfo.setId("123");
        riskInfo.setUpdateType("02");
        riskInfo.setCaseDesc("123");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0004 = pushPcac((T) body, "019-1", "UP0004");
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
        String[] UP0004 = pushPcac((T) body, "019", "UP0004");
    }

    @Test
    void UP0004JJ() {
        //拼装Body UP0004-商户风险信息降级
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo();
        riskInfo.setId("01");
        riskInfo.setUpdateType("03");
        riskInfo.setLevel("02");
        riskInfo.setCaseDesc("123");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0004 = pushPcac((T) body, "019-2", "UP0004");
    }

    @Test
    void UP0005() {
        //拼装Body UP0005-风险信息查询使用反馈-个人
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();
        PcacList pcacList = new PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
        riskInfo.setId("UO6ES8sc54i3NaCr9qRabA==");
        riskInfo.setCusType("02");
        riskInfo.setHandleResult("01");
        riskInfo.setHandleTime("2019-01-01");
        riskInfo.setHandleNote("123");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("12.32");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0005 = pushPcac((T) body, "045", "UP0005");
        creatFile(UP0005[0], "UP0005-风险信息查询使用反馈-个人-请求");
        creatFile(UP0005[1], "UP0005-风险信息查询使用反馈-个人-响应");
    }

    @Test
    void UP0011() {
        //拼装Body UP0011-跨境商户黑名单信息反馈
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.PcacList();
        pcacList.setCount("");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo> riskInfos = new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo();
        riskInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded,"恒黑04"));
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("10000.00");
        riskInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded,"恒黑4"));
        riskInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded,"231025198212261526"));
        riskInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded,"6663636263646472778"));
        riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded,"www.qpay.com"));
        riskInfo.setRegisteredCode(CFCACipherUtils.encrypt(symmetricKeyEncoded,"9221379179"));
        riskInfo.setHandleResult("03");
        riskInfo.setHandleTime("2020-09-27");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0011 = pushPcac((T) body, "058", "UP0011");
    }

    public String[] pushPcac(T body, String code, String trnxCode) {

        Document<T> document = getDocument(body, trnxCode);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("请求xml数据: {}", XmlJsonUtils.formatXml(xml));
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return null;
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries." + code);
        if (!validate) {
            log.info("XML校验失败");
            return null;
        }
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        String formatXml = XmlJsonUtils.formatXml(XmlJsonUtils.convertObjectToXmlStr(doc));
        log.info("协会返回数据对象:{}", formatXml);
        return new String[]{XmlJsonUtils.formatXml(xml), formatXml};
    }

    private Document<T> getDocument(T body, String trnxCode) {
        //拼装报文
        Document<T> document = new Document<>();
        //设置报文头
        Request<T> request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, trnxCode);
        //设置报文体
        request.setBody(body);
        document.setRequest(request);
        XmlJsonUtils.doSignature(document);
        return document;
    }
}

package com.cmcc.paymentclean;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac003.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039.BaseInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
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
    public static String ENTER = System.getProperty("line.separator"); // 换行
    @Autowired
    private PcacConfig pcacConfig;
    private byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();

    public static void creatFile(String xml, String fileName) {
        Writer write = null;
        try {
            write = new FileWriter(new File(PROJECT_PATH + ENTER + "bw" + ENTER + fileName + ".txt"));
            FileCopyUtils.copy(xml, write);
        } catch (IOException e) {
            log.error("异常:" + e);
        } finally {
            if (write != null) {
                try {
                    write.close();
                } catch (IOException e) {
                    log.error("异常:" + e);
                }
            }
        }
    }

    @Test
    void QR0001() {
        // 拼装Body QR0001-个人风险信息查询
        Body body = new Body();
        body.setRiskType("01");
        body.setMobileNo("13900000001");
        body.setMac("82:0F:17:C7:A4:C0");
        body.setImei("0000001");
        body.setBankNo("6000100010002");
        body.setOpenBank("1");
        body.setCusName("个人姓名1");
        body.setDocType("02");
        body.setDocCode("600010001000212345");
        body.setIp("192.168.0.1");
        body.setAddress("收货地址1");
        body.setTelephone("010-67891234");
        body.setRecBankNo("6000100010002");
        body.setRecOpenBank("工商银行");
        body.setEmail("qq@126.com");
        body.setOccurtimeb("2019-08-12");
        body.setOccurtimee("2020-09-30");
        body.setOccurchan("03");
        body.setOccurarea("430000");
        body.setRecHostArea("CN");
        body.setScope("01");
        body.setValidStatus("01");
        String[] QR0001 = pushPcac((T) body, "003", "QR0001");
        //        creatFile(QR0001[0], "QR0001-个人风险信息查询-请求");
        //        creatFile(QR0001[1], "QR0001-个人风险信息查询-响应");
    }

    @Test
    void QR0002() {
        // 拼装Body QR0002-商户风险信息查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac015.Body();
        body.setRiskType("01");
        body.setCusNature("01");
        body.setCusName("中移动");
        body.setRegName("中移动电子商务有限公司");
        body.setCusCode("888200700999999");
        body.setDocType("01");
        body.setDocCode("222000399940408");
        body.setLegRepName("刘东东");
        body.setLegDocCode("229339029203948764");
        // 银行卡号协会好像没有加密，但是东阳的代码应该是加密了，之后需要确认
        body.setBankNo("123123123123");
        body.setOpenBank("支付账户开立机构");
        body.setUrl("www.chinamobile.com");
        body.setServerIp("192.168.3.2");
        body.setMobileNo("12345678909");
        body.setAddress("长沙");
        body.setIcp("ICP 备案编号21");
        body.setLevel("01");
        body.setOccurtimeb("2020-07-06");
        body.setOccurtimee("2099-12-30");
        body.setOccurchan("01");
        body.setOccurarea("659000");
        body.setScope("01");
        body.setValidStatus("01");
        body.setRegisteredArea("CN");
        body.setRegisteredCode("1231");
        String[] QR0002 = pushPcac((T) body, "015", "QR0002");
        //            creatFile(QR0002[0], "QR0002-商户风险信息查询-请求");
        //            creatFile(QR0002[1], "QR0002-商户风险信息查询-响应");
    }

    @Test
    void QR0003() {
        // 拼装Body QR0003-风险信息批量导入查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
        body.setCusProperty("01");
        body.setKeyWord("01");
        body.setInfos("13900000001");
        String[] QR0003 = pushPcac((T) body, "005", "QR0003");
        //        creatFile(QR0003[0], "QR0003-风险信息批量导入查询-个人-请求");
        //        creatFile(QR0003[1], "QR0003-风险信息批量导入查询-个人-响应");
    }

    @Test
    void QR0003MER() {
        // 拼装Body QR0003-风险信息批量导入查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
        body.setCusProperty("02");
        body.setKeyWord("01");
        body.setInfos("中移金科");
        String[] QR0003 = pushPcac((T) body, "005", "QR0003");
        //            creatFile(QR0003[0], "QR0003-风险信息批量导入查询-商户-请求");
        //            creatFile(QR0003[1], "QR0003-风险信息批量导入查询-商户-响应");
    }

    @Test
    void UP0001() {
        // 拼装Body UP0001-个人风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac009.Body();
        body.setRiskType("01");
        body.setMobileNo("13900000001");
        body.setMac("82:0F:17:C7:A4:C0");
        body.setImei("0000001");
        body.setBankNo("6000100010002");
        String[] UP0001 = pushPcac((T) body, "009", "UP0001");
        //        creatFile(UP0001[0], "UP0001-个人风险信息变更查询-请求");
        //        creatFile(UP0001[1], "UP0001-个人风险信息变更查询-响应");
    }

    @Test
    void UP0002BG() {
        // 拼装Body UP0002-个人风险信息变更
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        riskInfo.setId("250349");
        riskInfo.setUpdateType("01");
        riskInfo.setCusProperty("01");
        riskInfo.setRiskType("01");
        riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "13900000001"));
        riskInfo.setMac("82:0F:17:C7:A4:C0");
        riskInfo.setImei("0000001");
        riskInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "6000100010002"));
        riskInfo.setOpenBank("1");
        riskInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, "个人姓名1"));
        riskInfo.setDocType("02");
        riskInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "600010001000212345"));
        riskInfo.setIp("192.168.0.1");
        riskInfo.setAddress("收货地址1");
        riskInfo.setTelephone(CFCACipherUtils.encrypt(symmetricKeyEncoded, "010-67891234"));
        riskInfo.setRecHostArea("CN");
        BankList bankList = new BankList();
        List<BankInfo> bankInfos = new ArrayList<>();
        BankInfo bankInfo = new BankInfo();
        bankInfo.setIsTransfer("0");
        bankInfo.setRecName("收款人姓名1");
        bankInfo.setRecDocType("02");
        bankInfo.setRecDocCode("600010001000212345");
        bankInfo.setRecBankNo("6000100010002");
        bankInfo.setRecOpenBank("工商银行");
        bankInfos.add(bankInfo);
        bankList.setBankInfo(bankInfos);
        bankList.setCount(bankInfos.size() + "");
        riskInfo.setBankList(bankList);
        riskInfo.setEmail("qq@126.com");
        riskInfo.setValidDate("2099-12-30");
        riskInfo.setOccurtimeb("2019-08-12");
        riskInfo.setOccurtimee("2020-09-30");
        riskInfo.setOccurchan("03");
        riskInfo.setOccurarea("430000");
        riskInfo.setNote("测试");
        riskInfo.setOrgId("asdfas");
        riskInfo.setRepDate("2020-09-28 13:36:34");
        riskInfo.setRepType("03");
        riskInfo.setRepPerson("liudong");
        riskInfo.setSourceChannel("GA");
        riskInfo.setDiskNumber("12e32");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("122.88");
        riskInfo.setRiskFindTime("2020-09-17");
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String[] UP0002BG = pushPcac((T) body, "011", "UP0002");
        //       creatFile(UP0002BG[0], "UP0002-个人风险信息变更-请求");
        //       creatFile(UP0002BG[1], "UP0002-个人风险信息变更-响应");
    }

    @Test
    void UP0002SX() {
        // 拼装Body UP0002-个人风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac011.PcacList();
        pcacList.setCount("1");
        ArrayList<RiskInfo> list = new ArrayList<>();
        RiskInfo riskInfo = new RiskInfo();
        riskInfo.setId("250081");
        riskInfo.setUpdateType("02");
        riskInfo.setCusProperty("01");
        riskInfo.setRiskType("01");
        riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "13900000001"));
        riskInfo.setMac("82:0F:17:C7:A4:C0");
        riskInfo.setImei("0000001");
        riskInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "6000100010002"));
        riskInfo.setOpenBank("1");
        riskInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, "个人姓名1"));
        riskInfo.setDocType("02");
        riskInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "600010001000212345"));
        riskInfo.setIp("192.168.0.1");
        riskInfo.setAddress("收货地址1");
        riskInfo.setTelephone(CFCACipherUtils.encrypt(symmetricKeyEncoded, "010-67891234"));
        riskInfo.setRecHostArea("CN");
        BankList bankList = new BankList();
        bankList.setCount("1");
        List<BankInfo> bankInfos = new ArrayList<>();
        BankInfo bankInfo = new BankInfo();
        bankInfo.setIsTransfer("0");
        bankInfo.setRecName("收款人姓名1");
        bankInfo.setRecDocType("02");
        bankInfo.setRecDocCode("600010001000212345");
        bankInfo.setRecBankNo("6000100010002");
        bankInfo.setRecOpenBank("工商银行");
        bankInfos.add(bankInfo);
        bankList.setBankInfo(bankInfos);
        riskInfo.setBankList(bankList);
        riskInfo.setEmail("qq@126.com");
        riskInfo.setValidDate("2099-12-30");
        riskInfo.setOccurtimeb("2019-08-12");
        riskInfo.setOccurtimee("2020-09-30");
        riskInfo.setOccurchan("03");
        riskInfo.setOccurarea("430000");
        riskInfo.setNote("测试");
        riskInfo.setOrgId("asdfas");
        riskInfo.setRepDate("2020-09-22 13:36:34");
        riskInfo.setRepType("03");
        riskInfo.setRepPerson("zhangzhi");
        riskInfo.setSourceChannel("GA");
        riskInfo.setDiskNumber("12e32");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("12.90");
        riskInfo.setRiskFindTime("2020-09-17");
        list.add(riskInfo);
        pcacList.setRiskInfo(list);
        body.setPcacList(pcacList);
        String[] UP0002SX = pushPcac((T) body, "011", "UP0002");
        //        creatFile(UP0002SX[0], "UP0002-个人风险信息失效-请求");
        //        creatFile(UP0002SX[1], "UP0002-个人风险信息失效-响应");
    }

    @Test
    void UP0003() {
        // 拼装Body UP0003-商户风险信息变更查询
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body();
        body.setRiskType("01");
        body.setCusName("中移动");
        body.setDocType("01");
        body.setDocCode("222000399940408");
        body.setLegRepName("刘东东");
        body.setLegDocCode("229339029203948764");
    /*
        body.setRiskType("01");
        body.setCusName("T1");
        body.setDocType("01");
        body.setDocCode("111123123123123");
        body.setLegRepName("法定代表人T1");
        body.setLegDocCode("211111111122335");
    */
        String[] UP0003 = pushPcac((T) body, "017", "UP0003");
        //            creatFile(UP0003[0], "UP0003-商户风险信息变更查询-请求");
        //            creatFile(UP0003[1], "UP0003-商户风险信息变更查询-响应");
    }

    @Test
    void UP0004SX() {
        // 拼装Body UP0004-商户风险信息失效
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_1.RiskInfo();
        riskInfo.setId("693530");
        riskInfo.setUpdateType("02");
        riskInfo.setCaseDesc("测试商户风险信息失效");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0004 = pushPcac((T) body, "019-1", "UP0004");
        //        creatFile(UP0004[0], "UP0004-商户风险信息失效-请求");
        //        creatFile(UP0004[1], "UP0004-商户风险信息失效-响应");
    }

    @Test
    void UP0004BL() {
        // 拼装Body UP0004-商户风险信息补录
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.PcacList();
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.RiskInfo();
        pcacList.setCount("1");
        riskInfo.setId("693463");
        riskInfo.setUpdateType("01");
        riskInfo.setCusType("01");
        riskInfo.setCusNature("01");
        riskInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, "T1"));
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankInfo> bankInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankList bankList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankList();
        bankList.setCount("1");
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankInfo bankInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankInfo();
        bankInfo.setIsTransfer("0");
        bankInfo.setBankNo("6539391774292993");
        bankInfo.setOpenBank("大兴支行");
        bankInfos.add(bankInfo);
        bankList.setBankInfo(bankInfos);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019.BankList> bankLists =
                new ArrayList<>();
        bankLists.add(bankList);
        riskInfo.setBankList(bankLists);
        riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, "www.abc.123"));
        riskInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, "192.168.1.1"));
        riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "15810889999"));
        riskInfo.setAddress("长沙");
        riskInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, "ICP 备案编号01"));
        riskInfo.setOccurtimeb("2020-07-06");
        riskInfo.setOccurtimee("2099-12-30");
        riskInfo.setOccurchan("01");
        riskInfo.setOccurarea("659000");
        riskInfo.setNote("测试");
        riskInfo.setValidDate("2099-12-30");
        riskInfo.setOrgId("zyjk");
        riskInfo.setRepDate("2020-09-19 11:11:11");
        riskInfo.setRepType("03");
        riskInfo.setRepPerson("admin");
        riskInfo.setRegisteredArea("AD");
        riskInfo.setRegisteredCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "1"));
        riskInfo.setSourceChannel("QT");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("30010.10");
        riskInfo.setRiskFindTime("2020-07-06");
        riskInfo.setLegControlName("实控人姓名1");
        riskInfo.setLegControlCardType("01");
        riskInfo.setLegControlCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "111111111111111"));
        riskInfo.setRemarks("测试商户风险信息补录");
        BenInfo benInfo = new BenInfo();
        benInfo.setLegBenName("测试人");
        benInfo.setLegBenCardType("01");
        benInfo.setLegBenCardCode("124512797127463288");
        ArrayList<BenInfo> benInfos = new ArrayList<>();
        benInfos.add(benInfo);
        BenList benList = new BenList();
        benList.setCount("1");
        benList.setBenInfo(benInfos);
        ArrayList<BenList> benLists = new ArrayList<>();
        benLists.add(benList);
        riskInfo.setBenList(benLists);
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0004 = pushPcac((T) body, "019", "UP0004");
        //        creatFile(UP0004[0], "UP0004-商户风险信息补录-请求");
        //        creatFile(UP0004[1], "UP0004-商户风险信息补录-响应");
    }

    @Test
    void UP0003111111111() {
        // 为了测试UP0004-商户风险信息降级获取id号使用，不要执行创建命令
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac017.Body();
        body.setRiskType("01");
        body.setCusName("中移动");
        body.setDocType("01");
        body.setDocCode("222000399940408");
        body.setLegRepName("刘东");
        body.setLegDocCode("229339029203948764");
        String[] UP0003 = pushPcac((T) body, "017", "UP0003");
    }

    @Test
    void UP0004JJ() {
        // 拼装Body UP0004-商户风险信息降级
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.PcacList();
        pcacList.setCount(1);
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac019_2.RiskInfo();
        riskInfo.setId("694154");
        riskInfo.setUpdateType("03");
        riskInfo.setLevel("03");
        riskInfo.setCaseDesc("测试商户风险信息降级");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0004 = pushPcac((T) body, "019-2", "UP0004");
        //        creatFile(UP0004[0], "UP0004-商户风险信息降级-请求");
        //        creatFile(UP0004[1], "UP0004-商户风险信息降级-响应");
    }

    @Test
    void UP0005() {
        // 拼装Body UP0005-风险信息查询使用反馈-个人
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
        riskInfo.setId("i4q19Fw2jN7uuCV7dGVdbg==");
        riskInfo.setCusType("01");
        riskInfo.setHandleResult("01");
        riskInfo.setHandleTime("2020-10-26");
        riskInfo.setHandleNote("123");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("12.32");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0005 = pushPcac((T) body, "045", "UP0005");
        //            creatFile(UP0005[0], "UP0005-风险信息查询使用反馈-个人-请求");
        //            creatFile(UP0005[1], "UP0005-风险信息查询使用反馈-个人-响应");
    }

    @Test
    void UP0005MER() {
        // 拼装Body UP0005-风险信息查询使用反馈-商户
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();

        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
        riskInfo.setId("695191");
        // riskInfo.setId("UO6ES8sc54i3NaCr9qRabA==");
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
        //        creatFile(UP0005[0], "UP0005-风险信息查询使用反馈-商户-请求");
        //        creatFile(UP0005[1], "UP0005-风险信息查询使用反馈-商户-响应");
    }

    /**
     * pcac.ries.046 商户黑名单信息反馈请求
     */
    @Test
    void UP0006() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.PcacList();
        pcacList.setCount("1");
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.RiskInfo();
        riskInfo.setCusType("03");
        riskInfo.setRegName("刘包子");
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("129.00");
        riskInfo.setDocType("01");
        riskInfo.setDocCode("151215121512151");
        riskInfo.setHandleResult("02");
        riskInfo.setHandleTime("2020-10-26");
    /*riskInfo.setCusType("04");
    riskInfo.setRegName("中移动电子商务有限公司");
    riskInfo.setCurrency("CNY");
    riskInfo.setAmount("129.00");
    riskInfo.setDocType("01");
    riskInfo.setDocCode("222000399940408");
    riskInfo.setHandleResult("02");
    riskInfo.setHandleTime("2020-10-26");*/
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.RiskInfo> riskInfos =
                new ArrayList<>();
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0006 = pushPcac((T) body, "046", "UP0006");
        creatFile(UP0006[0], "UP0006-商户黑名单信息反馈-请求");
        creatFile(UP0006[1], "UP0006-商户黑名单信息反馈-响应");
    }

    @Test
    void UP0011() {
        // 拼装Body UP0011-跨境商户黑名单信息反馈
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.PcacList();
        pcacList.setCount("1");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo> riskInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo riskInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac058.RiskInfo();
        riskInfo.setCurrency("CNY");
        riskInfo.setAmount("999.99");
    /*        riskInfo.setRegName("");
    riskInfo.setLegDocName("");
    riskInfo.setDocCode("");
    riskInfo.setBankNo("");
    riskInfo.setUrl("");
    riskInfo.setRegisteredCode(CFCACipherUtils.encrypt(symmetricKeyEncoded,"132312321"));*/
        riskInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, "中移动电子商务有限公司"));
        riskInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded, "刘东"));
        riskInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "229339029203948764"));
        riskInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, "8q/HMqAepL9Ob3ZEhLQEhg=="));
        riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, "www.chinamobile.com"));
        riskInfo.setRegisteredCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, "1231"));
        riskInfo.setHandleResult("03");
        riskInfo.setHandleTime("2020-09-30");
        riskInfos.add(riskInfo);
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        String[] UP0011 = pushPcac((T) body, "058", "UP0011");
        //        creatFile(UP0011[0], "UP0011-跨境商户黑名单信息反馈-请求");
        //        creatFile(UP0011[1], "UP0011-跨境商户黑名单信息反馈-响应");
    }

    /**
     * 特约商户信息差错处理
     */
    @Test
    void EDEL01() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.PcacList();
        pcacList.setCount("1");
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.BaseInfo baseInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac026.BaseInfo();
        baseInfo.setCusType("01");
        baseInfo.setDocType("01");
        baseInfo.setDocCode("220110199888011111");
        baseInfo.setCusCode("yd123456555");
        pcacList.setBaseInfo(baseInfo);
        body.setPcacList(pcacList);
        pushPcac((T) body, "026", "EDEL01");
    }

    /**
     * 特约商户 个人商户信息上报请求 测试RecSystemId是SECB01
     */
    @Test
    void EPR001() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.PcacList();
        pcacList.setCount("1");
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.BaseInfo> baseInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.BaseInfo baseInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac024.BaseInfo();
        baseInfo.setCusType("01");
        baseInfo.setCusNature("03");
        baseInfo.setRegName("中移动电子玩具店");
        baseInfo.setCusName("中移玩具");
        baseInfo.setCusNameEn("chinamobileEN");
        baseInfo.setDocType("01");
        baseInfo.setDocCode("220110199888011111");
        baseInfo.setCusCode("yd123456555");
        baseInfo.setInduType("01");
        baseInfo.setBankNo("6266669903331");
        baseInfo.setOpenBank("中粮支行");
        baseInfo.setRegAddrProv("110000");
        baseInfo.setRegAddrDetail("北京市东城区中粮置地");
        baseInfo.setAddrProv("110000");
        baseInfo.setAddrDetail("北京市东城区中粮置地");
        baseInfo.setUrl("www.chinamobil.com");
        baseInfo.setServerIp("192.128.120.22");
        baseInfo.setIcp("浙ICP备06044328号");
        baseInfo.setContName("刘阳");
        baseInfo.setContPhone("13334448733");
        baseInfo.setCusEmail("999@126.com");
        baseInfo.setOccurarea("110000");
        baseInfo.setNetworkType("04");
        baseInfo.setStatus("01");
        baseInfo.setStartTime("2019-01-01");
        baseInfo.setEndTime("2099-12-12");
        baseInfo.setRiskStatus("01");
        baseInfo.setOpenType("01");
        baseInfo.setChageType("01");
        baseInfo.setAccountType("04");
        baseInfo.setExpandType("01");
        baseInfo.setOutServiceName("外包1");
        baseInfo.setOutServiceCardType("01");
        baseInfo.setOutServiceCardCode("129391930132318");
        baseInfo.setOutServiceLegCardType("01");
        baseInfo.setOutServiceLegCardCode("110220199011112222");
        baseInfo.setOrgId("123123123");
        baseInfo.setRepDate("2020-10-14 17:47:50");
        baseInfo.setRepType("03");
        baseInfo.setRepPerson("老刘");
    /*
        baseInfo.setCusType("01");
        baseInfo.setCusNature("03");
        baseInfo.setRegName("中移动电子玩具店");
        baseInfo.setCusName("中移玩具");
        baseInfo.setCusNameEn("chinamobileEN");
        baseInfo.setDocType("01");
        baseInfo.setDocCode("220110199888018844");
        baseInfo.setCusCode("yd123456789");
        baseInfo.setInduType("01");
        baseInfo.setBankNo("6266669909321");
        baseInfo.setOpenBank("中粮支行");
        baseInfo.setRegAddrProv("110000");
        baseInfo.setRegAddrDetail("北京市东城区中粮置地");
        baseInfo.setAddrProv("110000");
        baseInfo.setAddrDetail("北京市东城区中粮置地");
        baseInfo.setUrl("www.chinamobil.com");
        baseInfo.setServerIp("192.128.120.22");
        baseInfo.setIcp("浙ICP备06044328号");
        baseInfo.setContName("刘东");
        baseInfo.setContPhone("13334448767");
        baseInfo.setCusEmail("999@126.com");
        baseInfo.setOccurarea("110000");
        baseInfo.setNetworkType("04");
        baseInfo.setStatus("01");
        baseInfo.setStartTime("2019-01-01");
        baseInfo.setEndTime("2099-12-12");
        baseInfo.setRiskStatus("01");
        baseInfo.setOpenType("01");
        baseInfo.setChageType("01");
        baseInfo.setAccountType("04");
        baseInfo.setExpandType("01");
        baseInfo.setOutServiceName("外包");
        baseInfo.setOutServiceCardType("01");
        baseInfo.setOutServiceCardCode("129391930132318");
        baseInfo.setOutServiceLegCardType("01");
        baseInfo.setOutServiceLegCardCode("110220199011112222");
        baseInfo.setOrgId("123123123");
        baseInfo.setRepDate("2020-10-14 17:47:50");
        baseInfo.setRepType("03");
        baseInfo.setRepPerson("老赵");
    */

        baseInfos.add(baseInfo);
        pcacList.setBaseInfo(baseInfos);
        body.setPcacList(pcacList);
        pushPcac((T) body, "024", "EPR001");
    }

    @Test
    void QE0001NO() {
        // 拼装Body QE0001-个人商户查询无数据
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac037.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac037.Body();
        body.setDocCode("967522156112317186");
        body.setRegName("中移动电子商务有限公司");
        String[] QE0001 = pushPcac((T) body, "037", "QE0001");
        //       creatFile(QE0001[0], "QE0001-个人商户查询无数据-请求");
        //    creatFile(QE0001[1], "QE0001-个人商户查询无数据-响应");
    }

    @Test
    void QE0001YES() {
        // 拼装Body QE0001-个人商户查询有数据
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac037.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac037.Body();
        body.setDocCode("220110199888011111");
        body.setRegName("中移动电子玩具店");
        String[] QE0001 = pushPcac((T) body, "037", "QE0001");
        // creatFile(QE0001[0], "QE0001-个人商户查询有数据-请求");
        // creatFile(QE0001[1], "QE0001-个人商户查询有数据-响应");
    }

    /**
     * 个人商户批量查询
     * <ResultSequence>Wzhdg7Ih6mjH83czy38ERMR9jd1WwrtDpJ1O8qc5MK+6MlNBaaZm4ZFz9JOxMoVR</ResultSequence>
     */
    @Test
    void QE0002() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac039.PcacList();
        pcacList.setCount("1");
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setDocCode("220110199888011111");
        baseInfo.setRegName("中移动电子玩具店");
        ArrayList<BaseInfo> baseInfos = new ArrayList<>();
        baseInfos.add(baseInfo);
        pcacList.setBaseInfo(baseInfos);
        body.setPcacList(pcacList);
        String[] QE0002 = pushPcac((T) body, "039", "QE0002");
        // creatFile(QE0002[0], "QE0002-个人商户批量查询-请求");
        // creatFile(QE0002[1], "QE0002-个人商户批量查询-响应");
    }

    /**
     * 企业商户批量查询有数据 NMJDh2a9OwnpaAdh1pikUNhzbBlpSMkPPrZj3X9HhGy6MlNBaaZm4ZFz9JOxMoVR
     * titEqhNm9cDu4VVjyFiw1vd4qsm4738E/Ce0n/a8c9u6MlNBaaZm4ZFz9JOxMoVR
     */
    @Test
    void QE0004() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList();
        pcacList.setCount("1");
        ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo> baseInfos =
                new ArrayList<>();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo baseInfo =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo();
        baseInfo.setRegName("中移动");
        baseInfo.setLegDocCode("");
        baseInfo.setLegDocName("");
        baseInfo.setDocCode("");
        baseInfos.add(baseInfo);
        pcacList.setBaseInfo(baseInfos);
        body.setPcacList(pcacList);
        pushPcac((T) body, "044", "QE0004");
    }

    /**
     * 企业商户查询单商户 企业商户查询多商户 企业商户查询无数据
     */
    @Test
    void QE0003() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac041.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac041.Body();
        body.setDocType("");
        body.setDocCode("967522156112317186");
        body.setRegName("");
        body.setLegDocCode("");
        body.setLegDocName("");
        body.setResultSequence("");
        String[] qe0003s = pushPcac((T) body, "041", "QE0003");
        //    creatFile(qe0003s[0], "QE0003-企业商户查询多商户-请求");
        //    creatFile(qe0003s[1], "QE0003-企业商户查询多商户-响应");

    }

    /**
     * 个人商户批量查询结果补发 商户批量查询结果补发
     */
    @Test
    void TS0008() {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac034.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac034.Body();
        // 商户批量查询结果补发序列
        body.setResultSequence("ImUnjN2APkBWtI/T/9oN6UnmGcAVipkkiCrjB30l0oC6MlNBaaZm4ZFz9JOxMoVR");
        // 个人商户批量查询结果补发序列
        // body.setResultSequence("Wzhdg7Ih6mjH83czy38ERMR9jd1WwrtDpJ1O8qc5MK+6MlNBaaZm4ZFz9JOxMoVR");
        String[] TS0008 = pushPcac((T) body, "034", "TS0008");
        //    creatFile(TS0008[0], "TS0008-个人商户批量查询结果补发有数据-请求");
        //    creatFile(TS0008[1], "TS0008-个人商户批量查询结果补发有数据-响应");
        //    creatFile(TS0008[0], "TS0008-商户批量查询结果补发有数据-请求");
        //    creatFile(TS0008[1], "TS0008-商户批量查询结果补发有数据-响应");

    }

    @Test
    void TS0009() {
    }

    public String[] pushPcac(T body, String code, String trnxCode) {
        Document<T> document = getDocument(body, trnxCode);
        // 报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return null;
        }
        // 校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries." + code);
        if (!validate) {
            log.info("XML校验失败");
            return null;
        }
        Document<T> encrDocument = BeanUtilsEx.getEncrBean(document, symmetricKeyEncoded);
        encrDocument.setSignature(null);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(encrDocument);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        encrDocument.setSignature(signature);
        //      XmlJsonUtils.doSignature(encrDocument);
        xml = XmlJsonUtils.convertObjectToXmlStr(encrDocument);
        log.info("请求xml数据: {}", XmlJsonUtils.formatXml(xml));
        // 上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        String formatXml = XmlJsonUtils.formatXml(post);
        log.info("协会返回数据对象:{}", formatXml);
        return new String[]{XmlJsonUtils.formatXml(xml), formatXml};
    }

    private Document<T> getDocument(T body, String trnxCode) {
        // 拼装报文
        Document<T> document = new Document<>();
        // 设置报文头
        Request<T> request =
                XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, trnxCode);
        // 设置报文体
        request.setBody(body);
        document.setRequest(request);
        XmlJsonUtils.doSignature(document);
        return document;
    }
}

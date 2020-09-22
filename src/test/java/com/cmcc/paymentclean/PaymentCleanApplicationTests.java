package com.cmcc.paymentclean;

import com.cmcc.paymentclean.controller.PcacRiskInfoPushController;
import com.cmcc.paymentclean.cron.SubmitPcacPersonRiskInfo;
import com.cmcc.paymentclean.entity.LoginResult;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;
import com.cmcc.paymentclean.service.LoginPcacService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentCleanApplicationTests {

    @Autowired
    private SubmitPcacPersonRiskInfo submitPcacPersonRiskInfo;
    @Autowired
    private LoginPcacService loginPcacService;

    @Autowired
    private PcacRiskInfoPushController pcacRiskInfoPushController;

    @Test
    void contextLoads() {
    }


    /**
     * 测试个人风险信息上报接口
     */
    @Test
    public void test01() {
        submitPcacPersonRiskInfo.submit();
    }


    /**
     * 测试登录登出接口
     */
    @Test
    public void test02() {
        LoginResult result = loginPcacService.login();
        // LoginResult result = loginPcacService.logout();
        System.out.println("----------------登录结果--------------");
        System.out.println(result);
    }

    /**
     * 测试黑名单推送，风险提示信息推送
     */
    @Test
    public void test03() {

        String doxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><Request><Head><Version>V1.3.0</Version><Identification>202009171000001662</Identification><OrigSender>Z2004343000017</OrigSender><OrigSenderSID>zf_sysstem</OrigSenderSID><RecSystemId>R0001</RecSystemId><TrnxCode>TS0002</TrnxCode><TrnxTime>20200917124036</TrnxTime><UserToken>Io2lrHofKybUc%2BmKeG6qo%2FMQwXMQTOQ6IwrnIfgvhyHTf2SAN63W0wKbw%2FODal5I</UserToken><SecretKey></SecretKey></Head><Body><PcacList><Count>2</Count><UpDate>2020-09-17</UpDate><RiskInfo><RegName>1</RegName><CusName></CusName><DocType>1</DocType><DocCode></DocCode><LegDocName></LegDocName><LegDocType>2020-09-27</LegDocType><LegDocCode>2020-09-17 12:40:36</LegDocCode><Level>1</Level><RiskType>1</RiskType><ValidDate>1</ValidDate><CusType></CusType><Occurarea></Occurarea><BankNo></BankNo><Url></Url><RegisteredCode></RegisteredCode></RiskInfo></PcacList></Body></Request></Document>";
        String s = pcacRiskInfoPushController.blackListAndTipsInfo(doxml);
        System.out.println(s);
    }

    @Test
    public  void test04(){
        ReissueRiskInfoReq reissueRiskInfoReq = new ReissueRiskInfoReq();
        reissueRiskInfoReq.setReqDate("2020-09-01");
        //reissueRiskInfoReq.setReqDateEnd("2020-09-05");
        reissueRiskInfoReq.setRiskType("01");
        ResultBean resultBean = pcacRiskInfoPushController.reissueRiskInfo(reissueRiskInfoReq);
        System.out.println("响应结果："+resultBean);
    }

}

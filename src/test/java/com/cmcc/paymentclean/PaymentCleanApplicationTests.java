package com.cmcc.paymentclean;

import com.cmcc.paymentclean.controller.PcacRiskInfoPushController;
import com.cmcc.paymentclean.cron.SubmitPcacPersonRiskInfo;
import com.cmcc.paymentclean.entity.LoginResult;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.RiskInfo;
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
     *
     * */
    @Test
    public void  test01(){
        submitPcacPersonRiskInfo.submit();
    }


    /**
     * 测试登录登出接口
     * */
    @Test
    public void  test02(){
       LoginResult result = loginPcacService.login();
       // LoginResult result = loginPcacService.logout();
        System.out.println("----------------登录结果--------------");
        System.out.println(result);
    }

    /**
     *
     * 测试黑名单推送，风险提示信息推送
     * */
    public  void test03(){

        String doxml = "";
        pcacRiskInfoPushController.riskTipsInfo(doxml);
    }

}

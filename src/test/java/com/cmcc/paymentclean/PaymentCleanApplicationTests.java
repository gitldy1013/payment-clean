package com.cmcc.paymentclean;

import com.cmcc.paymentclean.cron.SubmitPcacPersonRiskInfo;
import com.cmcc.paymentclean.entity.LoginResult;
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
    @Test
    void contextLoads() {
    }

    @Test
    public void  test01(){
        submitPcacPersonRiskInfo.submit();
    }

    @Test
    public void  test02(){
       LoginResult result = loginPcacService.login();
       // LoginResult result = loginPcacService.logout();
        System.out.println("----------------登录结果--------------");
        System.out.println(result);
    }

}

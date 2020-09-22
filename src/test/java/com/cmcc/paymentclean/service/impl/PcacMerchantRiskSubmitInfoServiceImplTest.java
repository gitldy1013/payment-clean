package com.cmcc.paymentclean.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
class PcacMerchantRiskSubmitInfoServiceImplTest {

    @Autowired
    private PcacMerchantRiskSubmitInfoServiceImpl pcacMerchantRiskSubmitInfoService;

    @Test
    void queryRiskMerchantAndPushPcac() {
        pcacMerchantRiskSubmitInfoService.queryRiskMerchantAndPushPcac();
    }
}

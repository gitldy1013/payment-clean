package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PcacEnterpriseRiskSubmitInfoServiceImplTest {
    @Autowired
    private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

    @Test
    void queryRiskEnterpriseAndPushPcac() {
        pcacEnterpriseRiskSubmitInfoService.queryRiskEnterpriseAndPushPcac();
    }
}

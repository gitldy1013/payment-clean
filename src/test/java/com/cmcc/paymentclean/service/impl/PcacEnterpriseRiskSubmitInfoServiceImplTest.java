package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
class PcacEnterpriseRiskSubmitInfoServiceImplTest {
  @Autowired private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

  @Test
  void queryRiskEnterpriseAndPushPcac() {
    pcacEnterpriseRiskSubmitInfoService.queryRiskEnterpriseAndPushPcac();
  }
}

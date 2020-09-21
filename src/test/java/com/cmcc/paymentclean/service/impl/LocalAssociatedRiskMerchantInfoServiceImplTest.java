package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoBackReq;
import com.cmcc.paymentclean.service.LocalAssociatedRiskMerchantInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class LocalAssociatedRiskMerchantInfoServiceImplTest {

    @Autowired
    private LocalAssociatedRiskMerchantInfoService localAssociatedRiskMerchantInfoService;

    @Test
    void localAssociatedRiskMerchantInfoBack() {
        ArrayList<AssociatedRiskMerchantInfoBackReq> associatedRiskMerchantInfoBackReqs = new ArrayList<>();
        AssociatedRiskMerchantInfoBackReq associatedRiskMerchantInfoBackReq = new AssociatedRiskMerchantInfoBackReq();
        associatedRiskMerchantInfoBackReq.setAmount("123.23");
        associatedRiskMerchantInfoBackReq.setDocCode("111123123123123");
        associatedRiskMerchantInfoBackReq.setDocType("01");
        associatedRiskMerchantInfoBackReq.setHandleResult("02");
        associatedRiskMerchantInfoBackReq.setOperator("东东");
        associatedRiskMerchantInfoBackReqs.add(associatedRiskMerchantInfoBackReq);
        ResultBean<Body> resultBean = localAssociatedRiskMerchantInfoService.localAssociatedRiskMerchantInfoBack(associatedRiskMerchantInfoBackReqs);
        log.info("反馈结果：{}",resultBean);

    }
}

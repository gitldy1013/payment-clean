package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ActiveProfiles("dev")
class QueryPcacMerchantRiskInfoServiceImplTest {

    @Autowired
    private QueryPcacMerchantRiskInfoService queryPcacMerchantRiskInfoService;

    @Test
    void batchQueryPcacMerchantRisk() {
        List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs = new ArrayList<>();
        QueryPcacMerchantRiskReq queryPcacMerchantRiskReq = new QueryPcacMerchantRiskReq();
        queryPcacMerchantRiskReq.setKeyWord("01");
        queryPcacMerchantRiskReq.setCusProperty("02");
        queryPcacMerchantRiskReq.setInfos("123,223");
        QueryPcacMerchantRiskReq queryPcacMerchantRiskReq2 = new QueryPcacMerchantRiskReq();
        queryPcacMerchantRiskReq2.setKeyWord("01");
        queryPcacMerchantRiskReq2.setCusProperty("02");
        queryPcacMerchantRiskReq2.setInfos("143,233");
        queryPcacMerchantRiskReqs.add(queryPcacMerchantRiskReq);
        queryPcacMerchantRiskReqs.add(queryPcacMerchantRiskReq2);
        ResultBean<Body> resultBean = queryPcacMerchantRiskInfoService.batchQueryPcacMerchantRisk(queryPcacMerchantRiskReqs);
        log.info("响应结果：{}",resultBean);
    }

    @Test
    void queryPcacMerchantRiskInfoBack(){
        List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReqs = new ArrayList<>();
        QueryPcacMerchantRiskInfoBackReq queryPcacMerchantRiskInfoBack = new QueryPcacMerchantRiskInfoBackReq();
        queryPcacMerchantRiskInfoBack.setId("UO6ES8sc54i3NaCr9qRabA==");
        queryPcacMerchantRiskInfoBack.setCusType("01");
        queryPcacMerchantRiskInfoBack.setAmount("12.56");
        queryPcacMerchantRiskInfoBack.setHandleResult("01");
        queryPcacMerchantRiskInfoBack.setHandleTime("2019-01-13");
        queryPcacMerchantRiskInfoBackReqs.add(queryPcacMerchantRiskInfoBack);
        ResultBean<Body> resultBean = queryPcacMerchantRiskInfoService.queryPcacMerchantRiskInfoBack(queryPcacMerchantRiskInfoBackReqs);
        log.info("响应结果：{}",resultBean);
    }
}

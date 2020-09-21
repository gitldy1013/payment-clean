package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
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
class QueryPcacMerchantRiskInfoServiceImplTest {

    @Autowired
    private QueryPcacMerchantRiskInfoService queryPcacMerchantRiskInfoService;

    @Test
    void queryPcacMerchantRiskInfoBack() {
        List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs = new ArrayList<>();
        QueryPcacMerchantRiskReq queryPcacMerchantRiskReq = new QueryPcacMerchantRiskReq();
        queryPcacMerchantRiskReq.setKeyWord("01");
        queryPcacMerchantRiskReq.setCusProperty("02");
        queryPcacMerchantRiskReq.setInfos("123,223");
        QueryPcacMerchantRiskReq queryPcacMerchantRiskReq2 = new QueryPcacMerchantRiskReq();
        queryPcacMerchantRiskReq2.setKeyWord("01");
        queryPcacMerchantRiskReq2.setCusProperty("02");
        queryPcacMerchantRiskReq2.setInfos("123,223");
        queryPcacMerchantRiskReqs.add(queryPcacMerchantRiskReq);
        queryPcacMerchantRiskReqs.add(queryPcacMerchantRiskReq2);
        ResultBean<Body> resultBean = queryPcacMerchantRiskInfoService.batchQueryPcacMerchantRisk(queryPcacMerchantRiskReqs);
        log.info("响应结果：{}",resultBean);
    }
}

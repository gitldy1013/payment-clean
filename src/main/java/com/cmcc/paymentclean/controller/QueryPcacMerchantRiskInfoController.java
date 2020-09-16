package com.cmcc.paymentclean.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaolei
 * @since 2020-09-14
 * @version v1.0
 */
@RestController
@RequestMapping("/isocRisk")
public class QueryPcacMerchantRiskInfoController {

    @Autowired
    private QueryPcacMerchantRiskInfoService queryPcacMerchantRiskInfoService;

    /**
     * 协会风险商户查询请求接口
     */
    @ApiOperation(value = "协会风险商户查询请求接口", notes = "协会风险商户查询请求接口")
    @RequestMapping(value = "/isocRegRisk/query",method = RequestMethod.POST)
    public ResultBean<Page<QueryPcacMerchantRiskInfoResp>> queryPage(@RequestBody QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq) {

        return queryPcacMerchantRiskInfoService.pageLocalAssociatedRiskMerchantInfo(queryPcacMerchantRiskInfoReq);
    }

    /**
     * 批量查询商户风险信息
     */
    @ApiOperation(value = "批量查询商户风险信息", notes = "批量查询商户风险信息")
    @RequestMapping(value = "/isocRegRiskByKeyWord/query",method = RequestMethod.POST)
    public ResultBean<Body> query(@RequestBody QueryPcacMerchantRiskReq queryPcacMerchantRiskReq) {
        return queryPcacMerchantRiskInfoService.batchQueryPcacMerchantRisk(queryPcacMerchantRiskReq);
    }
}

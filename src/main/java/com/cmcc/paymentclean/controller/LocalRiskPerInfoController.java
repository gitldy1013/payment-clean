package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonRiskSyncInfoReq;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import com.cmcc.paymentclean.service.RiskPersonRiskSyncInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 风险个人 前端控制器
 * </p>
 *
 * @author lumma
 * @since 2020-09-08
 * @version v1.0 */
@RestController
@RequestMapping("/localRisk/localRiskPer")
@Slf4j
public class LocalRiskPerInfoController {

    @Autowired
    private RiskPersonRiskSyncInfoService riskPersonRiskSyncInfoService;

    @Autowired
    private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

    /**
     * 风险个人同步请求接口
     */
    @ApiOperation(value = "风险个人同步", notes = "风险个人同步")
    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    public ResultBean<Boolean> sync(@RequestBody List<RiskPersonRiskSyncInfoReq> riskPersonList) {

        return riskPersonRiskSyncInfoService.addRiskPerson(riskPersonList);
    }

    /**
     * 风险个人查询请求接口
     */
    @ApiOperation(value = "风险个人查询", notes = "风险个人查询")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultBean<Page<RiskPersonResp>> query(@RequestBody RiskPersonReq riskPersonReq){
        return pcacPersonRiskSubmitInfoService.pageRiskPerson(riskPersonReq);
    }
}

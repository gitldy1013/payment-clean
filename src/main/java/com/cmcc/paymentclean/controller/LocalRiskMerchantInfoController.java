package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.service.RiskMerchantService;
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
 * 风险商户 前端控制器
 * </p>
 *
 * @author lumma
 * @since 2020-09-08
 * @version v1.0 */
@RestController
@RequestMapping("/localRisk/localRiskReg")
@Slf4j
public class LocalRiskMerchantInfoController {

    @Autowired
    private RiskMerchantService riskMerchantService;

    @Autowired
    private PcacMerchantRiskSubmitInfoService pcacMerchantRiskSubmitInfoService;

    /**
     * 风险商户同步请求接口
     */
    @ApiOperation(value = "风险商户同步", notes = "风险商户同步")
    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    public ResultBean<Boolean> sync(@RequestBody List<RiskMerchant> riskMerchants) {

        return riskMerchantService.addMerchant(riskMerchants);
    }

    /**
     * 风险商户查询请求接口
     */
    @ApiOperation(value = "风险商户查询", notes = "风险商户查询")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultBean<Page<RiskMerchantResp>> query(@RequestBody RiskMerchantReq riskMerchantReq){
        return pcacMerchantRiskSubmitInfoService.pageRiskMerchant(riskMerchantReq);
    }

}

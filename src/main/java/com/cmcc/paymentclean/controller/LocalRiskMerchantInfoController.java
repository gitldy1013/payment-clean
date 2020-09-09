package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import com.cmcc.paymentclean.service.RiskMerchantService;
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
@RequestMapping("/localRisk/localRiskReg")
@Slf4j
public class LocalRiskMerchantInfoController {

    @Autowired
    private RiskMerchantService riskMerchantService;

    @Autowired
    private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

    /**
     * 风险个人查询请求接口
     */
    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    public ResultBean<Boolean> sync(@RequestBody List<RiskMerchant> riskMerchants) {

        return new ResultBean<>(riskMerchantService.addRiskPerson(riskMerchants));
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultBean<Page<RiskPersonResp>> query(@RequestBody RiskPersonReq riskPersonReq){
        System.out.println("11");
        return new ResultBean<>(pcacPersonRiskSubmitInfoService.pageRiskPerson(riskPersonReq));
    }
}

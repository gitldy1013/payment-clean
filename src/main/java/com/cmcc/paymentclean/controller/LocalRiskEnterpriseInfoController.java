package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.RiskEnterprise;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import com.cmcc.paymentclean.service.RiskEnterpriseService;
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
@RequestMapping("/localRisk/localRiskCom")
@Slf4j
public class LocalRiskEnterpriseInfoController {

    @Autowired
    private RiskEnterpriseService riskEnterpriseService;

    @Autowired
    private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

    /**
     * 风险个人查询请求接口
     */
    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    public ResultBean<Boolean> sync(@RequestBody List<RiskEnterprise> riskEnterprises) {

        return riskEnterpriseService.addRiskPerson(riskEnterprises);
    }

}

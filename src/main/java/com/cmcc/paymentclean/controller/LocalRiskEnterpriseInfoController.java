package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseRiskSyncInfoReq;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import com.cmcc.paymentclean.service.RiskEnterpriseRiskSyncInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 风险企业 前端控制器
 *
 * @author lumma
 * @since 2020-09-08
 * @version v1.0
 */
@RestController
@RequestMapping("/localRisk/localRiskCom")
@Slf4j
public class LocalRiskEnterpriseInfoController {

  @Autowired private RiskEnterpriseRiskSyncInfoService riskEnterpriseRiskSyncInfoService;

  @Autowired private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

  /** 风险企业同步请求接口 */
  @ApiOperation(value = "风险企业同步", notes = "风险企业同步")
  @RequestMapping(value = "/sync", method = RequestMethod.POST)
  public ResultBean<Boolean> sync(
      @RequestBody List<RiskEnterpriseRiskSyncInfoReq> riskEnterprises) {

    return riskEnterpriseRiskSyncInfoService.addEnterprise(riskEnterprises);
  }

  /** 风险企业查询接口 */
  @ApiOperation(value = "风险企业查询", notes = "风险企业查询")
  @RequestMapping(value = "/query", method = RequestMethod.POST)
  public ResultBean<Page<RiskEnterpriseResp>> query(
      @RequestBody RiskEnterpriseReq riskEnterpriseReq) {
    return pcacEnterpriseRiskSubmitInfoService.pageRiskEnterprise(riskEnterpriseReq);
  }
}

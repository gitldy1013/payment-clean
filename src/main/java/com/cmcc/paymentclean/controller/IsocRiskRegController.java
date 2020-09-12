package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lumma on 2020/9/12.
 */
@RestController
@RequestMapping("/isocRisk/isocRiskReg")
@Slf4j
public class IsocRiskRegController {

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;

    /**
     * 协会风险商户查询请求接口
     */
    @ApiOperation(value = "协会风险商户查询请求接口", notes = "协会风险商户查询请求接口")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultBean<Page<PcacRiskInfoResp>> sync(@RequestBody PcacRiskInfoReq pcacRiskInfoReq) {

        return pcacRiskInfoService.pagePcacRiskInfo(pcacRiskInfoReq);
    }
}

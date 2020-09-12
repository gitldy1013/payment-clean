package com.cmcc.paymentclean.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;
import com.cmcc.paymentclean.service.LocalAssociatedRiskMerchantInfoService;
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
@RequestMapping("/localRisk/localRiskMsg")
@Slf4j
public class localRiskMsgController {

    @Autowired
    private LocalAssociatedRiskMerchantInfoService localAssociatedRiskMerchantInfoService;

    /**
     * 本地商户关联请求接口
     */
    @ApiOperation(value = "本地商户关联查询", notes = "本地商户关联查询")
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultBean<Page<AssociatedRiskMerchantInfoResp>> sync(@RequestBody AssociatedRiskMerchantInfoReq associatedRiskMerchantInfoReq) {

        return localAssociatedRiskMerchantInfoService.pageLocalAssociatedRiskMerchantInfo(associatedRiskMerchantInfoReq);
    }
}

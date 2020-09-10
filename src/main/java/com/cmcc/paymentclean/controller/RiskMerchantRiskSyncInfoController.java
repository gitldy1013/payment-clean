package com.cmcc.paymentclean.controller;


import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.RiskMerchantRiskSyncInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 风控商户风险信息同步表  前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/risk-merchant-risk-sync-info")
public class RiskMerchantRiskSyncInfoController {

    @Autowired
    private RiskMerchantRiskSyncInfoService riskMerchantRiskSyncInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(riskMerchantRiskSyncInfoService.listRiskMerchantRiskSyncInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(riskMerchantRiskSyncInfoService.getRiskMerchantRiskSyncInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        return new ResultBean<>(riskMerchantRiskSyncInfoService.insertRiskMerchantRiskSyncInfo(riskMerchantRiskSyncInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(riskMerchantRiskSyncInfoService.deleteRiskMerchantRiskSyncInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        return new ResultBean<>(riskMerchantRiskSyncInfoService.updateRiskMerchantRiskSyncInfo(riskMerchantRiskSyncInfo));
    }
}

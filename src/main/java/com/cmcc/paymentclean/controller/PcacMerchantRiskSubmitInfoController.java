package com.cmcc.paymentclean.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 协会商户风险信息上报表  前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 * @version v1.0
 */
@RestController
@RequestMapping("/paymentclean/api/v1/pcac-merchant-risk-submit-info")
public class PcacMerchantRiskSubmitInfoController {

    @Autowired
    private PcacMerchantRiskSubmitInfoService pcacMerchantRiskSubmitInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(pcacMerchantRiskSubmitInfoService.listPcacMerchantRiskSubmitInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacMerchantRiskSubmitInfoService.getPcacMerchantRiskSubmitInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        return new ResultBean<>(pcacMerchantRiskSubmitInfoService.insertPcacMerchantRiskSubmitInfo(pcacMerchantRiskSubmitInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(pcacMerchantRiskSubmitInfoService.deletePcacMerchantRiskSubmitInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        return new ResultBean<>(pcacMerchantRiskSubmitInfoService.updatePcacMerchantRiskSubmitInfo(pcacMerchantRiskSubmitInfo));
    }
}

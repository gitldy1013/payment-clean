package com.cmcc.paymentclean.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/paymentclean/api/v1/query-pcac-merchant-risk-info")
public class QueryPcacMerchantRiskInfoController {

    @Autowired
    private QueryPcacMerchantRiskInfoService queryPcacMerchantRiskInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(queryPcacMerchantRiskInfoService.listQueryPcacMerchantRiskInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(queryPcacMerchantRiskInfoService.getQueryPcacMerchantRiskInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo) {
        return new ResultBean<>(queryPcacMerchantRiskInfoService.insertQueryPcacMerchantRiskInfo(queryPcacMerchantRiskInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(queryPcacMerchantRiskInfoService.deleteQueryPcacMerchantRiskInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo) {
        return new ResultBean<>(queryPcacMerchantRiskInfoService.updateQueryPcacMerchantRiskInfo(queryPcacMerchantRiskInfo));
    }
}

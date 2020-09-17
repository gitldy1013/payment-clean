package com.cmcc.paymentclean.controller;


import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;
import com.cmcc.paymentclean.service.BusinessInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 企业商户信息表  前端控制器
 * </p>
 *
 * @author cmcc
 * @since 2020-09-15
 * @version v1.0
 */
@RestController
@RequestMapping("/business/businessInfo")
public class BusinessInfoController {

    @Autowired
    private BusinessInfoService businessInfoService;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(businessInfoService.listBusinessInfosByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(businessInfoService.getBusinessInfoById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody BusinessInfo businessInfo) {
        return new ResultBean<>(businessInfoService.insertBusinessInfo(businessInfo));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(businessInfoService.deleteBusinessInfoById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody BusinessInfo businessInfo) {
        return new ResultBean<>(businessInfoService.updateBusinessInfo(businessInfo));
    }

    /**
     * 批量企业商户查询请求接口
     */
    @ApiOperation(value = "批量企业商户查询请求接口", notes = "批量企业商户查询请求接口")
    @RequestMapping(value = "/batchQuery",method = RequestMethod.POST)
    public ResultBean<?> batchQuery(@RequestBody List<BusinessInfoReq> businessInfoReqs) {

       return businessInfoService.batchQuery(businessInfoReqs);
    }

    /**
     * 批量企业商户查询请求接口
     */
    @ApiOperation(value = "批量企业商户查询请求接口", notes = "批量企业商户查询请求接口")
    @RequestMapping(value = "/getBusinessInfoXML",method = RequestMethod.POST)
    public ResultBean<?> getBusinessInfoXML(@RequestBody String xml) {

        return  businessInfoService.getBusinessInfoXML(xml);

    }
}

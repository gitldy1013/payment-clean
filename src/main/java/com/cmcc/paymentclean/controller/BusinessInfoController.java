package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;
import com.cmcc.paymentclean.service.BusinessInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 企业商户信息表 前端控制器
 *
 * @author cmcc
 * @since 2020-09-15
 * @version v1.0
 */
@RestController
@RequestMapping("/specReg/specRegCom")
public class BusinessInfoController {

  @Autowired private BusinessInfoService businessInfoService;

  /** 批量企业商户查询请求接口 */
  @ApiOperation(value = "批量企业商户查询请求接口", notes = "批量企业商户查询请求接口")
  @RequestMapping(value = "/query", method = RequestMethod.POST)
  public ResultBean<?> batchQuery(@RequestBody List<BusinessInfoReq> businessInfoReqs) {

    return businessInfoService.batchQuery(businessInfoReqs);
  }

  /** 批量查询企业信息结果推送 */
  /*  @ApiOperation(value = "批量查询企业信息结果推送", notes = "批量查询企业信息结果推送")
  @RequestMapping(value = "/getBusinessInfoXML",method = {RequestMethod.POST,RequestMethod.GET})
  public String getBusinessInfoXML(@RequestBody String xml) {

      return  businessInfoService.getBusinessInfoXML(xml);

  }*/
}

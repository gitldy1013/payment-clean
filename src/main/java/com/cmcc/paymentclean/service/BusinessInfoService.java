package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;

import java.util.List;

/**
* <p>
* 企业商户信息表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-15
*/
public interface BusinessInfoService {

    ResultBean<Body> exportExcel();

    /**
     * 企业商户查询本地数据库推送至协会
     */
    void queryBusinessInfoAndPushPcac();

    /**
     * 批量协会查询企业商户信息
     */
    ResultBean batchQuery(List<BusinessInfoReq> businessInfoReqs);

    /**
     * 批量查询企业信息结果推送
     */
    ResultBean<?> getBusinessInfoXML(String xml);
}

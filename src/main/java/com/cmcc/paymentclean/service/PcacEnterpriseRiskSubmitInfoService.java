package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;

/**
* <p>
* 协会企业风险信息上报表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface PcacEnterpriseRiskSubmitInfoService {

    /**
     * 风险企业查询请求接口
     * @param riskEnterpriseReq
     * @return Page<RiskEnterpriseResp>
     */
    ResultBean<Page<RiskEnterpriseResp>> pageRiskEnterprise(RiskEnterpriseReq riskEnterpriseReq);

    /**
     * 风险个人查询本地数据库推送至协会
     */
    void queryRiskEnterpriseAndPushPcac();
}

package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;

/**
* <p>
* 协会商户风险信息上报表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface PcacMerchantRiskSubmitInfoService {

    /**
     * 风险商户查询请求接口
     * @param riskMerchantReq
     * @return Page<RiskMerchantReqResp>
     */
    ResultBean<Page<RiskMerchantResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq);

    /**
     * 风险商户查询本地数据库推送至协会
     */
    void queryRiskMerchantAndPushPcac();

}

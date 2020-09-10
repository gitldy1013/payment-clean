package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantReqResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;

/**
 * Created by lumma on 2020/9/10.
 */
public interface PcacMerchantRiskSubmitInfoService {
    /**
     * 风险商户查询请求接口
     * @param riskMerchantReq
     * @return Page<RiskMerchantReqResp>
     */
    ResultBean<Page<RiskMerchantReqResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq);
}

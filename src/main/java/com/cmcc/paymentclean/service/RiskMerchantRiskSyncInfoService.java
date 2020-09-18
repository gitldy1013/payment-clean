package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;

import java.util.List;

/**
* <p>
* 风控商户风险信息同步表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface RiskMerchantRiskSyncInfoService {

    /**
     * 风险商户同步请求接口
     * @param riskMerchantList
     * @return Page<Boolean>
     */
    ResultBean<Boolean> addMerchant(List<RiskMerchantRiskSyncInfoReq> riskMerchantList);

}

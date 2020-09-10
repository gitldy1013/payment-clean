package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */

public interface RiskMerchantService {

    /**
     * 风险商户同步请求接口
     * @param riskMerchantList
     * @return Page<Boolean>
     */
    ResultBean<Boolean> addMerchant(List<RiskMerchant> riskMerchantList);
}

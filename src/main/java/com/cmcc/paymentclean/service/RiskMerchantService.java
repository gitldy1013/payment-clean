package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */

public interface RiskMerchantService {
    ResultBean<Boolean> addRiskPerson(List<RiskMerchant> riskMerchantList);
}

package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskMerchant;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */

public interface RiskMerchantService {
    boolean addRiskPerson(List<RiskMerchant> riskMerchantList);
}

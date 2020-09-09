package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskEnterprise;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */
public interface RiskEnterpriseService {
    boolean addRiskPerson(List<RiskEnterprise> riskEnterpriseList);
}

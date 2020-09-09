package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskEnterprise;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */
public interface RiskEnterpriseService {
    ResultBean<Boolean> addRiskPerson(List<RiskEnterprise> riskEnterpriseList);
}

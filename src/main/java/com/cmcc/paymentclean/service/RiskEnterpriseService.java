package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskEnterprise;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */
public interface RiskEnterpriseService {

    /**
     * 风险企业同步请求接口
     * @param riskEnterpriseList
     * @return Page<Boolean>
     */
    ResultBean<Boolean> addEnterprise(List<RiskEnterprise> riskEnterpriseList);
}

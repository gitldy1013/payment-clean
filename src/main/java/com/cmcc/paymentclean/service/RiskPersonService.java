package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskPerson;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
public interface RiskPersonService {

    /**
     * 风险个人同步请求接口
     * @param riskPersonList
     * @return Page<Boolean>
     */
    ResultBean<Boolean> addRiskPerson(List<RiskPerson> riskPersonList);

}

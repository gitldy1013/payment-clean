package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskPerson;
import com.cmcc.paymentclean.entity.dto.ResultBean;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
public interface RiskPersonService {

    ResultBean<Boolean> addRiskPerson(List<RiskPerson> riskPersonList);

}

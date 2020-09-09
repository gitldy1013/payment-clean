package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskPerson;

import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
public interface RiskPersonService {

    boolean addRiskPerson(List<RiskPerson> riskPersonList);

}

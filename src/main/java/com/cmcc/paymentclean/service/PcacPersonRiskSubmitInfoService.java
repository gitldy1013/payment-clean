package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;

/**
 * Created by lumma on 2020/9/9.
 */
public interface PcacPersonRiskSubmitInfoService {

    Page<RiskPersonResp> pageRiskPerson(RiskPersonReq riskPersonReq);
}

package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;

/**
 * Created by lumma on 2020/9/9.
 */
public interface PcacPersonRiskSubmitInfoService {

    /**
     * 风险个人查询请求接口
     * @param riskPersonReq
     * @return Page<RiskPersonResp>
     */
    ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq);
}

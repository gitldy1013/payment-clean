package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;

/**
* <p>
* 协会个人风险信息上报表  服务类
* </p>
*
* @author zhaolei
* @since 2020-09-13
*/
public interface PcacPersonRiskSubmitInfoService {

    /**
     * 风险个人查询请求接口
     * @param riskPersonReq
     * @return Page<RiskPersonResp>
     */
    ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq);

}

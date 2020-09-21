package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;

import java.util.List;

/**
* <p>
* 本地关联风险商户信息表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface LocalAssociatedRiskMerchantInfoService {

    /**
     * 协会风险商户查询请求接口
     * @param associatedRiskMerchantInfoReq
     * @return Page<RiskPersonResp>
     */
    ResultBean<Page<AssociatedRiskMerchantInfoResp>> pageLocalAssociatedRiskMerchantInfo(AssociatedRiskMerchantInfoReq associatedRiskMerchantInfoReq);

    /**
     * 协会风险商户反馈请求接口&商户黑名单信息反馈
     * @param associatedRiskMerchantInfoBackReq 反馈信息
     * @return 反馈状态信息
     */
    ResultBean<Body> localAssociatedRiskMerchantInfoBack(List<AssociatedRiskMerchantInfoBackReq> associatedRiskMerchantInfoBackReq);
}

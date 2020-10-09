package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;

import java.util.List;

/**
 * 风控商户风险信息同步表 服务类
 *
 * @author cmcc
 * @since 2020-09-10
 */
public interface RiskMerchantRiskSyncInfoService {

  /**
   * 风险商户同步请求接口
   *
   * @param riskMerchantList
   * @return Page<Boolean>
   */
  ResultBean<Boolean> addMerchant(List<RiskMerchantRiskSyncInfoReq> riskMerchantList);
}

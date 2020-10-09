package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseRiskSyncInfoReq;

import java.util.List;

/**
 * 风控企业风险信息同步表 服务类
 *
 * @author zhaolei
 * @since 2020-09-11
 */
public interface RiskEnterpriseRiskSyncInfoService {

  /**
   * 风险企业同步请求接口
   *
   * @param riskEnterpriseList
   * @return Page<Boolean>
   */
  ResultBean<Boolean> addEnterprise(List<RiskEnterpriseRiskSyncInfoReq> riskEnterpriseList);
}

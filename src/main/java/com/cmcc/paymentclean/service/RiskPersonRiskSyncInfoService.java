package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonRiskSyncInfoReq;

import java.util.List;

/**
 * 风控个人风险信息同步表 服务类
 *
 * @author cmcc
 * @since 2020-09-10
 */
public interface RiskPersonRiskSyncInfoService {

  /**
   * 风险个人同步请求接口
   *
   * @param riskPersonList
   * @return Page<Boolean>
   */
  ResultBean<Boolean> addRiskPerson(List<RiskPersonRiskSyncInfoReq> riskPersonList);
}

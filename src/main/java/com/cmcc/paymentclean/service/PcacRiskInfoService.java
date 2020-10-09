package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;

import java.util.ArrayList;
import java.util.List;

/**
 * 商户黑名单提示信息表 服务类
 *
 * @author cmcc
 * @since 2020-09-08
 */
public interface PcacRiskInfoService {

  /**
   * 协会风险商户查询请求接口
   *
   * @param riskInfoReq
   * @return Page<RiskPersonResp>
   */
  ResultBean<Page<PcacRiskInfoResp>> pagePcacRiskInfo(PcacRiskInfoReq riskInfoReq);

  /**
   * 协会风险商户根据推送名单类型 查询(未上传)
   *
   * @param pushListType
   * @return List<PcacRiskInfo>
   */
  List<PcacRiskInfoDTO> listByIsBlack(String pushListType);

  // String insertBatchPcacRiskInfo(ArrayList<PcacRiskInfo> pcacRiskInfoList,String identification);
  void insertBatchPcacRiskInfo(ArrayList<PcacRiskInfo> pcacRiskInfoList);

  void updatePushStatus(List<String> ids);

  ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body> reissueRiskInfo(ReissueRiskInfoReq reissueRiskInfoReq);

  List<PcacRiskInfoDTO> listAll();
}

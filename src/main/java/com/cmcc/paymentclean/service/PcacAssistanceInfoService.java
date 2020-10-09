package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 商户信息比对协查信息表 服务类
 *
 * @author cmcc
 * @since 2020-09-08
 */
@Service
public interface PcacAssistanceInfoService {

  // String saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList,String
  // identification);
  void saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList);
}

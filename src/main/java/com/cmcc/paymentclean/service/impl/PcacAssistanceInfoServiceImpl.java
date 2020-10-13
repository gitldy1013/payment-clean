package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.mapper.PcacAssistanceInfoMapper;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 商户信息比对协查信息表 服务实现类
 *
 * @author cmcc
 * @since 2020-09-08
 */
@Slf4j
@Service
public class PcacAssistanceInfoServiceImpl
    extends ServiceImpl<PcacAssistanceInfoMapper, PcacAssistanceInfo>
    implements PcacAssistanceInfoService {

  @Autowired private PcacAssistanceInfoMapper pcacAssistanceInfoMapper;
  @Autowired private PcacConfig pcacConfig;

  /*    @Override
  public String saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList,String identification) {
      try {
          pcacAssistanceInfoMapper.insertBatchAssistanceInfo(assistanceInfoList);
          Document document = XmlJsonUtils.getRespDocument(pcacConfig,identification);
          String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
          return doXml;
      }catch (Exception e){
          log.error("异常:"+e);
          return e.getMessage();
      }

  }*/
  @Override
  public void saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList) {
    try {
      pcacAssistanceInfoMapper.insertBatchAssistanceInfo(assistanceInfoList);

    } catch (Exception e) {
      log.error("异常:" + e);
    }
  }
}

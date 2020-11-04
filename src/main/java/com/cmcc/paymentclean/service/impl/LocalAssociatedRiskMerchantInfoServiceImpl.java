package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.FeedbackStatusEnum;
import com.cmcc.paymentclean.consts.HandleResultEnum;
import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.PushListTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.StatusEnum;
import com.cmcc.paymentclean.consts.SysLanEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;
import com.cmcc.paymentclean.mapper.LocalAssociatedRiskMerchantInfoMapper;
import com.cmcc.paymentclean.mapper.PcacRiskInfoMapper;
import com.cmcc.paymentclean.service.LocalAssociatedRiskMerchantInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cmcc.paymentclean.entity.dto.ResultBean.PARAM_ERR;

/**
 * 本地关联风险商户信息表 服务实现类
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class LocalAssociatedRiskMerchantInfoServiceImpl
    extends ServiceImpl<LocalAssociatedRiskMerchantInfoMapper, LocalAssociatedRiskMerchantInfo>
    implements LocalAssociatedRiskMerchantInfoService {

  @Autowired private LocalAssociatedRiskMerchantInfoMapper localAssociatedRiskMerchantInfoMapper;

  @Autowired private PcacRiskInfoMapper pcacRiskInfoMapper;

  @Autowired private PcacConfig pcacConfig;

  @Override
  public ResultBean<Page<AssociatedRiskMerchantInfoResp>> pageLocalAssociatedRiskMerchantInfo(
      AssociatedRiskMerchantInfoReq associatedRiskMerchantInfoReq) {
    log.info(
        "pageLocalAssociatedRiskMerchantInfo req={}",
        com.alibaba.fastjson.JSON.toJSON(associatedRiskMerchantInfoReq));
    ResultBean<Page<AssociatedRiskMerchantInfoResp>> resultBean = new ResultBean<>();
    Page<AssociatedRiskMerchantInfoResp> page =
        new Page<>(
            associatedRiskMerchantInfoReq.getPageNo(), associatedRiskMerchantInfoReq.getPageSize());
    Page<AssociatedRiskMerchantInfoResp> pageLocalAssociatedRiskMerchantInfo =
        localAssociatedRiskMerchantInfoMapper.pageLocalAssociatedRiskMerchantInfo(
            page, associatedRiskMerchantInfoReq);
    List<AssociatedRiskMerchantInfoResp> associatedRiskMerchantInfoResps =
        pageLocalAssociatedRiskMerchantInfo.getRecords();
    if (!CollectionUtils.isEmpty(associatedRiskMerchantInfoResps)) {
      for (AssociatedRiskMerchantInfoResp associatedRiskMerchantInfoResp :
          associatedRiskMerchantInfoResps) {
        String validStatus =
            (new Date().before(associatedRiskMerchantInfoResp.getValidDate()))
                ? CommonConst.VALIDSTATUS_01
                : CommonConst.VALIDSTATUS_02;
        associatedRiskMerchantInfoResp.setValidStatus(validStatus);
        associatedRiskMerchantInfoResp.setPushListType(
            PushListTypeEnum.getPushListTypeDesc(associatedRiskMerchantInfoResp.getPushListType()));
        associatedRiskMerchantInfoResp.setFeedbackStatus(
            FeedbackStatusEnum.getFeedbackStatusDesc(
                associatedRiskMerchantInfoResp.getFeedbackStatus()));
        associatedRiskMerchantInfoResp.setLegDocType(
            LegDocTypeEnum.getLegDocTypeDesc(associatedRiskMerchantInfoResp.getLegDocType()));
        associatedRiskMerchantInfoResp.setIsBlack(
            IsBlackEnum.getIsBlackEnumDesc(associatedRiskMerchantInfoResp.getIsBlack()));
        associatedRiskMerchantInfoResp.setDocType(
            DocTypeEnum.getDocTypeDesc(associatedRiskMerchantInfoResp.getDocType()));
        associatedRiskMerchantInfoResp.setLevel(
            LevelCodeEnum.getLevelDesc(associatedRiskMerchantInfoResp.getLevel()));
        associatedRiskMerchantInfoResp.setRiskType(
            RiskTypeEnum.getRiskTypeDesc(associatedRiskMerchantInfoResp.getRiskType()));
        associatedRiskMerchantInfoResp.setHandleResult(
            HandleResultEnum.getHandleResultDesc(associatedRiskMerchantInfoResp.getHandleResult()));
        associatedRiskMerchantInfoResp.setCusType(
            CusTypeEnum.getCusTypeEnum(associatedRiskMerchantInfoResp.getCusType()));
        associatedRiskMerchantInfoResp.setStatus(
            StatusEnum.getStatusDesc(associatedRiskMerchantInfoResp.getStatus()));
        associatedRiskMerchantInfoResp.setOccurarea(
            SysLanEnum.getSysLanEnumDesc(associatedRiskMerchantInfoResp.getOccurarea()));
      }
    }
    resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
    resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
    resultBean.setData(pageLocalAssociatedRiskMerchantInfo);
    log.info(
        "pageLocalAssociatedRiskMerchantInfo resp={}",
        com.alibaba.fastjson.JSON.toJSON(pageLocalAssociatedRiskMerchantInfo));
    return resultBean;
  }

  @Override
  public ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resp.Body>
      localAssociatedRiskMerchantInfoBack(
          List<AssociatedRiskMerchantInfoBackReq> associatedRiskMerchantInfoBackReqs) {
    ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resp.Body> resultBean = new ResultBean<>();
    // 拼装报文
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    Document<Body> document = new Document<>();
    // 设置报文头
    Request<Body> request =
        XmlJsonUtils.getRequest(
            symmetricKeyEncoded,
            document,
            pcacConfig,
            TrnxCodeEnum.LOCAL_ASSOCIATED_RISK_INFO_BACK.getCode());
    // 设置报文体
    Body body = new Body();
    PcacList pcacList = new PcacList();
    pcacList.setCount(associatedRiskMerchantInfoBackReqs.size() + "");
    List<RiskInfo> riskInfos = new ArrayList<>();
    PcacRiskInfo pcacRiskInfo;
    List<LocalAssociatedRiskMerchantInfo> localAssociatedRiskMerchantInfos = new ArrayList<>();
    for (AssociatedRiskMerchantInfoBackReq associatedRiskMerchantInfoBackReq :
        associatedRiskMerchantInfoBackReqs) {
      QueryWrapper<PcacRiskInfo> wrapper = new QueryWrapper<>();
      log.info("风控反馈的商户信息：{}",associatedRiskMerchantInfoBackReq);
      wrapper.eq("doc_type", associatedRiskMerchantInfoBackReq.getDocType());
      wrapper.eq("doc_code", associatedRiskMerchantInfoBackReq.getDocCode());
      List<PcacRiskInfo> pcacRiskInfos = pcacRiskInfoMapper.selectList(wrapper);
      if (pcacRiskInfos.size() > 0) {
        pcacRiskInfo = pcacRiskInfos.get(0);
      } else {
        resultBean.setResMsg("反馈数据异常，未查到对应的反馈信息！");
        resultBean.setResCode(PARAM_ERR);
        return resultBean;
      }
      RiskInfo riskInfo = new RiskInfo();
      riskInfo.setCusType(pcacRiskInfo.getCusType());
      // riskInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded,
      // pcacRiskInfo.getRegName()));
      riskInfo.setRegName(pcacRiskInfo.getRegName());
      riskInfo.setCurrency("CNY");
      riskInfo.setAmount(associatedRiskMerchantInfoBackReq.getAmount());
      riskInfo.setDocType(this.splitStrs(associatedRiskMerchantInfoBackReq.getDocType()));
      /*riskInfo.setDocCode(
      CFCACipherUtils.encrypt(
          symmetricKeyEncoded, associatedRiskMerchantInfoBackReq.getDocCode()));*/
      riskInfo.setDocCode(associatedRiskMerchantInfoBackReq.getDocCode());
      riskInfo.setHandleResult(this.splitStrs(associatedRiskMerchantInfoBackReq.getHandleResult()));
      riskInfo.setHandleTime(DateUtils.formatTime(new Date(), DateUtils.FORMAT_DATE));
      riskInfos.add(riskInfo);
      pcacList.setRiskInfo(riskInfos);
      body.setPcacList(pcacList);
      request.setBody(body);

      // 更新数据
      QueryWrapper<LocalAssociatedRiskMerchantInfo> localWapper = new QueryWrapper<>();
      localWapper
          .eq("doc_code", associatedRiskMerchantInfoBackReq.getDocCode())
          .or()
          .eq("leg_doc_code", pcacRiskInfo.getLegDocCode());
      localAssociatedRiskMerchantInfos =
          localAssociatedRiskMerchantInfoMapper.selectList(localWapper);
    }
    document.setRequest(request);
    // 加签
    // XmlJsonUtils.doSignature(document);
    document.setSignature("");
    // 发起反馈
    String xmlStr = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("未加密的xml数据：{}",xmlStr);
    boolean validateXML = ValidateUtils.validateXMLByXSD(xmlStr, "pcac.ries.046");
    if (!validateXML) {
      log.info("XSD校验失败{}", xmlStr);
      resultBean.setResCode(PARAM_ERR);
      resultBean.setResMsg("XSD校验失败:" + XmlJsonUtils.formatXml(xmlStr));
      return resultBean;
    }

    Document encrBean = BeanUtilsEx.getEncrBean(document, symmetricKeyEncoded);
    XmlJsonUtils.doSignature(encrBean);
    String encrXmlStr = XmlJsonUtils.convertObjectToXmlStr(encrBean);
    log.info("反馈数据：{}", XmlJsonUtils.formatXml(encrXmlStr));
    // 解析响应
    String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), encrXmlStr);
    log.info("响应数据：{}", XmlJsonUtils.formatXml(post));
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc =
        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
            XmlJsonUtils.convertXmlStrToObject(
                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
    com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = resDoc.getRespone().getBody();
    String resultCode = resBody.getRespInfo().getResultCode();
    for (int i = 0; i < localAssociatedRiskMerchantInfos.size(); i++) {
      LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo =
          localAssociatedRiskMerchantInfos.get(i);
      UpdateWrapper<LocalAssociatedRiskMerchantInfo> updateWrapper = new UpdateWrapper<>();
      updateWrapper.set("feedback_status", "已反馈");
      updateWrapper.set(
          "handle_result", associatedRiskMerchantInfoBackReqs.get(i).getHandleResult());
      updateWrapper.set("operator", associatedRiskMerchantInfoBackReqs.get(i).getOperator());
      updateWrapper.set(
          "msg_detail",
          FeedbackStatusEnum.getFeedbackStatusDesc(resultCode)
              + resBody.getRespInfo().getMsgDetail());
      localAssociatedRiskMerchantInfoMapper.update(localAssociatedRiskMerchantInfo, updateWrapper);
    }
    resultBean.setData(resBody);
    resultBean.setResCode(resBody.getRespInfo().getResultCode());
    if (resBody.getRespInfo().getMsgDetail() != null) {
      resultBean.setResMsg(resBody.getRespInfo().getResultStatus());
    } else {
      resultBean.setResMsg(resBody.getRespInfo().getMsgDetail());
    }
    return resultBean;
  }

  private String splitStrs(String strings) {
    if (StringUtils.isEmpty(strings)) {
      return strings;
    }
    String[] strs = strings.split("\\|");
    return strs[0];
  }
}

package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusNatureEnum;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.MerdocTypeEnum;
import com.cmcc.paymentclean.consts.MsgTypeEnum;
import com.cmcc.paymentclean.consts.PcacResultCodeEnum;
import com.cmcc.paymentclean.consts.PerdocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.consts.SysLanLocalEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.mapper.PcacMerchantRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
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

/**
 * 协会商户风险信息上报表 服务实现类
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class PcacMerchantRiskSubmitInfoServiceImpl
    extends ServiceImpl<PcacMerchantRiskSubmitInfoMapper, PcacMerchantRiskSubmitInfo>
    implements PcacMerchantRiskSubmitInfoService {

  @Autowired private PcacMerchantRiskSubmitInfoMapper pcacMerchantRiskSubmitInfoMapper;

  @Autowired private PcacConfig pcacConfig;

  @Override
  public ResultBean<Page<RiskMerchantResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq) {
    log.info("pageRiskMerchant req={}", riskMerchantReq);
    ResultBean<Page<RiskMerchantResp>> resultBean = new ResultBean<>();
    resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
    resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

    Page<PcacMerchantRiskSubmitInfo> page =
        new Page<>(riskMerchantReq.getPageNo(), riskMerchantReq.getPageSize());
    Page<RiskMerchantResp> pagePcacMerchantRiskSubmitInfo =
        pcacMerchantRiskSubmitInfoMapper.pagePcacMerchantRiskSubmitInfo(page, riskMerchantReq);
    List<RiskMerchantResp> riskMerchantResps = pagePcacMerchantRiskSubmitInfo.getRecords();
    if (!CollectionUtils.isEmpty(riskMerchantResps)) {
      for (RiskMerchantResp riskMerchantResp : riskMerchantResps) {
        String validStatus =
            (new Date(System.currentTimeMillis()).before(riskMerchantResp.getValidDate()))
                ? CommonConst.VALIDSTATUS_01
                : CommonConst.VALIDSTATUS_02;
        riskMerchantResp.setValidStatus(validStatus);
        riskMerchantResp.setSubmitStatus(
            SubmitStatusEnum.getSubmitStatusEnumDesc(riskMerchantResp.getSubmitStatus()));
        riskMerchantResp.setCusType(CusTypeEnum.getCusTypeEnum(riskMerchantResp.getCusType()));
        riskMerchantResp.setCusNature(
            CusNatureEnum.getCusNatureEnum(riskMerchantResp.getCusNature()));
        riskMerchantResp.setSourceChannel(
            SourChaEnum.getSourChaEnum(riskMerchantResp.getSourceChannel()));
        riskMerchantResp.setLevel(LevelCodeEnum.getLevelDesc(riskMerchantResp.getLevel()));
        riskMerchantResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskMerchantResp.getRiskType()));
        riskMerchantResp.setCusProperty(
            CusPropertyEnum.getCusPropertyEnum(riskMerchantResp.getCusProperty()));
        riskMerchantResp.setMsgType(MsgTypeEnum.MsgTypeEnum_02.getDesc());
      }
    }
    resultBean.setData(pagePcacMerchantRiskSubmitInfo);
    log.info("pageRiskMerchant resp={}",pagePcacMerchantRiskSubmitInfo);
    return resultBean;
  }

  @Override
  public void queryRiskMerchantAndPushPcac() {
    // 跟新不需要上报的数据状体
    PcacMerchantRiskSubmitInfo entity = new PcacMerchantRiskSubmitInfo();
    entity.setMsgDetail("商户类型不属于全网远程，全网现场，本地远程，本地现场，不进行上报。");
    entity.setSubmitStatus(SubmitStatusEnum.ISBLACKENUM_3.getCode());
    UpdateWrapper<PcacMerchantRiskSubmitInfo> updateWrapper = new UpdateWrapper<>();
    updateWrapper.notIn("merc_typ", "1", "2", "3", "4");
    pcacMerchantRiskSubmitInfoMapper.update(entity, updateWrapper);
    entity.setMsgDetail("风险发生地域为空，无法上报");
    updateWrapper.clear();
    updateWrapper.eq("occurarea", "").or().eq("occurarea", "null").or().isNull("occurarea");
    pcacMerchantRiskSubmitInfoMapper.update(entity, updateWrapper);
    // 获取未上报的数据
    QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper =
        new QueryWrapper<PcacMerchantRiskSubmitInfo>()
            .eq("submit_status", SubmitStatusEnum.ISBLACKENUM_0.getCode())
            .in("merc_typ", "1", "2", "3", "4");
    List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos =
        pcacMerchantRiskSubmitInfoMapper.selectList(queryWrapper);
    if (pcacMerchantRiskSubmitInfos.size() == 0) {
      log.info("当前没有可上报的风险商户信息");
      return;
    }
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    for (int i = 0; i < pcacMerchantRiskSubmitInfos.size(); i++) {
      List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfoPush = new ArrayList<>();
      pcacMerchantRiskSubmitInfoPush.add(pcacMerchantRiskSubmitInfos.get(i));
      Document<Body> document = getDocument(pcacMerchantRiskSubmitInfoPush, symmetricKeyEncoded);
      // 报文转换
      String xml = XmlJsonUtils.convertObjectToXmlStr(document);
      log.info("获取到的xml数据:{}", XmlJsonUtils.formatXml(xml));
      if (StringUtils.isEmpty(xml)) {
        log.info("xml报文转换失败");
        return;
      }
      // 校验xml报文
      if (!ValidateUtils.validateXMLByXSD(xml, "pcac.ries.013")) {
        log.info("XML校验失败");
        return;
      }
      // 报文转换
      Document<Body> encrBean = BeanUtilsEx.getEncrBean(document, symmetricKeyEncoded);
      // 加签
      XmlJsonUtils.doSignature(encrBean);
      xml = XmlJsonUtils.convertObjectToXmlStr(encrBean);
      log.info("请求报文: {}", XmlJsonUtils.formatXml(xml));
      pushToPcac(pcacMerchantRiskSubmitInfoPush, xml);
    }
  }

  private void pushToPcac(
      List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos, String xml) {
    // 上报数据
    String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
    if (post == null) {
      log.error("协会接口异常！");
      return;
    }
    log.info("url:{}", pcacConfig.getUrl());
    log.info("协会返回数据字符串:{}", XmlJsonUtils.formatXml(post));
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc =
        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
            XmlJsonUtils.convertXmlStrToObject(
                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
    log.info("协会返回数据对象:{}", doc);
    if (doc.getRespone().getBody().getRespInfo().getResultCode() != null) {
      for (PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo : pcacMerchantRiskSubmitInfos) {
        pcacMerchantRiskSubmitInfo.setSubmitTime(new Date());
        pcacMerchantRiskSubmitInfo.setSubmitStatus(SubmitStatusEnum.ISBLACKENUM_1.getCode());
        pcacMerchantRiskSubmitInfo.setResultCode(
            doc.getRespone().getBody().getRespInfo().getResultCode());
        pcacMerchantRiskSubmitInfo.setResultStatus(
            doc.getRespone().getBody().getRespInfo().getResultStatus());
        pcacMerchantRiskSubmitInfo.setMsgDetail(
            PcacResultCodeEnum.S00000
                    .getCode()
                    .equals(doc.getRespone().getBody().getRespInfo().getResultCode())
                ? ""
                : doc.getRespone().getBody().getRespInfo().getMsgDetail().replaceAll("商户风险信息，第1条数据有错误：", "").replaceAll("第1条",""));
        pcacMerchantRiskSubmitInfo.setRepDate(new Date());
        pcacMerchantRiskSubmitInfoMapper.updateById(pcacMerchantRiskSubmitInfo);
      }
      log.info(
          "返回状态码及信息：{}:{}",
          doc.getRespone().getBody().getRespInfo().getResultCode(),
          doc.getRespone().getBody().getRespInfo().getMsgDetail());
    }
  }

  private Document<Body> getDocument(
      List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos, byte[] symmetricKeyEncoded) {
    // 拼装报文
    Document<Body> document = new Document<>();
    // 设置报文头
    Request<Body> request =
        XmlJsonUtils.getRequest(
            symmetricKeyEncoded,
            document,
            pcacConfig,
            TrnxCodeEnum.MERCHANT_RISK_INFO_SUBMIT.getCode());
    // 设置报文体
    Body body = new Body();
    PcacList pcacList = new PcacList();
    ArrayList<RiskInfo> riskInfos = new ArrayList<>();
    for (int i = 0; i < pcacMerchantRiskSubmitInfos.size(); i++) {
      pcacList.setCount(pcacMerchantRiskSubmitInfos.size() + "");
      RiskInfo riskInfo = new RiskInfo();
      PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = pcacMerchantRiskSubmitInfos.get(i);
      BeanUtilsEx.copyProperties(riskInfo, pcacMerchantRiskSubmitInfo);
      // 地域
      if ("1".equals(pcacMerchantRiskSubmitInfo.getMercTyp())
          || "3".equals(pcacMerchantRiskSubmitInfo.getMercTyp())) {
        riskInfo.setOccurarea(SysLanLocalEnum.SysLanLocalEnum_100000.getCode());
      } else {
        riskInfo.setOccurarea(
            SysLanLocalEnum.getSysLanLocalEnumCode(pcacMerchantRiskSubmitInfo.getOccurarea()));
      }
      // 法人证件类型
      riskInfo.setDocType(
          MerdocTypeEnum.getMerdocTypeEnumDesc(pcacMerchantRiskSubmitInfo.getDocType()));
      // 法定代表人证件类型
      riskInfo.setLegDocType(
          PerdocTypeEnum.getPerdocTypeEnumDesc(pcacMerchantRiskSubmitInfo.getLegDocType()));
      // BeanUtilsEx.copyProperties(riskInfo, pcacMerchantRiskSubmitInfo);
      BankList bankList = new BankList();
      List<BankInfo> bankInfos = new ArrayList<>();
      BankInfo bankInfo = new BankInfo();
      String decryptBankData =
          InnerCipherUtils.decryptBankData(pcacMerchantRiskSubmitInfo.getBankNo());
      log.debug("解密后的银行卡号是：{}", decryptBankData);
      // pcacMerchantRiskSubmitInfo.setBankNo(decryptBankData);
      BeanUtilsEx.copyProperties(bankInfo, pcacMerchantRiskSubmitInfo);
      bankInfo.setBankNo(decryptBankData);
      bankInfos.add(bankInfo);
      bankList.setBankInfo(bankInfos);
      riskInfo.setBankList(bankList);
      riskInfo.setOrgId(pcacConfig.getOrigSender());
      riskInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
      BenList benList = new BenList();
      List<BenInfo> benInfos = new ArrayList<>();
      BenInfo benInfo = new BenInfo();
      BeanUtilsEx.copyProperties(benInfo, pcacMerchantRiskSubmitInfo);
      benInfos.add(benInfo);
      benList.setBenInfo(benInfos);
      boolean beanIsNotNull = BeanUtilsEx.checkObjFieldIsNotNull(benInfo);
      if (beanIsNotNull) {
        benList.setCount(benInfos.size() + "");
      } else {
        benList.setCount("0");
      }
      bankList.setCount(bankInfos.size() + "");
      riskInfo.setBenList(benList);
      riskInfos.add(riskInfo);
      pcacList.setRiskInfo(riskInfos);
    }
    body.setPcacList(pcacList);
    request.setBody(body);
    document.setRequest(request);
    document.setSignature("");
    return document;
  }
}

package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac027.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.Differents;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.EntInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Document027Wapper;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Document028Wapper;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Request027Wapper;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Request028Wapper;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaolei
 * @date 2020-09-15 12:38
 */
@Controller
@RequestMapping("/localRisk")
@Slf4j
public class PcacRiskInfoPushController {

  private static ExecutorService executor = Executors.newSingleThreadExecutor();
  @Autowired private PcacRiskInfoService pcacRiskInfoService;
  @Autowired private PcacAssistanceInfoService pcacAssistanceInfoService;
  @Autowired private BusinessInfoService businessInfoService;
  @Autowired private PcacConfig pcacConfig;
  /** 统一接收协会推送数据接口 */
  @ApiOperation(value = "协会推送数据接口", notes = "协会推送数据接口")
  @RequestMapping(
      value = "/pcacPushInfo",
      method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public String pcacPushInfo(
      /*@Required*/ @RequestParam(value = "xml", required = false) String xmlStr) {
    log.info("协会推送信息报文：{}", xmlStr);
    if (StringUtils.isEmpty(xmlStr)) {
      return XmlJsonUtils.convertObjectToXmlStr(XmlJsonUtils.getRespDocument(pcacConfig, "未知",""));
    }
    Document document = (Document) XmlJsonUtils.convertXmlStrToObject(xmlStr, Document.class);
    String trnxCode = document.getRequest().getHead().getTrnxCode();
    String identification = document.getRequest().getHead().getIdentification();

    log.info("----------协会推送交易类型:{}，{}", trnxCode, TrnxCodeEnum.getTrnxCodeEnum(trnxCode));

    executor.execute(
        () -> {
          log.info("------------------开始执行线程池任务----------------");
          if (TrnxCodeEnum.BLACKLIST_PUSH.getCode().equals(trnxCode)
              || TrnxCodeEnum.RISK_TIPS_INFO_PUSH.getCode().equals(trnxCode)) {
            log.info("接收协会黑名单或者风险提示信息报文：{}", xmlStr);
            saveRiskInfo(xmlStr);
          } else if (TrnxCodeEnum.MERCHANT_INFO_ASSISTANCE_PUSH.getCode().equals(trnxCode)) {
            log.info("接收协会比对协查信息请求报文：{}", xmlStr);
            saveAssistanceInfo(xmlStr);
          } else if (TrnxCodeEnum.BUSINESS_INFO_BATCH_QUERY_RESULT_PUSH
              .getCode()
              .equals(trnxCode)) {
            log.info("接收协会企业商户批量查询结果推送请求报文：{}", xmlStr);
            businessInfoService.getBusinessInfoXML(xmlStr);
          }
        });

    com.cmcc.paymentclean.entity.dto.pcac.resp.Document respDocument =
        XmlJsonUtils.getRespDocument(pcacConfig, identification,trnxCode);
    String doXml = XmlJsonUtils.convertObjectToXmlStr(respDocument);
    log.info("----------------------响应协会推送报文-------------------------：{}", doXml);
    return doXml;
  }

  /** 黑名单和风险提示信息推送 风险提示信息关键字：商户名称、商户简称、 法人证件号码、法定代表人姓名、法定代表人证件号码 */
  private void saveRiskInfo(String xmlStr) {

    String doXml = null;
    String pushListType = null;
    Document027Wapper document =
        (Document027Wapper) XmlJsonUtils.convertXmlStrToObject(xmlStr, Document027Wapper.class);
    String signature = document.getSignature();
    document.setSignature(null);
    String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("验签使用的原数据xml：{}", noSignatureXml);
    // boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
    // log.info("-------风险信息推送验证签名结果为：{}", isSign);
    Request027Wapper request = document.getRequest();
    Head head = request.getHead();
    String trnxCode = head.getTrnxCode();
    if (TrnxCodeEnum.BLACKLIST_PUSH.getCode().equals(trnxCode)) {
      pushListType = IsBlackEnum.ISBLACKE_01.getCode();
    }
    if (TrnxCodeEnum.RISK_TIPS_INFO_PUSH.getCode().equals(trnxCode)) {
      pushListType = IsBlackEnum.ISBLACKE_02.getCode();
    }
    log.info("清算协会推送的风险类型是：{}", pushListType);
    String secretKey = head.getSecretKey();
    // 获取报文唯一表示，响应清算协会时需使用
    String identification = head.getIdentification();
    log.info("报文唯一表示：{}", identification);
    Body body = request.getBody();
    PcacList pcacList = body.getPcacList();
    String upDate = pcacList.getUpDate();
    List<RiskInfo> riskInfoList = pcacList.getRiskInfo();
    ArrayList<PcacRiskInfo> pcacRiskInfoList = new ArrayList<>();
    for (RiskInfo riskInfo : riskInfoList) {
      log.info("协会返回风险信息：{}", riskInfo);
      // 对关键字进行解密，证件号码和银行卡号加密
      // 商户简称
      String decryptCusName = CFCACipherUtils.decrypt(secretKey, riskInfo.getCusName());
      riskInfo.setCusName(decryptCusName);
      // 商户名称
      String decryptRegName = CFCACipherUtils.decrypt(secretKey, riskInfo.getRegName());
      riskInfo.setRegName(decryptRegName);
      // 法人证件号码
      String decryptDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getDocCode());
      riskInfo.setDocCode(decryptDocCode);
      // 法定代表人姓名
      String decryptLegDocName = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocName());
      riskInfo.setLegDocName(decryptLegDocName);
      // url
      String decryptUrl = CFCACipherUtils.decrypt(secretKey, riskInfo.getUrl());
      riskInfo.setUrl(decryptUrl);
      // 商户注册号
      String decryptRegisteredCode =
          CFCACipherUtils.decrypt(secretKey, riskInfo.getRegisteredCode());
      riskInfo.setRegisteredCode(decryptRegisteredCode);
      // 法定代表人证件号码
      String decryptLegDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocCode());
      String encryptLegDocCode = null;
      // 判断证件类型是身份证就进行内部加密
      if (!StringUtils.isEmpty(riskInfo.getLegDocCode())
          && LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(riskInfo.getLegDocType())) {
        encryptLegDocCode = InnerCipherUtils.encryptUserData(decryptLegDocCode);
      }

      riskInfo.setLegDocCode(encryptLegDocCode);
      String encryptBankNo = InnerCipherUtils.encryptBankData(riskInfo.getBankNo());
      riskInfo.setBankNo(encryptBankNo);
      PcacRiskInfo pcacRiskInfo = new PcacRiskInfo();
      BeanUtilsEx.copyProperties(pcacRiskInfo, riskInfo);
      log.info("BeanUtilsEx.copyProperties方法封装进对象后风险信息：{}", pcacRiskInfo);
      pcacRiskInfo.setUpDate(upDate);
      // 设置类型01为黑名单,02为风险提示信息
      pcacRiskInfo.setPushListType(pushListType);
      pcacRiskInfoList.add(pcacRiskInfo);
    }
    log.debug("需要入库风险信息：{}", pcacRiskInfoList);
    // doXml = pcacRiskInfoService.insertBatchPcacRiskInfo(pcacRiskInfoList,identification);
    pcacRiskInfoService.insertBatchPcacRiskInfo(pcacRiskInfoList);
    // return doXml;
  }

  @RequestMapping(value = "/localRiskMsg", method = RequestMethod.POST)
  @ResponseBody
  public ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body> reissueRiskInfo(
      @RequestBody @Validated ReissueRiskInfoReq reissueRiskInfoReq) {
    log.info("补发请求入参是：{}", reissueRiskInfoReq);

    ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body> resultBean =
        pcacRiskInfoService.reissueRiskInfo(reissueRiskInfoReq);
    log.info("请求补发返回结果信息：{}", resultBean);
    return resultBean;
  }

  /** 商户信息比对协查推送 需要解密关键字：商户信息比对协查：商户代码、商户名称、法定代表人姓名 */
  private void saveAssistanceInfo(String xmlStr) {
    Document028Wapper document =
        (Document028Wapper) XmlJsonUtils.convertXmlStrToObject(xmlStr, Document028Wapper.class);
    String signature = document.getSignature();
    document.setSignature(null);
    String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("验签使用的原数据xml：{}", noSignatureXml);
    boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
    log.info("-------商户信息比对协查推送验证签名结果为：{}", isSign);
    Request028Wapper request = document.getRequest();
    Head head = request.getHead();
    String secretKey = head.getSecretKey();
    // 获取报文唯一表示，响应清算协会时需使用
    String identification = head.getIdentification();
    log.info("报文唯一表示：{}", identification);
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.Body body = request.getBody();
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.PcacList pcacList = body.getPcacList();
    String upDate = pcacList.getUpDate();
    List<EntInfo> entInfoList = pcacList.getEntInfo();
    ArrayList<PcacAssistanceInfo> pcacAssistanceInfoList = new ArrayList<>();
    for (EntInfo entInfo : entInfoList) {
      log.info("协会返回比对协查信息：{}", entInfo);
      List<Differents> differents = entInfo.getDifferents();
      if (differents.size() > 0) {

        for (Differents different : differents) {
          PcacAssistanceInfo pcacAssistanceInfo = new PcacAssistanceInfo();
          // 对关键字进行解密
          pcacAssistanceInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, entInfo.getCusCode()));
          pcacAssistanceInfo.setRegName(CFCACipherUtils.decrypt(secretKey, entInfo.getRegName()));
          pcacAssistanceInfo.setLegDocName(
              CFCACipherUtils.decrypt(secretKey, entInfo.getLegDocName()));
          pcacAssistanceInfo.setDifCusCode(
              CFCACipherUtils.decrypt(secretKey, different.getCusCode()));
          pcacAssistanceInfo.setDifRegName(
              CFCACipherUtils.decrypt(secretKey, different.getRegName()));
          pcacAssistanceInfo.setDifLegDocName(
              CFCACipherUtils.decrypt(secretKey, different.getLegDocName()));
          pcacAssistanceInfo.setUpDate(upDate);
          pcacAssistanceInfoList.add(pcacAssistanceInfo);
        }
      }
    }

    // return pcacAssistanceInfoService.saveAssistanceInfo(pcacAssistanceInfoList,identification);
    pcacAssistanceInfoService.saveAssistanceInfo(pcacAssistanceInfoList);
  }
}

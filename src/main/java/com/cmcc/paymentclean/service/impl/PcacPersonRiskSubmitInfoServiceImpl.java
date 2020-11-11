package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.*;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.exception.SubmitPCACException;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 协会个人风险信息上报表 服务实现类
 *
 * @author zhaolei
 * @since 2020-09-13
 */
@Slf4j
@Service
public class PcacPersonRiskSubmitInfoServiceImpl
        extends ServiceImpl<PcacPersonRiskSubmitInfoMapper, PcacPersonRiskSubmitInfo>
        implements PcacPersonRiskSubmitInfoService {

  @Autowired private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;

  @Autowired private PcacConfig pcacConfig;

  @Override
  public ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq) {
    log.info("pageRiskPerson req={}", com.alibaba.fastjson.JSON.toJSON(riskPersonReq));
    ResultBean<Page<RiskPersonResp>> resultBean = new ResultBean<>();
    Page<PcacPersonRiskSubmitInfo> page =
            new Page<>(riskPersonReq.getPageNo(), riskPersonReq.getPageSize());
    Page<RiskPersonResp> pcacPersonRiskSubmitInfoPage =
            pcacPersonRiskSubmitInfoMapper.pagePcacPersonRiskSubmitInfo(page, riskPersonReq);
    List<RiskPersonResp> riskPersonResps = pcacPersonRiskSubmitInfoPage.getRecords();
    if (!CollectionUtils.isEmpty(riskPersonResps)) {
      for (RiskPersonResp riskPersonResp : riskPersonResps) {
        String validStatus =
                (new Date().before(riskPersonResp.getValidDate()))
                        ? CommonConst.VALIDSTATUS_01
                        : CommonConst.VALIDSTATUS_02;
        riskPersonResp.setValidStatus(validStatus);
        riskPersonResp.setSubmitStatus(
                SubmitStatusEnum.getSubmitStatusEnumDesc(riskPersonResp.getSubmitStatus()));
        riskPersonResp.setCusProperty(
                CusPropertyEnum.getCusPropertyEnum(riskPersonResp.getCusProperty()));
        riskPersonResp.setSourceChannel(
                SourChaEnum.getSourChaEnum(riskPersonResp.getSourceChannel()));
        riskPersonResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskPersonResp.getRiskType()));
      }
    }
    resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
    resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
    resultBean.setData(pcacPersonRiskSubmitInfoPage);
    log.info(
            "pageRiskPerson resp={}", com.alibaba.fastjson.JSON.toJSON(pcacPersonRiskSubmitInfoPage));
    return resultBean;
  }

  /** 个人风险信息上报清算协会 个人风险信息需要加密字段：个人风险信息关键字：手机号、银行帐/卡号、客户姓名、身份证件号码、 固定电话、收款银 行帐/卡号 */
  @Override
  public void submit() {
    List<PcacPersonRiskSubmitInfo> pcacPersonRiskList =
            pcacPersonRiskSubmitInfoMapper.selectPcacPersonRiskSubmitInfoList();
    Date date = new Date();
    log.info("查询个人风险信息结果：{}", pcacPersonRiskList);
    if (pcacPersonRiskList.size() == 0) {
      log.info("当前没有可上报的个人风险信息");
      return;
    }
    // 获取随机加密密码
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    // String secretKey = CFCACipherUtils.getSecretKey(symmetricKeyEncoded);

    log.debug("-------开始封装xml报文实体对象------");


    for (PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo : pcacPersonRiskList) {
      ArrayList<RiskInfo> riskInfos = new ArrayList<>();
      pcacPersonRiskSubmitInfo.setDocType(
              PerdocTypeEnum.getPerdocTypeEnumDesc(pcacPersonRiskSubmitInfo.getDocType()));
      RiskInfo riskInfo = new RiskInfo();
      BeanUtilsEx.copyProperties(riskInfo, pcacPersonRiskSubmitInfo);
      // 上报日期库里有就不加了，没有的再自己生成
      String repDateStr = DateUtils.formatTime(date, "yyyy-MM-dd HH:mm:ss");
      riskInfo.setRepDate(repDateStr);
      riskInfo.setOrgId(pcacConfig.getOrigSender());
      log.info("riskInfo复制的对象属性包括：{}", riskInfo);

      BankList bankList = new BankList();
      BankInfo bankInfo = new BankInfo();
      BeanUtilsEx.copyProperties(bankInfo, pcacPersonRiskSubmitInfo);
      ArrayList<BankInfo> bankInfos = new ArrayList<>();
      bankInfos.add(bankInfo);
      bankList.setBankInfo(bankInfos);
      bankList.setCount("1");
      riskInfo.setBankList(bankList);
      riskInfos.add(riskInfo);

      PcacList pcacLists = new PcacList();
      pcacLists.setCount(riskInfos.size() + "");
      pcacLists.setRiskInfo(riskInfos);
      Body body = new Body();
      body.setPcacList(pcacLists);
      Document document = new Document();
      Request request =
              XmlJsonUtils.getRequest(
                      symmetricKeyEncoded,
                      document,
                      pcacConfig,
                      TrnxCodeEnum.PERSON_RISK_INFO_SUBMIT.getCode());
      request.setBody(body);
      document.setRequest(request);
      // 注意生成签名的时候设置空串显示<Signature>,不设置空串默认null，就不显示<Signature>
      // document.setSignature("");
      document.setSignature("");
      String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
      log.info("个人风险信息上报支付清算协会请求xml报文：{}", doXml);
      try {
        boolean validate = ValidateUtils.validateXMLByXSD(doXml, "pcac.ries.001");
        if (validate) {

          Document encrDocument = BeanUtilsEx.getEncrBean(document, symmetricKeyEncoded);
          encrDocument.setSignature(null);
          String noSignXml = XmlJsonUtils.convertObjectToXmlStr(encrDocument);
          String signature = CFCACipherUtils.doSignature(noSignXml);
          encrDocument.setSignature(signature);
          doXml = XmlJsonUtils.convertObjectToXmlStr(document);

          log.info("----------------------------------------------打印个人风险信息上报参数：--------");
          String s = XmlJsonUtils.formatXml(doXml);
          log.info(s);
          log.info("----------------------------------------------打印个人风险信息上报参数：--------");
          // String result =
          // HttpClientUtils.sendHttpsPost("http://210.12.239.161:10001/ries_interface/httpServlet",
          // doXml);
          String result = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), doXml);
          log.info("----------------------------------------------打印个人风险信息响应参数：--------");
          String ss = XmlJsonUtils.formatXml(result);
          log.info(ss);
          log.info("----------------------------------------------打印个人风险信息响应参数：--------");
          log.info("个人风险信息上报支付清算协会响应xml报文：", result);
          com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp =
                  (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
                          com.cmcc.paymentclean.utils.XmlJsonUtils.convertXmlStrToObject(
                                  result, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
          String signatureResp = documentResp.getSignature();
          log.info("响应报文的签名串signature：{}", signatureResp);
          documentResp.setSignature(null);
          String noSignXmlResp = XmlJsonUtils.convertObjectToXmlStr(documentResp);
          log.info("不加签名信息的响应报文xml串：{}", noSignXmlResp);
          boolean isSign = CFCACipherUtils.verifySignature(noSignXmlResp, signatureResp);
          //  if (isSign) {
          Respone respone = documentResp.getRespone();
          RespInfo respInfo = respone.getBody().getRespInfo();
          if (PcacResultCodeEnum.S00000.getCode().equals(respInfo.getResultCode())
                  && "01".equals(respInfo.getResultStatus())) {
            // 上报成功，修改数据库状态
            PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo1 = new PcacPersonRiskSubmitInfo();
            BeanUtils.copyProperties(respInfo, pcacPersonRiskSubmitInfo1);
            pcacPersonRiskSubmitInfo1.setSubmitTime(date);
            pcacPersonRiskSubmitInfo1.setSubmitStatus("1");
            pcacPersonRiskSubmitInfo1.setMsgDetail("");
            pcacPersonRiskSubmitInfo1.setRepDate(date);
            pcacPersonRiskSubmitInfo1.setPcacPersonRiskSubmitInfoId(pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
            log.info("更新数据库表时间和状态信息：{}", pcacPersonRiskSubmitInfo1);
            pcacPersonRiskSubmitInfoMapper.updateByPcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo1);
          } else {
            // 上报失败，修改数据库状态
            PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo1 = new PcacPersonRiskSubmitInfo();
            BeanUtils.copyProperties(respInfo, pcacPersonRiskSubmitInfo1);
            pcacPersonRiskSubmitInfo1.setSubmitTime(date);
            pcacPersonRiskSubmitInfo1.setSubmitStatus("1");
            if(!StringUtils.isEmpty(respInfo.getMsgDetail())){
              pcacPersonRiskSubmitInfo1.setMsgDetail(respInfo.getMsgDetail().replaceAll("个人风险信息,第1条数据:",""));
            }else {
              pcacPersonRiskSubmitInfo1.setMsgDetail(PcacResultCodeEnum.getPcacResultCodeEnum(respInfo.getResultCode()));
            }
            pcacPersonRiskSubmitInfo1.setRepDate(date);
            pcacPersonRiskSubmitInfo1.setPcacPersonRiskSubmitInfoId(pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
            log.info("更新数据库表时间和状态信息：{}", pcacPersonRiskSubmitInfo1);
            pcacPersonRiskSubmitInfoMapper.updateByPcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo1);
          }

        } else {
          log.info("----------xsd文件校验xml格式失败-------");
          throw new SubmitPCACException(
                  ResultCodeEnum.XSD_FILE_VALID_FALSE.getCode(),
                  ResultCodeEnum.XSD_FILE_VALID_FALSE.getDesc());
        }

      } catch (Exception e) {
        log.error("异常:" + e);
      }
    }
  }
}

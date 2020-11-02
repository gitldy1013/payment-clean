package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.MsgDetailEnum;
import com.cmcc.paymentclean.consts.MsgTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.consts.SysLanEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac059.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;
import com.cmcc.paymentclean.mapper.PcacEnterpriseRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
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

/**
 * 协会企业风险信息上报表 服务实现类
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class PcacEnterpriseRiskSubmitInfoServiceImpl
    extends ServiceImpl<PcacEnterpriseRiskSubmitInfoMapper, PcacEnterpriseRiskSubmitInfo>
    implements PcacEnterpriseRiskSubmitInfoService {

  @Autowired private PcacEnterpriseRiskSubmitInfoMapper pcacEnterpriseRiskSubmitInfoMapper;

  @Autowired private PcacConfig pcacConfig;

  @Override
  public ResultBean<Page<RiskEnterpriseResp>> pageRiskEnterprise(
      RiskEnterpriseReq riskEnterpriseReq) {
    log.info("pageRiskEnterprise req={}", com.alibaba.fastjson.JSON.toJSON(riskEnterpriseReq));
    ResultBean<Page<RiskEnterpriseResp>> resultBean = new ResultBean();
    resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
    resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

    Page<RiskEnterpriseResp> page =
        new Page<>(riskEnterpriseReq.getPageNo(), riskEnterpriseReq.getPageSize());
    Page<RiskEnterpriseResp> pagePcacEnterpriseRiskSubmitInfo =
        pcacEnterpriseRiskSubmitInfoMapper.pagePcacEnterpriseRiskSubmitInfo(
            page, riskEnterpriseReq);
    List<RiskEnterpriseResp> riskEnterpriseResps = pagePcacEnterpriseRiskSubmitInfo.getRecords();
    if (!CollectionUtils.isEmpty(riskEnterpriseResps)) {
      for (RiskEnterpriseResp riskEnterpriseResp : riskEnterpriseResps) {
        String validStatus =
            (new Date().before(riskEnterpriseResp.getValidDate()))
                ? CommonConst.VALIDSTATUS_01
                : CommonConst.VALIDSTATUS_02;
        riskEnterpriseResp.setValidStatus(validStatus);
        riskEnterpriseResp.setLegDocType(
            LegDocTypeEnum.getLegDocTypeDesc(riskEnterpriseResp.getLegDocType()));
        riskEnterpriseResp.setSubmitStatus(
            SubmitStatusEnum.getSubmitStatusEnumDesc(riskEnterpriseResp.getSubmitStatus()));
        riskEnterpriseResp.setDocType(DocTypeEnum.getDocTypeDesc(riskEnterpriseResp.getDocType()));
        riskEnterpriseResp.setSubmitStatus(
            SubmitStatusEnum.getSubmitStatusEnumDesc(riskEnterpriseResp.getSubmitStatus()));
        riskEnterpriseResp.setSourceChannel(
            SourChaEnum.getSourChaEnum(riskEnterpriseResp.getSourceChannel()));
        riskEnterpriseResp.setRiskType(
            RiskTypeEnum.getRiskTypeDesc(riskEnterpriseResp.getRiskType()));
        riskEnterpriseResp.setMsgType(MsgTypeEnum.MsgTypeEnum_04.getDesc());
        riskEnterpriseResp.setOccurarea(
            SysLanEnum.getSysLanEnumDesc(riskEnterpriseResp.getOccurarea()));
      }
    }
    resultBean.setData(pagePcacEnterpriseRiskSubmitInfo);
    log.info(
        "pageRiskEnterprise resp={}",
        com.alibaba.fastjson.JSON.toJSON(pagePcacEnterpriseRiskSubmitInfo));
    return resultBean;
  }

  @Override
  public void queryRiskEnterpriseAndPushPcac() {
    // 获取未上报的数据
    QueryWrapper<PcacEnterpriseRiskSubmitInfo> queryWrapper =
        new QueryWrapper<PcacEnterpriseRiskSubmitInfo>()
            .eq("msg_detail", MsgDetailEnum.MSGDETAILENUM_00.getDesc());
    List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos =
        pcacEnterpriseRiskSubmitInfoMapper.selectList(queryWrapper);
    if (PcacEnterpriseRiskSubmitInfos.size() == 0) {
      log.info("当前没有可上报的风险商户信息");
      return;
    }
    Document document = getDocument(PcacEnterpriseRiskSubmitInfos);
    // 报文转换
    String xml = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("获取到的xml数据:{}", xml);
    if (StringUtils.isEmpty(xml)) {
      log.info("xml报文转换失败");
      return;
    }
    // 校验xml报文
    boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.059");
    // boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
    if (!validate) {
      log.info("XML校验失败");
      return;
    }
    pushToPcac(PcacEnterpriseRiskSubmitInfos, xml);
  }

  private void pushToPcac(
      List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos, String xml) {
    // 上报数据
    String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
    log.info("url:{}", pcacConfig.getUrl());
    /*String post = "<Body>\n" +
    "    <RespInfo>\n" +
    "        <ResultStatus>已上报</ResultStatus>\n" +
    "        <ResultCode>01</ResultCode>\n" +
    "    </RespInfo>\n" +
    "</Body>";*/
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc =
        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
            XmlJsonUtils.convertXmlStrToObject(
                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
    log.info("协会返回数据对象:{}", doc);
    for (PcacEnterpriseRiskSubmitInfo PcacEnterpriseRiskSubmitInfo :
        PcacEnterpriseRiskSubmitInfos) {
      UpdateWrapper<PcacEnterpriseRiskSubmitInfo> updateWrapper =
          new UpdateWrapper<PcacEnterpriseRiskSubmitInfo>()
              .set("msg_detail", doc.getRespone().getBody().getRespInfo().getMsgDetail());
      pcacEnterpriseRiskSubmitInfoMapper.update(PcacEnterpriseRiskSubmitInfo, updateWrapper);
    }
  }

  private Document getDocument(List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos) {
    // 拼装报文
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    Document document = new Document();
    // 设置报文头
    Request request =
        XmlJsonUtils.getRequest(
            symmetricKeyEncoded,
            document,
            pcacConfig,
            TrnxCodeEnum.ENTERPRISE_RISK_INFO_SUBMIT.getCode());
    // 设置报文体
    Body body = new Body();
    PcacList pcacList = new PcacList();
    ArrayList<RiskInfo> riskInfos = new ArrayList<>();
    pcacList.setCount(PcacEnterpriseRiskSubmitInfos.size() + "");
    for (int i = 0; i < PcacEnterpriseRiskSubmitInfos.size(); i++) {
      RiskInfo riskInfo = new RiskInfo();
      PcacEnterpriseRiskSubmitInfo PcacEnterpriseRiskSubmitInfo =
          PcacEnterpriseRiskSubmitInfos.get(i);
      BeanUtilsEx.copyProperties(riskInfo, PcacEnterpriseRiskSubmitInfo);
      BankList bankList = new BankList();
      List<BankInfo> bankInfos = new ArrayList<>();
      BankInfo bankInfo = new BankInfo();
      BeanUtilsEx.copyProperties(bankInfo, PcacEnterpriseRiskSubmitInfo);
      // 银行结算账号
      bankInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, bankInfo.getBankNo()));
      bankInfos.add(bankInfo);
      bankList.setBankInfo(bankInfos);
      riskInfo.setBankList(bankList);
      riskInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
      BenList benList = new BenList();
      List<BenInfo> benInfos = new ArrayList<>();
      BenInfo benInfo = new BenInfo();
      BeanUtilsEx.copyProperties(benInfo, PcacEnterpriseRiskSubmitInfo);
      bankInfos.add(bankInfo);
      benList.setBenInfo(benInfos);
      // 解密风控加密协会 商户上报：
      // 商户名称
      riskInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getRegName()));
      // 商户简称
      riskInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getCusName()));
      // 商户代码
      riskInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getCusCode()));
      // 法定代表人姓名/负责人姓名
      riskInfo.setLegRepName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getRegName()));
      // 法定代表人（负责人）证件号码
      riskInfo.setLegDocCode(
          CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegDocCode()));
      // 法定代表人（负责人）手机号
      riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getMobileNo()));
      // 网址
      riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getUrl()));
      // 服务器 ip
      riskInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getServerIp()));
      // 法人证件号码
      riskInfo.setDocCode(
          CFCACipherUtils.getInnerToCFCA(
              PcacEnterpriseRiskSubmitInfo.getDocType(),
              PcacEnterpriseRiskSubmitInfo.getDocCode(),
              symmetricKeyEncoded));
      riskInfo.setBenList(benList);
      riskInfos.add(riskInfo);
      pcacList.setRiskInfo(riskInfos);
    }
    body.setPcacList(pcacList);
    request.setBody(body);
    String xml = XmlJsonUtils.convertObjectToXmlStr(document);
    // 加签
    String doSignature = CFCACipherUtils.doSignature(xml);
    document.setSignature(doSignature);
    document.setRequest(request);
    return document;
  }
}

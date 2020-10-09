package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.AccountTypeEnum;
import com.cmcc.paymentclean.consts.ChageTypeEnum;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.ExpandTypeEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.OpenTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.StatusEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.consts.UnitPropEnum;
import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.BaseInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Condition;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ConditionList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ResultCondition;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ResultInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.SingInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Request033Wapper;
import com.cmcc.paymentclean.entity.dto.response.BusinessInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;
import com.cmcc.paymentclean.mapper.BusinessInfoMapper;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cmcc.paymentclean.entity.dto.ResultBean.PARAM_ERR;

/**
 * 企业商户信息表 服务实现类
 *
 * @author cmcc
 * @since 2020-09-15
 */
@Slf4j
@Service
public class BusinessInfoServiceImpl extends ServiceImpl<BusinessInfoMapper, BusinessInfo>
    implements BusinessInfoService {

  @Autowired private SftpConfig sftpConfig;

  @Autowired private PcacConfig pcacConfig;

  @Autowired private BusinessInfoMapper businessInfoMapper;

  @Autowired private SysLanService sysLanService;

  @Override
  public ResultBean<Body> exportExcel() {
    ResultBean<Body> resultBean = new ResultBean<>();
    resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
    resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
    // 查出未推送数据
    List<BusinessInfoResp> businessInfoResps = businessInfoMapper.qryByPushStatus("0");
    if (CollectionUtils.isEmpty(businessInfoResps)) {
      return resultBean;
    }
    List<String> stringList = new ArrayList<>();
    for (BusinessInfoResp businessInfoResp : businessInfoResps) {
      stringList.add(businessInfoResp.getBusinessInfoId());
      businessInfoResp.setDocType(DocTypeEnum.getDocTypeDesc(businessInfoResp.getDocType()));
      businessInfoResp.setChageType(
          ChageTypeEnum.getChageTypeDesc(businessInfoResp.getChageType()));
      businessInfoResp.setOutServiceCardType(
          DocTypeEnum.getDocTypeDesc(businessInfoResp.getOutServiceCardType()));
      businessInfoResp.setOutServiceLegCardType(
          LegDocTypeEnum.getLegDocTypeDesc(businessInfoResp.getOutServiceLegCardType()));
      businessInfoResp.setUnitProp(UnitPropEnum.getUnitPropEnum(businessInfoResp.getUnitProp()));
      businessInfoResp.setOpenType(OpenTypeEnum.getOpenTypeDesc(businessInfoResp.getOpenType()));
      businessInfoResp.setAccountType(
          AccountTypeEnum.getAccountTypeDesc(businessInfoResp.getAccountType()));
      businessInfoResp.setExpandType(
          ExpandTypeEnum.getExpandTypeDesc(businessInfoResp.getExpandType()));
      businessInfoResp.setStatus(StatusEnum.getStatusDesc(businessInfoResp.getStatus()));
      businessInfoResp.setRiskStatus(
          RiskTypeEnum.getRiskTypeDesc(businessInfoResp.getRiskStatus()));
      businessInfoResp.setLegDocType(
          LegDocTypeEnum.getLegDocTypeDesc(businessInfoResp.getLegDocType()));
      businessInfoResp.setSubmitStatus(
          SubmitStatusEnum.getSubmitStatusEnumDesc(businessInfoResp.getSubmitStatus()));
      SysLan sysLan = sysLanService.getLanInfoById(businessInfoResp.getOccurarea());
      if (null != sysLan) {
        businessInfoResp.setOccurarea(sysLan.getLanName());
      }
    }

    // 生成excel文件
    ExcelUtils excelUtils = new ExcelUtils();
    String fileName =
        sftpConfig.getBusinessInfoFileNamePrefix()
            + DateUtils.curDateString()
            + CommonConst.SFTP_FILE_NAME_SUFFIX;
    try {
      // 文件名
      SXSSFWorkbook sxssfWorkbook =
          excelUtils.exportExcel(businessInfoResps, BusinessInfoResp.class);
      FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
      sxssfWorkbook.write(fos);
      // dispose of temporary files backing this workbook on disk -> 处理SXSSFWorkbook导出excel时，产生的临时文件
      sxssfWorkbook.dispose();
      fos.close();
    } catch (Exception e1) {
      e1.printStackTrace();
    }

    // 上传文件
    SFTPUtils.operateSFTP(
        sftpConfig.getUsername(),
        sftpConfig.getHost(),
        sftpConfig.getPort(),
        sftpConfig.getPassword(),
        sftpConfig.getRemotePathUpload(),
        fileName,
        sftpConfig.getModDir(),
        fileName,
        SFTPUtils.OPERATE_UPLOAD);
    // 更新状态为推送
    businessInfoMapper.updatePushStatus(stringList);
    return resultBean;
  }

  @Override
  public void queryBusinessInfoAndPushPcac() {
    // 获取未上报的数据
    QueryWrapper<BusinessInfo> queryWrapper =
        new QueryWrapper<BusinessInfo>()
            .like("submit_status", SubmitStatusEnum.ISBLACKENUM_0.getCode());
    List<BusinessInfo> businessInfos = businessInfoMapper.selectList(queryWrapper);
    if (businessInfos.size() == 0) {
      log.info("当前没有可上报的企业商户信息");
      return;
    }
    Document document = getDocument(businessInfos);
    // 报文转换
    String xml = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("获取到的xml数据:{}", xml);
    if (StringUtils.isEmpty(xml)) {
      log.info("xml报文转换失败");
      return;
    }
    // 校验xml报文  企业商户信息上报请求
    boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.025");
    if (!validate) {
      log.info("XML校验失败");
      return;
    }
    pushToPcac(businessInfos, xml);
  }

  @Override
  public ResultBean batchQuery(List<BusinessInfoReq> businessInfoReqs) {
    ResultBean resultBean = new ResultBean();
    if (CollectionUtils.isEmpty(businessInfoReqs)) {
      resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
      resultBean.setResMsg("入参为空");
      return resultBean;
    }
    for (BusinessInfoReq businessInfoReq : businessInfoReqs) {
      if ((StringUtils.isNotEmpty(businessInfoReq.getDocCode())
          || StringUtils.isNotEmpty(businessInfoReq.getRegName()))) {
        continue;
      } else if (StringUtils.isNotEmpty(businessInfoReq.getLegDocCode())
          && StringUtils.isNotEmpty(businessInfoReq.getLegDocName())) {
        continue;
      } else {
        resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
        resultBean.setResMsg("查询条件组合中选择一种进行查询：企业商户法人名称;法人证件号码;法定代表人（负责人）证件号码+法定代表人姓名");
        return resultBean;
      }
    }
    Document document = this.getDocumentByQuery(businessInfoReqs);
    // 报文转换
    String xml = XmlJsonUtils.convertObjectToXmlStr(document);
    log.info("获取到的xml数据:{}", xml);
    if (StringUtils.isEmpty(xml)) {
      log.info("XSD校验失败{}", xml);
      resultBean.setResCode(PARAM_ERR);
      resultBean.setResMsg("XSD校验失败:" + XmlJsonUtils.formatXml(xml));
      return resultBean;
    }
    // 校验xml报文  企业商户信息上报请求
    boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.044");
    if (!validate) {
      log.info("XSD校验失败{}", xml);
      resultBean.setResCode(PARAM_ERR);
      resultBean.setResMsg("XSD校验失败:" + XmlJsonUtils.formatXml(xml));
      return resultBean;
    }
    log.info("反馈数据：{}", XmlJsonUtils.formatXml(xml));
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc = this.pushToPcacByQuery(xml);
    Respone respone = resDoc.getRespone();
    Body resBody = respone.getBody();
    resultBean.setData(resBody);
    resultBean.setResCode(resBody.getRespInfo().getResultCode());
    if (org.springframework.util.StringUtils.isEmpty(resBody.getRespInfo().getMsgDetail())) {
      resultBean.setResMsg(resBody.getRespInfo().getResultStatus());
    } else {
      resultBean.setResMsg(resBody.getRespInfo().getMsgDetail());
    }
    return resultBean;
  }

  private void pushToPcac(List<BusinessInfo> businessInfos, String xml) {
    // 上报数据
    String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
    log.info("url:{}", pcacConfig.getUrl());
    /*String post = "<Body>\n" +
    "    <RespInfo>\n" +
    "        <ResultStatus>已上报</ResultStatus>\n" +
    "        <ResultCode>01</ResultCode>\n" +
    "    </RespInfo>\n" +
    "</Body>";*/
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc =
        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
            XmlJsonUtils.convertXmlStrToObject(
                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
    Body resBody = resDoc.getRespone().getBody();
    log.info("协会返回数据对象:{}", resBody);
    for (BusinessInfo pcacMerchantRiskSubmitInfo : businessInfos) {
      BusinessInfo businessInfo = new BusinessInfo();
      businessInfo.setSubmitStatus("1");
      businessInfo.setRepDate(new Date());
      businessInfo.setResultStatus(resBody.getRespInfo().getResultStatus());
      businessInfo.setResultCode(resBody.getRespInfo().getResultCode());
      UpdateWrapper<BusinessInfo> updateWrapper = new UpdateWrapper<BusinessInfo>();
      updateWrapper.eq("business_info_id", pcacMerchantRiskSubmitInfo.getBusinessInfoId());
      businessInfoMapper.update(businessInfo, updateWrapper);
    }
  }

  private Document getDocument(List<BusinessInfo> businessInfos) {
    // 拼装报文
    Document document = new Document();
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    // 设置报文头
    Request request =
        XmlJsonUtils.getRequest(
            symmetricKeyEncoded, document, pcacConfig, TrnxCodeEnum.BUSINESS_INFO_SUBMIT.getCode());
    // 设置报文体
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.Body body =
        new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.Body();
    ArrayList<BaseInfo> baseInfos = new ArrayList<BaseInfo>();
    PcacList pcacList = new PcacList();
    pcacList.setCount(businessInfos.size() + "");
    for (BusinessInfo info : businessInfos) {
      BaseInfo baseInfo = new BaseInfo();
      BeanUtils.copyProperties(info, baseInfo);
      baseInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));

      // 解密风控加密协会 商户上报：
      //            企业商户信息关键字：商户名称、商户简称、商户英文名称、法人证件号码、法定代表人姓名、
      //            法定代表人证件号码、商户代码、收款账\卡号、商户注册地址、商户经营地址、网址、服务器 IP、
      //            ICP 备案编号、商户联系人、商户联系电话、股东信息、外包服务机构名称、外包服务机构法人证
      //            件号码、外包服务机构法定代表人证件号码。
      // 商户名称
      baseInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegName()));
      // 商户简称
      baseInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusName()));
      // 商户英文名称
      baseInfo.setCusNameEn(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusNameEn()));
      // 商户代码
      baseInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusCode()));
      // 法定代表人姓名/负责人姓名
      baseInfo.setLegDocName(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocName()));
      // 法定代表人证件号码
      baseInfo.setLegDocCode(
              CFCACipherUtils.getInnerToCFCA(
                      info.getLegDocType(), info.getLegDocCode(), symmetricKeyEncoded));
      // 商户代码
      baseInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusCode()));
      // 收款账\卡号
      baseInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getBankNo()));
      // 商户注册地址
      baseInfo.setRegAddrDetail(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegAddrDetail()));
      // 商户注册地址
      baseInfo.setAddrDetail(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getAddrDetail()));
      // 网址
      baseInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getUrl()));
      // 服务器 ip
      baseInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getServerIp()));
      // 商户联系人
      baseInfo.setContName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContName()));
      // 商户联系电话
      baseInfo.setContPhone(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContPhone()));
      // 股东信息
      baseInfo.setShareHolder(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getShareHolder()));
      // 外包服务机构名称
      baseInfo.setOutServiceName(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceName()));
      // 外包服务机构法人证件号码
      baseInfo.setOutServiceCardCode(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceCardCode()));
      // 外包服务机构法定代表人证件号码"
      baseInfo.setOutServiceLegCardCode(
              CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceLegCardCode()));

      baseInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getIcp()));
      baseInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getDocCode()));
      baseInfos.add(baseInfo);
      pcacList.setBaseInfo(baseInfos);
    }
    body.setPcacList(pcacList);
    request.setBody(body);
    document.setRequest(request);
    // 加签
    XmlJsonUtils.doSignature(document);
    return document;
  }

  private Document getDocumentByQuery(List<BusinessInfoReq> businessInfoReqs) {
    // 拼装报文
    Document document = new Document();
    byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
    // 设置报文头
    Request request =
        XmlJsonUtils.getRequest(
            symmetricKeyEncoded, document, pcacConfig, TrnxCodeEnum.BUSINESS_INFO_REQ.getCode());
    // 设置报文体
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body body =
        new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body();
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList pcacList =
        new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList();
    ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo> baseInfos =
        new ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo>();
    pcacList.setCount(businessInfoReqs.size() + "");
    for (int i = 0; i < businessInfoReqs.size(); i++) {
      com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo baseInfo =
          new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo();
      BusinessInfoReq businessInfo = businessInfoReqs.get(i);
      BeanUtils.copyProperties(businessInfo, baseInfo);
      if (StringUtils.isNotEmpty(businessInfo.getDocCode())) {
        // 法人证件号码
        baseInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getDocCode()));
      } else {
        baseInfo.setDocCode("");
      }
      if (StringUtils.isNotEmpty(businessInfo.getRegName())) {
        // 商户名称
        baseInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegName()));
      } else {
        baseInfo.setRegName("");
      }
      if (StringUtils.isNotEmpty(businessInfo.getLegDocName())) {
        // 法定代表人姓名/负责人姓名
        baseInfo.setLegDocName(
            CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocName()));
      } else {
        baseInfo.setLegDocName("");
      }
      if (StringUtils.isNotEmpty(businessInfo.getLegDocCode())) {
        // 法定代表人（负责人）证件号码
        baseInfo.setLegDocCode(
            CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocCode()));
      } else {
        baseInfo.setLegDocCode("");
      }
      baseInfos.add(baseInfo);
    }
    pcacList.setBaseInfo(baseInfos);
    body.setPcacList(pcacList);
    request.setBody(body);
    document.setRequest(request);
    // 加签
    XmlJsonUtils.doSignature(document);
    return document;
  }

  private com.cmcc.paymentclean.entity.dto.pcac.resp.Document pushToPcacByQuery(String xml) {
    // 上报数据
    String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
    log.info("url:{}", pcacConfig.getUrl());
    /*String post = "<Body>\n" +
    "    <RespInfo>\n" +
    "        <ResultStatus>已上报</ResultStatus>\n" +
    "        <ResultCode>01</ResultCode>\n" +
    "    </RespInfo>\n" +
    "</Body>";*/
    com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc =
        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
            XmlJsonUtils.convertXmlStrToObject(
                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
    log.info("协会返回数据对象:{}", resDoc);
    return resDoc;
  }

  @Override
  public void getBusinessInfoXML(String xml) {
    String identification = null;
    log.info("接收的xml:{}", xml);
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Document033Wapper resDoc =
        (com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Document033Wapper)
            XmlJsonUtils.convertXmlStrToObject(
                xml,
                com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper.Document033Wapper.class);
    com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body resBody =
        resDoc.getRequest().getBody();
    ConditionList conditionLists = resBody.getConditionList();
    if (conditionLists != null) {
      Request033Wapper request = resDoc.getRequest();
      Head head = request.getHead();
      String secretKey = head.getSecretKey();
      identification = head.getIdentification();
      List<Condition> conditions = conditionLists.getCondition();
      List<BusinessInfo> businessInfos = new ArrayList<>();
      for (int i = 0; i < conditions.size(); i++) {
        Condition condition = conditions.get(i);
        // 返回记录总数
        ResultCondition resultCondition = condition.getResultCondition();
        List<ResultInfo> resultInfo = resultCondition.getResultInfo();
        String count = condition.getCount();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.BaseInfo baseInfo =
            resultInfo.get(0).getBaseInfo();
        List<ResultInfo> resultInfos = condition.getResultCondition().getResultInfo();
        // 待补充落表逻辑 需求不清晰，东阳建议全部按一条数据来处理汇总一条BusinessInfo 数据
        SingInfo hisSingInfo = resultInfo.get(0).getHisSignList().get(0).getSingInfo().get(0);
        SingInfo curSingInfo = resultInfo.get(0).getCurSignList().get(0).getSingInfo().get(0);
        RiskInfo blackRiskInfo = resultInfo.get(0).getBlackList().get(0).getRiskInfo().get(0);
        RiskInfo warningRiskInfo = resultInfo.get(0).getWarningList().get(0).getRiskInfo().get(0);
        RiskInfo legBlackRiskInfo = resultInfo.get(0).getLegBlackList().get(0).getRiskInfo().get(0);
        RiskInfo legWarningRiskInfo =
            resultInfo.get(0).getLegWarningList().get(0).getRiskInfo().get(0);
        BusinessInfo businessInfo = new BusinessInfo();
        BeanUtils.copyProperties(hisSingInfo, businessInfo);
        BeanUtils.copyProperties(curSingInfo, businessInfo);
        BeanUtils.copyProperties(blackRiskInfo, businessInfo);
        BeanUtils.copyProperties(warningRiskInfo, businessInfo);
        BeanUtils.copyProperties(legBlackRiskInfo, businessInfo);
        BeanUtils.copyProperties(legWarningRiskInfo, businessInfo);
        // 对关键字进行解密
        businessInfo = this.decryptBusinessInfo(businessInfo, secretKey);
        businessInfos.add(businessInfo);
      }
      // 入库
      this.saveBatch(businessInfos);

      String fileName =
          sftpConfig.getBusinessInfoBlackFileNamePrefix()
              + DateUtils.curDateString()
              + CommonConst.SFTP_FILE_NAME_SUFFIX;
      ExcelUtils excelUtils = new ExcelUtils();
      try {
        // 文件名
        SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(businessInfos, BusinessInfo.class);
        FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
        sxssfWorkbook.write(fos);
        // dispose of temporary files backing this workbook on disk ->
        // 处理SXSSFWorkbook导出excel时，产生的临时文件
        sxssfWorkbook.dispose();
        fos.close();
      } catch (Exception e1) {
        e1.printStackTrace();
      }

      // 上传文件
      SFTPUtils.operateSFTP(
          sftpConfig.getUsername(),
          sftpConfig.getHost(),
          sftpConfig.getPort(),
          sftpConfig.getPassword(),
          sftpConfig.getRemotePathUpload(),
          fileName,
          sftpConfig.getModDir(),
          fileName,
          SFTPUtils.OPERATE_UPLOAD);
    }
    // com.cmcc.paymentclean.entity.dto.pcac.resp.Document document =
    // XmlJsonUtils.getRespDocument(pcacConfig,identification);
    // return XmlJsonUtils.convertObjectToXmlStr(document);
  }

  private BusinessInfo decryptBusinessInfo(BusinessInfo businessInfo, String secretKey) {
    // 商户名称
    if (StringUtils.isNotEmpty(businessInfo.getRegName())) {
      businessInfo.setRegName(CFCACipherUtils.decrypt(secretKey, businessInfo.getRegName()));
    }
    // 商户简称
    if (StringUtils.isNotEmpty(businessInfo.getCusName())) {
      businessInfo.setCusName(CFCACipherUtils.decrypt(secretKey, businessInfo.getCusName()));
    }
    // 商户英文名称
    if (StringUtils.isNotEmpty(businessInfo.getCusNameEn())) {
      businessInfo.setCusNameEn(CFCACipherUtils.decrypt(secretKey, businessInfo.getCusNameEn()));
    }
    // 商户代码
    if (StringUtils.isNotEmpty(businessInfo.getCusCode())) {
      businessInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, businessInfo.getCusCode()));
    }
    // 法定代表人姓名/负责人姓名
    if (StringUtils.isNotEmpty(businessInfo.getLegDocName())) {
      businessInfo.setLegDocName(CFCACipherUtils.decrypt(secretKey, businessInfo.getLegDocName()));
    }
    // 法定代表人证件号码
    if (StringUtils.isNotEmpty(businessInfo.getLegDocCode())) {
      String decryptLegDocCode = CFCACipherUtils.decrypt(secretKey, businessInfo.getLegDocCode());
      if (LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(businessInfo.getLegDocType())) {
        String encryptLegDocCode = InnerCipherUtils.encryptUserData(decryptLegDocCode);
        businessInfo.setLegDocCode(encryptLegDocCode);
      } else {
        businessInfo.setLegDocCode(decryptLegDocCode);
      }
    }
    // 商户代码
    if (StringUtils.isNotEmpty(businessInfo.getCusCode())) {
      businessInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, businessInfo.getCusCode()));
    }
    // 收款账\卡号
    if (StringUtils.isNotEmpty(businessInfo.getBankNo())) {
      String decryptBankNo = CFCACipherUtils.decrypt(secretKey, businessInfo.getBankNo());
      businessInfo.setBankNo(InnerCipherUtils.encryptUserData(decryptBankNo));
    }
    // 商户注册地址
    if (StringUtils.isNotEmpty(businessInfo.getRegAddrDetail())) {
      businessInfo.setRegAddrDetail(
          CFCACipherUtils.decrypt(secretKey, businessInfo.getRegAddrDetail()));
    }
    // 商户注册地址
    if (StringUtils.isNotEmpty(businessInfo.getAddrDetail())) {
      businessInfo.setAddrDetail(CFCACipherUtils.decrypt(secretKey, businessInfo.getAddrDetail()));
    }
    // 网址
    if (StringUtils.isNotEmpty(businessInfo.getUrl())) {
      businessInfo.setUrl(CFCACipherUtils.decrypt(secretKey, businessInfo.getUrl()));
    }
    // 服务器 ip
    if (StringUtils.isNotEmpty(businessInfo.getServerIp())) {
      businessInfo.setServerIp(CFCACipherUtils.decrypt(secretKey, businessInfo.getServerIp()));
    }
    // 商户联系人
    if (StringUtils.isNotEmpty(businessInfo.getContName())) {
      businessInfo.setContName(CFCACipherUtils.decrypt(secretKey, businessInfo.getContName()));
    }
    // 商户联系电话
    if (StringUtils.isNotEmpty(businessInfo.getContPhone())) {
      businessInfo.setContPhone(CFCACipherUtils.decrypt(secretKey, businessInfo.getContPhone()));
    }
    // 股东信息
    if (StringUtils.isNotEmpty(businessInfo.getShareHolder())) {
      businessInfo.setShareHolder(
          CFCACipherUtils.decrypt(secretKey, businessInfo.getShareHolder()));
    }
    // 外包服务机构名称
    if (StringUtils.isNotEmpty(businessInfo.getOutServiceName())) {
      businessInfo.setOutServiceName(
          CFCACipherUtils.decrypt(secretKey, businessInfo.getOutServiceName()));
    }
    // 外包服务机构法人证件号码
    if (StringUtils.isNotEmpty(businessInfo.getOutServiceCardCode())) {
      businessInfo.setOutServiceCardCode(
          CFCACipherUtils.decrypt(secretKey, businessInfo.getOutServiceCardCode()));
    }

    // 外包服务机构法定代表人证件号码
    if (StringUtils.isNotEmpty(businessInfo.getOutServiceLegCardCode())) {
      String decryptOutServiceLegCardCode =
          CFCACipherUtils.decrypt(secretKey, businessInfo.getOutServiceLegCardCode());
      if (LegDocTypeEnum.LEGDOCTYPEENUM_01
          .getCode()
          .equals(businessInfo.getOutServiceLegCardType())) {
        String encryptOutServiceLegCardCode =
            InnerCipherUtils.encryptUserData(decryptOutServiceLegCardCode);
        businessInfo.setOutServiceLegCardCode(encryptOutServiceLegCardCode);
      } else {
        businessInfo.setOutServiceLegCardCode(decryptOutServiceLegCardCode);
      }
    }
    // ICP
    if (StringUtils.isNotEmpty(businessInfo.getIcp())) {
      businessInfo.setIcp(CFCACipherUtils.decrypt(secretKey, businessInfo.getIcp()));
    }
    // doccode
    if (StringUtils.isNotEmpty(businessInfo.getDocCode())) {
      businessInfo.setDocCode(CFCACipherUtils.decrypt(secretKey, businessInfo.getDocCode()));
    }
    return businessInfo;
  }
}

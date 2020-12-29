package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusNatureEnum;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.FeedbackStatusEnum;
import com.cmcc.paymentclean.consts.HandleResultEnum;
import com.cmcc.paymentclean.consts.IsTransferEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.OccurChanEnum;
import com.cmcc.paymentclean.consts.PcacResultCodeEnum;
import com.cmcc.paymentclean.consts.PushStatusEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SysLanEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.exception.SubmitPCACException;
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
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
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务实现类
 *
 * @author zhaolei
 * @since 2020-09-14
 */
@Slf4j
@Service
public class QueryPcacMerchantRiskInfoServiceImpl
        extends ServiceImpl<QueryPcacMerchantRiskInfoMapper, QueryPcacMerchantRiskInfo>
        implements QueryPcacMerchantRiskInfoService {

    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    @Autowired
    private SftpConfig sftpConfig;
    @Autowired
    private PcacConfig pcacConfig;
    @Autowired
    private QueryPcacMerchantRiskInfoMapper queryPcacMerchantRiskInfoMapper;

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(
            List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs) {
        ResultBean<Body> resultBean = new ResultBean<>();
        // 设置报文体
        String resCode = "01";
        String resMsg = "查询无此记录！";
        if (queryPcacMerchantRiskReqs.size() == 0) {
            resultBean.setResMsg("参数为空");
            resultBean.setResCode("100");
            return resultBean;
        }
        for (int i = 0; i < queryPcacMerchantRiskReqs.size(); i++) {
            // 拼装报文
            byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
            Document document = new Document();
            // 设置报文头
            Request request =
                    XmlJsonUtils.getRequest(
                            symmetricKeyEncoded,
                            document,
                            pcacConfig,
                            TrnxCodeEnum.QUERY_MERCHANT_RISK_INFO.getCode());
            QueryPcacMerchantRiskReq queryPcacMerchantRiskReq = queryPcacMerchantRiskReqs.get(i);
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body =
                    new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
            body.setCusProperty(this.splitStrs(queryPcacMerchantRiskReq.getCusProperty()));
            body.setKeyWord(this.splitStrs(queryPcacMerchantRiskReq.getKeyWord()));
            body.setInfos(queryPcacMerchantRiskReq.getInfos());
            request.setBody(body);
            document.setRequest(request);
            // 加签
            XmlJsonUtils.doSignature(document);
            // 报文转换
            String xml = XmlJsonUtils.convertObjectToXmlStr(document);
            log.info("请求报文：{}", XmlJsonUtils.formatXml(xml));
            if (StringUtils.isEmpty(xml)) {
                log.info("xml报文转换失败");
                resultBean.setResMsg("xml报文转换失败");
                resultBean.setResCode("100");
                return resultBean;
            }
            // 校验xml报文
            boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.005");
            // boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
            if (!validate) {
                log.info("XML校验失败");
                resultBean.setResMsg("xml报文转换失败");
                resultBean.setResCode("801");
                return resultBean;
            }
            Body resBody = pushQueryPcacMerchantRiskReqToPcac(xml);
            RespInfo respInfo = resBody.getRespInfo();
//            if (!respInfo.getResultCode().equals(PcacResultCodeEnum.S00000.getCode())) {
//                resCode = respInfo.getResultCode();
//                resMsg =
//                        respInfo.getMsgDetail() == null
//                                ? PcacResultCodeEnum.getPcacResultCodeEnum(respInfo.getResultCode())
//                                : respInfo.getMsgDetail();
//            }
            if (resBody.getPcacList()!=null && resBody.getPcacList().getCount() > 0) {
                resMsg = "查询成功！";
            }
        }
        executor.execute(
                () -> {
                    log.info("------------------开始执行上传文件----------------");
                    exportExcel();
                    log.info("------------------结束执行上传文件----------------");
                });
        resultBean.setResCode(resCode);
        resultBean.setResMsg(resMsg);
        return resultBean;
    }

    private Body pushQueryPcacMerchantRiskReqToPcac(String xml) {
        // 上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        if (org.apache.commons.lang3.StringUtils.isEmpty(post)) {
            throw new SubmitPCACException(ResultBean.UNSPECIFIED_CODE, "协会接口异常");
        }
        log.info("响应报文：{}", XmlJsonUtils.formatXml(post));
        log.info("url:{}", pcacConfig.getUrl());
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc =
                (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
                        XmlJsonUtils.convertXmlStrToObject(
                                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        String secretKey = resDoc.getRespone().getHead().getSecretKey();
        Body resBody = resDoc.getRespone().getBody();
        log.info("pcac.ries.005 协会返回数据对象:{}", resBody);
        PcacList pcacList = resBody.getPcacList() != null ? resBody.getPcacList() : new PcacList();
        List<RiskInfo> riskInfos =
                pcacList.getRiskInfo() != null ? pcacList.getRiskInfo() : new ArrayList<RiskInfo>();
        for (RiskInfo riskInfo : riskInfos) {
            riskInfo.setCusName(CFCACipherUtils.decrypt(secretKey, riskInfo.getCusName()));
            riskInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getCusCode()));
            riskInfo.setRegName(CFCACipherUtils.decrypt(secretKey, riskInfo.getRegName()));
            riskInfo.setDocCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getDocCode()));
            riskInfo.setLegRepName(CFCACipherUtils.decrypt(secretKey, riskInfo.getLegRepName()));
            // 新增身份证号加密
            String encryptLegDocCode = null;
            String decryptLegDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocCode());
            // 判断证件类型是身份证就进行内部加密
      /*if (!org.springframework.util.StringUtils.isEmpty(riskInfo.getLegDocCode())
          && LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(riskInfo.getLegDocType())) {*/
            encryptLegDocCode = InnerCipherUtils.encryptUserData(decryptLegDocCode);
            riskInfo.setLegDocCode(encryptLegDocCode);
    /*  } else {
        riskInfo.setLegDocCode(decryptLegDocCode);
      }*/

            riskInfo.setUrl(CFCACipherUtils.decrypt(secretKey, riskInfo.getUrl()));
            riskInfo.setServerIp(CFCACipherUtils.decrypt(secretKey, riskInfo.getServerIp()));
            riskInfo.setMobileNo(CFCACipherUtils.decrypt(secretKey, riskInfo.getMobileNo()));
            riskInfo.setIcp(CFCACipherUtils.decrypt(secretKey, riskInfo.getIcp()));
            riskInfo.setRegisteredCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getRegisteredCode()));

            // 新增实控人身份证号加密
            String encryptLegControlCardCode = null;
            String decryptLegControlCardCode =
                    CFCACipherUtils.decrypt(secretKey, riskInfo.getLegControlCardCode());
            // 判断证件类型是身份证就进行内部加密
     /* if (!org.springframework.util.StringUtils.isEmpty(riskInfo.getLegControlCardCode())
          && LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(riskInfo.getLegControlCardType())) {*/
            encryptLegControlCardCode = InnerCipherUtils.encryptUserData(decryptLegControlCardCode);
            riskInfo.setLegControlCardCode(encryptLegControlCardCode);
     /* } else {
        riskInfo.setLegControlCardCode(decryptLegControlCardCode);
      }*/

            BankInfo bankInfo = riskInfo.getBankInfo() != null ? riskInfo.getBankInfo() : new BankInfo();
            BankList bankList = riskInfo.getBankList() != null ? riskInfo.getBankList() : new BankList();
            BenList benList = riskInfo.getBenList() != null ? riskInfo.getBenList() : new BenList();
            BenInfo benInfo =
                    riskInfo.getBenList().getBenInfo() != null
                            ? riskInfo.getBenList().getBenInfo()
                            : new BenInfo();
            QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo = new QueryPcacMerchantRiskInfo();
            // 银行卡加密
            bankInfo.setBankNo(InnerCipherUtils.encryptBankData(bankInfo.getBankNo()));

            String encryptLegBenCardCode = null;
            String decryptLegBenCardCode =
                    CFCACipherUtils.decrypt(secretKey, benInfo.getLegBenCardCode());
            // 判断证件类型是身份证就进行内部加密
     /* if (!org.springframework.util.StringUtils.isEmpty(benInfo.getLegBenCardCode())
          && LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(benInfo.getLegBenCardType())) {*/
            encryptLegBenCardCode = InnerCipherUtils.encryptUserData(decryptLegBenCardCode);
            benInfo.setLegBenCardCode(encryptLegBenCardCode);
      /*} else {
        benInfo.setLegBenCardCode(decryptLegBenCardCode);
      }*/
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, bankInfo);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, bankList);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, benList);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, benInfo);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, riskInfo);
            queryPcacMerchantRiskInfoMapper.insert(queryPcacMerchantRiskInfo);
        }
        return resBody;
    }

    @Override
    public ResultBean<Page<QueryPcacMerchantRiskInfoResp>> pageLocalAssociatedRiskMerchantInfo(
            QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq) {
        log.info(
                "pageLocalAssociatedRiskMerchantInfo req={}",
                com.alibaba.fastjson.JSON.toJSON(queryPcacMerchantRiskInfoReq));
        ResultBean<Page<QueryPcacMerchantRiskInfoResp>> resultBean = new ResultBean();
        Page<QueryPcacMerchantRiskInfoResp> page =
                new Page<>(
                        queryPcacMerchantRiskInfoReq.getPageNo(), queryPcacMerchantRiskInfoReq.getPageSize());
        Page<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoRespPage =
                queryPcacMerchantRiskInfoMapper.pageLocalAssociatedRiskMerchantInfo(
                        page, queryPcacMerchantRiskInfoReq);
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps =
                queryPcacMerchantRiskInfoRespPage.getRecords();
        if (!CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)) {
            for (QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp :
                    queryPcacMerchantRiskInfoResps) {
                String validStatus =
                        (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate()))
                                ? CommonConst.VALIDSTATUS_01
                                : CommonConst.VALIDSTATUS_02;
                queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
                queryPcacMerchantRiskInfoResp.setLegDocType(
                        LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
                queryPcacMerchantRiskInfoResp.setIsTransfer(
                        IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(
                        LegDocTypeEnum.getLegDocTypeDesc(
                                queryPcacMerchantRiskInfoResp.getLegControlCardType()));
                queryPcacMerchantRiskInfoResp.setDocType(
                        DocTypeEnum.getDocTypeDesc(queryPcacMerchantRiskInfoResp.getDocType()));
                queryPcacMerchantRiskInfoResp.setCusType(
                        CusTypeEnum.getCusTypeEnum(queryPcacMerchantRiskInfoResp.getCusType()));
                queryPcacMerchantRiskInfoResp.setRiskType(
                        RiskTypeEnum.getRiskTypeDesc(queryPcacMerchantRiskInfoResp.getRiskType()));
                queryPcacMerchantRiskInfoResp.setCusNature(
                        CusNatureEnum.getCusNatureEnum(queryPcacMerchantRiskInfoResp.getCusNature()));
                queryPcacMerchantRiskInfoResp.setSourceChannel(
                        SourChaEnum.getSourChaEnum(queryPcacMerchantRiskInfoResp.getSourceChannel()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(
                        LegDocTypeEnum.getLegDocTypeDesc(
                                queryPcacMerchantRiskInfoResp.getLegControlCardType()));
                queryPcacMerchantRiskInfoResp.setLegBenCardType(
                        LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegBenCardType()));
                queryPcacMerchantRiskInfoResp.setLevel(
                        LevelCodeEnum.getLevelDesc(queryPcacMerchantRiskInfoResp.getLevel()));
                queryPcacMerchantRiskInfoResp.setFeedbackStatus(
                        FeedbackStatusEnum.getFeedbackStatusDesc(
                                queryPcacMerchantRiskInfoResp.getFeedbackStatus()));
                queryPcacMerchantRiskInfoResp.setCusProperty(
                        CusPropertyEnum.getCusPropertyEnum(queryPcacMerchantRiskInfoResp.getCusProperty()));
                queryPcacMerchantRiskInfoResp.setHandleResult(
                        HandleResultEnum.getHandleResultDesc(queryPcacMerchantRiskInfoResp.getHandleResult()));
                queryPcacMerchantRiskInfoResp.setOccurchan(
                        OccurChanEnum.getOccurChanEnum(queryPcacMerchantRiskInfoResp.getOccurchan()));
                queryPcacMerchantRiskInfoResp.setOccurarea(
                        SysLanEnum.getSysLanEnumDesc(queryPcacMerchantRiskInfoResp.getOccurarea()));
                queryPcacMerchantRiskInfoResp.setCount(queryPcacMerchantRiskInfoResps.size() + "");
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(queryPcacMerchantRiskInfoRespPage);
        log.info(
                "pageLocalAssociatedRiskMerchantInfo resp={}",
                com.alibaba.fastjson.JSON.toJSON(queryPcacMerchantRiskInfoRespPage));
        return resultBean;
    }

    @Override
    public ResultBean<Body> exportExcel() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        // 查出未推送数据
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps =
                queryPcacMerchantRiskInfoMapper.qryByPushStatus("0");
        if (CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)) {
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for (QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp :
                queryPcacMerchantRiskInfoResps) {
            stringList.add(queryPcacMerchantRiskInfoResp.getQueryPcacMerchantRiskInfoId());
            String validStatus =
                    (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate()))
                            ? CommonConst.VALIDSTATUS_01
                            : CommonConst.VALIDSTATUS_02;
            queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
            queryPcacMerchantRiskInfoResp.setLegDocType(
                    LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
            queryPcacMerchantRiskInfoResp.setIsTransfer(
                    IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
            queryPcacMerchantRiskInfoResp.setLegControlCardType(
                    LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
            queryPcacMerchantRiskInfoResp.setDocType(
                    DocTypeEnum.getDocTypeDesc(queryPcacMerchantRiskInfoResp.getDocType()));
            queryPcacMerchantRiskInfoResp.setCusType(
                    CusTypeEnum.getCusTypeEnum(queryPcacMerchantRiskInfoResp.getCusType()));
            queryPcacMerchantRiskInfoResp.setRiskType(
                    RiskTypeEnum.getRiskTypeDesc(queryPcacMerchantRiskInfoResp.getRiskType()));
            queryPcacMerchantRiskInfoResp.setCusNature(
                    CusNatureEnum.getCusNatureEnum(queryPcacMerchantRiskInfoResp.getCusNature()));
            queryPcacMerchantRiskInfoResp.setSourceChannel(
                    SourChaEnum.getSourChaEnum(queryPcacMerchantRiskInfoResp.getSourceChannel()));
            queryPcacMerchantRiskInfoResp.setLegControlCardType(
                    LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
            queryPcacMerchantRiskInfoResp.setLegBenCardType(
                    LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegBenCardType()));
            queryPcacMerchantRiskInfoResp.setLevel(
                    LevelCodeEnum.getLevelDesc(queryPcacMerchantRiskInfoResp.getLevel()));
            queryPcacMerchantRiskInfoResp.setFeedbackStatus(
                    FeedbackStatusEnum.getFeedbackStatusDesc(
                            queryPcacMerchantRiskInfoResp.getFeedbackStatus()));
            queryPcacMerchantRiskInfoResp.setCusProperty(
                    CusPropertyEnum.getCusPropertyEnum(queryPcacMerchantRiskInfoResp.getCusProperty()));
            queryPcacMerchantRiskInfoResp.setHandleResult(
                    HandleResultEnum.getHandleResultDesc(queryPcacMerchantRiskInfoResp.getHandleResult()));
            queryPcacMerchantRiskInfoResp.setOccurchan(
                    OccurChanEnum.getOccurChanEnum(queryPcacMerchantRiskInfoResp.getOccurchan()));
            queryPcacMerchantRiskInfoResp.setOccurarea(
                    SysLanEnum.getSysLanEnumDesc(queryPcacMerchantRiskInfoResp.getOccurarea()));
            queryPcacMerchantRiskInfoResp.setTotalOrganNum(
                    queryPcacMerchantRiskInfoResp.getTotalOrganNum());
            queryPcacMerchantRiskInfoResp.setErrInfo(queryPcacMerchantRiskInfoResp.getErrInfo());
        }

        // 生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName =
                sftpConfig.getQueryPcacMerchantRiskInfoFileNamePrefix()
                        + DateUtils.curDateString()
                        + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            // 文件名
            SXSSFWorkbook sxssfWorkbook =
                    excelUtils.exportExcel(
                            queryPcacMerchantRiskInfoResps, QueryPcacMerchantRiskInfoResp.class);
            FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
            sxssfWorkbook.write(fos);
            // dispose of temporary files backing this workbook on disk -> 处理SXSSFWorkbook导出excel时，产生的临时文件
            sxssfWorkbook.dispose();
            fos.close();
        } catch (Exception e) {
            log.error("异常:" + e);
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
        queryPcacMerchantRiskInfoMapper.updatePushStatus(stringList);
        return resultBean;
    }

    @Override
    public ResultBean<Body> queryPcacMerchantRiskInfoBack(
            List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReqs) {
        ResultBean<Body> resultBean = new ResultBean<>();
        // 拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        // 设置报文头
        Request request =
                XmlJsonUtils.getRequest(
                        symmetricKeyEncoded,
                        document,
                        pcacConfig,
                        TrnxCodeEnum.QUERY_MERCHANT_RISK_INFO_BACK.getCode());
        // 设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList pcacList =
                new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList();
        pcacList.setCount(queryPcacMerchantRiskInfoBackReqs.size() + "");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos =
                new ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReqs.size(); i++) {
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo =
                    new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
            BeanUtilsEx.copyProperties(riskInfo, queryPcacMerchantRiskInfoBackReqs.get(i));
            riskInfo.setCusType(this.splitStrs(riskInfo.getCusType()));
            riskInfo.setHandleResult(this.splitStrs(riskInfo.getHandleResult()));
            String repDateStr = DateUtils.formatTime(new Date(), "yyyy-MM-dd");
            riskInfo.setHandleTime(repDateStr);
            riskInfos.add(riskInfo);
        }
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        // 加签
        XmlJsonUtils.doSignature(document);
        // 报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", XmlJsonUtils.formatXml(xml));
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            resultBean.setResMsg("xml报文转换失败");
            resultBean.setResCode("100");
            return resultBean;
        }
        // 校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.045");
        // boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
        if (!validate) {
            log.info("XML校验失败");
            resultBean.setResMsg("xml报文转换失败");
            resultBean.setResCode("801");
            return resultBean;
        }
        return pushQueryPcacMerchantRiskInfoBackToPcac(
                xml, resultBean, queryPcacMerchantRiskInfoBackReqs);
    }

    private ResultBean<Body> pushQueryPcacMerchantRiskInfoBackToPcac(
            String xml,
            ResultBean<Body> resultBean,
            List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReqs) {
        // 上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        if (null == post) {
            resultBean.setResCode(ResultBean.SERVICE_OUT);
            resultBean.setResMsg("支付清算服务接口超时");
            return resultBean;
        }
        log.info("响应报文:{}", XmlJsonUtils.formatXml(post));
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc =
                (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)
                        XmlJsonUtils.convertXmlStrToObject(
                                post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        Body resBody = resDoc.getRespone().getBody();
        log.info("pcac.ries.045 协会返回数据对象:{}", resBody);
        RespInfo respInfo = resBody.getRespInfo();
        String resultCode = respInfo.getResultCode();
        String resultStatus = respInfo.getResultStatus();
        // 更新数据库数据状态
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReqs.size(); i++) {
            ids.add(queryPcacMerchantRiskInfoBackReqs.get(i).getId());
            queryPcacMerchantRiskInfoMapper.updateByProId(queryPcacMerchantRiskInfoBackReqs.get(i));
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("Id", ids);
        List<QueryPcacMerchantRiskInfo> list = queryPcacMerchantRiskInfoMapper.selectList(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo = list.get(i);
            queryPcacMerchantRiskInfo.setResultStatus(resultStatus);
            queryPcacMerchantRiskInfo.setResultCode(resultCode);
            queryPcacMerchantRiskInfo.setPushStatus(PushStatusEnum.PUSHSTATUSENUM_1.getCode());
            queryPcacMerchantRiskInfoMapper.updateById(queryPcacMerchantRiskInfo);
        }
        resultBean.setResMsg(
                PcacResultCodeEnum.getPcacResultCodeEnum(resultCode) + respInfo.getMsgDetail());
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

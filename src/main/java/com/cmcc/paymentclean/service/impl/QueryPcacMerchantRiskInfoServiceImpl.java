package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.BankList;
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
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.*;
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

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhaolei
 * @since 2020-09-14
 */
@Slf4j
@Service
public class QueryPcacMerchantRiskInfoServiceImpl extends ServiceImpl<QueryPcacMerchantRiskInfoMapper, QueryPcacMerchantRiskInfo> implements QueryPcacMerchantRiskInfoService {

    @Autowired
    private SftpConfig sftpConfig;

    @Autowired
    private PcacConfig pcacConfig;

    @Autowired
    private SysLanService sysLanService;

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs) {
        ResultBean<Body> resultBean = new ResultBean<>();
//        if(true){
//            resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
//            resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
//            return resultBean;
//        }
        //设置报文体
        String resCode = "01";
        String resMsg = "查询成功！";
        if (queryPcacMerchantRiskReqs.size() == 0) {
            resultBean.setResMsg("参数为空");
            resultBean.setResCode("100");
            return resultBean;
        }
        for (int i = 0; i < queryPcacMerchantRiskReqs.size(); i++) {
            //拼装报文
            byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
            Document document = new Document();
            //设置报文头
            Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "QR0003");
            QueryPcacMerchantRiskReq queryPcacMerchantRiskReq = queryPcacMerchantRiskReqs.get(i);
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
            body.setCusProperty(this.splitStrs(queryPcacMerchantRiskReq.getCusProperty()));
            body.setKeyWord(this.splitStrs(queryPcacMerchantRiskReq.getKeyWord()));
            body.setInfos(queryPcacMerchantRiskReq.getInfos());
            request.setBody(body);
            document.setRequest(request);
            //加签
            XmlJsonUtils.doSignature(document);
            //报文转换
            String xml = XmlJsonUtils.convertObjectToXmlStr(document);
            log.info("请求报文：{}", XmlJsonUtils.formatXml(xml));
            if (StringUtils.isEmpty(xml)) {
                log.info("xml报文转换失败");
                resultBean.setResMsg("xml报文转换失败");
                resultBean.setResCode("100");
                return resultBean;
            }
            //校验xml报文
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
            if (!respInfo.getResultCode().equals("S00000")) {
                resCode = respInfo.getResultCode();
                resMsg = respInfo.getMsgDetail();
            }
        }
        resultBean.setResCode(resCode);
        resultBean.setResMsg(resMsg);
        return resultBean;
    }

    private Body pushQueryPcacMerchantRiskReqToPcac(String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("响应报文：{}", XmlJsonUtils.formatXml(post));
        log.info("url:{}", pcacConfig.getUrl());
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post,com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        String secretKey = resDoc.getRespone().getHead().getSecretKey();
        Body resBody = resDoc.getRespone().getBody();
        log.info("pcac.ries.005 协会返回数据对象:{}", resBody);
        PcacList pcacList = resBody.getPcacList() != null ? resBody.getPcacList() : new PcacList();
        List<RiskInfo> riskInfos = pcacList.getRiskInfo() != null ? pcacList.getRiskInfo() : new ArrayList<RiskInfo>();
        for (RiskInfo riskInfo : riskInfos) {
            riskInfo.setCusName(CFCACipherUtils.decrypt(secretKey, riskInfo.getCusName()));
            riskInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getCusCode()));
            riskInfo.setRegName(CFCACipherUtils.decrypt(secretKey, riskInfo.getRegName()));
            riskInfo.setDocCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getDocCode()));
            riskInfo.setLegRepName(CFCACipherUtils.decrypt(secretKey, riskInfo.getLegRepName()));
            riskInfo.setLegDocCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocCode()));
            riskInfo.setUrl(CFCACipherUtils.decrypt(secretKey, riskInfo.getUrl()));
            riskInfo.setServerIp(CFCACipherUtils.decrypt(secretKey, riskInfo.getServerIp()));
            riskInfo.setMobileNo(CFCACipherUtils.decrypt(secretKey, riskInfo.getMobileNo()));
            riskInfo.setIcp(CFCACipherUtils.decrypt(secretKey, riskInfo.getIcp()));
            riskInfo.setRegisteredCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getRegisteredCode()));
            riskInfo.setLegControlCardCode(CFCACipherUtils.decrypt(secretKey, riskInfo.getLegControlCardCode()));
            BankInfo bankInfo = riskInfo.getBankInfo() != null ? riskInfo.getBankInfo() : new BankInfo();
            BankList bankList = riskInfo.getBankList() != null ? riskInfo.getBankList() : new BankList();
            BenList benList = riskInfo.getBenList() != null ? riskInfo.getBenList() : new BenList();
            QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo = new QueryPcacMerchantRiskInfo();
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, bankInfo);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, bankList);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, benList);
            BeanUtilsEx.copyProperties(queryPcacMerchantRiskInfo, riskInfo);
            queryPcacMerchantRiskInfoMapper.insert(queryPcacMerchantRiskInfo);
        }
        return resBody;
    }

    @Autowired
    private QueryPcacMerchantRiskInfoMapper queryPcacMerchantRiskInfoMapper;

    @Override
    public ResultBean<Page<QueryPcacMerchantRiskInfoResp>> pageLocalAssociatedRiskMerchantInfo(QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq) {
        log.info("pageLocalAssociatedRiskMerchantInfo req={}", com.alibaba.fastjson.JSON.toJSON(queryPcacMerchantRiskInfoReq));
        ResultBean<Page<QueryPcacMerchantRiskInfoResp>> resultBean = new ResultBean();
        Page<QueryPcacMerchantRiskInfoResp> page = new Page<>(queryPcacMerchantRiskInfoReq.getPageNo(), queryPcacMerchantRiskInfoReq.getPageSize());
        Page<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoRespPage = queryPcacMerchantRiskInfoMapper.pageLocalAssociatedRiskMerchantInfo(page, queryPcacMerchantRiskInfoReq);
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps = queryPcacMerchantRiskInfoRespPage.getRecords();
        if (!CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)) {
            for (QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp : queryPcacMerchantRiskInfoResps) {
                String validStatus = (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
                queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
                queryPcacMerchantRiskInfoResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
                queryPcacMerchantRiskInfoResp.setIsTransfer(IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
                queryPcacMerchantRiskInfoResp.setDocType(DocTypeEnum.getDocTypeDesc(queryPcacMerchantRiskInfoResp.getDocType()));
                queryPcacMerchantRiskInfoResp.setCusType(CusTypeEnum.getCusTypeEnum(queryPcacMerchantRiskInfoResp.getCusType()));
                queryPcacMerchantRiskInfoResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(queryPcacMerchantRiskInfoResp.getRiskType()));
                queryPcacMerchantRiskInfoResp.setCusNature(CusNatureEnum.getCusNatureEnum(queryPcacMerchantRiskInfoResp.getCusNature()));
                queryPcacMerchantRiskInfoResp.setSourceChannel(SourChaEnum.getSourChaEnum(queryPcacMerchantRiskInfoResp.getSourceChannel()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
                queryPcacMerchantRiskInfoResp.setLegBenCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegBenCardType()));
                queryPcacMerchantRiskInfoResp.setLevel(LevelCodeEnum.getLevelDesc(queryPcacMerchantRiskInfoResp.getLevel()));
                queryPcacMerchantRiskInfoResp.setFeedbackStatus(FeedbackStatusEnum.getFeedbackStatusDesc(queryPcacMerchantRiskInfoResp.getFeedbackStatus()));
                queryPcacMerchantRiskInfoResp.setCusProperty(CusPropertyEnum.getCusPropertyEnum(queryPcacMerchantRiskInfoResp.getCusProperty()));
                queryPcacMerchantRiskInfoResp.setHandleResult(HandleResultEnum.getHandleResultDesc(queryPcacMerchantRiskInfoResp.getHandleResult()));
                queryPcacMerchantRiskInfoResp.setOccurchan(OccurChanEnum.getOccurChanEnum(queryPcacMerchantRiskInfoResp.getOccurchan()));
                SysLan sysLan = sysLanService.getLanInfoById(queryPcacMerchantRiskInfoResp.getOccurarea());
                if(null != sysLan){
                    queryPcacMerchantRiskInfoResp.setOccurarea(sysLan.getLanName());
                }
                //联调测试
                queryPcacMerchantRiskInfoResp.setCount("99");
                queryPcacMerchantRiskInfoResp.setSubmitAmount("99");
                queryPcacMerchantRiskInfoResp.setCusCodeCount("99");
                queryPcacMerchantRiskInfoResp.setTotalOrganNum("99");
                queryPcacMerchantRiskInfoResp.setBenListcount("99");
                queryPcacMerchantRiskInfoResp.setOperator("联调测试");
                queryPcacMerchantRiskInfoResp.setErrInfo("联调测试");
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(queryPcacMerchantRiskInfoRespPage);
        log.info("pageLocalAssociatedRiskMerchantInfo resp={}", com.alibaba.fastjson.JSON.toJSON(queryPcacMerchantRiskInfoRespPage));
        return resultBean;
    }

    @Override
    public ResultBean<Body> exportExcel() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        //查出未推送数据
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps = queryPcacMerchantRiskInfoMapper.qryByPushStatus("0");
        if (CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)) {
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for (QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp : queryPcacMerchantRiskInfoResps) {
            stringList.add(queryPcacMerchantRiskInfoResp.getQueryPcacMerchantRiskInfoId());
            String validStatus = (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
            queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
            queryPcacMerchantRiskInfoResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
            queryPcacMerchantRiskInfoResp.setIsTransfer(IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
            queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
            queryPcacMerchantRiskInfoResp.setDocType(DocTypeEnum.getDocTypeDesc(queryPcacMerchantRiskInfoResp.getDocType()));
            queryPcacMerchantRiskInfoResp.setCusType(CusTypeEnum.getCusTypeEnum(queryPcacMerchantRiskInfoResp.getCusType()));
            queryPcacMerchantRiskInfoResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(queryPcacMerchantRiskInfoResp.getRiskType()));
            queryPcacMerchantRiskInfoResp.setCusNature(CusNatureEnum.getCusNatureEnum(queryPcacMerchantRiskInfoResp.getCusNature()));
            queryPcacMerchantRiskInfoResp.setSourceChannel(SourChaEnum.getSourChaEnum(queryPcacMerchantRiskInfoResp.getSourceChannel()));
            queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
            queryPcacMerchantRiskInfoResp.setLegBenCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegBenCardType()));
            queryPcacMerchantRiskInfoResp.setLevel(LevelCodeEnum.getLevelDesc(queryPcacMerchantRiskInfoResp.getLevel()));
            queryPcacMerchantRiskInfoResp.setFeedbackStatus(FeedbackStatusEnum.getFeedbackStatusDesc(queryPcacMerchantRiskInfoResp.getFeedbackStatus()));
            queryPcacMerchantRiskInfoResp.setCusProperty(CusPropertyEnum.getCusPropertyEnum(queryPcacMerchantRiskInfoResp.getCusProperty()));
            queryPcacMerchantRiskInfoResp.setHandleResult(HandleResultEnum.getHandleResultDesc(queryPcacMerchantRiskInfoResp.getHandleResult()));
            queryPcacMerchantRiskInfoResp.setOccurchan(OccurChanEnum.getOccurChanEnum(queryPcacMerchantRiskInfoResp.getOccurchan()));
            SysLan sysLan = sysLanService.getLanInfoById(queryPcacMerchantRiskInfoResp.getOccurarea());
            if(null != sysLan){
                queryPcacMerchantRiskInfoResp.setOccurarea(sysLan.getLanName());
            }
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getQueryPcacMerchantRiskInfoFileNamePrefix() + DateUtils.curDateString() + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(queryPcacMerchantRiskInfoResps, QueryPcacMerchantRiskInfoResp.class);
            FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
            sxssfWorkbook.write(fos);
            // dispose of temporary files backing this workbook on disk -> 处理SXSSFWorkbook导出excel时，产生的临时文件
            sxssfWorkbook.dispose();
            fos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //上传文件
        SFTPUtils.operateSFTP(sftpConfig.getUsername(), sftpConfig.getHost(), sftpConfig.getPort(), sftpConfig.getPassword(),
                sftpConfig.getRemotePathUpload(), fileName, sftpConfig.getModDir(), fileName, SFTPUtils.OPERATE_UPLOAD);
        //更新状态为推送
        queryPcacMerchantRiskInfoMapper.updatePushStatus(stringList);
        return resultBean;
    }

    @Override
    public ResultBean<Body> queryPcacMerchantRiskInfoBack(List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReqs) {
        ResultBean<Body> resultBean = new ResultBean<>();
//        if(true){
//            resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
//            resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
//            return resultBean;
//        }
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "UP0005");
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList();
        pcacList.setCount(queryPcacMerchantRiskInfoBackReqs.size() + "");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos = new ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReqs.size(); i++) {
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
            BeanUtilsEx.copyProperties(riskInfo, queryPcacMerchantRiskInfoBackReqs.get(i));
            riskInfo.setCusType(this.splitStrs(riskInfo.getCusType()));
            riskInfo.setHandleResult(this.splitStrs(riskInfo.getHandleResult()));
            riskInfos.add(riskInfo);
        }
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        //加签
        XmlJsonUtils.doSignature(document);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", XmlJsonUtils.formatXml(xml));
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            resultBean.setResMsg("xml报文转换失败");
            resultBean.setResCode("100");
            return resultBean;
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.045");
        // boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
        if (!validate) {
            log.info("XML校验失败");
            resultBean.setResMsg("xml报文转换失败");
            resultBean.setResCode("801");
            return resultBean;
        }
        return pushQueryPcacMerchantRiskInfoBackToPcac(xml, resultBean, queryPcacMerchantRiskInfoBackReqs);
    }

    private ResultBean<Body> pushQueryPcacMerchantRiskInfoBackToPcac(String xml, ResultBean<Body> resultBean, List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReqs) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("响应报文:{}", XmlJsonUtils.formatXml(post));
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        Body resBody = resDoc.getRespone().getBody();
        log.info("pcac.ries.045 协会返回数据对象:{}", resBody);
        RespInfo respInfo = resBody.getRespInfo();
        String resultCode = respInfo.getResultCode();
        String resultStatus = respInfo.getResultStatus();
        //更新数据库数据状态
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReqs.size(); i++) {
            ids.add(queryPcacMerchantRiskInfoBackReqs.get(i).getId());
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.in("Id", ids);
        List<QueryPcacMerchantRiskInfo> list = queryPcacMerchantRiskInfoMapper.selectList(queryWrapper);
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("result_status", resultStatus);
        updateWrapper.set("result_code", resultCode);
        for (int i = 0; i < list.size(); i++) {
            queryPcacMerchantRiskInfoMapper.update(list.get(i), updateWrapper);
        }
        resultBean.setResCode(resultCode);
        resultBean.setResMsg(resultStatus);
        return resultBean;
    }

    private String splitStrs(String strings){
        if(StringUtils.isEmpty(strings)){
            return strings;
        }
        String [] strs = strings.split("\\|");
        return strs[0];
    }
}

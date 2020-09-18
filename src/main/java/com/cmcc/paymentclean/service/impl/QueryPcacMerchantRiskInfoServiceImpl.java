package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusNatureEnum;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.IsTransferEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
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
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
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

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs) {
        ResultBean<Body> resultBean = new ResultBean<>();
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "");
        //设置报文体
        String resCode = "01";
        String resMsg = "查询成功！";
        for (int i = 0; i < queryPcacMerchantRiskReqs.size(); i++) {
            QueryPcacMerchantRiskReq queryPcacMerchantRiskReq = queryPcacMerchantRiskReqs.get(i);
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac005.Body();
            body.setCusProperty(queryPcacMerchantRiskReq.getCusProperty());
            body.setKeyWord(queryPcacMerchantRiskReq.getKeyWord());
            body.setInfos(queryPcacMerchantRiskReq.getInfos());
            request.setBody(body);
            document.setRequest(request);
            //报文转换
            String xml = XmlJsonUtils.convertObjectToXmlStr(document);
            log.info("获取到的xml数据:{}", xml);
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
            if(!respInfo.getResultCode().equals("S00000")){
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
        log.info("url:{}", pcacConfig.getUrl());
        Body resBody = (Body) XmlJsonUtils.convertXmlStrToObject(Body.class, post);
        log.info("pcac.ries.005 协会返回数据对象:{}", resBody);
        PcacList pcacList = resBody.getPcacList();
        List<RiskInfo> riskInfos = pcacList.getRiskInfo();
        for (RiskInfo riskInfo : riskInfos) {
            BankInfo bankInfo = riskInfo.getBankInfo();
            BankList bankList = riskInfo.getBankList();
            BenList benList = riskInfo.getBenList();
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
                queryPcacMerchantRiskInfoResp.setDocType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getDocType()));
                queryPcacMerchantRiskInfoResp.setCusType(CusTypeEnum.getCusTypeEnum(queryPcacMerchantRiskInfoResp.getCusType()));
                queryPcacMerchantRiskInfoResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(queryPcacMerchantRiskInfoResp.getRiskType()));
                queryPcacMerchantRiskInfoResp.setCusNature(CusNatureEnum.getCusNatureEnum(queryPcacMerchantRiskInfoResp.getCusNature()));
                queryPcacMerchantRiskInfoResp.setSourceChannel(SourChaEnum.getSourChaEnum(queryPcacMerchantRiskInfoResp.getSourceChannel()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
                queryPcacMerchantRiskInfoResp.setLegBenCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegBenCardType()));
                queryPcacMerchantRiskInfoResp.setLevel(LevelCodeEnum.getLevelDesc(queryPcacMerchantRiskInfoResp.getLevel()));
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
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getQueryPcacMerchantRiskInfoFileNamePrefix() + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
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
    public ResultBean<Body> queryPcacMerchantRiskInfoBack(List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReq) {
        ResultBean<Body> resultBean = new ResultBean<>();
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "");
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.PcacList();
        pcacList.setCount(queryPcacMerchantRiskInfoBackReq.size() + "");
        List<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo> riskInfos = new ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReq.size(); i++) {
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo riskInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac045.RiskInfo();
            BeanUtilsEx.copyProperties(riskInfo, queryPcacMerchantRiskInfoBackReq);
            riskInfos.add(riskInfo);
        }
        pcacList.setRiskInfo(riskInfos);
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
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
        return pushQueryPcacMerchantRiskInfoBackToPcac(xml, resultBean, queryPcacMerchantRiskInfoBackReq);
    }

    private ResultBean<Body> pushQueryPcacMerchantRiskInfoBackToPcac(String xml, ResultBean<Body> resultBean, List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReq) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        Body resBody = (Body) XmlJsonUtils.convertXmlStrToObject(Body.class, post);
        log.info("pcac.ries.045 协会返回数据对象:{}", resBody);
        RespInfo respInfo = resBody.getRespInfo();
        String resultCode = respInfo.getResultCode();
        String resultStatus = respInfo.getResultStatus();
        //更新数据库数据状态
        List<String> ids = new ArrayList<>();
        for (int i = 0; i < queryPcacMerchantRiskInfoBackReq.size(); i++) {
            ids.add(queryPcacMerchantRiskInfoBackReq.get(i).getId());
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
}

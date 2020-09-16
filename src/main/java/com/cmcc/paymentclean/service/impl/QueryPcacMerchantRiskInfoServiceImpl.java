package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.IsTransferEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Request;
import com.cmcc.paymentclean.entity.dto.pcac.resq.RiskInfo;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* <p>
*  服务实现类
* </p>
*
* @author zhaolei
* @since 2020-09-14
*/
@Slf4j
@Service
public class QueryPcacMerchantRiskInfoServiceImpl extends ServiceImpl<QueryPcacMerchantRiskInfoMapper, QueryPcacMerchantRiskInfo> implements QueryPcacMerchantRiskInfoService {

    @Value("${sftp.modDir}")
    private String modDir;

    @Value("${sftp.remotePathUpload}")
    private String remotePathUpload;

    @Value("${sftp.queryPcacMerchantRiskInfoFileNamePrefix}")
    private String fileNamePrefix;

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(QueryPcacMerchantRiskReq queryPcacMerchantRiskReq) {
        ResultBean<Body> resultBean = new ResultBean<>();
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig);
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.Body();
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
        pushToPcac(queryPcacMerchantRiskReq, xml);
        return resultBean;
    }

    private void pushToPcac(QueryPcacMerchantRiskReq queryPcacMerchantRiskReq, String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        /*String post = "<Body>\n" +
                "    <RespInfo>\n" +
                "        <ResultStatus>已上报</ResultStatus>\n" +
                "        <ResultCode>01</ResultCode>\n" +
                "    </RespInfo>\n" +
                "</Body>";*/
        com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = (com.cmcc.paymentclean.entity.dto.pcac.resp.Body) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Body.class, post);
        log.info("pcac.ries.005 协会返回数据对象:{}", resBody);
        resBody.getRespInfo();
    }

    @Autowired
    private QueryPcacMerchantRiskInfoMapper queryPcacMerchantRiskInfoMapper;

    @Override
    public ResultBean<Page<QueryPcacMerchantRiskInfoResp>> pageLocalAssociatedRiskMerchantInfo(QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq) {
        ResultBean<Page<QueryPcacMerchantRiskInfoResp>> resultBean = new ResultBean();
        Page<QueryPcacMerchantRiskInfoResp> page = new Page<>(queryPcacMerchantRiskInfoReq.getPageNo(), queryPcacMerchantRiskInfoReq.getPageSize());
        Page<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoRespPage =  queryPcacMerchantRiskInfoMapper.pageLocalAssociatedRiskMerchantInfo(page, queryPcacMerchantRiskInfoReq);
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps = queryPcacMerchantRiskInfoRespPage.getRecords();
        if(!CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)){
            for(QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp:queryPcacMerchantRiskInfoResps){
                String validStatus = (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
                queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
                queryPcacMerchantRiskInfoResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
                queryPcacMerchantRiskInfoResp.setIsTransfer(IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
                queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(queryPcacMerchantRiskInfoRespPage);
        return resultBean;
    }

    @Override
    public ResultBean<Body> exportExcel() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        //查出未推送数据
        List<QueryPcacMerchantRiskInfoResp> queryPcacMerchantRiskInfoResps = queryPcacMerchantRiskInfoMapper.qryByPushStatus("0");
        if(CollectionUtils.isEmpty(queryPcacMerchantRiskInfoResps)){
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for(QueryPcacMerchantRiskInfoResp queryPcacMerchantRiskInfoResp:queryPcacMerchantRiskInfoResps){
            stringList.add(queryPcacMerchantRiskInfoResp.getQueryPcacMerchantRiskInfoId());
            String validStatus = (new Date().before(queryPcacMerchantRiskInfoResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
            queryPcacMerchantRiskInfoResp.setValidStatus(validStatus);
            queryPcacMerchantRiskInfoResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegDocType()));
            queryPcacMerchantRiskInfoResp.setIsTransfer(IsTransferEnum.getIsTransferDesc(queryPcacMerchantRiskInfoResp.getIsTransfer()));
            queryPcacMerchantRiskInfoResp.setLegControlCardType(LegDocTypeEnum.getLegDocTypeDesc(queryPcacMerchantRiskInfoResp.getLegControlCardType()));
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = fileNamePrefix+ System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(queryPcacMerchantRiskInfoResps,QueryPcacMerchantRiskInfoResp.class);
            FileOutputStream fos = new FileOutputStream(modDir + fileName);
            sxssfWorkbook.write(fos);
            if(sxssfWorkbook != null) {
                // dispose of temporary files backing this workbook on disk -> 处
                //     理SXSSFWorkbook导出excel时，产生的临时文件
                sxssfWorkbook.dispose();
            }
            if(fos != null) {
                fos.close();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        SFTPUtils sftpUtils = new SFTPUtils();
        //上传文件
        try {
            sftpUtils.connect();
            sftpUtils.uploadFile(remotePathUpload,fileName,modDir,fileName);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sftpUtils.disconnect();
        }

        //更新状态为推送
        queryPcacMerchantRiskInfoMapper.updatePushStatus(stringList);
        return resultBean;
    }
}

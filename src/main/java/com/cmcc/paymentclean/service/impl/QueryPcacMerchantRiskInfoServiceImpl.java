package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.IsTransferEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
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

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs) {
        return null;
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
        String fileName = "RiskMer_"+ System.currentTimeMillis() + ".xlsx";
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

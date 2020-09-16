package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.TxtFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lumma on 2020/9/14.
 */
@Slf4j
@Component
public class SftpPcacRiskInfo {

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;

    @Value("${sftp.modDir}")
    private String modDir;

    @Value("${sftp.remotePathUpload}")
    private String remotePathUpload;

    public void run()  {
        Date startDate = new Date();
        log.info("SftpPcacRiskInfoJob run start.....{}", startDate);
        //1.先取出加黑的所有名单数据
        List<PcacRiskInfoDTO> pcacRiskInfos = pcacRiskInfoService.listByIsBlack(IsBlackEnum.ISBLACKE_01.getCode());
        if(CollectionUtils.isEmpty(pcacRiskInfos)){
            return;
        }
        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = "Black_"+ System.currentTimeMillis() + ".xlsx";
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(pcacRiskInfos,PcacRiskInfoDTO.class);
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

        //上传文件
        SFTPUtils sftpUtils = new SFTPUtils();
        try {
            sftpUtils.connect();
            sftpUtils.uploadFile(remotePathUpload,fileName,modDir,fileName);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sftpUtils.disconnect();
        }
        Date endDate = new Date();
        log.info("SftpPcacRiskInfoJob run end.....{}", endDate);
    }

    private String setStr(String str,String msg,boolean flag){
        if(flag){
            str +=msg+"|";
        }
        else{
            str+=msg;
        }
        return str;
    }
}

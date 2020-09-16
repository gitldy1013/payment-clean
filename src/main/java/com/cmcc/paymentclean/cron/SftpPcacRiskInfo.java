package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
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

    @Autowired
    private SftpConfig sftpConfig;

    public void run() {
        Date startDate = new Date();
        log.info("SftpPcacRiskInfoJob run start.....{}", startDate);
        //1.先取出加黑的所有名单数据
        List<PcacRiskInfoDTO> pcacRiskInfos = pcacRiskInfoService.listByIsBlack(IsBlackEnum.ISBLACKE_01.getCode());
        if (CollectionUtils.isEmpty(pcacRiskInfos)) {
            return;
        }
        List<String> ids = new ArrayList<>();
        for (PcacRiskInfoDTO pcacRiskInfoDTO : pcacRiskInfos) {
            ids.add(pcacRiskInfoDTO.getPcacRiskInfoId());
        }
        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getQueryPcacMerchantRiskInfoFileNamePrefix() + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(pcacRiskInfos, PcacRiskInfoDTO.class);
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
        //更新状态为上报
        pcacRiskInfoService.updateStatus(ids);
        Date endDate = new Date();
        log.info("SftpPcacRiskInfoJob run end.....{}", endDate);
    }

    private String setStr(String str, String msg, boolean flag) {
        if (flag) {
            str += msg + "|";
        } else {
            str += msg;
        }
        return str;
    }
}

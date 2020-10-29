package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.PushListTypeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SysLanEnum;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.DateUtils;
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

/** Created by lumma on 2020/9/14. */
@Slf4j
@Component
public class SftpPcacRiskInfo {

  @Autowired private PcacRiskInfoService pcacRiskInfoService;

  @Autowired private SftpConfig sftpConfig;

  @Autowired private SysLanService sysLanService;

  public void run() {
    Date startDate = new Date();
    log.info("SftpPcacRiskInfoJob run start.....{}", startDate);
    // 1.先取出加黑的所有名单数据
    List<PcacRiskInfoDTO> pcacRiskInfos = pcacRiskInfoService.listAll();
    if (CollectionUtils.isEmpty(pcacRiskInfos)) {
      return;
    }
    List<String> ids = new ArrayList<>();
    for (PcacRiskInfoDTO pcacRiskInfoDTO : pcacRiskInfos) {
      pcacRiskInfoDTO.setDocType(DocTypeEnum.getDocTypeDesc(pcacRiskInfoDTO.getDocType()));
      pcacRiskInfoDTO.setLegDocType(
          LegDocTypeEnum.getLegDocTypeDesc(pcacRiskInfoDTO.getLegDocType()));
      pcacRiskInfoDTO.setLevel(LevelCodeEnum.getLevelDesc(pcacRiskInfoDTO.getLevel()));
      pcacRiskInfoDTO.setRiskType(RiskTypeEnum.getRiskTypeDesc(pcacRiskInfoDTO.getRiskType()));
      pcacRiskInfoDTO.setCusType(CusTypeEnum.getCusTypeEnum(pcacRiskInfoDTO.getRiskType()));
      pcacRiskInfoDTO.setOccurarea(SysLanEnum.getSysLanEnumDesc(pcacRiskInfoDTO.getOccurarea()));
      pcacRiskInfoDTO.setPushListType(
          PushListTypeEnum.getPushListTypeDesc(pcacRiskInfoDTO.getPushListType()));
      pcacRiskInfoDTO.setValidStatus(
          (new Date()
                  .before(
                      DateUtils.stringToDate(
                          pcacRiskInfoDTO.getValidDate(), DateUtils.FORMAT_DATE)))
              ? CommonConst.VALIDSTATUS_01
              : CommonConst.VALIDSTATUS_02);
      ids.add(pcacRiskInfoDTO.getPcacRiskInfoId());
    }

    // 生成excel文件
    ExcelUtils excelUtils = new ExcelUtils();
    String fileName =
        sftpConfig.getBusinessInfoFileNamePrefix()
            + DateUtils.curDateString()
            + CommonConst.SFTP_FILE_NAME_SUFFIX;
    // 写本地文件
    try {
      // 文件名
      SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(pcacRiskInfos, PcacRiskInfoDTO.class);
      FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
      sxssfWorkbook.write(fos);
      sxssfWorkbook.dispose();
      fos.close();
      // 上传文件
      boolean uploadFlag =
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
      if (uploadFlag) {
        // 更新状态为已推送
        pcacRiskInfoService.updatePushStatus(ids);
        log.info("SftpPcacRiskInfoJob上传成功 run end.....{}", new Date());
      } else {
        log.info("SftpPcacRiskInfoJob上传失败 run end.....{}", new Date());
      }
    } catch (Exception e) {
      log.error("异常:" + e);
    }
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

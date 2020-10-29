package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.TxtFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    List<String> fileList = new ArrayList<>();
    //        fileList.add("推送名单类型|推送日期|商户名称|商户简称|法人证件类型|法人证件号码|法定代表人姓名|法定代表人类型|法定代表人（负责人）
    // 证件号码|风险信息等级|" +
    //                "风险类型|有效期|有效性|商户类型|风险事件发生地域|银行结算账户|网址|商户注册号");

    for (PcacRiskInfoDTO pcacRiskInfoDTO : pcacRiskInfos) {
      String str = "";
      str = setStr(str, pcacRiskInfoDTO.getPushListType(), true);
      str = setStr(str, pcacRiskInfoDTO.getUpDate(), true);
      str = setStr(str, pcacRiskInfoDTO.getRegName(), true);
      str = setStr(str, pcacRiskInfoDTO.getCusName(), true);
      str = setStr(str, pcacRiskInfoDTO.getDocType(), true);
      str = setStr(str, pcacRiskInfoDTO.getDocCode(), true);
      str = setStr(str, pcacRiskInfoDTO.getLegDocName(), true);
      str = setStr(str, pcacRiskInfoDTO.getLegDocType(), true);
      str = setStr(str, pcacRiskInfoDTO.getLegDocCode(), true);
      str = setStr(str, pcacRiskInfoDTO.getLevel(), true);
      str = setStr(str, pcacRiskInfoDTO.getRiskType(), true);
      str = setStr(str, pcacRiskInfoDTO.getValidDate(), true);
      str = setStr(str, pcacRiskInfoDTO.getValidStatus(), true);
      str = setStr(str, pcacRiskInfoDTO.getCusType(), true);
      str = setStr(str, pcacRiskInfoDTO.getOccurarea(), true);
      str = setStr(str, pcacRiskInfoDTO.getBankNo(), true);
      str = setStr(str, pcacRiskInfoDTO.getUrl(), true);
      str = setStr(str, pcacRiskInfoDTO.getRegisteredCode(), false);
      fileList.add(str);
    }
    List<String> ids = new ArrayList<>();
    for (PcacRiskInfoDTO pcacRiskInfoDTO : pcacRiskInfos) {
      ids.add(pcacRiskInfoDTO.getPcacRiskInfoId());
    }

    // 生成txt文件
    String fileName =
        sftpConfig.getPcacRiskInfoFileNamePrefix()
            + DateUtils.curDateString()
            + CommonConst.SFTP_TXT_FILE_NAME_SUFFIX;
    // 写本地文件
    try {
      TxtFileUtil.writeFileContext(fileList, sftpConfig.getModDir(),fileName);
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
      // 更新状态为已推送
      pcacRiskInfoService.updatePushStatus(ids);
      Date endDate = new Date();
      log.info("SftpPcacRiskInfoJob run end.....{}", endDate);
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

package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;
import com.cmcc.paymentclean.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 使用quartz框架 项目中所有的定时任务统一放这里处理 */
@Component
@EnableScheduling
@Async // 启动多线程
@Slf4j
public class ScheduledTask {

  @Autowired private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

  @Autowired private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

  @Autowired private PcacMerchantRiskSubmitInfoService pcacMerchantRiskSubmitInfoService;

  @Autowired private SftpPcacRiskInfo sftpPcacRiskInfo;

  @Autowired private BusinessInfoService businessInfoService;
  @Autowired
  private PcacRiskInfoService pcacRiskInfoService;

  /** 上报个人风险信息 */
  @Scheduled(cron = "0 0 6 ? * *")
  public void submitPcacPersonRiskInfoJob() {
    log.info("每天6:00执行上报个人风险信息到清算协会任务==START==");
    pcacPersonRiskSubmitInfoService.submit();
    log.info("每天6:00执行上报个人风险信息到清算协会任务==END==");
  }

  /** 上报企业风险信息 */
  // @Scheduled(cron = "0 0 23 ? * *")
  public void runRiskEnterpriseAndPush() {
    log.info("每天23:00执行上报企业风险信息到清算协会任务==START==");
    pcacEnterpriseRiskSubmitInfoService.queryRiskEnterpriseAndPushPcac();
    log.info("每天23:00执行上报企业风险信息到清算协会任务==END==");
  }

  /** 上报商户风险信息 */
  @Scheduled(cron = "0 0 6 ? * *")
  public void runRiskMerchantAndPush() {
    log.info("每天6:00上报商户风险信息==START==");
    pcacMerchantRiskSubmitInfoService.queryRiskMerchantAndPushPcac();
    log.info("每天6:00上报商户风险信息==END==");
  }

  @Scheduled(cron = "0 0 11 ? * *")
  public void SftpPcacRiskInfoJob() {
    log.info("执行协会风险商户黑名单推送SFTP任务==START==");
    sftpPcacRiskInfo.run();
    log.info("执行协会风险商户黑名单推送SFTP任务==END==");
  }

  @Scheduled(cron = "5 0 11 ? * *")
  public void SftpBusinessInfoJob() {
    log.info("执行企业商户信息表推送SFTP任务==START==");
    businessInfoService.exportExcel();
    log.info("执行企业商户信息表推送SFTP任务==END==");
  }

  /** 上报企业商户信息 */
  @Scheduled(cron = "0 0 18 1 * ?")
  public void runBusinessInfoAndPushPcac() {
    log.info("每月1号8点上报企业商户信息==START==");
    businessInfoService.queryBusinessInfoAndPushPcac();
    log.info("每月1号8点上报企业商户信息==END==");
  }

  /** 补发黑名单信息*/
  @Scheduled(cron = "0 0 10 ? * *")
  public void runReissueBlackInfo() {
    log.info("每天10点申请补发前一天黑名单数据==START==");
    ReissueRiskInfoReq reissueRiskInfoReq = new ReissueRiskInfoReq();
    String dateStr = getBeforeDate();
    reissueRiskInfoReq.setRiskType("01");
    reissueRiskInfoReq.setReqDate(dateStr);
    reissueRiskInfoReq.setReqDateEnd(dateStr);
    ResultBean<Body> resultBean = pcacRiskInfoService.reissueRiskInfo(reissueRiskInfoReq);
    log.info("申请补发黑名单数据结果：{}",resultBean.getResMsg());
    log.info("每天10点申请补发前一天黑名单数据==END==");
  }

  private  String getBeforeDate() {
    String pattern = "yyyy-MM-dd";
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, -1); //得到前一天
    Date date = calendar.getTime();
    DateFormat df = new SimpleDateFormat(pattern);
    String dateStr = df.format(date);
    return dateStr;
  }

  /** 补发风险提示信息*/
  @Scheduled(cron = "0 10 17 ? * *")
  public void runReissueRiskInfo() {
    log.info("每天17点10分申请补发前一天风险提示信息数据==START==");
    ReissueRiskInfoReq reissueRiskInfoReq = new ReissueRiskInfoReq();
    String dateStr = getBeforeDate();
    reissueRiskInfoReq.setRiskType("02");
    reissueRiskInfoReq.setReqDate(dateStr);
    reissueRiskInfoReq.setReqDateEnd(dateStr);
    ResultBean<Body> resultBean = pcacRiskInfoService.reissueRiskInfo(reissueRiskInfoReq);
    log.info("申请补发风险提示信息数据结果：{}",resultBean.getResMsg());
    log.info("每天17点10分申请补发前一天风险提示信息数据==END==");
  }


}

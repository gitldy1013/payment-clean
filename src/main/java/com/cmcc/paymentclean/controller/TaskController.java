package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.cron.SftpPcacRiskInfo;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
  @Autowired private PcacPersonRiskSubmitInfoService pcacPersonRiskSubmitInfoService;

  @Autowired private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

  @Autowired private PcacMerchantRiskSubmitInfoService pcacMerchantRiskSubmitInfoService;

  @Autowired private SftpPcacRiskInfo sftpPcacRiskInfo;

  @Autowired private BusinessInfoService businessInfoService;

  /** 上报个人风险信息 */
  @ApiOperation(value = "上报个人风险信息", notes = "上报个人风险信息")
  @RequestMapping(value = "/submitPcacPersonRiskInfoJob", method = RequestMethod.GET)
  public void submitPcacPersonRiskInfoJob() {
    log.info("每天23:00执行上报个人风险信息到清算协会任务==START==");
    pcacPersonRiskSubmitInfoService.submit();
    log.info("每天23:00执行上报个人风险信息到清算协会任务==END==");
  }

  /** 上报企业风险信息 */
  @ApiOperation(value = "上报企业风险信息", notes = "上报企业风险信息")
  @RequestMapping(value = "/runRiskEnterpriseAndPush", method = RequestMethod.GET)
  public void runRiskEnterpriseAndPush() {
    log.info("每天23:00执行上报企业风险信息到清算协会任务==START==");
    pcacEnterpriseRiskSubmitInfoService.queryRiskEnterpriseAndPushPcac();
    log.info("每天23:00执行上报企业风险信息到清算协会任务==END==");
  }

  /** 上报商户风险信息 */
  @ApiOperation(value = "上报商户风险信息", notes = "上报商户风险信息")
  @RequestMapping(value = "/runRiskMerchantAndPush", method = RequestMethod.GET)
  public void runRiskMerchantAndPush() {
    log.info("每天23:00上报商户风险信息==START==");
    pcacMerchantRiskSubmitInfoService.queryRiskMerchantAndPushPcac();
    log.info("每天23:00上报商户风险信息==END==");
  }

  /** 执行协会风险商户黑名单推送SFTP任务 */
  @ApiOperation(value = "执行协会风险商户黑名单推送SFTP任务", notes = "执行协会风险商户黑名单推送SFTP任务")
  @RequestMapping(value = "/SftpPcacRiskInfoJob", method = RequestMethod.GET)
  public void SftpPcacRiskInfoJob() {
    log.info("执行协会风险商户黑名单推送SFTP任务==START==");
    sftpPcacRiskInfo.run();
    log.info("执行协会风险商户黑名单推送SFTP任务==END==");
  }

  /** 执行企业商户信息表推送SFTP任务 */
  @ApiOperation(value = "执行企业商户信息表推送SFTP任务", notes = "执行企业商户信息表推送SFTP任务")
  @RequestMapping(value = "/SftpBusinessInfoJob", method = RequestMethod.GET)
  public void SftpBusinessInfoJob() {
    log.info("执行企业商户信息表推送SFTP任务==START==");
    businessInfoService.exportExcel();
    log.info("执行企业商户信息表推送SFTP任务==END==");
  }

  /** 上报企业商户信息 */
  @ApiOperation(value = "上报企业商户信息", notes = "上报企业商户信息")
  @RequestMapping(value = "/runBusinessInfoAndPushPcac", method = RequestMethod.GET)
  public void runBusinessInfoAndPushPcac() {
    log.info("每月1号8点上报企业商户信息==START==");
    businessInfoService.queryBusinessInfoAndPushPcac();
    log.info("每月1号8点上报企业商户信息==END==");
  }
}

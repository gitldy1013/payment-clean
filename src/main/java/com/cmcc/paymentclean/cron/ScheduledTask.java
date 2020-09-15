package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 使用quartz框架
 * 项目中所有的定时任务统一放这里处理
 */
@Component
@EnableScheduling
@Async//启动多线程
@Slf4j
public class ScheduledTask {

    @Autowired
    private SubmitPcacPersonRiskInfo submitPcacPersonRiskInfo;

    @Autowired
    private PcacEnterpriseRiskSubmitInfoService pcacEnterpriseRiskSubmitInfoService;

    @Autowired
    private PcacMerchantRiskSubmitInfoService pcacMerchantRiskSubmitInfoService;

    @Autowired
    private SftpPcacRiskInfo sftpPcacRiskInfo;

    /**
     * 上报个人风险信息
     */
    @Scheduled(cron = "0 0 23 ? * *")
    public void  submitPcacPersonRiskInfoJob(){
        log.info("每天23:00执行上报个人风险信息到清算协会任务==START==");
        submitPcacPersonRiskInfo.submit();
        log.info("每天23:00执行上报个人风险信息到清算协会任务==END==");
    }

    /**
     * 上报企业风险信息
     */
    @Scheduled(cron = "0 0 23 ? * *")
    public void  runRiskEnterpriseAndPush(){
        log.info("每天23:00执行上报企业风险信息到清算协会任务==START==");
        pcacEnterpriseRiskSubmitInfoService.queryRiskEnterpriseAndPushPcac();
        log.info("每天23:00执行上报企业风险信息到清算协会任务==END==");
    }

    /**
     * 上报商户风险信息
     */
    @Scheduled(cron = "0 0 23 ? * *")
    public void runRiskMerchantAndPush(){
        log.info("每天23:00上报商户风险信息==START==");
        pcacMerchantRiskSubmitInfoService.queryRiskMerchantAndPushPcac();
        log.info("每天23:00上报商户风险信息==END==");
    }

    @Scheduled(cron = "0 0 8 ? * *")
    public void  SftpPcacRiskInfoJob(){
        log.info("执行协会风险商户黑名单推送SFTP任务==START==");
        sftpPcacRiskInfo.run();
        log.info("执行协会风险商户黑名单推送SFTP任务==END==");
    }

}

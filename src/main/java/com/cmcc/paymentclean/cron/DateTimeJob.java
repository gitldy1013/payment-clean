/*
package com.cmcc.paymentclean.cron;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

*/
/**
 * @author zhaolei    extends QuartzJobBean
 * @date 2020-09-10 21:18
 *//*

public class DateJob  implements Job {
  */
/*  @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取JobDetail中关联的数据
      *//*
*/
/*  String msg = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("msg");
        System.out.println("current time :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "---" + msg);
*//*
*/
/*
        System.out.println("定时任务执行内容。。。。");
    }*//*


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务执行内容。。。。");
    }

}
*/

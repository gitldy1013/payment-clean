/*
package com.cmcc.paymentclean.config;

import com.cmcc.paymentclean.cron.DateTimeJob;
import com.cmcc.paymentclean.cron.ScheduledTask;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

*/
/**
 * @author zhaolei
 * @date 2020-09-10 21:15
 *//*

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printTimeJobDetail() {
        return JobBuilder.newJob(DateTimeJob.class)//PrintTimeJob我们的业务类
                .withIdentity("DateTimeJob")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello Quartz")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }


    //=========================集群方式============================

    */
/**
     * 配置任务
     *
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     *//*

    @Bean(name = "reptilianJob")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTask quartzTask) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(false);
        // 设置任务的名字
        jobDetail.setName("MyJob");
        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("MyJobGroup");
        // 需要执行的对象
        jobDetail.setTargetObject(quartzTask);
        //执行QuartzTask类中的需要执行方法
        jobDetail.setTargetMethod("exec");
        return jobDetail;
    }

    */
/**
     * 定时触发器
     *
     * @param reptilianJob 任务
     * @return
     *//*

    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail reptilianJob) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(reptilianJob);
        //cron表达式，每1分钟执行一次
        tigger.setCronExpression("0 0/1 * * * ?");
        tigger.setName("reptilianTrigger");
        return tigger;
    }

    */
/**
     * 调度工厂
     *
     * @param jobTrigger 触发器
     * @return
     *//*

    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);
        // 注册触发器
        factoryBean.setTriggers(jobTrigger);
        return factoryBean;
    }
}
*/

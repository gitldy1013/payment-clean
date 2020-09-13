package com.cmcc.paymentclean.cron;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

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

    /**
     * cron：通过表达式来配置任务执行时间
     * 默认是fixedDelay 上一次执行完毕时间后执行下一轮
     * 一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void runOne() throws InterruptedException {
        System.out.println("run方法每隔5秒执行一次");
        System.out.println(Thread.currentThread().getName() + "=====>>>>>使用cron One  {}" + (System.currentTimeMillis() / 1000));
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void runSelf() throws InterruptedException {
        System.out.println("run方法每隔5秒执行一次");
        System.out.println(Thread.currentThread().getName() + "=====>>>>>使用cron Self {}" + (System.currentTimeMillis() / 1000));
    }

    //@Scheduled(cron = "0 55 13 ? * *")
    public void scheduled() {
        //“？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
        //当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
        System.out.println("报时：现在时间13点55分");
    }

    /**
     * fixedRate：定义一个按一定频率执行的定时任务
     */
    //@Scheduled(fixedRate = 5000)
    public void run1() throws InterruptedException {
        //fixedRate是从上次开始执行算
        System.out.println("run1方法：上一次开始执行时间点之后5秒再执行");
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName() + "=====>>>>>使用fixedRate  {}" + (System.currentTimeMillis() / 1000));
    }

    /**
     * fixedDelay：定义一个按一定频率执行的定时任务
     */
    //@Scheduled(fixedDelay = 5000)
    public void run2() throws InterruptedException {
        //fixedDelay是从上次执行完毕算
        System.out.println("run2方法：上一次执行完毕时间点之后5秒再执行");
        Thread.sleep(7000);
        System.out.println(Thread.currentThread().getName() + "=====>>>>>使用fixedDelay  {}" + (System.currentTimeMillis() / 1000));
    }

    /**
     * fixedDelay：定义一个按一定频率执行的定时任务，与上面fixedRate不同的是，
     * 该属性可以配合initialDelay， 定义该任务延迟执行时间。
     */
    //@Scheduled(initialDelay = 2000, fixedDelay = 5000)
    public void run3() {
        System.out.println("run3方法：第一次延迟2秒后执行，之后按fixedDelay的规则每5秒执行一次");
        System.out.println(Thread.currentThread().getName() + "=====>>>>>使用initialDelay  {}" + (System.currentTimeMillis() / 1000));
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void  submitPcacPersonRiskInfoJob(){
        log.info("---------执行上报个人风险信息到清算协会任务--------");
        submitPcacPersonRiskInfo.submit();
    }

}

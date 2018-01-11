package cn.wanlinus.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanli
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例,将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob")
                .usingJobData("message", "Hello myJob1")
                .usingJobData("floatJobValue", 3.14F)
                .build();
        System.out.println("jobDetail's name: " + jobDetail.getKey().getName());
        System.out.println("jobDetail's group: " + jobDetail.getKey().getGroup());
        System.out.println("jobDetail's jobClass: " + jobDetail.getJobClass().getName());

        //创建一个Trigger实例, 定义该Job立即执行,并且每隔2秒重复执行
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .usingJobData("message", "hello myTrigger1")
                .usingJobData("doubleTriggerValue", 2.0D)
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2).repeatForever())
                .build();
        //创建Schedule实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        //打印当前时间 格式是为2018-1-4 20:30:09
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time is:" + sdf.format(date));

        scheduler.scheduleJob(jobDetail, trigger);
    }
}

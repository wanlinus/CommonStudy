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
        Date date = new Date();
        //打印当前时间 格式是为2018-1-4 20:30:09
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time is:" + sdf.format(date));
        //创建一个JobDetail实例,将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob")
                .build();
//        每秒钟触发一次任务
        CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 1 ? * * 2018"))
                .build();
        //1. 2018年内每天10点15分触发一次
        //      0 15 10 ? * * 2018
        //2. 每天的14点整至14点59分55秒触发一次
        //      0/5 * 14,18 * * ?
        //3. 每月周一至周五的十点15分触发一次
        //4. 每月最后一天的10点15分触发一次
        //5. 每月第三个周五的10点15触发一次

        //创建Schedule实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}

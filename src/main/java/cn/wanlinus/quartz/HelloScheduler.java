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
        //距离当前时间4秒后执行且仅执行一次任务
        date.setTime(date.getTime() + 4000L);
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))//循环
                .build();
        //创建Schedule实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}

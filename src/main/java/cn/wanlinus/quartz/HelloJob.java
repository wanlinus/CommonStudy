package cn.wanlinus.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wanli
 */
public class HelloJob implements Job {
    private String message;
    private Float floatJobValue;
    private Double doubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前的执行时间,格式为2018-1-4 20:15:14
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time is:" + sdf.format(date));
        //编写具体的业务逻辑
        //打印传入参数
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("My job name and group are: " + jobKey.getName() + ":"
                + jobKey.getGroup() + ":");
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("My trigger name and group are:" + triggerKey.getName() + ":"
                + triggerKey.getGroup());
        System.out.println("floatJobValue is:" + floatJobValue);
        System.out.println("message is: " + message);
        System.out.println("triggerDoubleValue is: " + doubleTriggerValue);
    }
}

package cn.wanlinus.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * Job 实现业务逻辑的任务接口
 * 只有一个execute方法 执行业务逻辑
 * JobExecutionContext Job上下文
 * <p>
 * Job在Quartz中的声明周期
 * 每次调度器执行job时, 他在调用execute方法前会创建一个新的job实例
 * 当调用完成后,关联的job对象实例会被释放,释放的实例会被垃圾回收机制回收
 * <p>
 * JobDetail
 * 为Job实例提供了许多设置属性,以及JobDataMap成员变量属性
 * 他用来存储特定Job实例的状态信息,调度器需要借助JobDetail对象来添加Job实例
 * name     名称(必须)
 * group    组(默认DEFAULT)
 * jobClass 传入的Job类(必须)
 * jobDataMap   传参数
 *
 * @author wanli
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //阿银当前的执行时间,格式为2018-1-4 20:15:14
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time is:" + sdf.format(date));
        //编写具体的业务逻辑
        System.out.println("Hello World");
    }
}

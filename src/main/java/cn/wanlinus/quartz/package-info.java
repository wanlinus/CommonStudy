/**
 * <p>
 * Job
 * 实现业务逻辑的任务接口
 * 只有一个execute方法 执行业务逻辑
 * <p>
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
 * JobExecutionContext
 * 1. 当Schedule调用一个Job,就会将JobExecutionContext传递给Job的execute()方法
 * 2. Job能通过JobExecutionContext对象访问到Quartz运行时候的环境以及Job本身的明细数据
 * <p>
 * JobDataMap
 * 1. 在进行任务调度时JobDataMap存储在JobExecutionContext中,非常方便获取
 * 2. JobDataMap可以用来装载任何可序列化的数据对象,当job实例对象被执行时这些参数对象会传递给他
 * 3. JobDataMap事项了JDK的Map接口, 并且添加了一些非常方便的方法用来存取基本数据类型
 * <p>
 * Trigger
 * Quartz的触发器同来告诉调度程序作业什么时候触发
 * 即Trigger对象是用来触发执行Job的
 * 通用属性
 * JobKey:     表示Job实例的标识, 触发器被触发时,该指定的Job实例会执行
 * <p>
 * StartTime:  表示触发器的时间表首次被触发的时间 他的值的类型是Java.util.Date
 * <p>
 * EndTime:     指定触发器的不在触发的时间 他的值的类型是Java.util.Date
 * <p>
 * SimpleTrigger的作用
 * 在一个指定的时间段内执行一次作用任务 或是在指定的时间即那个内多次执行
 * 注意:
 * 重复次数可以为0,正整数或是SimpleTrigger.REPEAT_INDEFINITELY常量值
 * 重复的执行间隔必须为0或长整数, 一旦被执行了endTime参数,那么它会覆盖重复次数参数的效果
 * <p>
 * CronTrigger的作用
 * 基于日历的作调度器
 * 而不是想SimpleTrigger那样精确指定时间间隔时间,比SimpleTrigger更常见
 *
 * @author wanli
 */
package cn.wanlinus.quartz;
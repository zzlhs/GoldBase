package com.zzl.es.quartz;

import org.quartz.JobDataMap;

/**
 * @author lvgo
 * @version 1.0
 * @package com.erayt.xsds.common.schedule.core
 * @description: 触发器标识基础抽象类
 * @date 2019/9/19 14:11
 */
public abstract class AbstractTrigger {

    /**
     * 获取触发器名称
     *
     * @return 触发器名称
     */
    public abstract String getTriggerName();

    /**
     * 获取触发器组名称
     *
     * @return 触发器组名称
     */
    public abstract String getTriggerGroupName();

    /**
     * 获取cron表达式 执行时机
     *
     * @return cron表达式
     */
    public abstract String getCron();

    /**
     * 获取任务名称
     *
     * @return 任务名称
     */
    public abstract String getJobName();

    /**
     * 获取任务组名称
     *
     * @return 任务组名称
     */
    public abstract String getJobGroupName();

    /**
     * 获取任务执行所需参数, 假如需要的话
     *
     * @return 任务执行所需参数
     */
    public abstract JobDataMap getParam();
}


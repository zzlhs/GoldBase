package com.zzl.es.quartz;

import org.quartz.JobDataMap;

import java.util.Map;

/**
 * @author lvgo
 * @version 1.0
 * @package com.erayt.xsds.common.schedule.core
 * @description: xpad基础任务新增触发器类 通过 Builder 方法创建
 * @date 2019/9/19 14:01
 */
public class XsdsJobTrigger extends AbstractTrigger {

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务组名称
     */
    private String jobGroupName;
    /**
     * 触发器名称
     */
    private String triggerName;
    /**
     * 触发器组名称
     */
    private String triggerGroupName;
    /**
     * cron 表达式
     */
    private String cron;
    /**
     * 参数
     */
    private JobDataMap param = new JobDataMap();

    /**
     * 建议使用builder创建xsdsJOb触发器
     */
    private XsdsJobTrigger() {
    }

    @Override
    public String getJobName() {
        return jobName;
    }

    @Override
    public String getJobGroupName() {
        return jobGroupName;
    }

    @Override
    public String getTriggerName() {
        return triggerName;
    }

    @Override
    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    @Override
    public String getCron() {
        return cron;
    }

    @Override
    public JobDataMap getParam() {
        return param;
    }

    public static class Builder extends XsdsJobTrigger {
        public Builder jobName(String jobName) {
            super.jobName = jobName;
            return this;
        }

        public Builder jobGroupName(String jobGroupName) {
            super.jobGroupName = jobGroupName;
            return this;
        }

        public Builder triggerName(String triggerName) {
            super.triggerName = triggerName;
            return this;
        }

        public Builder triggerGroupName(String triggerGroupName) {
            super.triggerGroupName = triggerGroupName;
            return this;
        }

        public Builder cron(String cron) {
            super.cron = cron;
            return this;
        }

        public Builder params(Map<String, Object> param) {
            super.param = new JobDataMap(param);
            return this;
        }

        public Builder params(String key, Object value) {
            super.param.put(key, value);
            return this;
        }

        public Builder build() {
            return this;
        }
    }
}



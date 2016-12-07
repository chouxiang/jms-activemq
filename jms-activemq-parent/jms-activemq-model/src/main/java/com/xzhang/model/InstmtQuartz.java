package com.xzhang.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class InstmtQuartz {

    /**是否禁用:0禁用*/
    public static final String ENABLE_STATUS_NO = "0";
    /**是否禁用:1启用*/
    public static final String ENABLE_STATUS_YES = "1";

    /**任务状态:0关闭*/
    public static final String TRIGGER_STATUS_CLOSE = "0";
    /**任务状态:1运行中*/
    public static final String TRIGGER_STATUS_RUN = "1";
    /**任务状态:2暂停*/
    public static final String TRIGGER_STATUS_STOP = "2";

    private String id;
    private String jobgroup;//任务组
    private String triggergroup;//触发器组
    private String jobname;//任务名
    private String triggername;//触发器名
    private String classname;//执行代码的类名
    private String enablestatus = InstmtQuartz.ENABLE_STATUS_YES;//是否禁用:0禁用;1启用
    private String triggercron;//触发器类型(时间) */5 * * * * ?
    private String triggerstatus = InstmtQuartz.TRIGGER_STATUS_RUN;//任务状态:0关闭;1运行中;2暂停;
    private Date createtime;//创建时间
    private Date updatetime;//更新时间
    private String descript;//描述（例如‘推送账单、发送短信等’）


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getJobgroup() {
        return jobgroup;
    }

    public void setJobgroup(String jobgroup) {
        this.jobgroup = jobgroup;
    }

    public String getTriggergroup() {
        return triggergroup;
    }

    public void setTriggergroup(String triggergroup) {
        this.triggergroup = triggergroup;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getTriggername() {
        return triggername;
    }

    public void setTriggername(String triggername) {
        this.triggername = triggername;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getEnablestatus() {
        return enablestatus;
    }

    public void setEnablestatus(String enablestatus) {
        this.enablestatus = enablestatus;
    }

    public String getTriggercron() {
        return triggercron;
    }

    public void setTriggercron(String triggercron) {
        this.triggercron = triggercron;
    }

    public String getTriggerstatus() {
        return triggerstatus;
    }

    public void setTriggerstatus(String triggerstatus) {
        this.triggerstatus = triggerstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}

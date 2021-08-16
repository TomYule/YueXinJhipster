package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 定时任务调度日志表 entity.\n@author haiming
 */
@ApiModel(description = "定时任务调度日志表 entity.\n@author haiming")
@Entity
@Table(name = "sys_job_log")
public class SysJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_group")
    private String jobGroup;

    @Column(name = "invoke_target")
    private String invokeTarget;

    @Column(name = "status")
    private String status;

    @Column(name = "exception_info")
    private String exceptionInfo;

    @Column(name = "create_time")
    private LocalDate createTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public SysJobLog jobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public SysJobLog jobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
        return this;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public SysJobLog invokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
        return this;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getStatus() {
        return status;
    }

    public SysJobLog status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public SysJobLog exceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
        return this;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysJobLog createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysJobLog)) {
            return false;
        }
        return id != null && id.equals(((SysJobLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysJobLog{" +
            "id=" + getId() +
            ", jobName='" + getJobName() + "'" +
            ", jobGroup='" + getJobGroup() + "'" +
            ", invokeTarget='" + getInvokeTarget() + "'" +
            ", status='" + getStatus() + "'" +
            ", exceptionInfo='" + getExceptionInfo() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}

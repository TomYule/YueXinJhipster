package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 操作日志记录 entity.\n@author haiming
 */
@ApiModel(description = "操作日志记录 entity.\n@author haiming")
@Entity
@Table(name = "sys_oper_log")
public class SysOperLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "business_type")
    private Integer businessType;

    @Column(name = "method")
    private String method;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "operator_type")
    private Integer operatorType;

    @Column(name = "oper_name")
    private String operName;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "oper_url")
    private String operUrl;

    @Column(name = "oper_ip")
    private String operIp;

    @Column(name = "oper_location")
    private String operLocation;

    @Lob
    @Column(name = "oper_param")
    private String operParam;

    @Lob
    @Column(name = "json_result")
    private String jsonResult;

    @Column(name = "status")
    private Integer status;

    @Lob
    @Column(name = "error_msg")
    private String errorMsg;

    @Column(name = "oper_time")
    private LocalDate operTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public SysOperLog title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public SysOperLog businessType(Integer businessType) {
        this.businessType = businessType;
        return this;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public SysOperLog method(String method) {
        this.method = method;
        return this;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public SysOperLog requestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public SysOperLog operatorType(Integer operatorType) {
        this.operatorType = operatorType;
        return this;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public SysOperLog operName(String operName) {
        this.operName = operName;
        return this;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public SysOperLog deptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public SysOperLog operUrl(String operUrl) {
        this.operUrl = operUrl;
        return this;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public SysOperLog operIp(String operIp) {
        this.operIp = operIp;
        return this;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public SysOperLog operLocation(String operLocation) {
        this.operLocation = operLocation;
        return this;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public SysOperLog operParam(String operParam) {
        this.operParam = operParam;
        return this;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public SysOperLog jsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
        return this;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public SysOperLog status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public SysOperLog errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LocalDate getOperTime() {
        return operTime;
    }

    public SysOperLog operTime(LocalDate operTime) {
        this.operTime = operTime;
        return this;
    }

    public void setOperTime(LocalDate operTime) {
        this.operTime = operTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysOperLog)) {
            return false;
        }
        return id != null && id.equals(((SysOperLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysOperLog{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", businessType=" + getBusinessType() +
            ", method='" + getMethod() + "'" +
            ", requestMethod='" + getRequestMethod() + "'" +
            ", operatorType=" + getOperatorType() +
            ", operName='" + getOperName() + "'" +
            ", deptName='" + getDeptName() + "'" +
            ", operUrl='" + getOperUrl() + "'" +
            ", operIp='" + getOperIp() + "'" +
            ", operLocation='" + getOperLocation() + "'" +
            ", operParam='" + getOperParam() + "'" +
            ", jsonResult='" + getJsonResult() + "'" +
            ", status=" + getStatus() +
            ", errorMsg='" + getErrorMsg() + "'" +
            ", operTime='" + getOperTime() + "'" +
            "}";
    }
}

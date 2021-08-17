package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 参数配置表 entity.\n@author haiming
 */
@ApiModel(description = "参数配置表 entity.\n@author haiming")
@Entity
@Table(name = "sys_config")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "config_name", nullable = false)
    private String configName;

    @Column(name = "config_key")
    private String configKey;

    @Column(name = "config_value")
    private String configValue;

    @Column(name = "config_type")
    private String configType;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private LocalDate createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "up_local_date")
    private LocalDate upLocalDate;

    @Lob
    @Column(name = "remark")
    private String remark;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public SysConfig configName(String configName) {
        this.configName = configName;
        return this;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigKey() {
        return configKey;
    }

    public SysConfig configKey(String configKey) {
        this.configKey = configKey;
        return this;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public SysConfig configValue(String configValue) {
        this.configValue = configValue;
        return this;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigType() {
        return configType;
    }

    public SysConfig configType(String configType) {
        this.configType = configType;
        return this;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysConfig createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysConfig createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysConfig updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysConfig upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysConfig remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysConfig)) {
            return false;
        }
        return id != null && id.equals(((SysConfig) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysConfig{" +
            "id=" + getId() +
            ", configName='" + getConfigName() + "'" +
            ", configKey='" + getConfigKey() + "'" +
            ", configValue='" + getConfigValue() + "'" +
            ", configType='" + getConfigType() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

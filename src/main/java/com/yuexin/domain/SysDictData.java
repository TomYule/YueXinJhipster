package com.yuexin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 字典数据表 entity.\n@author haiming
 */
@ApiModel(description = "字典数据表 entity.\n@author haiming")
@Entity
@Table(name = "sys_dict_data")
public class SysDictData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dict_sort")
    private String dictSort;

    @Column(name = "dict_label")
    private String dictLabel;

    @Column(name = "dict_value")
    private String dictValue;

    @Column(name = "dict_type")
    private String dictType;

    @Column(name = "css_class")
    private String cssClass;

    @Column(name = "list_class")
    private String listClass;

    @Column(name = "is_default")
    private String isDefault;

    @Column(name = "status")
    private String status;

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

    @ManyToOne
    @JsonIgnoreProperties(value = "dictTypes", allowSetters = true)
    private SysDictType sysDictType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictSort() {
        return dictSort;
    }

    public SysDictData dictSort(String dictSort) {
        this.dictSort = dictSort;
        return this;
    }

    public void setDictSort(String dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public SysDictData dictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
        return this;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public SysDictData dictValue(String dictValue) {
        this.dictValue = dictValue;
        return this;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public SysDictData dictType(String dictType) {
        this.dictType = dictType;
        return this;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public SysDictData cssClass(String cssClass) {
        this.cssClass = cssClass;
        return this;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public SysDictData listClass(String listClass) {
        this.listClass = listClass;
        return this;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public SysDictData isDefault(String isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public SysDictData status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysDictData createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysDictData createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysDictData updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysDictData upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysDictData remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysDictType getSysDictType() {
        return sysDictType;
    }

    public SysDictData sysDictType(SysDictType sysDictType) {
        this.sysDictType = sysDictType;
        return this;
    }

    public void setSysDictType(SysDictType sysDictType) {
        this.sysDictType = sysDictType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysDictData)) {
            return false;
        }
        return id != null && id.equals(((SysDictData) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysDictData{" +
            "id=" + getId() +
            ", dictSort='" + getDictSort() + "'" +
            ", dictLabel='" + getDictLabel() + "'" +
            ", dictValue='" + getDictValue() + "'" +
            ", dictType='" + getDictType() + "'" +
            ", cssClass='" + getCssClass() + "'" +
            ", listClass='" + getListClass() + "'" +
            ", isDefault='" + getIsDefault() + "'" +
            ", status='" + getStatus() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

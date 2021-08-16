package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 字典类型表 entity.\n@author haiming
 */
@ApiModel(description = "字典类型表 entity.\n@author haiming")
@Entity
@Table(name = "sys_dict_type")
public class SysDictType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dict_name")
    private String dictName;

    @Column(name = "dict_type")
    private String dictType;

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

    @OneToMany(mappedBy = "sysDictType")
    private Set<SysDictData> dictTypes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public SysDictType dictName(String dictName) {
        this.dictName = dictName;
        return this;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public SysDictType dictType(String dictType) {
        this.dictType = dictType;
        return this;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getStatus() {
        return status;
    }

    public SysDictType status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysDictType createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysDictType createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysDictType updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysDictType upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysDictType remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysDictData> getDictTypes() {
        return dictTypes;
    }

    public SysDictType dictTypes(Set<SysDictData> sysDictData) {
        this.dictTypes = sysDictData;
        return this;
    }

    public SysDictType addDictType(SysDictData sysDictData) {
        this.dictTypes.add(sysDictData);
        sysDictData.setSysDictType(this);
        return this;
    }

    public SysDictType removeDictType(SysDictData sysDictData) {
        this.dictTypes.remove(sysDictData);
        sysDictData.setSysDictType(null);
        return this;
    }

    public void setDictTypes(Set<SysDictData> sysDictData) {
        this.dictTypes = sysDictData;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysDictType)) {
            return false;
        }
        return id != null && id.equals(((SysDictType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysDictType{" +
            "id=" + getId() +
            ", dictName='" + getDictName() + "'" +
            ", dictType='" + getDictType() + "'" +
            ", status='" + getStatus() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

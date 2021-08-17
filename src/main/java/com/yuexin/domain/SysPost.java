package com.yuexin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 岗位信息表 entity.\n@author haiming
 */
@ApiModel(description = "岗位信息表 entity.\n@author haiming")
@Entity
@Table(name = "sys_post")
public class SysPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "post_sort")
    private Integer postSort;

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

    @ManyToMany(mappedBy = "sysPosts")
    @JsonIgnore
    private Set<SysUser> sysUsers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public SysPost postCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostName() {
        return postName;
    }

    public SysPost postName(String postName) {
        this.postName = postName;
        return this;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getPostSort() {
        return postSort;
    }

    public SysPost postSort(Integer postSort) {
        this.postSort = postSort;
        return this;
    }

    public void setPostSort(Integer postSort) {
        this.postSort = postSort;
    }

    public String getStatus() {
        return status;
    }

    public SysPost status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysPost createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysPost createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysPost updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysPost upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysPost remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public SysPost sysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
        return this;
    }

    public SysPost addSysUser(SysUser sysUser) {
        this.sysUsers.add(sysUser);
        sysUser.getSysPosts().add(this);
        return this;
    }

    public SysPost removeSysUser(SysUser sysUser) {
        this.sysUsers.remove(sysUser);
        sysUser.getSysPosts().remove(this);
        return this;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysPost)) {
            return false;
        }
        return id != null && id.equals(((SysPost) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysPost{" +
            "id=" + getId() +
            ", postCode='" + getPostCode() + "'" +
            ", postName='" + getPostName() + "'" +
            ", postSort=" + getPostSort() +
            ", status='" + getStatus() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

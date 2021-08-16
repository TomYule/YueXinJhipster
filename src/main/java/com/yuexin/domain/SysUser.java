package com.yuexin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.yuexin.domain.enumeration.UserStatus;

/**
 * 用户信息表 entity.\n@author haiming
 */
@ApiModel(description = "用户信息表 entity.\n@author haiming")
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "dept_id", nullable = false)
    private String deptId;

    @Size(max = 30)
    @Column(name = "user_name", length = 30)
    private String userName;

    @Size(max = 30)
    @Column(name = "nick_name", length = 30)
    private String nickName;

    @Column(name = "user_type")
    private String userType;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @Size(max = 11)
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "login_date")
    private LocalDate loginDate;

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

    @ManyToMany
    @JoinTable(name = "sys_user_sys_post",
               joinColumns = @JoinColumn(name = "sys_user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "sys_post_id", referencedColumnName = "id"))
    private Set<SysPost> sysPosts = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "deptIds", allowSetters = true)
    private SysDept sysDept;

    @ManyToMany(mappedBy = "sysUsers")
    @JsonIgnore
    private Set<SysRole> sysRoles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public SysUser deptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserName() {
        return userName;
    }

    public SysUser userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public SysUser nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public SysUser userType(String userType) {
        this.userType = userType;
        return this;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public SysUser email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SysUser phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public SysUser gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUser avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public SysUser password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public SysUser status(UserStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public SysUser delFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public SysUser loginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public SysUser loginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public void setLoginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysUser createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysUser createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysUser updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysUser upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysUser remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysPost> getSysPosts() {
        return sysPosts;
    }

    public SysUser sysPosts(Set<SysPost> sysPosts) {
        this.sysPosts = sysPosts;
        return this;
    }

    public SysUser addSysPost(SysPost sysPost) {
        this.sysPosts.add(sysPost);
        sysPost.getSysUsers().add(this);
        return this;
    }

    public SysUser removeSysPost(SysPost sysPost) {
        this.sysPosts.remove(sysPost);
        sysPost.getSysUsers().remove(this);
        return this;
    }

    public void setSysPosts(Set<SysPost> sysPosts) {
        this.sysPosts = sysPosts;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public SysUser sysDept(SysDept sysDept) {
        this.sysDept = sysDept;
        return this;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public SysUser sysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
        return this;
    }

    public SysUser addSysRole(SysRole sysRole) {
        this.sysRoles.add(sysRole);
        sysRole.getSysUsers().add(this);
        return this;
    }

    public SysUser removeSysRole(SysRole sysRole) {
        this.sysRoles.remove(sysRole);
        sysRole.getSysUsers().remove(this);
        return this;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysUser)) {
            return false;
        }
        return id != null && id.equals(((SysUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysUser{" +
            "id=" + getId() +
            ", deptId='" + getDeptId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", userType='" + getUserType() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", gender='" + getGender() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", password='" + getPassword() + "'" +
            ", status='" + getStatus() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", loginIp='" + getLoginIp() + "'" +
            ", loginDate='" + getLoginDate() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

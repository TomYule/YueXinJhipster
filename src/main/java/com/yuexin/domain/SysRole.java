package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色信息表 entity.\n@author haiming
 */
@ApiModel(description = "角色信息表 entity.\n@author haiming")
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_key")
    private String roleKey;

    @Column(name = "role_sort")
    private Integer roleSort;

    @Column(name = "data_scope")
    private String dataScope;

    @Column(name = "menu_check_strictly")
    private Integer menuCheckStrictly;

    @Column(name = "dept_check_strictly")
    private Integer deptCheckStrictly;

    @Column(name = "status")
    private String status;

    @Column(name = "del_flag")
    private String delFlag;

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
    @JoinTable(name = "sys_role_sys_menu",
               joinColumns = @JoinColumn(name = "sys_role_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "sys_menu_id", referencedColumnName = "id"))
    private Set<SysMenu> sysMenus = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "sys_role_sys_user",
               joinColumns = @JoinColumn(name = "sys_role_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "sys_user_id", referencedColumnName = "id"))
    private Set<SysUser> sysUsers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public SysRole roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public SysRole roleKey(String roleKey) {
        this.roleKey = roleKey;
        return this;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public SysRole roleSort(Integer roleSort) {
        this.roleSort = roleSort;
        return this;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    public String getDataScope() {
        return dataScope;
    }

    public SysRole dataScope(String dataScope) {
        this.dataScope = dataScope;
        return this;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public Integer getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public SysRole menuCheckStrictly(Integer menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
        return this;
    }

    public void setMenuCheckStrictly(Integer menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public Integer getDeptCheckStrictly() {
        return deptCheckStrictly;
    }

    public SysRole deptCheckStrictly(Integer deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
        return this;
    }

    public void setDeptCheckStrictly(Integer deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    public String getStatus() {
        return status;
    }

    public SysRole status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public SysRole delFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysRole createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysRole createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysRole updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysRole upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysRole remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysMenu> getSysMenus() {
        return sysMenus;
    }

    public SysRole sysMenus(Set<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
        return this;
    }

    public SysRole addSysMenu(SysMenu sysMenu) {
        this.sysMenus.add(sysMenu);
        sysMenu.getSysRoles().add(this);
        return this;
    }

    public SysRole removeSysMenu(SysMenu sysMenu) {
        this.sysMenus.remove(sysMenu);
        sysMenu.getSysRoles().remove(this);
        return this;
    }

    public void setSysMenus(Set<SysMenu> sysMenus) {
        this.sysMenus = sysMenus;
    }

    public Set<SysUser> getSysUsers() {
        return sysUsers;
    }

    public SysRole sysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
        return this;
    }

    public SysRole addSysUser(SysUser sysUser) {
        this.sysUsers.add(sysUser);
        sysUser.getSysRoles().add(this);
        return this;
    }

    public SysRole removeSysUser(SysUser sysUser) {
        this.sysUsers.remove(sysUser);
        sysUser.getSysRoles().remove(this);
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
        if (!(o instanceof SysRole)) {
            return false;
        }
        return id != null && id.equals(((SysRole) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysRole{" +
            "id=" + getId() +
            ", roleName='" + getRoleName() + "'" +
            ", roleKey='" + getRoleKey() + "'" +
            ", roleSort=" + getRoleSort() +
            ", dataScope='" + getDataScope() + "'" +
            ", menuCheckStrictly=" + getMenuCheckStrictly() +
            ", deptCheckStrictly=" + getDeptCheckStrictly() +
            ", status='" + getStatus() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

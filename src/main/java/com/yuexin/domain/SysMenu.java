package com.yuexin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 菜单权限表 entity.\n@author haiming
 */
@ApiModel(description = "菜单权限表 entity.\n@author haiming")
@Entity
@Table(name = "sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "order_num")
    private Integer orderNum;

    @Column(name = "path")
    private String path;

    @Column(name = "components")
    private String components;

    @Column(name = "is_frame")
    private String isFrame;

    @Column(name = "is_cache")
    private String isCache;

    @Column(name = "menu_type")
    private String menuType;

    @Column(name = "visible")
    private String visible;

    @Column(name = "status")
    private String status;

    @Column(name = "perms")
    private String perms;

    @Column(name = "icon")
    private String icon;

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

    @ManyToMany(mappedBy = "sysMenus")
    @JsonIgnore
    private Set<SysRole> sysRoles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public SysMenu menuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public SysMenu parentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public SysMenu orderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPath() {
        return path;
    }

    public SysMenu path(String path) {
        this.path = path;
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponents() {
        return components;
    }

    public SysMenu components(String components) {
        this.components = components;
        return this;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getIsFrame() {
        return isFrame;
    }

    public SysMenu isFrame(String isFrame) {
        this.isFrame = isFrame;
        return this;
    }

    public void setIsFrame(String isFrame) {
        this.isFrame = isFrame;
    }

    public String getIsCache() {
        return isCache;
    }

    public SysMenu isCache(String isCache) {
        this.isCache = isCache;
        return this;
    }

    public void setIsCache(String isCache) {
        this.isCache = isCache;
    }

    public String getMenuType() {
        return menuType;
    }

    public SysMenu menuType(String menuType) {
        this.menuType = menuType;
        return this;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return visible;
    }

    public SysMenu visible(String visible) {
        this.visible = visible;
        return this;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getStatus() {
        return status;
    }

    public SysMenu status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerms() {
        return perms;
    }

    public SysMenu perms(String perms) {
        this.perms = perms;
        return this;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public SysMenu icon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreateBy() {
        return createBy;
    }

    public SysMenu createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public SysMenu createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public SysMenu updateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpLocalDate() {
        return upLocalDate;
    }

    public SysMenu upLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
        return this;
    }

    public void setUpLocalDate(LocalDate upLocalDate) {
        this.upLocalDate = upLocalDate;
    }

    public String getRemark() {
        return remark;
    }

    public SysMenu remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public SysMenu sysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
        return this;
    }

    public SysMenu addSysRole(SysRole sysRole) {
        this.sysRoles.add(sysRole);
        sysRole.getSysMenus().add(this);
        return this;
    }

    public SysMenu removeSysRole(SysRole sysRole) {
        this.sysRoles.remove(sysRole);
        sysRole.getSysMenus().remove(this);
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
        if (!(o instanceof SysMenu)) {
            return false;
        }
        return id != null && id.equals(((SysMenu) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysMenu{" +
            "id=" + getId() +
            ", menuName='" + getMenuName() + "'" +
            ", parentId=" + getParentId() +
            ", orderNum=" + getOrderNum() +
            ", path='" + getPath() + "'" +
            ", components='" + getComponents() + "'" +
            ", isFrame='" + getIsFrame() + "'" +
            ", isCache='" + getIsCache() + "'" +
            ", menuType='" + getMenuType() + "'" +
            ", visible='" + getVisible() + "'" +
            ", status='" + getStatus() + "'" +
            ", perms='" + getPerms() + "'" +
            ", icon='" + getIcon() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", upLocalDate='" + getUpLocalDate() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}

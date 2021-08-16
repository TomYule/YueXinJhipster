package com.yuexin.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 系统访问记录 entity.\n@author haiming
 */
@ApiModel(description = "系统访问记录 entity.\n@author haiming")
@Entity
@Table(name = "sys_login_infor")
public class SysLoginInfor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "ip_addr")
    private String ipAddr;

    @Column(name = "login_location")
    private String loginLocation;

    @Column(name = "browser")
    private String browser;

    @Column(name = "os")
    private String os;

    @Column(name = "status")
    private String status;

    @Column(name = "msg")
    private String msg;

    @Column(name = "login_time")
    private LocalDate loginTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public SysLoginInfor userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public SysLoginInfor ipAddr(String ipAddr) {
        this.ipAddr = ipAddr;
        return this;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public SysLoginInfor loginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
        return this;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public SysLoginInfor browser(String browser) {
        this.browser = browser;
        return this;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public SysLoginInfor os(String os) {
        this.os = os;
        return this;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getStatus() {
        return status;
    }

    public SysLoginInfor status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public SysLoginInfor msg(String msg) {
        this.msg = msg;
        return this;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public SysLoginInfor loginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
        return this;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysLoginInfor)) {
            return false;
        }
        return id != null && id.equals(((SysLoginInfor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SysLoginInfor{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", ipAddr='" + getIpAddr() + "'" +
            ", loginLocation='" + getLoginLocation() + "'" +
            ", browser='" + getBrowser() + "'" +
            ", os='" + getOs() + "'" +
            ", status='" + getStatus() + "'" +
            ", msg='" + getMsg() + "'" +
            ", loginTime='" + getLoginTime() + "'" +
            "}";
    }
}

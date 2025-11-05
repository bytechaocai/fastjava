package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_user")
public class SysUserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 用户标识。
     */
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;
    /**
     * 登录名。
     */
    @Column(name = "login_name", nullable = false)
    private String loginName;
    /**
     * 用户名。
     */
    @Column(name = "user_name", nullable = false)
    private String userName;
    /**
     * 用户类型。
     */
    @Column(name = "user_type")
    private Short userType;
    /**
     * 邮箱。
     */
    @Column(name = "email")
    private String email;
    /**
     * 电话号码。
     */
    @Column(name = "phone_number")
    private String phoneNumber;
    /**
     * 性别。
     */
    @Column(name = "gender", nullable = false)
    private Short gender;
    /**
     * 登录密码。
     */
    @Column(name = "password", nullable = false)
    private String password;
    /**
     * 盐加密。
     */
    @Column(name = "salt", nullable = false)
    private String salt;
    /**
     * 状态。
     */
    @Column(name = "status", nullable = false)
    private Short status;
    /**
     * 描述。
     */
    @Column(name = "description")
    private String description;
    /**
     * 创建用户。
     */
    @Column(name = "create_by", nullable = false)
    private String createBy;
    /**
     * 创建时间。
     */
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;
    /**
     * 更新用户。
     */
    @Column(name = "update_by")
    private String updateBy;
    /**
     * 更新时间。
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Short getUserType() {
        return this.userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Short getGender() {
        return this.gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}


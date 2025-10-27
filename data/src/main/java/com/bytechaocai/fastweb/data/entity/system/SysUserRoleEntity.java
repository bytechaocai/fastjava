package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户-角色关联表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRoleEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 关联标识。
     */
    @Id
    private String urId;
    /**
     * 用户标识。
     */
    @Column(name = "user_id", nullable = false)
    private String userId;
    /**
     * 角色标识。
     */
    @Column(name = "role_id", nullable = false)
    private String roleId;
    /**
     * 分配时间。
     */
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    public String getUrId() {
        return this.urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}


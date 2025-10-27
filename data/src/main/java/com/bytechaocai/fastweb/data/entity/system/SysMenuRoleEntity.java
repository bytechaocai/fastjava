package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色-菜单关联表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_menu_role")
public class SysMenuRoleEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 关联标识。
     */
    @Id
    private String rmId;
    /**
     * 角色标识。
     */
    @Column(name = "role_id", nullable = false)
    private String roleId;
    /**
     * 菜单标识。
     */
    @Column(name = "menu_id", nullable = false)
    private String menuId;
    /**
     * 分配时间。
     */
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    public String getRmId() {
        return this.rmId;
    }

    public void setRmId(String rmId) {
        this.rmId = rmId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}


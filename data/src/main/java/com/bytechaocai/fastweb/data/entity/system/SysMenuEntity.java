package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_menu")
public class SysMenuEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID。
     */
    @Id
    private String menuId;
    /**
     * 菜单名称。
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 父菜单ID。
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 显示顺序。
     */
    @Column(name = "menu_order", nullable = false)
    private Short menuOrder;
    /**
     * 请求地址。
     */
    @Column(name = "url", nullable = false)
    private String url;
    /**
     * 打开方式。
     */
    @Column(name = "target", nullable = false)
    private Short target;
    /**
     * 菜单类型。
     */
    @Column(name = "type", nullable = false)
    private Short type;
    /**
     * 菜单状态。
     */
    @Column(name = "status", nullable = false)
    private Short status;
    /**
     * 权限。
     */
    @Column(name = "permission")
    private String permission;
    /**
     * 菜单图标。
     */
    @Column(name = "icon")
    private String icon;
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

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Short getMenuOrder() {
        return this.menuOrder;
    }

    public void setMenuOrder(Short menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Short getTarget() {
        return this.target;
    }

    public void setTarget(Short target) {
        this.target = target;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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


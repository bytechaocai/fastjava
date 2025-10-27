package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

/**
 * 枚举值表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_enum_value")
public class SysEnumValueEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 类型代码。
     */
    @Id
    private String enumType;
    /**
     * 类型值。
     */
    @Column(name = "enum_value", nullable = false)
    private String enumValue;
    /**
     * 枚举值的翻译。
     */
    @Column(name = "enum_name", nullable = false)
    private String enumName;
    /**
     * 排序。
     */
    @Column(name = "enum_sort", nullable = false)
    private Short enumSort;
    /**
     * 是否默认值。
     */
    @Column(name = "enum_default", nullable = false)
    private Byte enumDefault;
    /**
     * 状态。
     */
    @Column(name = "enum_status", nullable = false)
    private Short enumStatus;
    /**
     * 描述。
     */
    @Column(name = "enum_description", nullable = false)
    private String enumDescription;

    public String getEnumType() {
        return this.enumType;
    }

    public void setEnumType(String enumType) {
        this.enumType = enumType;
    }

    public String getEnumValue() {
        return this.enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public String getEnumName() {
        return this.enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public Short getEnumSort() {
        return this.enumSort;
    }

    public void setEnumSort(Short enumSort) {
        this.enumSort = enumSort;
    }

    public Byte getEnumDefault() {
        return this.enumDefault;
    }

    public void setEnumDefault(Byte enumDefault) {
        this.enumDefault = enumDefault;
    }

    public Short getEnumStatus() {
        return this.enumStatus;
    }

    public void setEnumStatus(Short enumStatus) {
        this.enumStatus = enumStatus;
    }

    public String getEnumDescription() {
        return this.enumDescription;
    }

    public void setEnumDescription(String enumDescription) {
        this.enumDescription = enumDescription;
    }
}


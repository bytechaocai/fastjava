
package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

/**
 * 枚举类型表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_enum")
public class SysEnumEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 枚举类型。
     */
    @Id
    private String enumType;
    /**
     * 枚举名。
     */
    @Column(name = "enum_name", nullable = false)
    private String enumName;
    /**
     * 类型描述。
     */
    @Column(name = "enum_description", nullable = false)
    private String enumDescription;
    /**
     * 状态。
     */
    @Column(name = "enum_status", nullable = false)
    private Short enumStatus;

    public String getEnumType() {
        return this.enumType;
    }

    public void setEnumType(String enumType) {
        this.enumType = enumType;
    }
    public String getEnumName() {
        return this.enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }
    public String getEnumDescription() {
        return this.enumDescription;
    }

    public void setEnumDescription(String enumDescription) {
        this.enumDescription = enumDescription;
    }
    public Short getEnumStatus() {
        return this.enumStatus;
    }

    public void setEnumStatus(Short enumStatus) {
        this.enumStatus = enumStatus;
    }
}


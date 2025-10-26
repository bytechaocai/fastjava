package com.bytechaocai.fastweb.data.entity.system;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 枚举值表主键。
 *
 * @author bytechaocai
 */
public class SysEnumValuePK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 类型代码。
     */
    private String enumType;
    /**
     * 类型值。
     */
    private String enumValue;

    public SysEnumValuePK() {
    }

    public SysEnumValuePK(String enumType, String enumValue) {
        this.enumType = enumType;
        this.enumValue = enumValue;
    }

    public SysEnumValuePK getId() {
        return new SysEnumValuePK(enumType, enumValue);
    }

    public void setId(SysEnumValuePK id) {
        this.enumType = id.getEnumType();
        this.enumValue = id.getEnumValue();
    }

    public String getEnumType() {
        return enumType;
    }

    public void setEnumType(String enumType) {
        this.enumType = enumType;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumType, enumValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        SysEnumValuePK pk = (SysEnumValuePK) obj;
        return Objects.equals(pk.getEnumType(), enumType) && Objects.equals(pk.getEnumValue(), enumValue);
    }
}

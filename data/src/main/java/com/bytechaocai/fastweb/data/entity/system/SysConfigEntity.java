
package com.bytechaocai.fastweb.data.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

/**
 * 配置表 实体类。
 *
 * @author bytechaocai
 */
@Entity
@Table(name = "sys_config")
public class SysConfigEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 参数代码。
     */
    @Id
    private String configCode;
    /**
     * 参数名。
     */
    @Column(name = "config_name", nullable = false)
    private String configName;
    /**
     * 参数值。
     */
    @Column(name = "config_value", nullable = false)
    private String configValue;
    /**
     * 描述。
     */
    @Column(name = "config_description", nullable = false)
    private String configDescription;

    public String getConfigCode() {
        return this.configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }
    public String getConfigName() {
        return this.configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
    public String getConfigValue() {
        return this.configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
    public String getConfigDescription() {
        return this.configDescription;
    }

    public void setConfigDescription(String configDescription) {
        this.configDescription = configDescription;
    }
}


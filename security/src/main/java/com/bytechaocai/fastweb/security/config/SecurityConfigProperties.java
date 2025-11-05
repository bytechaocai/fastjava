package com.bytechaocai.fastweb.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "security")
@PropertySource("classpath:security.properties")
public class SecurityConfigProperties {
    private String nam;
    /**
     * 鉴权白名单。
     */
    private String[] excludes;

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String[] getExcludes() {
        return excludes;
    }

    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }
}

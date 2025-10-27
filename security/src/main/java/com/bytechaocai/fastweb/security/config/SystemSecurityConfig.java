package com.bytechaocai.fastweb.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置。
 */
@Configuration
public class SystemSecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // todo 暂时使用明文，等其他代码完善后，使用密码加密。
        return NoOpPasswordEncoder.getInstance();
    }
}

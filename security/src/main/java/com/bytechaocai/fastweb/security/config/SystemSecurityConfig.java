package com.bytechaocai.fastweb.security.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 安全配置。
 */
@Configuration
public class SystemSecurityConfig {
    @Resource
    private SecurityConfigProperties securityConfigProperties;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // todo 暂时使用明文，等其他代码完善后，使用密码加密。
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req -> req.requestMatchers(securityConfigProperties.getExcludes())
                        .permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}

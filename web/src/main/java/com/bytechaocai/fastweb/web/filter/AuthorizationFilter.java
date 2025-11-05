package com.bytechaocai.fastweb.web.filter;

import com.bytechaocai.fastweb.security.config.SecurityConfigProperties;
import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 认证过滤器。
 *
 * @author bytechaocai
 */
@Component
public class AuthorizationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Resource
    private SecurityConfigProperties securityConfigProperties;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        for (String exclude : securityConfigProperties.getExcludes()) {
            if (url.contains(exclude)) {
                LOGGER.info("请求{}不需要鉴权", url);
                chain.doFilter(request, response);
                return;
            }
        }
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader == null) {
            LOGGER.info("请求{}是没有经过认证的访问", url);
            // throw new AccessDeniedException("未授权的访问");
        } else {
            LOGGER.info("请求{}已经经过认证", url);
            String[] split = authHeader.split(",");
            UserDetails userDetails = userDetailsService.loadUserByUsername(split[0]);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, split[2],
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}

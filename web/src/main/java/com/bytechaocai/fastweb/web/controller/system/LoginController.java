package com.bytechaocai.fastweb.web.controller.system;

import com.bytechaocai.fastweb.core.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 登录登出控制器。
 *
 * @author bytechaocai
 */
@RestController
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public BaseResponse<String> login(String username, String password) {
        String token = "%s,%s,%s".formatted(username, password, UUID.randomUUID().toString());
        LOGGER.info("口令:{}", token);
        BaseResponse<String> response = new BaseResponse<>();
        response.setData(token);
        return response;
    }

    @GetMapping("/csrf")
    public CsrfToken csrf(CsrfToken csrfToken) {
        return csrfToken;
    }
}

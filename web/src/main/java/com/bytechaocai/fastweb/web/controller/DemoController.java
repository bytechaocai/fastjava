package com.bytechaocai.fastweb.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * 测试用的控制器。
 *
 * @author bytechaocai
 */
@RestController
@RequestMapping("/demo")
class DemoController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/system")
    public Properties system() {
        return System.getProperties();
    }
}

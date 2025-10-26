package com.bytechaocai.fastweb.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动类。
 *
 * @author bytechaocai
 */
public class FastWebApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FastWebApplication.class);

    public static void main(String[] args) {
        LOGGER.info("应用启动中...");
        SpringApplication springApplication = new SpringApplication(FastWebConfiguration.class);
        ConfigurableApplicationContext ctx = springApplication.run(args);
        LOGGER.info("应用启动完成:{}", ctx);
    }
}

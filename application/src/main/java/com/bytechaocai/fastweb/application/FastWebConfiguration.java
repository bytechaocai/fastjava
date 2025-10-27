package com.bytechaocai.fastweb.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 主启动类的配置类。
 *
 * <p>application模块只负责启动应用，不应该包含启动类和配置文件以外的内容</p>
 *
 * @author bytechaocai
 */
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.bytechaocai.fastweb"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.bytechaocai.fastweb.application"})
})
@MapperScan(basePackages = {"com.bytechaocai.fastweb.data.dao"})
@EnableJpaRepositories(basePackages = {"com.bytechaocai.fastweb.data.repository"})
@EntityScan(basePackages = {"com.bytechaocai.fastweb.data.entity"})
@EnableAutoConfiguration
public class FastWebConfiguration {
}

package com.bytechaocai.fastweb.data.config;

import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源配置。
 *
 * @author bytechaocai
 */
@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource getDataSource() {
        // 暂时现用本地明文文件代替解密。
        Properties properties = PropertiesUtil.load("datasource.properties");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setDriverClassName(properties.getProperty("driverClassName"));
        return dataSource;
    }
}

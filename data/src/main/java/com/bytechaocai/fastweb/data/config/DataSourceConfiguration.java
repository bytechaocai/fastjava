package com.bytechaocai.fastweb.data.config;

import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

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

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.bytechaocai.fastweb.data.entity");

        // 设置 JPA 供应商适配器
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // 配置 Hibernate 属性
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.setProperty("hibernate.max_fetch_depth", "3");
        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        jpaProperties.setProperty("hibernate.jdbc.batch_size", "10");

        // // Envers 审计配置
        // jpaProperties.setProperty("org.hibernate.envers.audit_table_suffix", "_H");
        // jpaProperties.setProperty("org.hibernate.envers.revision_field_name", "AUDIT_REVISION");
        // jpaProperties.setProperty("org.hibernate.envers.revision_type_field_name", "ACTION_TYPE");
        // jpaProperties.setProperty("org.hibernate.envers.audit_strategy",
        //         "org.hibernate.envers.strategy.internal.ValidityAuditStrategy");
        // jpaProperties.setProperty("org.hibernate.envers.audit_strategy_validity_end_rev_field_name",
        //         "AUDIT_REVISION_END");
        // jpaProperties.setProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp",
        //         "True");
        // jpaProperties.setProperty("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name",
        //         "AUDIT_REVISION_END_TS");

        em.setJpaProperties(jpaProperties);
        return em;
    }

}

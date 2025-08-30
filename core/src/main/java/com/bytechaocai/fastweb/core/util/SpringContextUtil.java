package com.bytechaocai.fastweb.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring上下文工具类。
 *
 * @author bytechaocai
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;

    /**
     * 获取上下文。
     *
     * @return 上下文
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    @SuppressWarnings({"java:S2696", "NullableProblems"})
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取指定类型的bean。
     *
     * @param <T> 类型泛型。
     * @param clazz 类型。
     *
     * @return bean对象。
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 用名称和类型获取bean。
     *
     * @param <T> 类型泛型。
     * @param name 名称。
     * @param clazz 类型。
     *
     * @return Bean对象
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 获取配置文件中的属性。
     *
     * @param key 配置项。
     *
     * @return 值。
     *
     */
    public static String getProperty(String key) {
        return applicationContext.getEnvironment().getProperty(key);
    }

    /**
     * 获取配置文件中的属性
     *
     * @param key 配置项。
     * @param defaultValue 默认值。
     *
     * @return 值。
     */
    public static String getProperty(String key, String defaultValue) {
        return applicationContext.getEnvironment().getProperty(key, defaultValue);
    }

    /**
     * 获取当前激活的环境。
     *
     * @return 当前激活的环境。
     */
    public static String[] getActiveProfiles() {
        return applicationContext.getEnvironment().getActiveProfiles();
    }

}

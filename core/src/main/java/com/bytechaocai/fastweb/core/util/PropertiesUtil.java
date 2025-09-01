package com.bytechaocai.fastweb.core.util;

import com.bytechaocai.fastweb.core.exceptions.SystemException;
import com.bytechaocai.fastweb.core.exceptions.SystemExceptionCode;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通用Properties工具类
 * 支持加载类路径下和非类路径下的配置文件，并提供缓存机制
 * 支持classpath:前缀识别
 */
public class PropertiesUtil {

    private static final String CLASSPATH_PREFIX = "classpath:";

    private static final ConcurrentHashMap<String, Properties> propertiesCache = new ConcurrentHashMap<>();

    /**
     * 根据路径自动识别加载方式
     * 如果路径以"classpath:"开头，则从类路径加载
     * 否则从文件系统加载
     *
     * @param path 资源路径
     *
     * @return Properties对象
     *
     */
    public static Properties load(String path) {
        // 检查缓存中是否已存在
        if (propertiesCache.containsKey(path)) {
            return propertiesCache.get(path);
        }

        Properties properties = new Properties();

        if (path.startsWith(CLASSPATH_PREFIX)) {
            // 从类路径加载
            String resourcePath = path.substring(CLASSPATH_PREFIX.length());
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(resourcePath);

            try (inputStream) {
                if (inputStream == null) {
                    throw new SystemException(SystemExceptionCode.FILE_NOT_FOUND);
                }
                properties.load(inputStream);
            } catch (IOException e) {
                throw new SystemException(SystemExceptionCode.IO_EXCEPTION, e);
            }
        } else {
            // 从文件系统加载
            Path filePath = Paths.get(path);
            if (!Files.exists(filePath)) {
                throw new SystemException(SystemExceptionCode.FILE_NOT_FOUND);
            }

            try (InputStream inputStream = Files.newInputStream(filePath)) {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new SystemException(SystemExceptionCode.IO_EXCEPTION, e);
            }
        }

        // 缓存加载的配置
        propertiesCache.put(path, properties);
        return properties;
    }

    /**
     * 获取属性。
     *
     * @param path 属性文件路径。
     * @param key 属性键。
     *
     * @return 属性值。
     */
    public static String getProperty(String path, String key) {
        if (!propertiesCache.containsKey(path)) {
            load(path);
        }
        return propertiesCache.get(path).getProperty(key);
    }

    /**
     * 获取属性。
     *
     * @param path 属性文件路径。
     * @param key 属性键。
     * @param defaultValue key不存在时的默认值。
     *
     * @return 属性值。
     */
    public static String getProperty(String path, String key, String defaultValue) {
        return propertiesCache.getOrDefault(path, new Properties()).getProperty(key, defaultValue);
    }
}

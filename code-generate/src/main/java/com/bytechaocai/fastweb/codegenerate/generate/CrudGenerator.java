package com.bytechaocai.fastweb.codegenerate.generate;

import com.bytechaocai.fastweb.codegenerate.config.CrudConfig;
import com.bytechaocai.fastweb.codegenerate.config.CrudTableConfig;
import com.bytechaocai.fastweb.core.exceptions.SystemException;
import com.bytechaocai.fastweb.core.exceptions.SystemExceptionCode;
import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 代码生成器。
 *
 * <p>代码生成器带状态，不能并发使用，只能单独使用，也就是开发在自己电脑上使用，此时是单线程，
 * 没有并发问题。</p>
 *
 * @author bytechaocai
 */
public class CrudGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrudGenerator.class);
    private CrudConfig crudConfig;
    private CrudTableConfig crudTableConfig;
    /**
     * 数据库连接，需要自己关闭。
     */
    private Connection connection;

    public CrudGenerator(CrudConfig crudConfig) {
        this.crudConfig = crudConfig;
    }

    /**
     * 加载默认值。
     */
    public void loadDefaultConfig() {
        LOGGER.info("加载crud生成配置");
        Properties properties = PropertiesUtil.load("classpath:default.properties");
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(CrudConfig.class);
        try {
            for (PropertyDescriptor pd : pds) {
                String name = pd.getName();
                if ("class".equals(name)) {
                    continue;
                }
                Class<?> propertyType = pd.getPropertyType();
                Object value = pd.getReadMethod().invoke(crudConfig);
                if (value != null) {
                    LOGGER.info("属性{}有值，不需要加载", name);
                    continue;
                }
                if (propertyType == Boolean.TYPE) {
                    value = Boolean.parseBoolean(properties.getProperty("crud." + name));
                } else {
                    value = properties.getProperty("crud." + name);
                }
                pd.getWriteMethod().invoke(crudConfig, value);
            }
            LOGGER.info("crud生成配置加载完成");
        } catch (ReflectiveOperationException e) {
            throw new SystemException(SystemExceptionCode.REFLECT_EXCEPTION, e);
        }
    }

    /**
     * 加载表里的字段。
     *
     * @param connection 数据库连接。
     */
    public void loadTableConfig(Connection connection) {
        try {
            LOGGER.info("读取表信息");
            List<Map<String, Object>> list = new ArrayList<>();
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, crudConfig.getTableName(), null);
            while (resultSet.next()) {
                Map<String, Object> columnMap = new HashMap<>();
                columnMap.put("columnName", resultSet.getString("COLUMN_NAME"));
                columnMap.put("dataType", resultSet.getInt("DATA_TYPE"));
                columnMap.put("typeName", resultSet.getString("TYPE_NAME"));
                columnMap.put("columnSize", resultSet.getInt("COLUMN_SIZE"));
                columnMap.put("nullable", resultSet.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
                columnMap.put("remarks", resultSet.getString("REMARKS"));
                list.add(columnMap);
            }
            crudTableConfig = new CrudTableConfig();
            crudTableConfig.setColumnList(list);
            LOGGER.info("表{}加载完成，一共{}个字段", crudConfig.getTableName(), list.size());
        } catch (SQLException e) {
            throw new SystemException(SystemExceptionCode.SQL_EXCEPTION, e);
        }
    }

    public void generate() {

    }
}

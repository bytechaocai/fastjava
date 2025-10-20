package com.bytechaocai.fastweb.codegenerate.generate.crud;

import com.bytechaocai.fastweb.codegenerate.bean.crud.ColumnInfo;
import com.bytechaocai.fastweb.codegenerate.bean.crud.CrudConfig;
import com.bytechaocai.fastweb.codegenerate.bean.crud.CrudTableConfig;
import com.bytechaocai.fastweb.core.exceptions.SystemException;
import com.bytechaocai.fastweb.core.exceptions.SystemExceptionCode;
import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import com.bytechaocai.fastweb.core.util.StrUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
    /**
     * Java类型。
     */
    private static final Map<Integer, String> JAVA_TYPE_MAP = new HashMap<>();
    /**
     * 导包。
     */
    private static final Map<String, String> JAVA_TYPE_IMPORT = new HashMap<>();
    /**
     * jdbc类型。
     */
    private static final Map<String, String> JDBC_TYPE_MAP = new HashMap<>();

    static {
        JAVA_TYPE_MAP.put(Types.BIT, "Byte");
        JAVA_TYPE_MAP.put(Types.TINYINT, "Short");
        JAVA_TYPE_MAP.put(Types.SMALLINT, "Short");
        JAVA_TYPE_MAP.put(Types.INTEGER, "Short");
        JAVA_TYPE_MAP.put(Types.BIGINT, "BigDecimal");
        JAVA_TYPE_MAP.put(Types.FLOAT, "Float");
        // JAVA_TYPE_MAP.put(Types.REAL, "REAL");
        JAVA_TYPE_MAP.put(Types.DOUBLE, "Double");
        JAVA_TYPE_MAP.put(Types.NUMERIC, "BigDecimal");
        JAVA_TYPE_MAP.put(Types.DECIMAL, "BigDecimal");
        JAVA_TYPE_MAP.put(Types.CHAR, "String");
        JAVA_TYPE_MAP.put(Types.VARCHAR, "String");
        JAVA_TYPE_MAP.put(Types.LONGVARCHAR, "String");
        JAVA_TYPE_MAP.put(Types.DATE, "Date");
        JAVA_TYPE_MAP.put(Types.TIME, "Date");
        JAVA_TYPE_MAP.put(Types.TIMESTAMP, "Date");
        // JAVA_TYPE_MAP.put(Types.BINARY, "BINARY");
        // JAVA_TYPE_MAP.put(Types.VARBINARY, "VARBINARY");
        // JAVA_TYPE_MAP.put(Types.LONGVARBINARY, "LONGVARBINARY");
        // JAVA_TYPE_MAP.put(Types.NULL, "NULL");
        // JAVA_TYPE_MAP.put(Types.OTHER, "OTHER");
        // JAVA_TYPE_MAP.put(Types.JAVA_OBJECT, "JAVA_OBJECT");
        // JAVA_TYPE_MAP.put(Types.DISTINCT, "DISTINCT");
        // JAVA_TYPE_MAP.put(Types.STRUCT, "STRUCT");
        // JAVA_TYPE_MAP.put(Types.ARRAY, "ARRAY");
        // JAVA_TYPE_MAP.put(Types.BLOB, "BLOB");
        // JAVA_TYPE_MAP.put(Types.CLOB, "CLOB");
        // JAVA_TYPE_MAP.put(Types.REF, "REF");
        // JAVA_TYPE_MAP.put(Types.DATALINK, "DATALINK");
        JAVA_TYPE_MAP.put(Types.BOOLEAN, "Boolean");
        // JAVA_TYPE_MAP.put(Types.ROWID, "ROWID");
        // JAVA_TYPE_MAP.put(Types.NCHAR, "String");
        // JAVA_TYPE_MAP.put(Types.NVARCHAR, "NVARCHAR");
        // JAVA_TYPE_MAP.put(Types.LONGNVARCHAR, "LONGNVARCHAR");
        // JAVA_TYPE_MAP.put(Types.NCLOB, "NCLOB");
        // JAVA_TYPE_MAP.put(Types.SQLXML, "SQLXML");
        // JAVA_TYPE_MAP.put(Types.REF_CURSOR, "REF_CURSOR");
        // JAVA_TYPE_MAP.put(Types.TIME_WITH_TIMEZONE, "TIME_WITH_TIMEZONE");
        // JAVA_TYPE_MAP.put(Types.TIMESTAMP_WITH_TIMEZONE, "TIMESTAMP_WITH_TIMEZONE");


        JAVA_TYPE_IMPORT.put("Date", "import java.util.Date;");
        JAVA_TYPE_IMPORT.put("BigDecimal", "import java.math.BigDecimal;");
    }

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
            List<ColumnInfo> list = new ArrayList<>();
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, crudConfig.getTableName(), null);
            while (resultSet.next()) {
                ColumnInfo columnInfo = new ColumnInfo();
                // todo 使用bean。
                columnInfo.setColumnName(resultSet.getString("COLUMN_NAME"));
                // java.sql.types中的类型
                columnInfo.setDataType(resultSet.getInt("DATA_TYPE"));
                // 数据库自己的类型
                columnInfo.setColumnType(resultSet.getString("TYPE_NAME"));
                columnInfo.setColumnLength(resultSet.getString("COLUMN_SIZE"));
                columnInfo.setNullable(resultSet.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
                columnInfo.setComment(resultSet.getString("REMARKS"));
                list.add(columnInfo);
            }
            ResultSet tables = metaData.getTables(null, null, crudConfig.getTableName(), null);
            tables.next();
            crudTableConfig = new CrudTableConfig();
            crudTableConfig.setTableName(tables.getString("TABLE_NAME"));
            crudTableConfig.setTableComment(tables.getString("REMARKS"));
            crudTableConfig.setColumnList(list);
            LOGGER.info("表{}加载完成，一共{}个字段", crudConfig.getTableName(), list.size());
        } catch (SQLException e) {
            throw new SystemException(SystemExceptionCode.SQL_EXCEPTION, e);
        }
    }

    /**
     * 生成前准备工作。
     */
    public void prepare() {
        crudConfig.setEntityName(
                StrUtil.underlineToUpperCamel(crudConfig.getTableName()) + crudConfig.getEntitySuffix());
        crudConfig.setAuthor(System.getProperty("user.name"));
        Set<String> set = new HashSet<>();
        for (ColumnInfo columnInfo : crudTableConfig.getColumnList()) {
            String columnName = columnInfo.getColumnName();
            columnInfo.setFieldName(StrUtil.underlineToLowerCamel(columnName));
            columnInfo.setUpperCamelFieldName(StrUtil.underlineToUpperCamel(columnName));
            columnInfo.setJavaType(JAVA_TYPE_MAP.get(columnInfo.getDataType()));
            if ("BigDecimal".equals(columnInfo.getJavaType())) {
                set.add("import java.math.BigDecimal;");
            }
            if ("Date".equals(columnInfo.getJavaType())) {
                set.add("import java.util.Date;");
            }
            columnInfo.setColumnType(JDBC_TYPE_MAP.get(columnInfo.getColumnType()));
            columnInfo.setComment(columnInfo.getComment() + "。");
        }
        crudTableConfig.getPackageList().addAll(set);
    }

    public void generate() throws Exception {
        Properties properties = PropertiesUtil.load("classpath:velocity.properties");
        // velocity会判断是否已经初始化
        Velocity.init(properties);
        Context context = new VelocityContext();
        context.put("crudConfig", crudConfig);
        context.put("tableConfig", crudTableConfig);
        context.put("columnList", crudTableConfig.getColumnList());
        Template template = Velocity.getTemplate("crud/entity.vm", "UTF-8");
        // todo 创建嵌套目录
        String path = String.format("%s/src/main/java/%s/", crudConfig.getModuleName(),
                crudConfig.getEntityPackage().replace(".", "/"));
        FileWriter fileWriter = new FileWriter(path + crudConfig.getEntityName() + ".java");
        template.merge(context, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}

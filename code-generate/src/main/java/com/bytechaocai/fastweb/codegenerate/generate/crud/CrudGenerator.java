package com.bytechaocai.fastweb.codegenerate.generate.crud;

import com.bytechaocai.fastweb.codegenerate.bean.crud.ColumnInfo;
import com.bytechaocai.fastweb.codegenerate.bean.crud.CrudConfig;
import com.bytechaocai.fastweb.codegenerate.exceptions.CrudExceptionCode;
import com.bytechaocai.fastweb.core.exceptions.SystemException;
import com.bytechaocai.fastweb.core.exceptions.SystemExceptionCode;
import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import com.bytechaocai.fastweb.core.util.StrUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     * 增删改查模板根目录路径。
     */
    private static final String TEMPLATE_ROOT = "crud";
    private static final String MAIN_JAVA = "src/main/java";
    private static final String MAIN_RESOURCE = "src/main/resources";
    private static final String TEST_JAVA = "src/test/java";
    private static final String TEST_RESOURCE = "src/test/resources";
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
    private static final Map<Integer, String> JDBC_TYPE_MAP = new HashMap<>();
    private static VelocityEngine velocityEngine;

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
        JAVA_TYPE_MAP.put(Types.DATE, "LocalDate");
        JAVA_TYPE_MAP.put(Types.TIME, "LocalTime");
        JAVA_TYPE_MAP.put(Types.TIMESTAMP, "LocalDateTime");
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


        JAVA_TYPE_IMPORT.put("LocalDate", "import java.time.LocalDate;");
        JAVA_TYPE_IMPORT.put("LocalTime", "import java.time.LocalTime;");
        JAVA_TYPE_IMPORT.put("LocalDateTime", "import java.time.LocalDateTime;");
        JAVA_TYPE_IMPORT.put("BigDecimal", "import java.math.BigDecimal;");

        JDBC_TYPE_MAP.put(Types.BIT, "BIT");
        JDBC_TYPE_MAP.put(Types.TINYINT, "TINYINT");
        JDBC_TYPE_MAP.put(Types.SMALLINT, "SMALLINT");
        JDBC_TYPE_MAP.put(Types.INTEGER, "INTEGER");
        JDBC_TYPE_MAP.put(Types.BIGINT, "BIGINT");
        JDBC_TYPE_MAP.put(Types.FLOAT, "FLOAT");
        JDBC_TYPE_MAP.put(Types.REAL, "REAL");
        JDBC_TYPE_MAP.put(Types.DOUBLE, "DOUBLE");
        JDBC_TYPE_MAP.put(Types.NUMERIC, "NUMERIC");
        JDBC_TYPE_MAP.put(Types.DECIMAL, "DECIMAL");
        JDBC_TYPE_MAP.put(Types.CHAR, "CHAR");
        JDBC_TYPE_MAP.put(Types.VARCHAR, "VARCHAR");
        JDBC_TYPE_MAP.put(Types.LONGVARCHAR, "LONGVARCHAR");
        JDBC_TYPE_MAP.put(Types.DATE, "DATE");
        JDBC_TYPE_MAP.put(Types.TIME, "TIME");
        JDBC_TYPE_MAP.put(Types.TIMESTAMP, "TIMESTAMP");
        JDBC_TYPE_MAP.put(Types.BINARY, "BINARY");
        JDBC_TYPE_MAP.put(Types.VARBINARY, "VARBINARY");
        JDBC_TYPE_MAP.put(Types.LONGVARBINARY, "LONGVARBINARY");
        JDBC_TYPE_MAP.put(Types.NULL, "NULL");
        JDBC_TYPE_MAP.put(Types.OTHER, "OTHER");
        JDBC_TYPE_MAP.put(Types.JAVA_OBJECT, "JAVA_OBJECT");
        JDBC_TYPE_MAP.put(Types.DISTINCT, "DISTINCT");
        JDBC_TYPE_MAP.put(Types.STRUCT, "STRUCT");
        JDBC_TYPE_MAP.put(Types.ARRAY, "ARRAY");
        JDBC_TYPE_MAP.put(Types.BLOB, "BLOB");
        JDBC_TYPE_MAP.put(Types.CLOB, "CLOB");
        JDBC_TYPE_MAP.put(Types.REF, "REF");
        JDBC_TYPE_MAP.put(Types.DATALINK, "DATALINK");
        JDBC_TYPE_MAP.put(Types.BOOLEAN, "BOOLEAN");
        JDBC_TYPE_MAP.put(Types.ROWID, "ROWID");
        JDBC_TYPE_MAP.put(Types.NCHAR, "NCHAR");
        JDBC_TYPE_MAP.put(Types.NVARCHAR, "NVARCHAR");
        JDBC_TYPE_MAP.put(Types.LONGNVARCHAR, "LONGNVARCHAR");
        JDBC_TYPE_MAP.put(Types.NCLOB, "NCLOB");
        JDBC_TYPE_MAP.put(Types.SQLXML, "SQLXML");
        JDBC_TYPE_MAP.put(Types.REF_CURSOR, "REF_CURSOR");
        JDBC_TYPE_MAP.put(Types.TIME_WITH_TIMEZONE, "TIME_WITH_TIMEZONE");
        JDBC_TYPE_MAP.put(Types.TIMESTAMP_WITH_TIMEZONE, "TIMESTAMP_WITH_TIMEZONE");

        Properties properties = PropertiesUtil.load("classpath:velocity.properties");
        // velocity会判断是否已经初始化
        Velocity.init(properties);
    }

    private CrudConfig crudConfig;
    /**
     * 数据库连接，需要自己关闭。
     */
    private Connection connection;
    /**
     * 模板文件生成的文件目录。
     */
    private Map<String, String> pathMap = new HashMap<>();
    /**
     * 文件后缀目录，包括扩展名。
     */
    private Map<String, String> suffixMap = new HashMap<>();

    public CrudGenerator(CrudConfig crudConfig) {
        this.crudConfig = crudConfig;
    }

    /**
     * 加载默认值。
     */
    public void loadDefaultConfig() {
        LOGGER.info("加载crud生成配置");
        Properties properties = PropertiesUtil.load("classpath:default.properties");
        crudConfig.setRootPackage(properties.getProperty("crud.rootPackage"));
        crudConfig.setAuthor(properties.getProperty("crud.author"));
        loadTemplatePath();
    }

    /**
     * 加载模板路径和目标文件路径的映射。
     */
    private void loadTemplatePath() {
        // 最终的文件路径是map.getValue[0] + entityName + map.value[1];
        LOGGER.info("加载模板和目标文件的路径映射：");

        String rootPath = crudConfig.getRootPackage().replace(".", "/");

        // 路径映射
        pathMap.put("crud/dao.vm",
                joinPath("data", MAIN_JAVA, rootPath, "data/dao", crudConfig.getDaoPackage()));
        // pathMap.put("crud/dao-test.vm",
        //         joinPath("data", TEST_JAVA, rootPath, "data/dao", crudConfig.getDaoPackage()));
        pathMap.put("crud/dao-xml.vm",
                joinPath("data", MAIN_RESOURCE, "mappers"));
        pathMap.put("crud/entity.vm",
                joinPath("data", MAIN_JAVA, rootPath, "data/entity", crudConfig.getEntityPackage()));
        pathMap.put("crud/repository.vm",
                joinPath("data", MAIN_JAVA, rootPath, "data/repository", crudConfig.getDaoPackage()));
        // 服务接口和实现分别放在base和impl目录下。
        pathMap.put("crud/service.vm",
                joinPath("service", MAIN_JAVA, rootPath, "service/base", crudConfig.getServicePackage()));
        pathMap.put("crud/service-impl.vm",
                joinPath("service", MAIN_JAVA, rootPath, "service/impl", crudConfig.getServicePackage()));
        pathMap.put("crud/vo.vm",
                joinPath("data", MAIN_JAVA, rootPath, "data/vo", crudConfig.getVoPackage()));

        // 后缀映射
        suffixMap.put("crud/dao.vm", "DAO.java");
        suffixMap.put("crud/dao-test.vm", "DAOTest.java");
        suffixMap.put("crud/dao-xml.vm", "DAO.xml");
        suffixMap.put("crud/entity.vm", "Entity.java");
        suffixMap.put("crud/repository.vm", "Repository.java");
        suffixMap.put("crud/service.vm", "Service.java");
        suffixMap.put("crud/service-impl.vm", "ServiceImpl.java");
        suffixMap.put("crud/vo.vm", "VO.java");

        LOGGER.info("路径映射加载完成");
    }

    /**
     * 添加包路径。
     *
     * @param path 路径
     *
     * @return 组合后的路径。
     */
    private String joinPath(String... path) {
        StringBuilder builder = new StringBuilder();
        for (String s : path) {
            if (s.isEmpty()) {
                continue;
            }
            builder.append(s.replace(".", "/")).append("/");
        }
        return builder.toString();
    }

    /**
     * 加载表里的字段。
     *
     * @param connection 数据库连接。
     */
    public void loadTableConfig(Connection connection) {
        String primaryKey = null;
        LOGGER.info("加载表信息");
        List<ColumnInfo> list = new ArrayList<>();
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
        } catch (SQLException e) {
            throw new SystemException(CrudExceptionCode.LOAD_META_ERROR, e);
        }
        // 先获取主键，在遍历列时直接比较，如果在遍历完列后比较，要多一次循环
        // 暂不支持多字段主键
        LOGGER.info("加载主键");
        try (ResultSet primaryKeyRs = metaData.getPrimaryKeys(null, null, crudConfig.getTableName())) {
            if (primaryKeyRs.next()) {
                primaryKey = primaryKeyRs.getString("COLUMN_NAME");
                LOGGER.info("主键是[{}]", primaryKey);
            }
        } catch (SQLException e) {
            throw new SystemException(CrudExceptionCode.LOAD_PRIMARY_ERROR, e);
        }

        try (ResultSet columnRs = metaData.getColumns(null, null, crudConfig.getTableName(), null)) {

            while (columnRs.next()) {
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setColumnName(columnRs.getString("COLUMN_NAME"));
                // java.sql.types中的类型
                columnInfo.setDataType(columnRs.getInt("DATA_TYPE"));
                columnInfo.setJdbcType(JDBC_TYPE_MAP.get(columnInfo.getDataType()));
                columnInfo.setColumnLength(columnRs.getString("COLUMN_SIZE"));
                columnInfo.setNullable(columnRs.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
                columnInfo.setComment(columnRs.getString("REMARKS"));
                if (columnInfo.getColumnName().equals(primaryKey)) {
                    columnInfo.setPrimaryKey(true);
                }
                list.add(columnInfo);
            }
            crudConfig.setColumnList(list);
        } catch (SQLException e) {
            throw new SystemException(CrudExceptionCode.LOAD_COLUMN_ERROR, e);
        }

        try (ResultSet tableRs = metaData.getTables(null, null, crudConfig.getTableName(), null)) {
            tableRs.next();
            crudConfig.setTableName(tableRs.getString("TABLE_NAME"));
            crudConfig.setTableComment(tableRs.getString("REMARKS"));
        } catch (SQLException e) {
            throw new SystemException(CrudExceptionCode.LOAD_TABLE_ERROR, e);
        }
        LOGGER.info("表{}加载完成，一共{}个字段", crudConfig.getTableName(), list.size());
    }

    /**
     * 生成前准备工作。
     */
    public void prepare() {
        crudConfig.setEntityName(
                StrUtil.underlineToUpperCamel(crudConfig.getTableName()));
        Set<String> set = new HashSet<>();
        for (ColumnInfo columnInfo : crudConfig.getColumnList()) {
            String columnName = columnInfo.getColumnName();
            columnInfo.setFieldName(StrUtil.underlineToLowerCamel(columnName));
            columnInfo.setUpperCamelFieldName(StrUtil.underlineToUpperCamel(columnName));
            columnInfo.setJavaType(JAVA_TYPE_MAP.get(columnInfo.getDataType()));
            if (JAVA_TYPE_IMPORT.containsKey(columnInfo.getJavaType())) {
                set.add(JAVA_TYPE_IMPORT.get(columnInfo.getJavaType()));
            }
            columnInfo.setJdbcType(JDBC_TYPE_MAP.get(columnInfo.getDataType()));
            columnInfo.setComment(columnInfo.getComment() + "。");
        }
        crudConfig.getPackageList().addAll(set);
    }

    /**
     * 生成实体类。
     */
    public void generate() {
        Context context = new VelocityContext();
        context.put("crudConfig", crudConfig);
        context.put("columnList", crudConfig.getColumnList());
        // 先创建目录，防止报错文件不存在
        try {
            for (Map.Entry<String, String> entry : pathMap.entrySet()) {
                Path path = Paths.get(entry.getValue());
                if (Files.exists(path)) {
                    continue;
                }
                LOGGER.info("模板{}对应的目标文件目录{}不存在，创建目录", entry.getKey(), entry.getValue());
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            throw new SystemException(SystemExceptionCode.IO_EXCEPTION, e);
        }

        for (Map.Entry<String, String> entry : pathMap.entrySet()) {
            LOGGER.info("解析模板文件{}", entry.getKey());
            Template template = Velocity.getTemplate(entry.getKey(), "UTF-8");

            try (FileWriter fileWriter = new FileWriter(
                    entry.getValue() + crudConfig.getEntityName() + suffixMap.get(entry.getKey()))) {
                template.merge(context, fileWriter);
                fileWriter.flush();
            } catch (IOException e) {
                throw new SystemException(SystemExceptionCode.IO_EXCEPTION, e);
            }
            LOGGER.info("模板文件{}解析完成", entry.getKey());
        }
    }
}

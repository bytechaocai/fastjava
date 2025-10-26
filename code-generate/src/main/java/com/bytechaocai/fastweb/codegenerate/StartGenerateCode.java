package com.bytechaocai.fastweb.codegenerate;

import com.bytechaocai.fastweb.codegenerate.bean.crud.CrudConfig;
import com.bytechaocai.fastweb.codegenerate.generate.crud.CrudGenerator;
import com.bytechaocai.fastweb.core.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

/**
 * crud入口。
 *
 * @author bytechaocai
 */
@SuppressWarnings("all")
public class StartGenerateCode {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名，使用逗号分隔");
        String tableName = scanner.nextLine();
        System.out.println("请输入包名（只有一个包）");
        String packageName = scanner.nextLine();
        if (StringUtils.isBlank(tableName) || StringUtils.isBlank(packageName)) {
            System.out.println("输入不能为空");
            System.exit(1);
        }
        Properties properties = PropertiesUtil.load("datasource.properties");
        CrudConfig crudConfig = new CrudConfig();
        crudConfig.setEntityPackage(packageName);
        crudConfig.setDaoPackage(packageName);
        crudConfig.setVoPackage(packageName);
        crudConfig.setServicePackage(packageName);
        CrudGenerator generator = new CrudGenerator(crudConfig);
        generator.loadDefaultConfig();
        try (Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties)) {
            for (String table : tableName.split(",")) {
                System.out.printf("当前表:%s%n", table);
                crudConfig.setTableName(table);
                generator.loadTableConfig(connection);
                generator.prepare();
                generator.generate();
            }
        }
    }
}

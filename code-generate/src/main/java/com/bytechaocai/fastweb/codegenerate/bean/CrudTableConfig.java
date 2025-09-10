package com.bytechaocai.fastweb.codegenerate.bean;

import java.util.List;

/**
 * 表配置，解析和生成配置一起传入模板。
 *
 * @author bytechaocai
 */
public class CrudTableConfig {
    /**
     * 模式名。
     */
    private String schemaName;
    /**
     * 表名。
     */
    private String tableName;
    /**
     * 表里的列。
     */
    private List<ColumnInfo> columnList;

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnInfo> columnList) {
        this.columnList = columnList;
    }
}

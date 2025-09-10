package com.bytechaocai.fastweb.codegenerate.config;

/**
 * 字段信息。
 *
 * @author bytechaocai
 */
public class ColumnInfo {
    /**
     * 字段名。
     */
    private String columnName;
    /**
     * java中的属性名。
     */
    private String fieldName;
    /**
     * 数据库ddl中的类型。
     */
    private String columnType;
    /**
     * 长度。
     */
    private String columnLength;
    /**
     * 是否为空。
     */
    private boolean nullable;
    /**
     * 注释。
     */
    private String comment;
    /**
     * java.sql.types中的类型。
     */
    private String dataType;
    /**
     * java类型，也是实体类属性的类型。
     */
    private String javaType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}

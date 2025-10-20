package com.bytechaocai.fastweb.codegenerate.bean.crud;

/**
 * 字段信息。
 *
 * @author bytechaocai
 */
public class ColumnInfo {
    /**
     * 是否是主键。
     */
    private boolean isPrimaryKey;
    /**
     * 字段名。
     */
    private String columnName;
    /**
     * java中的属性名。
     */
    private String fieldName;
    /**
     * 大驼峰字段名。
     */
    private String upperCamelFieldName;
    /**
     * mybatis sql中的类型，#{property,jdbcType=TYPE}。
     */
    private String jdbcType;
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
    private int dataType;
    /**
     * java类型，也是实体类属性的类型。
     */
    private String javaType;

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

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

    public String getUpperCamelFieldName() {
        return upperCamelFieldName;
    }

    public void setUpperCamelFieldName(String upperCamelFieldName) {
        this.upperCamelFieldName = upperCamelFieldName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
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

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}

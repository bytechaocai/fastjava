package com.bytechaocai.fastweb.codegenerate.bean.crud;

import java.util.ArrayList;
import java.util.List;

/**
 * 要生成的表以及生成配置。
 *
 * <p>基于表生成增删改查代码。</p>
 *
 * @author bytechaocai
 */
public class CrudConfig {
    /**
     * 表名，必填。
     */
    private String tableName;
    /**
     * 实体名，由表名计算。
     */
    private String entityName;
    /**
     * 作者，默认是主机名。
     */
    private String author;
    /**
     * 根包包名，会拼接在其他包名前面。
     */
    private String rootPackage;
    /**
     * 实体类包名。
     */
    private String entityPackage;
    /**
     * dao类包名。
     */
    private String daoPackage;
    /**
     * VO类包名。
     */
    private String voPackage;
    /**
     * service类包名。
     */
    private String servicePackage;
    /**
     * 表名注释。
     */
    private String tableComment;
    /**
     * 表里的列。
     */
    private List<ColumnInfo> columnList;
    /**
     * 导包列表。
     */
    private List<String> packageList = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRootPackage() {
        return rootPackage;
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getVoPackage() {
        return voPackage;
    }

    public void setVoPackage(String voPackage) {
        this.voPackage = voPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<ColumnInfo> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnInfo> columnList) {
        this.columnList = columnList;
    }

    public List<String> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<String> packageList) {
        this.packageList = packageList;
    }
}

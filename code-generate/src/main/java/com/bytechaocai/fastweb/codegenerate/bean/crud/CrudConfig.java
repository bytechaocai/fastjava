package com.bytechaocai.fastweb.codegenerate.bean.crud;

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
     * 模块名。
     */
    private String moduleName;
    /**
     * 作者，默认是主机名。
     */
    private String author;
    /**
     * 表别名。
     */
    private String tableNameAlias;
    /**
     * 根包包名。
     */
    private String rootPackage;
    /**
     * 实体类后缀。
     */
    private String entitySuffix;
    /**
     * 实体类包名。
     */
    private String entityPackage;
    /**
     * 是否生成dao。
     */
    private boolean enableDao;
    /**
     * dao类包名。
     */
    private String daoPackage;
    /**
     * dao类后缀。
     */
    private String daoSuffix;
    /**
     * mapper.xml文件路径。
     */
    private String mapperLocation;
    /**
     * 是否生成VO。
     */
    private boolean enableVO;
    /**
     * VO类包名。
     */
    private String VOPackage;
    /**
     * VO类后缀。
     */
    private String VOSuffix;
    /**
     * 是否生成service。
     */
    private boolean enableService;
    /**
     * service类包名。
     */
    private String servicePackage;
    /**
     * service类后缀。
     */
    private String serviceSuffix;
    /**
     * 是否生成dao测试类。
     */
    private boolean enableDAOTest;
    /**
     * 是否生成service测试类。
     */
    private boolean enableServiceTest;

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTableNameAlias() {
        return tableNameAlias;
    }

    public void setTableNameAlias(String tableNameAlias) {
        this.tableNameAlias = tableNameAlias;
    }

    public String getRootPackage() {
        return rootPackage;
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getEntitySuffix() {
        return entitySuffix;
    }

    public void setEntitySuffix(String entitySuffix) {
        this.entitySuffix = entitySuffix;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public boolean isEnableDao() {
        return enableDao;
    }

    public void setEnableDao(boolean enableDao) {
        this.enableDao = enableDao;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getDaoSuffix() {
        return daoSuffix;
    }

    public void setDaoSuffix(String daoSuffix) {
        this.daoSuffix = daoSuffix;
    }

    public String getMapperLocation() {
        return mapperLocation;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    public boolean isEnableVO() {
        return enableVO;
    }

    public void setEnableVO(boolean enableVO) {
        this.enableVO = enableVO;
    }

    public String getVOPackage() {
        return VOPackage;
    }

    public void setVOPackage(String VOPackage) {
        this.VOPackage = VOPackage;
    }

    public String getVOSuffix() {
        return VOSuffix;
    }

    public void setVOSuffix(String VOSuffix) {
        this.VOSuffix = VOSuffix;
    }

    public boolean isEnableService() {
        return enableService;
    }

    public void setEnableService(boolean enableService) {
        this.enableService = enableService;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getServiceSuffix() {
        return serviceSuffix;
    }

    public void setServiceSuffix(String serviceSuffix) {
        this.serviceSuffix = serviceSuffix;
    }

    public boolean isEnableDAOTest() {
        return enableDAOTest;
    }

    public void setEnableDAOTest(boolean enableDAOTest) {
        this.enableDAOTest = enableDAOTest;
    }

    public boolean isEnableServiceTest() {
        return enableServiceTest;
    }

    public void setEnableServiceTest(boolean enableServiceTest) {
        this.enableServiceTest = enableServiceTest;
    }
}

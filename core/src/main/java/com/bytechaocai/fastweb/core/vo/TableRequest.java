package com.bytechaocai.fastweb.core.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * 分页查询参数。
 *
 * @param <T> 查询参数类型。
 *
 * @author bytechaocai
 */
public class TableRequest<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 当前页码。
     */
    private Integer current;
    /**
     * 每页数据量。
     */
    private Integer pageSize;
    /**
     * 查询参数。
     */
    private T params;
    /**
     * 排序字段。
     */
    private Map<String, String> sorter;
    /**
     * 勾选的数据主键。
     */
    private String[] idList;
    /**
     * 排序sql，
     *
     * <p>该字段只能通过sorter字段计算，不能直接赋值。</p>
     */
    private transient String sorterSql;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public Map<String, String> getSorter() {
        return sorter;
    }

    public void setSorter(Map<String, String> sorter) {
        this.sorter = sorter;
    }

    public String[] getIdList() {
        return idList;
    }

    public void setIdList(String[] idList) {
        this.idList = idList;
    }

    public String getSorterSql() {
        return sorterSql;
    }

    public void setSorterSql(String sorterSql) {
        this.sorterSql = sorterSql;
    }
}

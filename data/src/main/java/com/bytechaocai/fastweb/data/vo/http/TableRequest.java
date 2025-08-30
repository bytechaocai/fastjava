package com.bytechaocai.fastweb.data.vo.http;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页查询请求。
 *
 * @param <T> 查询条件。
 *
 * @author bytechaocai
 */
public class TableRequest<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 当前页。
     */
    private int current;
    /**
     * 每页大小。
     */
    private int pageSize;
    /**
     * 查询参数。
     */
    private T params;
    /**
     * 多选场景下的主键。
     */
    private List<String> idList;
    /**
     * 排序条件。
     */
    private Map<String, String> order;
    /**
     * 排序sql。
     */
    private transient String orderSql;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public Map<String, String> getOrder() {
        return order;
    }

    public void setOrder(Map<String, String> order) {
        this.order = order;
    }

    public String getOrderSql() {
        return orderSql;
    }

    public void setOrderSql(String orderSql) {
        this.orderSql = orderSql;
    }
}

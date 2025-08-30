package com.bytechaocai.fastweb.core.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果。
 *
 * @param <T> 查询结果类型，可以是vo，可以是entity。
 *
 * @author bytechaocai
 */
public class TableResponse<T extends Serializable> extends BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 数据量。
     */
    private long total;
    /**
     * 数据。
     */
    private List<T> dataList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}

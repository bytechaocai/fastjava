package com.bytechaocai.fastweb.data.vo.http;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果。
 *
 * @param <T> 结果类型。
 *
 * @author bytechaocai
 */
public class TableResponse<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 查询是否成功。
     */
    private boolean success;
    /**
     * 错误码。
     */
    private String code;
    /**
     * 请求结果。
     */
    private String message;
    /**
     * 总数。
     */
    private long total;
    /**
     * 查询结果。
     */
    private List<T> dataList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

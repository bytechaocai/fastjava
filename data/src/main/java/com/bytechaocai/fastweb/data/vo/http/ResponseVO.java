package com.bytechaocai.fastweb.data.vo.http;

import java.io.Serial;
import java.io.Serializable;

/**
 * http响应。
 *
 * @param <T> 数据类型。
 * @author bytechaocai
 */
public class ResponseVO<T extends Serializable>implements Serializable {
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
     * 返回的数据。
     */
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

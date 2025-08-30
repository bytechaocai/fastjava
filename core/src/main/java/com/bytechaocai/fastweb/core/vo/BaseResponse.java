package com.bytechaocai.fastweb.core.vo;

import java.io.Serial;
import java.io.Serializable;

/**
 * 请求返回结果。
 *
 * @param <T> 返回结果类型。
 *
 * @author bytechaocai
 */
public class BaseResponse<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 请求是否成功。
     */
    private boolean success;
    /**
     * 错误码，0表示成功。
     */
    private String code;
    /**
     * 提示信息。
     */
    private String message;
    /**
     * 返回数据。
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

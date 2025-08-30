package com.bytechaocai.fastweb.core.exceptions;

import java.io.Serial;

/**
 * 自定义异常的父类。
 *
 * @author bytechaocai
 */
public class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 错误码。
     */
    private String code;
    /**
     * 错误提示。
     */
    private String codeMessage;

    public BaseException(String code, String codeMessage) {
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public String getCode() {
        return code;
    }


    public String getCodeMessage() {
        return codeMessage;
    }

}

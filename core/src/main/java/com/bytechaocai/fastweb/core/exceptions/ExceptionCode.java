package com.bytechaocai.fastweb.core.exceptions;

/**
 * 异常代码。
 *
 * <p>错误码格式为&lt;模块名&gt;-&lt;错误码&gt;,其中模块名为4位数字，从1000开始，错误码为
 * 4位数字，从1开始。</p>
 *
 * @author bytechaocai
 */
public enum ExceptionCode implements ExceptionCodeInterface {
    ;
    private final String code;
    private final String message;

    ExceptionCode(String errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

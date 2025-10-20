package com.bytechaocai.fastweb.codegenerate.exceptions;

import com.bytechaocai.fastweb.core.exceptions.ExceptionCodeInterface;

/**
 * crud生成错误码。
 *
 * @author bytechaocai
 */
public enum CrudExceptionCode implements ExceptionCodeInterface {
    LOAD_META_ERROR("0000-0501", "从数据库连接中获取元数据失败"),
    LOAD_PRIMARY_ERROR("0000-0502", "加载主键信息失败"),
    LOAD_COLUMN_ERROR("0000-0503", "加载列信息失败"),
    LOAD_TABLE_ERROR("0000-0504", "加载表注释信息失败");
    private final String code;
    private final String message;

    CrudExceptionCode(String errorCode, String message) {
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

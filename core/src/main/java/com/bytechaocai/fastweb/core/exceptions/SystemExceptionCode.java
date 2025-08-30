package com.bytechaocai.fastweb.core.exceptions;

/**
 * 系统异常代码。
 *
 * <p>脚手架自带的异常代码，大多数情况下，这里的异常代码都是公用的，有两种场景涉及公用，一种是
 * 系统功能，比如没有权限，一种是一至已知异常，比如主键冲突。系统异常也需要配置到表里，在系统
 * 第一次部署时插入数据库。</p>
 *
 * @author bytechaocai
 */
public enum SystemExceptionCode {

    SUCCESS("0000-0000", "成功"),
    KNOWN_ERROR("0000-0001", "未知错误"),

    // Java标准异常 (100-199)
    NULL_POINTER("0000-0100", "NullPointerException"),
    INDEX_OUT_OF_BOUNDS("0000-0101", "IndexOutOfBoundsException"),
    NET_TIME_OUT("0000-0102", "网络超时"),
    FILE_NOT_FOUND("0000-0103", "文件或目录不存在"),

    // Spring Web相关异常 (200-299)
    HTTP_REQUEST_METHOD_NOT_SUPPORTED("0000-0200", "不支持的http请求方法"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("0000-0201", "不支持的http媒体类型"),
    NO_HANDLER_FOUND("0000-0203", "功能未上线，请联系管理员"),

    // 业务相关异常 (300-399)
    ACCESS_DENIED("0000-0300", "没有访问权限"),
    CREDENTIALS_EXPIRED("0000-0301", "认证超时"),
    DISABLED("0000-0302", "账号已禁用"),
    LOCKED("0000-0303", "账号已锁定"),
    ACCOUNT_EXPIRED("0000-0304", "账号已过期"),

    // sql异常 (400-499)
    TRANSACTION_TIMED_OUT("0000-0401", "操作超时，请联系管理员"),
    QUERY_TIMEOUT("0000-0402", "查询数据超时"),
    EMPTY_RESULT("0000-0403", "预期至少一条数据，实际没有数据"),
    TOO_MANY_RESULTS("0000-0404", "预期有一条数据，实际有一条以上数据"),
    TOO_LITTLE_RESULT("0000-0405", "预期至少一条数据，实际没有数据"),
    DUPLICATE_KEY("0000-0406", "主键冲突"),
    ;

    private final String code;
    private final String message;

    SystemExceptionCode(String errorCode, String message) {
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


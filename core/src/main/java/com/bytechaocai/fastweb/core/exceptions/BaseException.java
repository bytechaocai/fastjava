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
    private static final String MESSAGE_FORMAT = "%s:%s";
    /**
     * 错误码。
     */
    private String code;
    /**
     * 错误提示。
     */
    private String codeMessage;

    public <T extends ExceptionCodeInterface> BaseException(T t) {
        super(String.format(MESSAGE_FORMAT, t.getCode(), t.getMessage()));
        this.code = t.getCode();
        this.codeMessage = t.getMessage();
    }

    public <T extends ExceptionCodeInterface> BaseException(T t, Throwable cause) {
        super(String.format(MESSAGE_FORMAT, t.getCode(), t.getMessage()), cause);
        this.code = t.getCode();
        this.codeMessage = t.getMessage();
    }

    public BaseException(String code, String codeMessage) {
        super(String.format(MESSAGE_FORMAT, code, codeMessage));
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public BaseException(Throwable cause, String code, String codeMessage) {
        super(String.format(MESSAGE_FORMAT, code, codeMessage), cause);
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

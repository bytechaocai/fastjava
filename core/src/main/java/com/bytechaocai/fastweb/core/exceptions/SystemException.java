package com.bytechaocai.fastweb.core.exceptions;

/**
 * 系统异常。
 *
 * @author bytechaocai
 */
public class SystemException extends BaseException {
    public <T extends ExceptionCodeInterface> SystemException(T t) {
        super(t);
    }

    public <T extends ExceptionCodeInterface> SystemException(T t, Throwable cause) {
        super(t, cause);
    }

    public <T extends ExceptionCodeInterface> SystemException(String code, String codeMessage) {
        super(code, codeMessage);
    }

    public <T extends ExceptionCodeInterface> SystemException(Throwable cause, String code, String codeMessage) {
        super(cause, code, codeMessage);
    }
}

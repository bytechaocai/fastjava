package com.bytechaocai.fastweb.codegenerate.exceptions;

import com.bytechaocai.fastweb.core.exceptions.BaseException;
import com.bytechaocai.fastweb.core.exceptions.ExceptionCodeInterface;

/**
 * crud生成异常。
 *
 * @author bytechaocai
 */
public class CrudException extends BaseException {
    public <T extends ExceptionCodeInterface> CrudException(T t) {
        super(t);
    }

    public <T extends ExceptionCodeInterface> CrudException(T t, Throwable cause) {
        super(t, cause);
    }

    public CrudException(String code, String codeMessage) {
        super(code, codeMessage);
    }

    public CrudException(Throwable cause, String code, String codeMessage) {
        super(cause, code, codeMessage);
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    @Override
    public String getCodeMessage() {
        return super.getCodeMessage();
    }
}

package com.bytechaocai.fastweb.web.exceptions;

import com.bytechaocai.fastweb.core.vo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理。
 *
 * @author bytechaocai
 */
@ControllerAdvice
public class SystemExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public BaseResponse<Object> handleException(Exception e) {
        // todo 使用SystemExceptionCache获取异常code和message，如果没有，就返回未知异常。
        return new BaseResponse<>();
    }
}

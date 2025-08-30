package com.bytechaocai.fastweb.web.exceptions;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 系统异常缓存。
 *
 * <p>系统启动时加载所有系统异常到缓存。</p>
 *
 * @author bytechaocai
 */
@Component
public class SystemExceptionCache implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // todo 加载异常到缓存
    }

    // todo 判断异常是不是系统异常，如果是，就返回code和message。
}

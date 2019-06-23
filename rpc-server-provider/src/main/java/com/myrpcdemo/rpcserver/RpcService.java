package com.myrpcdemo.rpcserver;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//类、接口
@Retention(RetentionPolicy.RUNTIME)//状态
@Component
public @interface RpcService {
    Class<?> value();//服务的类或接口

    String version() default "";
}

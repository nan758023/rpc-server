package com.myrpcdemo.rpcserver;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 15:50
 */

@Configuration
@ComponentScan(basePackages = "com.myrpcdemo.rpcserver")
public class SpringConfig {

    @Bean(name = "myRpcServer")
    public MyRpcServer getMyRpcServer(){
        return new MyRpcServer(8001);
    }
}

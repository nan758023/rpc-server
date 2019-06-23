package com.myrpcdemo.rpcserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
      /*IHelloService iHelloService = new HelloServiceImpl();
      RpcProxyServer rpcProxyServer = new RpcProxyServer();
      rpcProxyServer.publisher(8000,iHelloService);*/


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext)context).start();
    }
}

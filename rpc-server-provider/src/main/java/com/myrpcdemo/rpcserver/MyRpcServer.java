package com.myrpcdemo.rpcserver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 15:48
 */

@Component
public class MyRpcServer implements ApplicationContextAware,InitializingBean {

    ExecutorService executorService = Executors.newCachedThreadPool();
    private Map<String,Object> handlerMap = new HashMap<>();

    private int port;/* = 8001;

    public MyRpcServer() {
    }*/

    public MyRpcServer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                executorService.execute(new ProcessHandler4Annotation(socket,handlerMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String,Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()){
            for (Object serviceBean :serviceBeanMap.values()){
                //得到注解
                RpcService rpcService = serviceBean.getClass().getAnnotation(RpcService.class);
                String  serviceName = rpcService.value().getName();//拿到类
                String version  = rpcService.version();
                if (!StringUtils.isEmpty(version)){
                    serviceName += "-"+version;
                }
                handlerMap.put(serviceName,serviceBean);
            }
        }

    }
}

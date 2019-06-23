package com.myrpcdemo.rpcserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 10:56
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();
    public void publisher(int port,Object service){
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                executorService.execute(new ProcessHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

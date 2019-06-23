package com.myrpcdemo.rpcserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 11:00
 */
public class ProcessHandler implements Runnable {
    private Socket socket;
    private Object service;

    public ProcessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            //调用方法
            Object result = invoke(rpcRequest);
            //返回结果
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //反射调用
        Object[] params= rpcRequest.getParams();
        Class<?>[] paramTypes = new Class[params.length];
        for (int i=0;i<params.length;i++) {
            paramTypes[i] = params[i].getClass();
        }
        Class<?> clazz = Class.forName(rpcRequest.getClassName());//HelloServiceImpl
        Method method = clazz.getMethod(rpcRequest.getMethodName(),paramTypes);//saveUser,sayHello
        Object result =method.invoke(service,params);
        return result;
    }
}

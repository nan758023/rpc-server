package com.myrpcdemo.rpcserver;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 10:51
 */
@RpcService(value = IHelloService.class,version = "v1.0")
public class HelloServiceImpl implements IHelloService{
    @Override
    public String sayHello(String message) {
        System.out.println("【v1.0】 receive from sayHello:"+ message);
        return "【v1.0】 Hello " + message +"!";
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v1.0】 receive from saveUser:"+ user);
        return "【v1.0】 Hello " + user +"!";
    }
}

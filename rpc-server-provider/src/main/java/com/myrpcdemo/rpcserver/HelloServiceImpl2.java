package com.myrpcdemo.rpcserver;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 10:51
 */
@RpcService(value = IHelloService.class,version = "v2.0")
public class HelloServiceImpl2 implements IHelloService{
    @Override
    public String sayHello(String message) {
        System.out.println("【v2.0】 receive from sayHello:"+ message);
        return "【v2.0】 Hello " + message +"!";
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v2.0】 receive from saveUser:"+ user);
        return "【v2.0】 Hello " + user +"!";
    }
}

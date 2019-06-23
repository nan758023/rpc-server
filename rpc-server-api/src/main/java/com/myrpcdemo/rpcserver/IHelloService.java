package com.myrpcdemo.rpcserver;

public interface IHelloService {
    public String sayHello(String message);
    public String saveUser(User user);
}

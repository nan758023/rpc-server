package com.myrpcdemo.rpcserver;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 17:11
 */
@RpcService(value = IUserService.class,version = "v1.1")
public class IUserServiceImpl  implements IUserService{
    @Override
    public String getUser(String id) {
        User u  = new User();
        u.setName("hhh");
        u.setAge(18);
        return "userId:"+ id + ", userInfo:" + u;
    }
}

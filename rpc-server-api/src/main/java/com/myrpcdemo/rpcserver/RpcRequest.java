package com.myrpcdemo.rpcserver;

import java.io.Serializable;

/**
 * @author ：Nan
 * @date ：Created in 2019/6/23 11:03
 */
public class RpcRequest implements Serializable{
    private String className;
    private String methodName;
    private Object[] params;
    private String version;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

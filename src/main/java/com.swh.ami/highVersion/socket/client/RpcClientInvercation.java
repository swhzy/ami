package com.swh.ami.highVersion.socket.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcClientInvercation implements InvocationHandler{
    private String host;
    private int port;

    public RpcClientInvercation(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RequestDataInfo dataInfo = new RequestDataInfo();
        dataInfo.setClassName(method.getDeclaringClass().getName());
        dataInfo.setMethodName(method.getName());
        dataInfo.setParameters(args);
        return new ManagementSocket().handlerSocket(dataInfo, host, port);
    }
}

package com.swh.ami.highVersion.socket.client;

import java.lang.reflect.Proxy;

public class RpcClientProxy {

    public static  <T> T  clientProxy(Class<T> interfaceCls,String host,int post){
       return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                interfaceCls.getInterfaces(),
                new RpcClientInvercation(host,post));
    }
}

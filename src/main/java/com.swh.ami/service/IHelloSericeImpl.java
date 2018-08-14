package com.swh.ami.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IHelloSericeImpl extends UnicastRemoteObject implements IHelloSerice{


    protected IHelloSericeImpl() throws RemoteException {
        super();
    }

    public void sayHello(String name) throws RemoteException{
        System.out.println("hello:"+name);
    }
}

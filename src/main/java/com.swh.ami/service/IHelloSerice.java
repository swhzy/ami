package com.swh.ami.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloSerice extends Remote{

    void sayHello(String name) throws RemoteException;
}

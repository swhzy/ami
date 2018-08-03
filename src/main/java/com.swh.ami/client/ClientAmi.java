package com.swh.ami.client;



import com.swh.ami.service.IHelloSerice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ClientAmi {
    public static void main(String[] args) {
        try {
            IHelloSerice helloSerice = (IHelloSerice) Naming.lookup("rmi://127.0.0.1/Hello");
            helloSerice.sayHello("bw");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

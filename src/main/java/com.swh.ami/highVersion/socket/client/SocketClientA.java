package com.swh.ami.highVersion.socket.client;

import java.io.*;
import java.net.Socket;

public class SocketClientA {
    public static void main(String[] args) throws IOException {
        ILearnService iLearnService = RpcClientProxy.clientProxy(ILearnService.class, "127.0.0.1", 10222);
        iLearnService.learn("111");
    }
}

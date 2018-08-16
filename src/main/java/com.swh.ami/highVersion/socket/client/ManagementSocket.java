package com.swh.ami.highVersion.socket.client;

import java.io.*;
import java.net.Socket;

public class ManagementSocket {

    private Socket newSocket(String host, int port) {
        try {
            System.out.println("创建一个新的连接");
            return new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException("连接异常");
        }

    }

    public Object handlerSocket(RequestDataInfo requestDataInfo, String host, int port) {
        Socket socket = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = newSocket(host, port);
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(requestDataInfo);
            outputStream.flush();
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
                if(outputStream!=null){
                    outputStream.close();
                }
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}

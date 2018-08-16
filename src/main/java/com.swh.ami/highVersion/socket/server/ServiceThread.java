package com.swh.ami.highVersion.socket.server;

import com.swh.ami.highVersion.socket.client.ILearnService;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ServiceThread implements Runnable{
    Socket socket = null;

    public ServiceThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 创建serverSocket对象绑定监听端口
      
        try {

            InputStream inputStream = socket.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            RequestDataInfo requestDataInfo = (RequestDataInfo) objectInputStream.readObject();





            InputStreamReader streamReader = new InputStreamReader(inputStream, "utf-8");

            BufferedReader reader = new BufferedReader(streamReader);

            String s = reader.readLine();
            while (s!=null){
                System.out.println(s);
                s = reader.readLine();
            }
            socket.shutdownInput();
            OutputStream stream = socket.getOutputStream();
            PrintWriter printStream = new PrintWriter(stream);
            printStream.write("哈哈");
            printStream.flush();
            Proxy.newProxyInstance(ServiceThread.class.getClassLoader()
                    , ILearnService.class.getInterfaces()
                    , new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return null;
                        }
                    });
            reader.close();
            streamReader.close();
            inputStream.close();
            socket.close();

        }catch (Exception e){

        }

    }

    void m(){
        System.out.println("haha ===");
    }
}

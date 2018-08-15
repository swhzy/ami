package com.swh.ami.Thread.socket;

import java.io.*;
import java.net.ServerSocket;
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

            reader.close();
            streamReader.close();
            inputStream.close();
            socket.close();

        }catch (Exception e){

        }

    }
}

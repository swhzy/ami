package com.swh.ami.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket  编程 基础版
 *
 *
 *
 */
public class SocketService {

    public static void main(String[] args) throws IOException {
        /**
         *   ① 创建ServerSocket对象，绑定监听端口
             ② 通过accept()方法监听客户端请求
             ③ 连接建立后，通过输入流读取客户端发送的请求信息
             ④ 通过输出流向客户端发送乡音信息
             ⑤ 关闭相关资源
         */
        // 创建serverSocket对象绑定监听端口
        ServerSocket serverSocket = new ServerSocket(10222);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        InputStreamReader streamReader = new InputStreamReader(inputStream, "utf-8");

        BufferedReader reader = new BufferedReader(streamReader);

        String s = reader.readLine();
        while (s!=null){
            System.out.println(s);
            s = reader.readLine();
        }
        accept.shutdownInput();
        OutputStream stream = accept.getOutputStream();
        PrintWriter printStream = new PrintWriter(stream);
        printStream.write("哈哈");
        printStream.flush();

        reader.close();
        streamReader.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }

}

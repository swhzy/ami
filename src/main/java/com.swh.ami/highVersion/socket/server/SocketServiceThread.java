package com.swh.ami.highVersion.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *   socket  编程基础多线程版
 *
 *   ① 创建ServerSocket对象，绑定监听端口
 ② 通过accept()方法监听客户端请求
 ③ 连接建立后，通过输入流读取客户端发送的请求信息
 ④ 通过输出流向客户端发送乡音信息
 ⑤ 关闭相关资源
 */
public class SocketServiceThread {
    public static void main(String[] args) throws IOException {
        /**
         * ① 服务器端创建ServerSocket，循环调用accept()等待客户端连接
         ② 客户端创建一个socket并请求和服务器端连接
         ③ 服务器端接受苦读段请求，创建socket与该客户建立专线连接
         ④ 建立连接的两个socket在一个单独的线程上对话
         ⑤ 服务器端继续等待新的连接
         */
        // 创建serverSocket对象绑定监听端口
        ServerSocket serverSocket = new ServerSocket(10222);

        Socket accept = null;
        int count = 0;
       while (true){
           accept = serverSocket.accept();
           ServiceThread serviceThread = new ServiceThread(accept);
           new Thread(serviceThread).start();
           count++;
           System.out.println(count);
       }
    }

}

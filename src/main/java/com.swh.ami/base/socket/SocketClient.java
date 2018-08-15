package com.swh.ami.base.socket;

import java.io.*;
import java.net.Socket;

/**
 *  ① 创建Socket对象，指明需要连接的服务器的地址和端口号
 ② 连接建立后，通过输出流想服务器端发送请求信息
 ③ 通过输入流获取服务器响应的信息
 ④ 关闭响应资源
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10222);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.write("好困啊");
        writer.flush();
        socket.shutdownOutput();
        InputStream stream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String data = null;
        while ((data = reader.readLine())!=null){
            System.out.println(data);
        }
        reader.close();
        writer.close();
        outputStream.close();
        socket.close();
    }
}

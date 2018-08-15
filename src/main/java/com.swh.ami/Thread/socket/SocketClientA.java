package com.swh.ami.Thread.socket;

import java.io.*;
import java.net.Socket;

public class SocketClientA {
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

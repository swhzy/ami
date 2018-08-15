package com.swh.ami.base.socket;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class StocketStu {

    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        byte[] address = localHost.getAddress();
        System.out.println(JSON.toJSONString(address));
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostName+" "+hostAddress);

        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String data = bufferedReader.readLine();
        while (data != null){
            System.out.println(data);
            data = bufferedReader.readLine();
        }
        bufferedReader.close();
        streamReader.close();
        inputStream.close();
    }

}

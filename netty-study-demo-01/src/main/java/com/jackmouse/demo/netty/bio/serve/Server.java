package com.jackmouse.demo.netty.bio.serve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            //1.定义一个ServerSocket对象进行服务端的端口注册
            ServerSocket serverSocket = new ServerSocket(9999);
            //2. 监听客户端的Socket连接请求
            Socket socket = serverSocket.accept();
            //3.从socket管道中得到一个字节输入流对象
            InputStream inputStream = socket.getInputStream();
            //4.把字节输入流包装成一个缓存字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            if ((msg = bufferedReader.readLine()) != null) {
                System.out.println("服务端接收到：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

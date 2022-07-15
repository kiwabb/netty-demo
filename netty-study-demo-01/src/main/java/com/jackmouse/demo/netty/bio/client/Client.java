package com.jackmouse.demo.netty.bio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.创建Socket对象请求服务端的连接
            Socket socket = new Socket("127.0.0.1", 9999);
            //2.从Socket对象中获取一个字节输出流
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("hello World! 服务端，你好");
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

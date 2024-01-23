package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在这个Server实现两个功能:
 * 1.读取客户端写入到服务端的数据并输出
 * 2.向客户端写数据
 * 技术上的实现:
 * 1.在SimpleChatServer的构造方法中构建ServerSocket对象
 * 2.在SimpleChatServer类中定义start方法,在方法内部接收客户端的连接,然后读,写客户端数据
 * 3.读写数据时要求使用BufferedReader,PrintWriter
 * 4.所有方法内部都自己处理异常
 */
public class SimpleChatServer {
    private ServerSocket server;
    public SimpleChatServer(){
        try {
            server = new ServerSocket(9999);
            System.out.println("Server Start OK!");
        }catch (IOException e){
            e.printStackTrace();//日志记录
            throw new RuntimeException("服务器启动失败");
        }
    }
    public void start(){
        //这里的循环表示可以接收多个客户端的连接请求
        while(true){
            try {
                //接收客户端连接
                Socket socket = server.accept();
                System.out.println("客户端来了");
                //构建流对象读写数据
                BufferedReader reader=
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line=reader.readLine();
                System.out.println("来自客户端的数据:"+line);
                PrintWriter writer=new PrintWriter(socket.getOutputStream());
                writer.println("hello client");
                writer.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SimpleChatServer server=new SimpleChatServer();
        server.start();
    }
}

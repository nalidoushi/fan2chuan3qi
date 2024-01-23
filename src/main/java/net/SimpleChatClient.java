package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 这个Socket客户端有个需求:
 * 1.向服务端写数据
 * 2.从服务端读数据
 * 技术上的实现:
 * 1.在SimpleChatClient的构造方法中构建Socket对象
 * 2.在SimpleChatClient定义start方法,在方法内部写,读服务端数据
 * 3.读写数据时要求使用BufferedReader,PrintWriter
 * 4.所有方法内部都有自己处理异常
 */
public class SimpleChatClient {

    private Socket socket;
    public SimpleChatClient(){
        try {
            socket=new Socket("127.0.0.1",9999);
            System.out.println("连接成功了");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("连接失败了");
        }
    }
    public void start(){
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("hello server");
            pw.flush();
            BufferedReader reader=
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String content=reader.readLine();
            System.out.println("来自服务端的数据:"+content);
            pw.close();
            reader.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleChatClient client=new SimpleChatClient();
        client.start();
    }
}

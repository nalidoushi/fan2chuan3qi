package net;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerPlus {
    public static void main(String[] args)throws Exception{
        //1.创建Server对象,并申请8088端口,然后在此端口上进行服务监听
        ServerSocket server=new ServerSocket(8088);
        System.out.println("服务启动成功");
        //2.接收客户端的连接,并为客户端分配socket对象
        Socket socket=server.accept();
        System.out.println("有新客户端连接到了服务器");
        //3.创建流对象,读取Client端发送的数据
        ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
        while(true) {
            String content = in.readUTF();
            System.out.println(content);
            if("exit".equals(content))break;
        }
    }
}

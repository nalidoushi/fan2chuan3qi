package net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络通讯中服务端,网络通讯时,先要启动服务器
 */
public class Server {
    ServerSocket server;

    /**
     * 构造方法
     * @param port
     */
    public Server(int port){
        try {
            //创建服务器对象,此对象会向操作申请一个指定的端口,并在这个端口上进行监听
            server = new ServerSocket(port);
            System.out.println("服务器启动ok");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        while(true) {
            try {
                //服务端在指定端口进行监听,等待客户端的连接
                //客户端连接到服务器以后,服务器会为客户端分配一个socket服务于客户端
                Socket client = server.accept();//accept是一个阻塞式方法
                System.out.println("有客户端连接到服务器了");
                //获取与客户端进行数据交互的流对象,然后读客户端数据
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(client.getInputStream());
                    while(true) {
                        String content = in.readUTF();
                        if(content.equals("exit"))break;
                        System.out.println(content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
           Server server=new Server(8088);
           server.start();
    }
}

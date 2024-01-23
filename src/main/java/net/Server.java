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
    public Server(int port){
        try {
            //创建服务器对象
            server = new ServerSocket(port);
            System.out.println("服务器启动ok");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            //接受客户端的连接
            Socket client = server.accept();//accept是一个阻塞式方法
            System.out.println("有客户端连接到服务器了");
            ObjectInputStream in=null;
            try
            {
                in=new ObjectInputStream(client.getInputStream());
                String content=in.readUTF();
                System.out.println(content);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                //try{client.close();}catch (Exception e){}
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
           Server server=new Server(8088);
           server.start();
    }
}

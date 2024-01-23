package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 网络通讯中的客户端
 */
public class Client {
    Socket socket;
    public  Client(){
        try {
           //与服务端指定ip和端口建立连接
           socket = new Socket("127.0.0.1", 8088);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        ObjectOutputStream out=null;
        try
        {
          //获取输出流对象,然后向服务端写数据
          out=new ObjectOutputStream(socket.getOutputStream());
          Scanner sc=new Scanner(System.in);
          while(true) {
              String content=sc.nextLine();
              out.writeUTF(content);
              out.flush();
              if(content.equals("exit"))break;
          }
        }catch (IOException e){
          e.printStackTrace();
        }finally {
         try{socket.close();}catch (Exception e){}
        }
    }
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Client client1=new Client();
       //与服务器进行数据通讯
        client1.start();
    }
}

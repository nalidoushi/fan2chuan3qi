package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 网络通讯中的客户端
 */
public class Client {
    Socket socket;
    public  Client(){
        try {
           socket = new Socket("127.0.0.1", 8088);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void start(){
        ObjectOutputStream out=null;
        try
        {
          out=new ObjectOutputStream(socket.getOutputStream());
          out.writeUTF("hello 8088");
          out.flush();
        }catch (IOException e){
          e.printStackTrace();
        }finally {
         //try{socket.close();}catch (Exception e){}
        }
    }
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Client client1=new Client();
       //与服务器进行数据通讯
        client1.start();
    }
}

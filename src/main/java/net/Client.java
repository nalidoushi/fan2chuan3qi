package net;

import java.io.IOException;
import java.net.Socket;

/**
 * 网络通讯中的客户端
 */
public class Client {
    public  Client(){
        try {
            Socket socket = new Socket("127.0.0.1", 8088);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
       Client client1=new Client();
    }
}

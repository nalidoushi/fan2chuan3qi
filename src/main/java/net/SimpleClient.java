package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象并与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 8088);
        //2.向服务端发送数据
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeUTF("hello 8088");
        out.close();
        //3.释放资源
        socket.close();
    }
}

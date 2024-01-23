package net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClientPlus {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象并与服务器建立连接
        Socket socket = new Socket("127.0.0.1", 8088);
        //2.向服务端发送数据
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String content = scanner.nextLine();
            out.writeUTF(content);
            out.flush();
            if("exit".equals(content))break;
        }
        out.close();
        //3.释放资源
        socket.close();
    }
}

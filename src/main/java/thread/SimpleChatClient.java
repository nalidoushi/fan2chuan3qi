package thread;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {
    public static void main(String[] args) {
        try {
            //1.创建Socket
            Socket socket = new Socket();
            //2.连接服务器
            socket.connect(new InetSocketAddress("127.0.0.1",9999));
            System.out.println("连接服务器成功!");
            //3.获取输出流,转换为打印流
            PrintWriter printer = new PrintWriter(socket.getOutputStream());
            //4.循环从控制台读取输入,发送给服务器
            Scanner scanner = new Scanner(System.in);
            while(true){
                String line = scanner.nextLine();
                printer.println(line);
                printer.flush();
                if("exit".equals(line))break;
            }
            //5.关闭资源
            printer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package map2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MapChatClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //1.创建Socket对象
            socket = new Socket();
            //2.连接服务器
            socket.connect(new InetSocketAddress("127.0.0.1",9999));
            //3.获取流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printer = new PrintWriter(socket.getOutputStream());
            //4.开启线程,不停的接收服务器发送的数据打印
            new Thread(new Runnable() {
                @Override
                public void run() {
                   while(true){
                       try {
                           String line = reader.readLine();
                           System.out.println("读取到服务器返回的数据:"+line);
                       } catch (IOException e) {
                           System.out.println("服务器无法连接!程序退出!");
                           break;
                       }
                   }
                }
            }).start();
            //5.循环读取控制台,将读取到的消息发往服务器
            Scanner scanner = new Scanner(System.in);
            while(true){
                String line = scanner.nextLine();
                if("exit".equals(line)) break;
                printer.println(line);
                printer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

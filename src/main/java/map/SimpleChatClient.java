package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ClientRunnable implements Runnable{

    private BufferedReader reader;

    public ClientRunnable(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            while(true){
                String line = reader.readLine();
                System.out.println("收到服务器返回的数据:"+line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("###网络通信结束,停止读取服务器信息!");
        }
    }
}

/**
 * 客户端
 */
public class SimpleChatClient {
    public static void main(String[] args) {
        try {
            //1.创建Socket
            Socket socket = new Socket();
            //2.连接服务器
            socket.connect(new InetSocketAddress("127.0.0.1",9999));
            System.out.println("连接服务器成功!");
            //3.获取流
            PrintWriter printer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //4.开启线程处理读服务器操作
            new Thread(new ClientRunnable(reader)).start();
            //5.循环从控制台读取输入,发送给服务器
            Scanner scanner = new Scanner(System.in);
            while(true){
                //--向服务器发送数据
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

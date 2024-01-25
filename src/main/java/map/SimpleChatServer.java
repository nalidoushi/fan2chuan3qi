package map;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器
 */

class SocketRunnable implements Runnable{

    private Socket socket;

    public SocketRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1.获取客户端流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printer = new PrintWriter(socket.getOutputStream());
            //--将输出流存储到集合中
            SimpleChatServer.allOut.add(printer);
            //2.循环读取数据打印,如果读到exit则退出
            while(true){
                //--读取客户端发送的数据
                String line = reader.readLine();
                if("exit".equals(line))break;
                String host = socket.getInetAddress().getHostAddress();
                System.out.println("收到客户端["+host+"]发来的数据:"+line);

                //--向所有客户端返回数据
                for(PrintWriter pw : SimpleChatServer.allOut){
                    pw.println(line);
                    pw.flush();
                }
            }
            reader.close();
            printer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class SimpleChatServer {
    //定义一个集合用于保存所有客户端的输出流,用于实现消息广播
    public static List<PrintWriter> allOut = new ArrayList<>();

    public static void main(String[] args) {
        try {
            //1.创建ServerSocket
            ServerSocket ss = new ServerSocket();
            //2.绑定端口
            ss.bind(new InetSocketAddress(9999));
            while(true){
                //3.接收客户端连接
                Socket socket = ss.accept();
                //4.创建线程,将socket交给线程来处理
                new Thread(new SocketRunnable(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

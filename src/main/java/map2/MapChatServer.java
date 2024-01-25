package map2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapChatServer {
    public static void main(String[] args) {
        //定义一个Map存储用户名和该用户的输出流的映射关系
        Map<String, PrintWriter> map = Collections.synchronizedMap(new HashMap<>());
        try {
            //1.创建ServerSocket
            ServerSocket ss = new ServerSocket();
            //2.监听指定端口
            ss.bind(new InetSocketAddress(9999));
            //3.接收客户端连接
            while(true){
                //4.获取客户端连接
                Socket socket = ss.accept();
                //5.接收用户名,将用户名和对应的输出流存储到Map中
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printer = new PrintWriter(socket.getOutputStream());
                //--读取用户姓名
                String name = reader.readLine();
                //--保存到Map中
                map.put(name,printer);
                //6.创建线程,后续和该客户端的交互交由线程处理
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                //--读取消息,消息格式为#from@to:msg
                                String line = reader.readLine();
                                //--切割字符串,得到用户名和消息
                                line = line.substring(1);
                                String[] arr = line.split("@");
                                String from = arr[0];
                                String to = arr[1].split(":")[0];
                                String msg = arr[1].split(":")[1];
                                //--通过人名找到对应的输出流
                                if(map.containsKey(to)){
                                    //--找到目标客户端的输出流
                                    PrintWriter targetPrinter = map.get(to);
                                    //--发送消息
                                    targetPrinter.println("from["+from+"]:"+msg);
                                    targetPrinter.flush();
                                    //--给发送者,报告发送成功
                                    printer.println("发送消息成功!");
                                    printer.flush();
                                }else{
                                    //--给发送者,报告发送失败
                                    printer.println("该用户不在线,发送消息失败!");
                                    printer.flush();
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("客户端断开连接!");
                        }

                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

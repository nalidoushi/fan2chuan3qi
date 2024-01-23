package net;

/**
 * 在这个Server实现两个功能:
 * 1.读取客户端写入到服务端的数据并输出
 * 2.向客户端写数据
 * 技术上的实现:
 * 1.在Server的构造方法中构建ServerSocket对象
 * 2.在Server中定义start方法,在方法内部接收客户端的连接,然后读,写客户端数据
 * 3.读写数据时要求使用BufferedReader,PrintWriter
 * 4.所有方法内部都自己处理异常
 */
public class SimpleChatServer {
}

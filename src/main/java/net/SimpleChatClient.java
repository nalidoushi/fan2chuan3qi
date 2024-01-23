package net;

/**
 * 这个Socket客户端有个需求:
 * 1.向服务端写数据
 * 2.从服务端读数据
 * 技术上的实现:
 * 1.在client的构造方法中构建Socket对象
 * 2.在client定义start方法,在方法内部写,读服务端数据
 * 3.读写数据时要求使用BufferedReader,PrintWriter
 * 4.所有方法内部都有自己处理异常
 */
public class SimpleChatClient {
}

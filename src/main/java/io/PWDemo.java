package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流是一对字符流，内部默认维护一个8192长的char数组，总是以块读写形式保证文本数据的读写
 * 效率。
 *
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流，内部总是链接着BufferedWriter作为缓冲使用
 * 其具有的特点:
 * 可以按行写出字符串
 * 可以自动行刷新
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //向文件pw.txt中写入文本数据
        /*
            PrintWriter提供了直接对文件进行写操作的构造器
            PrintWriter(File file)
            PrintWriter(String fileName)
         */
        PrintWriter pw = new PrintWriter("./pw.txt");
        pw.println("我带着比身体重的行李，游入尼罗河低.");
        pw.println("穿过几道闪电，看到一堆光圈，不确定是不是这里.");
        System.out.println("写出完毕");
        pw.close();
    }
}







package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTextDemo {
    static void doWrite()throws IOException{
        String s1="我爱Java";
        FileOutputStream fos=new FileOutputStream("f1.txt",true);//true表示追加
        fos.write(s1.getBytes(StandardCharsets.UTF_8));
        fos.close();
        System.out.println("write ok");
    }
    static void doRead01()throws IOException{
        //1.构建文件对象
        File file=new File("f1.txt");
        //2.构建字节输入流对象
        FileInputStream fis = new FileInputStream(file);
        //3.读取数据
        //3.1构建字节数组，用于存储读取的字节
        byte[] data=new byte[(int)file.length()];
        //3.2将流中的数据读取到字节数组中
        fis.read(data);
        //4.释放资源
        fis.close();
        //5.构建字符文本对象
        String s = new String(data, StandardCharsets.UTF_8);
        System.out.println(s);
    }
    static void doRead02()throws IOException{
        //1.构建字节输入流对象
        FileInputStream fis = new FileInputStream("f1.txt");
        //2.读取数据
        //2.1构建字节数组，用于存储读取的字节
        byte[] data=new byte[fis.available()];//available方法用于返回流中可读取的字节数
        //2.2将流中的数据读取到字节数组中
        fis.read(data);
        //3.释放资源
        fis.close();
        //4.构建字符文本对象
        String s = new String(data, StandardCharsets.UTF_8);
        System.out.println(s);
    }
    public static void main(String[] args) throws IOException {
        doRead02();
    }
}

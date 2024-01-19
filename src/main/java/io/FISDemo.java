package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        //构建输入流对象
        FileInputStream fis=new FileInputStream("fos.dat");
        //读数据(一次读取一个字节)
        int a = fis.read();
        System.out.println(a);
        int b=fis.read();
        System.out.println(b);
        int c=fis.read();
        System.out.println(c);
        int d=fis.read();//-1表示已经读到文件尾
        System.out.println(d);
        //释放资源
        fis.close();
    }
}

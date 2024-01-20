package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *  JAVA IO
 *  I:Input
 *  O:Output
 *
 *  流:Stream,相当于是连接我们的程序与另一端的"管道",单向的流动字节.
 *  InputStream:输入流,方向是向程序中进入的,因此是我们编写的程序用于从外界获取信息的流
 *  OutputStream:输出流:方向是向外界发送的,因此是我们编写的程序向外界写出信息的流
 *
 *  InputStream用于读,java定义了一个类:java.io.InputStream,称为输入流,它是一个抽象类
 *  是所有输入流的超类,里面定义了几个read(读)方法,规定了所有字节输入流的基本操作.
 *
 *  java.io.OutputStream是用于写的,所有字节输出流的超类,里面定义了几个write方法,用于写出
 *  字节.
 *
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //1.在当前目录构建一个文件输出流对象
        FileOutputStream fos=
                new FileOutputStream("fos.dat");
        /*
            2.向文件中写入三个整数
            java.io.OutputStream定义了写出字节的基本方法:
            void write(int d)
            写出1个字节,写出的是给定的int值对应的2进制的"低八位"

            fos.write(1):
            int型整数1的2进制:
            00000000 00000000 00000000 00000001
                                       ^^^^^^^^
                                       写出的字节

            fos.dat文件中:
            00000001


             fos.write(2):
            int型整数2的2进制:
            00000000 00000000 00000000 00000010
                                       ^^^^^^^^
                                       写出的字节
            fos.dat文件中:
            00000001 00000010



           fos.write(3):
           int型整数3的2进制:
           00000000 00000000 00000000 00000011
                                      ^^^^^^^^
                                      写出的字节
            fos.dat文件中:
            00000001 00000010 00000011
         */
        fos.write(1);//只写低8位
        fos.write(2);
        fos.write(3);
        //3.关闭流
        fos.close();
    }
}

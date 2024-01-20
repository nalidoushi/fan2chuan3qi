package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        //构建输入流对象
        FileInputStream fis=new FileInputStream("fos.dat");
        /*
            java.io.InputStream定义了:
            int read()
            读取1个字节(8位2进制),以int型返回.如果返回值为整数-1则表示流读取到了末尾


 ---------------------------------------------------------------
            fos.dat文件数据:
            00000001 00000010 00000011
 ---------------------------------------------------------------
            第一次调用:int a = fis.read();
            fos.dat文件数据:
            00000001 00000010 00000011
            ^^^^^^^^
            读取的字节

            返回值a: 00000000 00000000 00000000 00000001
                    |------自动补24个0--------| 读取到的字节

 ---------------------------------------------------------------
            第二次调用:a = fis.read();
            fos.dat文件数据:
            00000001 00000010 00000011
                     ^^^^^^^^
                     读取的字节

            返回值a: 00000000 00000000 00000000 00000010
                    |------自动补24个0--------| 读取到的字节


 ---------------------------------------------------------------
            第三次调用:a = fis.read();
            fos.dat文件数据:
            00000001 00000010 00000011
                              ^^^^^^^^
                              读取的字节

            返回值a: 00000000 00000000 00000000 00000011
                    |------自动补24个0--------| 读取到的字节

   ---------------------------------------------------------------
            第三次调用:a = fis.read();
            fos.dat文件数据:
            00000001 00000010 00000011
                                       ^^^^^^^^
                                       文件末尾

            返回值a: 11111111 11111111 11111111 11111111
                    int型的-1
         */
        //读数据(一次读取一个字节)
        int a = fis.read();
        System.out.println(a);//1
        int b=fis.read();
        System.out.println(b);//2
        int c=fis.read();
        System.out.println(c);//3
        int d=fis.read();//-1表示已经读到文件尾
        System.out.println(d);
        //释放资源
        fis.close();
    }
}

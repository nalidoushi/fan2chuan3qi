package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //1.在当前目录构建一个文件输出流对象
        FileOutputStream fos=
                new FileOutputStream("fos.dat");
        //2.向文件中写入三个整数
        fos.write(1);//只写低8位
        fos.write(2);
        fos.write(3);
        //3.关闭流
        fos.close();
    }
}

package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制应用案例
 */
public class FileCopyDemo {
    static void doCopy01() throws IOException {
        //1.创建流对象(输入流，输出流)
        FileInputStream fis = new FileInputStream("a.png");
        FileOutputStream fos = new FileOutputStream("b.png");
        //2.读写文件数据(复制)
        int data;
        while ((data = fis.read()) != -1) {//这里一次读一个字节，当读到文件尾时返回值是-1
            //将读取的数据写入到文件
            fos.write(data);
        }
        //3.释放资源(关闭流)
        fis.close();
        fos.close();
    }

    static void doCopy02() throws IOException {
        //1.创建流对象(输入流，输出流)
        FileInputStream fis = new FileInputStream("a.png");
        FileOutputStream fos = new FileOutputStream("b.png");
        //2.读写文件数据(复制)
        byte[] buf = new byte[1024];//通过此数据存储一次读取的字节数
        int len=0;
        while ((len = fis.read(buf)) != -1) {//这里一次读取多个字节,len为读取的字节数
            //将读取的字节写入到文件,0表示起始位置，len表示写长度
            fos.write(buf, 0, len);
            //假如有页面，在这个位置要返回刷新页面进度条的数据
        }
        //3.释放资源(关闭流)
        fis.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        doCopy02();
        long t2 = System.currentTimeMillis();
        //输出耗时时长
        System.out.println(t2 - t1);
    }
}

package io;

import java.io.*;

/**
 * 缓冲流
 * java.io.BufferedInputStream和BufferedOutputStream
 * 它们是一对高级流,在流连接中的作用是保证读写效率.
 * 内部维护一个默认8192(8k)的字节数组,总是以块读写形式保证读写效率
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("a_cp.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d;
        long start = System.currentTimeMillis();
        while((d = bis.read())!=-1){
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时:"+(end-start)+"ms");
        bis.close();
        bos.close();
    }
}

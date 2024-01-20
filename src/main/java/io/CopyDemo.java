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
//        BufferedInputStream bis = new BufferedInputStream(fis);
        //缓冲流也可以自定义缓冲区(内部数组大小)大小
        BufferedInputStream bis = new BufferedInputStream(fis,1024*10);

        FileOutputStream fos = new FileOutputStream("a_cp.png");
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024*10);
        int d;
        long start = System.currentTimeMillis();
        /*
            缓冲流内部有一个默认8192长的字节数组,
            以缓冲字节输入流为例:
            当我们第一次调用bis.read()方法,看似仅要求读取一个字节,而实际上缓冲流会要求其
            连接的流(这里相当于文件流fis)一次性读取8192个字节并存入到内部的数组中,然后将
            数组第一个字节返回.
            如果再次调用bis.read()方法读取一个字节时,缓冲流会直接将数组第二个字节返回,不会
            再使用文件流做实际的读取操作,依次类推.直到8192个字节全部返回后才会再次块读8192个
            字节.

            缓冲流保证读写效率实际上就是无论我们调用缓冲流的何种读写操作,其内部一定是转换为
            块读写来保证读写效率的
         */
        while((d = bis.read())!=-1){
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时:"+(end-start)+"ms");
        bis.close();
        bos.close();
    }
}

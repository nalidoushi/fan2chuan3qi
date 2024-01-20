package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流的写缓冲问题
 */
public class BosFlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "让我再看你一遍,从南到北.";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);
        bos.write(data);
        /*
            flush:冲水

            void flush()
            强制要求缓冲输出流将内部缓冲区中已经缓存的数据全部写出
         */
//        bos.flush();
        System.out.println("写出完毕");
        //缓冲流close中会自动调用一次flush方法,确保关闭前所有内容都会写出
        bos.close();
    }
}

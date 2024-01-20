package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 读取文本数据
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
//        File file = new File("fos2.txt");
        File file = new File("./src/main/java/io/ReadStringDemo.java");
        FileInputStream fis = new FileInputStream(file);
        long len = file.length();//获取文件长度
        byte[] data = new byte[(int)len];
        //将文件所有字节读取到数组中
        fis.read(data);
        //String提供了构造器可以将一组字节还原为字符串
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);
        fis.close();
    }
}





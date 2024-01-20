package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 使用转换流测试读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("osw.txt");
        FileInputStream fis = new FileInputStream("./src/main/java/io/ISRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        /*
            Reader上读取一个字符的方法:
            int read()
            读取一个字符,返回值以int型返回.如果返回值为整数-1表达流读取到了末尾
         */
//        char c = (char)isr.read();
//        System.out.println(c);

        int d;
        while((d = isr.read())!=-1){
            System.out.print((char)d);
        }

        isr.close();
    }
}

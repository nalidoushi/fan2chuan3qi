package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileTextDemo {
    public static void main(String[] args) throws IOException {
        String s1="我爱Java";
        FileOutputStream fos=new FileOutputStream("f1.txt",true);//true表示追加
        fos.write(s1.getBytes(StandardCharsets.UTF_8));
        fos.close();
        System.out.println("write ok");
    }
}

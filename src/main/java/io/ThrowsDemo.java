package io;

import java.io.*;
public class ThrowsDemo {

    public static void doCopy() throws IOException {
        FileInputStream fis=new FileInputStream("a.png");
        FileOutputStream fos=new FileOutputStream("c.png");
        byte[] buf=new byte[fis.available()];
        fis.read(buf);
        fos.write(buf);
        fis.close();
        fos.close();
        System.out.println("copy ok");
    }

    public static void main(String[] args) throws IOException{
        doCopy();
    }
}

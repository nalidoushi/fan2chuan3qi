package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 写入文本数据
 */
public class WriteStringDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos2.txt");
        String line = "改革吹风吹满地,内个吹满地~";
        //先将字符串按照UTF-8编码转换为一组字节(编码过程)
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        //再将所有字节写入到文件中
        fos.write(data);
        fos.write("中国人民真争气,内个真争气~".getBytes(StandardCharsets.UTF_8));

        System.out.println("写出完毕");
        fos.close();

    }
}

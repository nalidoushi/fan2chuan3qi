package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * java将流按照读写单位划分为字节流与字符流
 * java.io.InputStream和OutputStream是所有字节流的超类,里面定义的read,write方法参数
 * 的单位都是字节
 *
 * java.io.Reader和Writer是所有字符流的超类,里面定义的read,write方法都是以char为单位读写
 *
 * 注意:字符流都是高级流
 *
 * 转换流
 * java.io.InputStreamReader和OutputStreamWriter
 * 转换流是唯一一对可以连接在字节流上的字符流,其它字符流都只能连接其它的字符流,原因是读写的
 * 数据单位不同.
 * 转换流的作用是负责将字符与字节相互转换,使得其它字符流可以和下面的字节流串联在一起工作.
 * 相当于是一个"转换器"的作用
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件中写入文本数据
        FileOutputStream fos = new FileOutputStream("osw.txt");
        //创建转换流时可以明确字符集
        OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);

//        String line = "我期待的不是雪,而是有你的冬天.";
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);

        osw.write("我期待的不是雪,而是有你的冬天.");
        osw.write("我期待的不是月,而是和你的遇见.");
        System.out.println("写出完毕!");
        osw.close();
    }
}






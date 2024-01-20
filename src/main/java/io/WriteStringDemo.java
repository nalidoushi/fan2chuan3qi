package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //向文件中写入字符串
        FileOutputStream fos = new FileOutputStream("fos.txt");
        /*
            知识背景:
            任何字符集中英文,数字,符号都是延用了ASC编码.
            特点:单字节
            'a'在ASC编码中的2进制:01100001    对应的整数就是97
         */
        /*
            97的2进制:00000000 00000000 00000000 01100001
                                                ^^^^^^^^

            fos.dat:
            01100001
         */
//        fos.write(97);

        for(int i=0;i<127;i++){
            fos.write(i);
        }

        System.out.println("写出完毕");
        fos.close();
    }
}








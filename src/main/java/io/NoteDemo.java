package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后,要求将控制台上输入的每一行字符串都写入到文件note.txt中.
 * 如果在控制台上单独输入"exit"则程序退出
 *
 * 例如:在控制台上输入如下内容
 * 你好
 * 嘿嘿
 * 呵呵
 * exit
 *
 * note.txt:
 * 你好嘿嘿呵呵
 *
 */
public class NoteDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请开始输入内容,单独输入exit退出");
        FileOutputStream fos = new FileOutputStream("note.txt");
        while(true){
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            byte[] data = line.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
        }
        System.out.println("再见!");
        fos.close();

    }
}







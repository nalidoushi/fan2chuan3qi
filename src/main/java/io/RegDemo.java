package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * 完成用户注册功能
 * 1:设计一个类:User
 *   类中有四个属性:
 *   String username;//用户名
 *   String password;//密码
 *   int age;//年龄
 *   char gender;//性别
 *   以JavaBean形式定义
 *
 * 2:程序启动后,要求用户在控制台上顺序输入上述信息,然后使用一个User实例保存用户信息,并将
 *   该对象序列化到文件中.
 *   文件名:用户名.obj
 *
 */
public class RegDemo {
    public static void main(String[] args) throws IOException {
        /*
        System.out.println("欢迎注册:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        ...
        User user = new User(...);
        */
        User user = InputUtil.getInputObject(new User(),"欢迎注册");
        System.out.println(user);

        FileOutputStream fos = new FileOutputStream(user.getUsername()+".obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        System.out.println("注册完毕!");
        oos.close();

    }
}

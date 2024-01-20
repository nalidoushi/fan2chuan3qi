package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * java.io.ObjectInputStream和ObjectOutputStream
 * 对象流是一对高级流,在流连接中的作用是进行对象的序列化和反序列化
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        //将一个Person对象写入文件person.obj中保存
        String name = "王克晶";
        int age = 18;
        char gender = '女';
        String[] otherInfo = {"嗓门大","黑","技术好","大家的启蒙老师"};
        Person p = new Person(name,age,gender,otherInfo);

        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
            对象输出流提供的方法:
            void writeObject(Object o)
            将给定的对象进行序列化并基于对象输出流连接的流将序列化后的字节写出
            要求:该对象必须实现了序列化接口,否则会抛出异常:java.io.NotSerializableException
         */
        oos.writeObject(p);
        System.out.println("写出完毕!");
        oos.close();
    }
}

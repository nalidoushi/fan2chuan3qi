package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类实例测试对象流的序列化与反序列化操作
 * <p>
 * 对象序列化:
 * 将一个对象转换为一组可以用于网络传输或者在磁盘保存的字节的过程.
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private char gender;
    /*
        transient:瞬间的
        被该关键字修饰的属性在序列化时,它的值会被忽略
        忽略不必要的属性可以达到对象"瘦身"的目的
     */
    private transient String[] otherInfo;

    public Person() {
    }

    public Person(String name, int age, char gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}

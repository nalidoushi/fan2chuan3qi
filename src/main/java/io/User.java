package io;

import java.io.Serializable;
import io.InputUtil.InputField;

public class User implements Serializable {
    @InputField(title="用户名",notNull=true)
    private String username;
    @InputField(title="密码",notNull=true)
    private String password;
    @InputField(title="年龄",regex="[0-9]{1,2}",regexNotMathTitle="年龄只能是1-2位整数" )
    private int age;
    @InputField(title="性别")
    private char gender;

    public User(){}

    public User(String username, String password, int age, char gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

package io;

public class IntTests {
    public static void main(String[] args) {
        int a=10;//10进制
        int b=010;//8进制(以0开头)
        int c=0x10;//16进制(以0x开头)
        System.out.println(b);
        System.out.println(c);
        //将10进制转换为16进制的数据进行输出
        System.out.println(Integer.toHexString(a));
    }
}

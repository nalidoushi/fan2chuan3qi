package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * JDK8之后，java推出了一个新特性:lambda表达式
 *
 * lambda表达式可以用更简洁的语法来创建匿名内部类
 * 语法:
 * (参数列表)->{
 *     方法体
 * }
 *
 * lambda表达式可以更突出重点逻辑，而不再赘述匿名内部类的语法
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //字符串的比较规则:字符从多到少排序需要
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };
        //lambda表达式:省去了匿名内部类中接口和方法签名部分。在参数列表和方法体之间加上"->"
        Comparator<String> c1 = (String o1, String o2)->{
            return o2.length()-o1.length();
        };

        //参数类型可以忽略
        Comparator<String> c2 = (o1, o2)->{
            return o2.length()-o1.length();
        };

        //如果方法体只有一句代码，方法体的"{}"可以忽略，同时return关键字也要一同忽略
        Comparator<String> c3 = (o1, o2)->o2.length()-o1.length();

        List<String> list = new ArrayList<>();
        list.add("王克晶");
        list.add("传奇");
        list.add("伟超老师");
        Collections.sort(list,(o1, o2)->o2.length()-o1.length());
        System.out.println(list);
    }
}







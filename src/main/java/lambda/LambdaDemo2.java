package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * JDK8之后，集合提供了一种基于lambda表达式遍历元素的方法:forEach
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        for(String s : list){
            System.out.println(s);
        }
        //lambda表达式如果只有一个参数时，参数列表的"()"可以忽略不写
//        list.forEach(s->System.out.println(s));
        /*
            方法引用:
            当lambda表达式的参数列表和表达式中调用的方法参数列表一致时，可以使用方法引用写法
            语法:
            对象::方法     对应成员方法
            类名::方法     对应静态方法

            例如:
            list.forEach((s)->System.out.println(s));
                         ^^^                    ^^^
                      lambda参数-----一致-------调用方法的参数
            可以简写为:
            list.forEach(System.out::println);
         */
        list.forEach(System.out::println);
    }
}







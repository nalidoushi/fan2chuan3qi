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
        list.forEach(s->System.out.println(s));
    }
}







package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 *
 * 数组的工具类:java.util.Arrays提供了一个静态方法:asList
 * 可以将一个数组转换为一个List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println("数组:"+ Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println("List:"+list);
        /*
            对该集合的操作就是对原数组对应的操作
         */
        list.set(1,"six");
        System.out.println("List:"+list);
        System.out.println("数组:"+ Arrays.toString(array));

        /*
            由于数组是定长的,因此会影响数组长度的操作都是不支持的
            因此该集合的add,remove这些操作调用时都会抛出异常:
            java.lang.UnsupportedOperationException
                      不支持的    操作      异常
         */
//        list.add("seven");
        /*
            如果希望增删元素,只能自行再创建一个集合,并包含数组转换的集合中所有元素
         */
//        List<String> list2 = new ArrayList<>();
//        list2.addAll(list);
        //所有集合都提供了一个参数为Collection的构造器,目的是创建集合时包含给定集合所有元素
        List<String> list2 = new ArrayList<>(list);
        System.out.println("List2:"+list2);
        list2.add("seven");
        System.out.println("List2:"+list2);
    }
}

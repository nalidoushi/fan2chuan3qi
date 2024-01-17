package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * java.util.List集合
 * List-线性表
 * 特点:有序且可以存放重复元素
 *
 * List集合提供了一组方法,可以通过下标操作元素
 * 常用实现类:
 * java.util.ArrayList:内部使用数组实现,查询性能更好
 * java.util.LinkedList:内部使用链表实现,首尾增删性能更好
 *
 * 没有特别的性能要求时,通常使用ArrayList就可以完成大部分需求
 *
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
            List集合提供的方法:
            E get(int index)
            获取给定位置上的元素
         */
        //获取集合中第三个元素
        String e = list.get(2);
        System.out.println(e);

        for(int i=0;i<list.size();i++){
            e = list.get(i);
            System.out.println(e);
        }

        /*
            E set(int index,E e)
            将给定元素设置到指定位置,返回值为原位置对应的元素
            本质是替换元素操作
         */
        //将six设置到第四个位置上
        String old = list.set(3,"six");
        System.out.println(list);
        System.out.println(old);


        //把list集合元素反转
        //思路:第一个元素和最后一个元素交换位置,依次操作.
        //[one, two, three, six, five]
        for(int i=0;i<list.size()/2;i++){
            String s = list.get(i);//先将正数位置上的元素获取到
            s = list.set(list.size()-1-i,s);//将他放入倒数位置上并获取原倒数位置元素
            list.set(i,s);//将原倒数位置元素放到正数位置上
        }

        //[five,six,three,two,one]
        System.out.println(list);
        //java.util.Collections是集合的工具类,静态方法reverse可以翻转集合
        Collections.reverse(list);
        System.out.println(list);
    }
}






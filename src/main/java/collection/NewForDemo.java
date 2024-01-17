package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK1.5推出了一个新特性:增强型for循环
 * 也称为新循环,它不取代传统for循环的工作,仅用来遍历集合或数组使用
 * 语法:
 * for(元素类型 变量名 : 集合或数组){
 *     循环体
 * }
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five","six"};
        for(int i=0;i<array.length;i++){
            String e = array[i];
            System.out.println(e);
        }
        /*
            新循环是编译器认可而非虚拟机
            编译器发现使用新循环遍历数组时,会将其改回成普通的for循环遍历
         */
        //新循环遍历次数由数组长度决定,每一次循环会陆续从数组取出一个元素赋值给变量e
        for(String e : array){
            System.out.println(e);
        }

        Collection<String> c = new ArrayList();
        c.add("一");
        c.add("二");
        c.add("三");
        c.add("四");
        c.add("五");
        System.out.println(c);
        //迭代器遍历集合
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            String e = it.next();
            System.out.println(e);
        }
        /*
            新循环遍历集合,会被改回成迭代器遍历
         */
        //新循环遍历集合
        for(String e : c){
            //新循环遍历集合不可以通过集合的方法增删元素,原因:本质还是迭代器遍历
            System.out.println(e);
        }

    }
}



package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * java.util.Collection 集合
 * 集合与数组一样,可以保存一组元素.
 * 集合将元素的操作全部提供为方法,使用简便.并且集合提供了多种不同数据结构的实现.
 *
 * Collection接口下面派生了多个子接口表达不同种类的集合,其中常用的有:
 * java.util.List:可重复且有序的集合
 * java.util.Set:不可重复的集合
 * 这里重复是指元素是否可以重复,重复的标准是元素自身equals比较的结果.
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        Collection c = new HashSet();//HashSet是不可重复的集合
        /*
            boolean add(E e)
            向当前集合中添加一个元素(这里先将E当做Object看待,实际是泛型,后面会介绍)
            从方法定义可以看出,集合只能存放引用类型元素

            如果元素成功存入到集合中,则add方法返回true
         */
        boolean success = c.add("one");
        System.out.println("是否存入成功:"+success);
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        success = c.add("one");//重复元素对于Set集合而言无法存入第二次
        System.out.println("是否存入成功:"+success);
//        c.add(123);//基本类型元素看似可以直接存入,实则触发了自动装箱变为Integer
        System.out.println(c);
        /*
            int size()
            返回当前集合的元素个数
         */
        int size = c.size();
        System.out.println("size:"+size);
        /*
            boolean isEmpty()
            判断当前集合是否为空集
         */
        boolean isEmpty = c.isEmpty();
        System.out.println("是否为空集:"+isEmpty);
        /*
            void clear()
            清空集合
         */
        c.clear();
        System.out.println(c);
        System.out.println("size:"+c.size());
        System.out.println("是否为空集:"+c.isEmpty());
    }
}





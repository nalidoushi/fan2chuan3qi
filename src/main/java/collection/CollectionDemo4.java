package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合仅能保存引用类型元素,并且每个元素保存的就是元素的引用(地址)
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        //Collection<E>  E:是一个占位符,用于表示一个类型,实际使用是可以指定其实际类型
        Collection<Point> c = new ArrayList<>();//指定E的实际类型为:Point
        /*
            boolean add(E e)
            此时E就是Point类型
         */
//        c.add("one");//不是Point类型的都不能存入集合
//        c.add(123);//不行
        Point p = new Point(1,2);
        c.add(p);//将p变量的值存入集合,因此集合第一个元素也是一个地址
        System.out.println("p:"+p);//(1,2)
        System.out.println("c:"+c);//[(1,2)]

        p.setX(2);

        System.out.println("p:"+p);//(2,2)
        System.out.println("c:"+c);//[(2,2)]  集合内容也发生了变化

        doSome(p,c);
        System.out.println("p:"+p);//?
        System.out.println("c:"+c);//?
    }

    public static void doSome(Point p,Collection c){
        p.setX(5);
        p = new Point(6,7);
        c = new ArrayList();
        c.add(p);
        p.setX(8);
    }
}






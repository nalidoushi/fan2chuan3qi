package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(5,9));
        list.add(new Point(27,18));
        list.add(new Point(2,6));
        list.add(new Point(0,1));
        list.add(new Point(99,24));
        list.add(new Point(37,45));
        System.out.println(list);
        /*
            compare:比较
            Collections.sort(List)要求集合元素必须可比较，规则:元素需要实现Comparable
            不推荐这样做，因为它具有侵入性
            侵入性:当我们使用一个API时，它要求我们为其修改额外代码，那么这样的行为就是侵入性
            侵入性不利于程序后期维护，因此要尽量避免。
         */
//        Collections.sort(list);

//        MyComparator comparator = new MyComparator();
//        Collections.sort(list,comparator);

        //使用匿名内部类形式创建比较器
//        Comparator<Point> c = new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                int len1 = o1.getX()*o1.getX()+o1.getY()* o1.getY();
//                int len2 = o2.getX()*o2.getX()+o2.getY()* o2.getY();
//                return len1-len2;
//            }
//        };
//        Collections.sort(list,c);


        Collections.sort(list,new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int len1 = o1.getX()*o1.getX()+o1.getY()* o1.getY();
                int len2 = o2.getX()*o2.getX()+o2.getY()* o2.getY();
                return len1-len2;
            }
        });

        System.out.println(list);
    }
}

/*class MyComparator implements Comparator<Point>{
    @Override
    *//*
        compare方法用于定义两个参数o1与o2比较大小的规则
        返回值用于表达大小关系
        当返回值>0时，表达o1>o2的
        当返回值<0时，表达o1<o2的
        当返回值=0时，表达o1=o2的
     *//*
    public int compare(Point o1, Point o2) {
        int len1 = o1.getX()*o1.getX()+o1.getY()* o1.getY();
        int len2 = o2.getX()*o2.getX()+o2.getY()* o2.getY();
        return len1-len2;
    }
}*/

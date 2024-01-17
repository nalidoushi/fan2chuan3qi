package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合之间的操作:并集,交集,差集
 */
public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add(".net");
        c1.add("c++");
        System.out.println("c1:"+c1);
        Collection c2 = new HashSet();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2:"+c2);
        /*
            boolean addAll(Collection c)
            将给定集合所有元素添加到当前集合中(并集)
            操作后当前集合发生了改变则返回true
         */
        c1.addAll(c2);
//        c2.addAll(c1);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);


        Collection c3 = new ArrayList();
        c3.add("c++");
        c3.add("android");
//        c3.add("php");
        System.out.println("c3:"+c3);
        /*
            retainAll(Collection c)
            取交集,仅保留当前集合中与给定集合的共有元素
         */
//        c1.retainAll(c3);
//        System.out.println("c1:"+c1);
//        System.out.println("c3:"+c3);

        /*
            removeAll(Collection c)
            差集,删除当前集合中与给定集合的共有元素
         */
//        c1.removeAll(c3);
//        System.out.println("c1:"+c1);
//        System.out.println("c3:"+c3);

        /*
            boolean containsAll(Collection c)
            判断给定集合是否为当前集合的子集
         */
        boolean containsAll = c1.containsAll(c3);
        System.out.println("包含所有:"+containsAll);
    }
}






package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 元素equals方法与toString方法对集合的影响
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,10));
        /*
            集合重写了toString方法,用于展示集合内容
            格式:
            [元素1.toString(), 元素2.toString(), ....]
         */
        System.out.println(c);
    }
}






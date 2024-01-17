package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 元素equals方法与toString方法对集合的影响
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        Collection c = new HashSet();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,10));
        c.add(new Point(1,2));//重复元素也是依靠元素equals比较的
        /*
            集合重写了toString方法,用于展示集合内容
            格式:
            [元素1.toString(), 元素2.toString(), ....]
         */
        System.out.println(c);

        Point p = new Point(1,2);
        /*
            boolean contains(Object o)
            判断当前集合是否包含给定元素
            判断依据:该元素是否存在与集合现有元素equals比较为true的情况,存在则认为
            包含该元素.因此元素自身的equals方法决定着判断包含的结果.
         */
        boolean contains = c.contains(p);
        System.out.println("是否包含:"+contains);

        /*
            boolean remove(Object o)
            将给定元素从集合中删除.
            删除的是与给定元素equals比较为true的元素
            对于List而言，如果是重复元素，仅删除靠前的第一个元素，并非把所有重复的该元素都删除
         */
        c.remove(p);
        System.out.println(c);


    }
}






package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了一个方法:toArray可以将集合转换为一个数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println("集合:"+c);
//        Object[] array = c.toArray();
        String[] array = c.toArray(new String[c.size()]);
//        String[] array = c.toArray(new String[10]);
//        String[] array = c.toArray(new String[1]);
        System.out.println("数组:"+ Arrays.toString(array));
    }
}






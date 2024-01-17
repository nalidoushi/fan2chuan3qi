package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 *                                   die
 * 集合Collection提供了统一的遍历元素方式:迭代器模式
 * Iterator iterator()
 * 该方法会返回一个用于遍历当前集合的迭代器
 *
 * java.util.Iterator接口,迭代器接口
 * 定义了迭代器遍历集合的相关操作
 * 迭代器遍历集合遵循的步骤为:问->取->删
 * 其中删除不是必须操作
 *
 * 不同的集合都提供了一个用于遍历自身的迭代器实现类,我们无需记住实现类的名字,只需要用多态
 * 的思想看作为Iterator即可
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);

        /*
            1获取迭代器
            迭代器支持泛型,指定时与集合指定的泛型一致即可
            泛型不指定时默认的原形为Object
         */
        Iterator<String> it = c.iterator();
        /*
            2使用迭代器遍历集合元素
            迭代器中两个方法:
            boolean hasNext()
            判断集合是否还有下一个元素可供遍历

            E next()
            迭代器向后移动并获取该元素
         */
        while(it.hasNext()){
            String e = it.next();
            //遍历过程中将"#"元素删除
            if("#".equals(e)){//好的书写习惯:字符串字面量与变量equals时应当写为:字面量.equals(变量);避免空指针的产生
                /*
                    迭代器要求:
                    使用迭代器遍历集合的过程中不可以通过集合的方法增删元素
                    否则会抛出异常:java.util.ConcurrentModificationException
                 */
//                c.remove(e);
                /*
                    迭代器也提供了remove方法,删除本次通过next方法获取的元素
                 */
                it.remove();
            }
            System.out.println(e);
        }
        System.out.println(c);

    }
}








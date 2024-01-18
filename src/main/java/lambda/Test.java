package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 创建一个List集合，里面存入10个0-100之间的随机整数
 * 将集合按照从大到小排序后，遍历输出每个元素
 * 排序时:使用lambda创建比较器
 * 遍历时:forEach方法遍历输出
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list,(o1,o2)->o2-o1);
        /*
            JDK8之后，List自身也提供了sort方法，对List集合内容进行排序
         */
        list.sort((o1,o2)->o2-o1);
        System.out.println(list);
        list.forEach(System.out::println);
    }
}





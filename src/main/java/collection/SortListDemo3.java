package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 */
public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //字符串实现了Comparable接口，比较规则是按照字符的unicode对应的整数大小
//        list.add("tom");
//        list.add("jerry");
//        list.add("jack");
//        list.add("rose");
//        list.add("ada");
//        list.add("Jackson");
//        list.add("James");
//        list.add("Bill");
//        list.add("petter");
        list.add("王克晶");//该规则对于排序中文而言作用不大
        list.add("传奇");
        list.add("伟超老师");
        System.out.println(list);
//        Collections.sort(list);
        //为排序字符串定义比较规则:按照字符多少排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
                //反过来减就可以实现降序
                return o2.length()-o1.length();
            }
        });
        System.out.println(list);
    }
}






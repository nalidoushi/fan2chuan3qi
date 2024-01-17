package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了获取子集的操作
 * List subList(int start,int end)
 * 获取指定下标范围内的子集,两个下标含头不含尾
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(2,8);
        System.out.println("subList:"+subList);
        //将子集每个元素扩大10倍
        for(int i=0;i<subList.size();i++){
            int n = subList.get(i);
            n = n * 10;
            subList.set(i,n);
        }
        /*
            对子集的操作就是对原集合对应的操作
         */
        //[20,30,40,50,60,70]
        System.out.println("subList:"+subList);
        System.out.println(list);
        //将list集合中的1-8删除
        list.subList(1,9).clear();
        System.out.println(list);


    }
}

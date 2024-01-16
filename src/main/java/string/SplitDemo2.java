package string;

import java.util.Arrays;

/**
 * 重载的split方法
 * String[] split(String regex,int limit)
 * limit用于限制拆分项的个数
 */
public class SplitDemo2 {
    public static void main(String[] args) {
        String line = "a=b=c=d=e=f=========";
        String[] array = line.split("=");
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));

        //仅拆分出2项
        array = line.split("=",2);
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));

        array = line.split("=",3);
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));
        //后面连续拆分出的空字符串都会得以保留
        array = line.split("=",10);
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));
        //当limit超过了最多可拆分项时，仅为最多可拆分项
        array = line.split("=",20);//数组长度15(最多可拆分项)
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));

        //limit=0时，与split(String regex)效果一致
        array = line.split("=",0);
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));

        //limit<0时为"应拆尽拆"
        array = line.split("=",-1);
        System.out.println("len:"+array.length);
        System.out.println("array:"+ Arrays.toString(array));
    }
}

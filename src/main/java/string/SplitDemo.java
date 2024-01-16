package string;

import java.util.Arrays;

/**
 * String支持正则表达式的方法二:
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分拆分，并将拆分后的所有部分以数组形式返回
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str = "abc123def456ghi";
        String[] array = str.split("[0-9]+");
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));

        //如果连续遇到可拆分项时，中间会拆分出一个空字符串
        str = "abc==def=ghi";
        array = str.split("=");
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        //字符串最开始出现可拆分项时，那么最开始会拆分出一个空字符串
        str = "==abc=def=ghi";
        array = str.split("=");
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        //末尾连续出现可拆分项时，拆分出的空字符串都会被舍弃
        str = "abc=def=ghi==========";
        array = str.split("=");
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));

        /*
            123.jpg
            18972378162783.jpg
         */
        String image = "123.jpg";
        //后缀  names:[123,jpg]
        String[] names = image.split("\\.");
        String name = System.currentTimeMillis()+"."+names[1];
        System.out.println(name);
    }
}




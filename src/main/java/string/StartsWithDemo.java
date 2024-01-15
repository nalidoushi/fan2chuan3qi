package string;

/**
 * boolean startsWith(String str)
 * 判断当前字符串是否是以给定字符串开始的
 *
 * boolean endsWith(String str)
 * 判断当前字符串是否是以给定字符串结尾的
 *
 */
public class StartsWithDemo {
    public static void main(String[] args) {
        String str = "www.tedu.cn";
        boolean starts = str.startsWith("www");
        System.out.println("starts:"+starts);//true

        boolean ends = str.endsWith(".com");
        System.out.println("ends:"+ends);//false
    }
}

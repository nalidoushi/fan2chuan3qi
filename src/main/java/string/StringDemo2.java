package string;

/**
 * String修改字符串的性能问题
 * String频繁修改性能低，开销大。因此不利于进行修改内容操作。
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str = "a";
        for (int i = 0; i < 1000000; i++) {
//            str = str + "a";
            str = new StringBuilder(str).append("a").toString();
        }
        System.out.println("执行完毕");
    }
}

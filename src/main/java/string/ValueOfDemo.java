package string;

/**
 * String提供了一组静态的方法:valueOf
 * 用于将java中其他类型转换为字符串
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int a = 123;
        String s1 = String.valueOf(a);//s1="123";
        System.out.println(s1);

        double d = 123.123;
        String s2 = String.valueOf(d);//s2="123.123";
        System.out.println(s2);

        String s3 = a+"";
        System.out.println(s3);
    }
}

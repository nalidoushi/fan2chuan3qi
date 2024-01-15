package string;

import java.util.Scanner;

/**
 * String toUpperCase()
 * 将当前字符串中的英文部分转换为全大写
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全小写
 */
public class ToUpperCaseDemo {
    public static void main(String[] args) {
        String str = "我爱Java";
        System.out.println(str);

        String upper = str.toUpperCase();
        System.out.println(upper);

        String lower = str.toLowerCase();
        System.out.println(lower);



        String code = "A8s4Q5k";
        System.out.println("请输入验证码:A8s4Q5k");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "a8s4q5k";
        /*
            ==是"值比较"，比较两个变量的值是否相同
            对于引用类型变量而言，值就是对象的地址，除非两个引用类型变量引用的是同一个
            对象地址才会相同。

            对于字符串而言，我们通常比较相等的需求是"比较字符串的内容是否相等"。因此
            通常我们并不关心两个字符串变量的地址是否相同，而更多关心的是两个字符串对象
            的内容是否相同。
            此时应当使用字符串提供的方法:equals
            该方法的作用是判断两个字符串对象的内容是否相同。
            因此实际开发中我们总是使用equals方法来比较字符串"相等"的
         */
//        System.out.println(code==input);//不要用==比较字符串内容

        //为了忽略大小写问题，可以将两个字符串都转换为全大写或全小写
//        code = code.toUpperCase();
//        input = input.toUpperCase();
//        System.out.println(code.equals(input));

        /*
            String提供了忽略大小写判断字符串内容的方法了
         */
        System.out.println(code.equalsIgnoreCase(input));
    }
}




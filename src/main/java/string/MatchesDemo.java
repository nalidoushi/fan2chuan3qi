package string;

/**
 * String支持正则表达式的方法一:
 * boolean matches(String regex)
 * 使用给定的正则表达式验证当前字符串内容，如果如何格式要求则返回true
 */
public class MatchesDemo {
    public static void main(String[] args) {
        /*
            邮箱的正则表达式
            用户名@域名.后缀
            [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
         */
        String email = "fancq@tedu.com.cn";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean match = email.matches(regex);
        if(match){
            System.out.println("是邮箱");
        }else{
            System.out.println("不是邮箱");
        }
    }
}

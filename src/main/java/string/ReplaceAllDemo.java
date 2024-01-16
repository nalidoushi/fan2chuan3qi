package string;

/**
 * String支持正则表达式的方法三:
 * String replaceAll(String regex,String replacement)
 * 将当前字符串中满足正则表达式的部分替换为给定内容
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String str = "abc123def456ghi";
//        String line = str.replaceAll("[0-9]+","NUMBER");
        String line = str.replaceAll("[a-z]+","NUMBER");
        System.out.println(line);

        String regex = "(wqnmlgb|dsb|cnm|nc|mdzz|nmsl|fw|djb)";
        String message = "wqnmlgb!你个fw,你怎么这么nc,纯纯的dsb,你个djb!";
        message = message.replaceAll(regex,"***");
        System.out.println(message);
    }
}

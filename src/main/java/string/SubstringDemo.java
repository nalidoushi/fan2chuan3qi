package string;

/**
 * String substring(int start,int end)
 * 截取当前字符串从下标start处开始到end处结尾部分的字符串内容
 * 需要注意:在Java api中，通常使用两个数字表示范围时，都是"含头不含尾"的。
 */
public class SubstringDemo {
    public static void main(String[] args) {
        //            01234567890
        String str = "www.tedu.cn";
        String sub = str.substring(4,8);//tedu
        System.out.println(sub);
        //重载的方法可以从指定位置一直截取到字符串末尾
        sub = str.substring(4);
        System.out.println(sub);

    }
}




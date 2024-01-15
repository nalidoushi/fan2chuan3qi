package string;

/**
 * int indexOf(String str)
 * 检索给定字符串在当前字符串中第一次出现的位置。如果当前字符串不含有给定内容则返回值为-1
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        //            0123456789012345
        String str = "thinking in java";
        //检索str中第一次出现"in"的位置
        int index = str.indexOf("in");
        System.out.println(index);//2
        //如果str中不含有给定内容，则返回值为-1
        index = str.indexOf("IN");
        System.out.println(index);//-1

        //从指定位置开始检索第一次出现的位置
        index = str.indexOf("in",2);
        System.out.println(index);//2
        index = str.indexOf("in",3);
        System.out.println(index);//5
        //检索最后一次出现的位置
        index = str.lastIndexOf("in");
        System.out.println(index);
    }
}




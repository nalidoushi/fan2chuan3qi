package string;

/**
 * StringBuilder是专门用于修改字符串的工具类
 * 内部维护一个可变的char数组。
 * 提供了编辑字符串内容的相关操作:
 * 增:append
 * 删:delete
 * 改:replace
 * 插:insert
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String str = "好好学习java";
//        StringBuilder builder = new StringBuilder(str);
        StringBuffer builder = new StringBuffer(str);
        /*
            增:append
            好好学习java
                V
            好好学习java,为了找个好工作
         */
        builder.append(",为了找个好工作");
        str = builder.toString();//将StringBuilder内部的内容以String形式返回
        System.out.println(str);

        /*
            改:replace
            好好学习java,为了找个好工作
                V
            好好学习java,就是为了改变世界
         */
        builder.replace(9,16,"就是为了改变世界");
        System.out.println(builder);

        /*
            删:delete
            好好学习java,就是为了改变世界
                V
            ,就是为了改变世界
         */
        builder.delete(0,8);
        System.out.println(builder);

        /*
            插:insert
            ,就是为了改变世界
                V
            活着,就是为了改变世界
         */
        builder.insert(0,"活着");
        System.out.println(builder);

        //反转字符串
        builder.reverse();
        System.out.println(builder);
    }
}

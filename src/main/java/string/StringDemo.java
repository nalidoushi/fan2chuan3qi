package string;

/**
 * java.lang.String
 * String内部维护一个char数组，用来表示一个字符串。
 * String是不变对象:一旦创建，字符串内容不可改变，改变内容会创建新对象
 *
 * java对字符串有一个优化:常量池
 * 常量池是在JVM内部的堆内存中创建一段内存区域，用来保存所有使用字面量形式创建的字符串
 * 对象。当再次使用相同字面量创建字符串对象时JVM会直接重用常量池中的对象来减少内存开销。
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "123abc";//第一次使用某字面量创建字符串时该对象会缓存在常量池中
        String s2 = "123abc";//使用相同字面量创建字符串时会重用对象
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println(s1==s2);//true 地址相同，引用了同一个对象
        String s3 = "123abc";//依然重用了s1指向的对象
        System.out.println("s3:"+s3);
        System.out.println(s1==s3);
        //new比较强制，一定创建新对象，java不推荐这样创建字符串
        String s4 = new String("123abc");
        System.out.println("s4:"+s4);
        System.out.println(s1==s4);//与s1地址不同

        //字符串是不变对象，修改内容会创建新对象，并且该对象不缓存到常量池。
        s1 = s1+"!";//会产生一个新对象并将地址赋值给s1
        System.out.println("s1:"+s1);//123abc!
        System.out.println("s2:"+s2);//123abc
        System.out.println(s1==s2);//地址不相同了

        /*
            编译器的预编译特性:
            当编译器编译代码时发现一个计算表达式可以在编译期间就能计算结果时则会直接
            进行计算，并将结果编译到字节码文件中
            有时候写一个计算表达式更能表达值的含义时可以使用计算表达式说明来增强可读性
            例如:
            int a = 60*60*24*1000; 该计算表达式表明值是一天有多少毫秒

            同理
            String s5 = "123"+"abc";
            编译器编译后改为：
            String s5 = "123abc";//因此它会重用常量池对象
         */
        String s5 = "123"+"abc";
        System.out.println("s5:"+s5);
        System.out.println(s2==s5);//地址相同，s5重用了常量池对象

        String s = "123";
        String s6 = s + "abc";//拼接字符串产生新对象
        System.out.println("s6:"+s6);
        System.out.println(s2==s6);//false
    }
}








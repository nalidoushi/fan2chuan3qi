package object;

/**
 * 测试派生类重写Object常用的方法:toString和equals
 */
public class Demo {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        /*
            开发中常见的一个操作:
            将一个对象输出到控制台上查看其内容

            Object定义了toString方法,作用是将一个对象转换为一个字符串
            默认实现格式:类名@地址
         */
//        String line = point.toString();
//        System.out.println(line);
        //输出时会调用point的toString方法将转换的字符串输出到控制台上
        System.out.println(point);


    }
}

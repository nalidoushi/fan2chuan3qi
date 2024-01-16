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
        /*
            另一个常见操作:
            字符串和任何类型连接,结果都是字符串,意味着其它类型都可以转换为字符串
            转换字符串也是依靠着toString方法
         */
        String line = "这是一个点:" + point;
        System.out.println(line);


        Point p2 = new Point(1,2);
        System.out.println("p2:"+p2);
        /*
            引用类型变量保存的是对象的"地址"
            ==是值比较,比较两个变量的值是否相同,对于引用类型变量而言相当于比较的
            是地址是否相同,逻辑:比较是否为同一个对象
         */
        System.out.println(point==p2);//false
        /*
            Object定义了equals方法,目的是比较两个对象的内容是否相同
            但是站在Object的角度,"东西"是没有特征的,因此它的默认实现使用"=="比较
            因此,子类如果希望比较两个实例是否内容相同需要重写该方法,结合自身的特征
            进行比较.
         */
        System.out.println(point.equals(p2));//true
    }
}

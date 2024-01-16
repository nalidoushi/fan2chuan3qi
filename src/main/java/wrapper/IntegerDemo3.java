package wrapper;

/**
 * JDK1.5推出时推出了一个新特性:自动拆装箱
 *
 */
public class IntegerDemo3 {
    public static void main(String[] args) {
        int a = 123;
        /*
            当我们将基本类型值直接赋值给引用类型变量时会触发编译器的自动装箱特性
            自动装箱:
            编译器会补充代码将基本类型转换为包装类
            Integer in = a;
            会被编译器改为:
            Integer in = Integer.valueOf(a);
            字节码文件中是上述样子.
         */
        Integer in = a;
        /*
            将包装类对象直接赋值给基本类型变量则会触发自动拆箱特性
            编译器会将代码:
            int b = in;
            改为:
            int b = in.valueOf();
         */
        int b = in;

        doSome("hello");
        //触发自动装箱:doSome(Integer.valueOf(123));
        doSome(123);
    }

    public static void doSome(Object o){

    }
}





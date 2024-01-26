package reflect;

import java.lang.reflect.Method;

/**
 * 暴力反射,突破访问权限控制
 * clz.getDeclaredField();
 * clz.getDeclaredMethod();
 * clz.getDeclaredConstructor();
 * setAccessible();
 */
class Person6{
    private String name;
    private int age;

    public Person6() {
    }

    private Person6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void eat(){
        System.out.println("吃..");
    }
}
public class Demo06 {
    public static void main(String[] args) throws Exception {
        Person6 p = new Person6();

        Class<? extends Person6> clz = p.getClass();

        //Method mx = clz.getMethod("eat");
        //mx.invoke(p);

        //获取到原来看不到的方法
        Method mx = clz.getDeclaredMethod("eat");
        //开启强行访问
        mx.setAccessible(true);
        mx.invoke(p);
    }
}

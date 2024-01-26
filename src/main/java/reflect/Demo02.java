package reflect;

import java.lang.reflect.Constructor;

/**
 * Constructor 构造器类
 */

class Person2{
    public Person2() {
        System.out.println("无参构造Person..");
    }
    public Person2(String name) {
        System.out.println("一参构造Person.."+name);
    }
    public Person2(String name,int age){
        System.out.println("两参构造Person.."+name+"#"+age);
    }

}

public class Demo02 {
    public static void main(String[] args) throws Exception{

        Class<Person2> clz = Person2.class;

        //快捷方式创建对象 - 使用无参构造
        //Person2 p = clz.newInstance();

        //获取指定类型构造器
        Constructor<Person2> cons1 = clz.getConstructor();
        Constructor<Person2> cons2 = clz.getConstructor(String.class);
        Constructor<Person2> cons3 = clz.getConstructor(String.class, int.class);

        //通过构造器创建对象
        Person2 px1 = cons1.newInstance();
        Person2 px2 = cons2.newInstance("zs");
        Person2 px3 = cons3.newInstance("ls", 18);

    }
}

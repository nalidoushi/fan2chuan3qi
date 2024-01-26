package reflect;

import java.lang.reflect.Field;

/**
 * Field 属性类
 */
class Person3{
    public String name;
    public int age;
}

public class Demo03 {
    public static void main(String[] args) throws Exception {
        Class<Person3> clz = Person3.class;

        //获取类的属性信息
        Field[] fds = clz.getFields();
        Field fd1 = clz.getField("name");
        Field fd2 = clz.getField("age");

        //获取属性名
        String name = fd1.getName();
        System.out.println(name);

        //获取属性类型
        Class<?> type = fd1.getType();
        System.out.println(type);

        //获取属性值
        Person3 px1 = new Person3();
        px1.name = "zs";
        Person3 px2 = new Person3();
        px2.name = "ls";
        String n1 = (String) fd1.get(px1);
        System.out.println(n1);
        String n2 = (String) fd1.get(px2);
        System.out.println(n2);

        //设置属性值
        Person3 px3 = new Person3();
        fd2.setInt(px3,99);
    }

}

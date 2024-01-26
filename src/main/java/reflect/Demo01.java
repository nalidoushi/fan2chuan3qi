package reflect;

import java.util.Arrays;

interface Eat{}
interface Run{}

class Person implements Eat,Run  {

}

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1.获取类的class
        //--通过类名来获取
        Class<Person> clz1 = Person.class;
       //--通过对象来获取
        Person p1 = new Person();
        Class clz2 = p1.getClass();
        //--通过类名来获取
        Class clz3 = Class.forName("reflect.Person");

        //2.常用方法
        //--获取类名
        String name = clz1.getName();
        System.out.println(name);
        //--获取类的简单名称
        String name2 = clz1.getSimpleName();
        System.out.println(name2);
        //--获取类的包
        String pack = clz1.getPackage().getName();
        System.out.println(pack);
        //--获取类的父类
        Class supClz = clz1.getSuperclass();
        System.out.println(supClz);
        //--获取类实现的接口们
        Class[] intfs = clz1.getInterfaces();
        System.out.println(Arrays.asList(intfs));
        //--判断Class代表的是否是一个接口 枚举 集合 注解
        System.out.println(clz1.isInterface());
        System.out.println(clz1.isEnum());
        System.out.println(clz1.isArray());
        System.out.println(clz1.isAnnotation());

    }
}

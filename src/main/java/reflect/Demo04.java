package reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Method 方法类
 */
class Person4{
    private String name;

    public Person4(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(name+"说..");
    }
    public void eat(String food){
        System.out.println(name+"吃.."+food);
    }
    public String eat(String food1,String food2){
        System.out.println(name+"吃.."+food1+"就着.."+food2);
        return "八瓶啤酒";
    }
}

public class Demo04 {
    public static void main(String[] args) throws Exception {
        Class<Person4> clz = Person4.class;

        //获取方法对象
        Method[] methods = clz.getMethods();
        Method m1 = clz.getMethod("say");
        Method m2 = clz.getMethod("eat", String.class);
        Method m3 = clz.getMethod("eat", String.class, String.class);

        //方法类常用方法
        String name = m3.getName();
        System.out.println(name);
        Class<?>[] pTypes = m3.getParameterTypes();
        System.out.println(Arrays.asList(pTypes));
        Class<?> returnType = m3.getReturnType();
        System.out.println(returnType);

        //反射执行方法
        Person4 px1 = new Person4("王五");
        Person4 px2 = new Person4("赵六");

        Object retObj = m3.invoke(px1, "羊肉串", "大蒜");
        System.out.println(retObj);
    }
}

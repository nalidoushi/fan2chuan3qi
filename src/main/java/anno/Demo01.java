package anno;

/**
 * Java原生注解
 * @Override
 * @Deprecated
 * @SuppressWarnings
 */

class Person{
    public void say(){
        System.out.println("说话..");
    }
    @Deprecated
    public void eat(){
        System.out.println("吃饭..");
    }
    public void eat2(){
        System.out.println("洗个手..吃饭..洗个脸..");
    }
}
class Teacher {
    @Override
    public void say(){
        System.out.println("一本正经的说..");
    }
}

public class Demo01 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Person p = new Teacher();
        p.eat();
        p.say();
        p.eat2();
    }
}

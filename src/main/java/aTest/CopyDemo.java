package aTest;

class Number{
    int num;
}
class Person implements Cloneable{
    public int age;
    public Number number;
    public Person(int age,Number num){
        this.age = age;
        this.number = num;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class CopyDemo extends Object{
    public static void main(String[] args) throws Exception{
        Person p1 = new Person(18,new Number());
        Person p2 = (Person) p1.clone();
        System.out.println(p1.age == p2.age);
        p1.age = 15;
        System.out.println(p1.age == p2.age);

        System.out.println(p1.number.num== p2.number.num);
        p1.number.num=5;
        System.out.println(p1.number.num== p2.number.num);
    }

}

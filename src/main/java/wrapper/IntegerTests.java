package wrapper;

public class IntegerTests {
    public static void main(String[] args) {
        Integer a1=100;  //自动装箱，底层调用valueOf进行自动装箱
        Integer a2=100;
        Integer a3=200;
        Integer a4=200;
        System.out.println(a1==a2);//true (从整数池获取的是同一个对象,整数池-128~+127)
        System.out.println(a3==a4);//false (整数池没有200，每次会创建新的对象)
        int a5=200;
        boolean flag=a4==a5;//true (在这里a4会自动拆箱)
        print(flag);
    }
    static void print(boolean flag){
        System.out.println(flag);
    }
}

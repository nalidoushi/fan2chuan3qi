package aTest;

public class A {
    public void run(){
        System.out.println("父类跑步");
    }
    public void work(){
        System.out.println("父类工作");
    }
}
class B extends A{
    public void run(){
        System.out.println("子类跑步");
    }
    public void study(){
        System.out.println("子类学习");
    }

    public static void main(String[] args) {
        A a = new B();
        /*a.run();
        a.work();*/
        //此时如果调用子类独有的方法
        if(a instanceof B){
            B b = (B)a;
            b.study();
        }

    }
}

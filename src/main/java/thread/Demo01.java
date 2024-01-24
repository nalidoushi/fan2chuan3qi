package thread;

public class Demo01 {
    public static void main(String[] args) {
        MyThread01 t01 = new MyThread01("from 01..");
        t01.start();
        MyThread01 t02 = new MyThread01("from 02..");
        t02.start();
        MyThread02 t03 = new MyThread02();
        t03.start();
        //匿名内部类方式,快速创建线程
       new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("print from inner Thread..");
                }
            }
        }.start();

    }
}

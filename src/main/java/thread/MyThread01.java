package thread;

/**
 * 线程创建方式1:
 * 写一个类继承Thread
 * 重写其中的run方法,在其中写上线程要执行的代码
 * 创建当前线程类的对象
 * 调用其start()方法即可启动一个线程
 */
public class MyThread01 extends Thread {
    private String msg;
    public MyThread01(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("t1 is running..."+msg);
        }
    }
}

package thread;

public class MyThread02 extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println("当前时间:"+System.currentTimeMillis());
        }
    }
}

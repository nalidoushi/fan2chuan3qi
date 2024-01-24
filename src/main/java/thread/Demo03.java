package thread;
/**
 * 线程之间的关系：
 * 程序从main方法启动时，本身就是启动了一个线程称之为主线程
 * 任意线程中都可以开启新的线程
 * 默认情况下，线程之间都是平等的，平等的抢夺cpu执行
 * 只有程序中所有的线程都结束了，程序才会结束
 */
public class Demo03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"#"+t1.getName()+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1.getId()+"#"+t1.getName()+"..stop..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"#"+t1.getName()+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1.getId()+"#"+t1.getName()+"..stop..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread tx = Thread.currentThread();
        System.out.println(tx);

        System.out.println("主线程结束了..");
    }
}

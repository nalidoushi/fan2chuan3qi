package thread;

public class Demo03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1+"..stop..");
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
                    System.out.println(t1+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1+"..stop..");
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

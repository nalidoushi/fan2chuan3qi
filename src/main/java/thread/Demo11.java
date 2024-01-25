package thread;

public class Demo11 {
    static int i = 0;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (Demo11.class) {
                        Thread.sleep(2000);
                        System.out.println("弟弟买米回来了..");
                        i++;
                        Demo11.class.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (Demo11.class) {
                        Thread.sleep(3000);
                        System.out.println("姐姐买菜回来了..");
                        i++;
                        Demo11.class.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (Demo11.class) {
                        Thread.sleep(5000);
                        System.out.println("爸爸买锅回来了..");
                        i++;
                        Demo11.class.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        synchronized (Demo11.class){
            try {
               while(i<3){
                    Demo11.class.wait();
               }
                System.out.println("妈妈开始做饭了~~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

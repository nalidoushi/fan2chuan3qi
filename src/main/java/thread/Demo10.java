package thread;

/**
 * 线程间的通信
 */
public class Demo10 {
    private static String name = "小明";
    private static String gender = "男";
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (Demo10.class) {
                            if("小明".equals(name)){
                                name = "小花";
                                gender = "女";
                            } else {
                                name = "小明";
                                gender = "男";
                            }
                            Demo10.class.notify();
                            Demo10.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (Demo10.class) {
                        try {
                            System.out.println(name+"#"+gender);
                            Demo10.class.notify();
                            Demo10.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

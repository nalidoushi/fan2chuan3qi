package thread;



/**
 * 线程常用API：
 * Thread.currentThread()
 * Thread.sleep()
 *
 * 需要了理解,无需练习:
 * long getId():返回该线程的标识符
 * String getName():返回该线程的名称
 * void setName(String name):设置线程的名字
 * setPriority():设置线程优先级
 * int getPriority():返回线程的优先级
 * boolean isAlive():测试线程是否处于活动状态
 * void setDaemon():设置线程为守护线程
 * boolean isDaemon():测试线程是否为守护线程
 * boolean isInterrupted():测试线程是否已经中断
 */
public class Demo04 {
    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }

    /**
     * 守护线程
     */
    public static void test03(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("用户线程在执行..");
                    Thread.sleep(3000);
                    System.out.println("用户线程执行结束..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                        System.out.println("守护进程在执行..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }

    /**
     * 测试alive
     */
    public static void test02(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"开始运行..");
                    Thread.sleep(3000);
                    System.out.println(t1.getId()+"运行结束..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        while(true){
            System.out.println("主线程检测到t1是否存活:"+t1.isAlive());
        }

    }

    /**
     * 测试Priority
     */
    public static void test01(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("t1");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("t2");
                }
            }
        });

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }

}

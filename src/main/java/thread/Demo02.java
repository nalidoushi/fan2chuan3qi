package thread;

/**
 * 创建线程的方式2：
 *  写一个类实现Runnable接口，实现run()方法，定义出任务类
 *  创建任务类的对象
 *  创建线程对象，传入任务对象
 *  调用线程对象的start()方法，启动线程
 */
public class Demo02 {
    public static void main(String[] args) {
        MyRunnable01 r01 = new MyRunnable01();
        Thread t1 = new Thread(r01);
        t1.start();

        MyRunnable02 r02 = new MyRunnable02();
        Thread t2 = new Thread(r02);
        t2.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    System.out.println("Inner Runnable print..");
                }
            }
        }).start();
    }
}

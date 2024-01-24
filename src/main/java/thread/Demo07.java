package thread;

/**
 * 多线程并发安全问题的解决 - 同步代码块 - synchronized(){}机制
 *
 * 使用共享资源作为锁对象
 * 使用this
 * 使用类的class做为锁对象
 *
 * 锁对象必须是同一个对象,才能互斥
 * 因此必须选择所有要互斥的线程都能看到的对象作为锁对象
 * 锁的抢夺是随机,并不保证顺序
 * 加锁时尽量只加有风险的代码,其它代码尽量不要加进去,减少性能损耗
 */
public class Demo07 {
    private static String name = "小明";
    private static String gender = "男";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("其它无关代码..");
                    synchronized (Demo07.class){
                        if("小明".equals(name)){
                            name = "小花";
                            gender = "女";
                        }else{
                            name = "小明";
                            gender = "男";
                        }
                    }
                    System.out.println("其它无关代码..");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (Demo07.class){
                        System.out.println(name+"#"+gender);
                    }
                }
            }
        }).start();
    }
}

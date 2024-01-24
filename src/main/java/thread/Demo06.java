package thread;

/**
 * 多线程并发安全问题 - 案例
 *
 * syncronized方法默认的锁对象:
 *  普通方法,使用this作为锁对象
 *  静态方法,使用当前类.class作为所对象
 *
 */
class Bank{
    private int total = 20000;
    public synchronized boolean getMoney(int money){
        if(money<=total){
            total -= money;
            System.out.println("取现金"+money+"元");
            return true;
        }
        System.out.println("余额不足!");
        return false;
    }
}

public class Demo06 {
    private static Bank bank = new Bank();
    public static void main(String[] args) {
        //小王
        new Thread(new Runnable() {
            @Override
            public void run() {
                bank.getMoney(20000);
            }
        }).start();
        //小李
        new Thread(new Runnable() {
            @Override
            public void run() {
                bank.getMoney(20000);
            }
        }).start();
    }
}

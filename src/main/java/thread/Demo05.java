package thread;

/**
 * 多线程并发安全问题
 * 多个线程访问同一共享资源,由于线程执行的不可预知性,造成的混乱,称之为多线程并发安全问题
 */
public class Demo05 {
    private static String name = "小明";
    private static String gender = "男";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if("小明".equals(name)){
                        name = "小花";
                        gender = "女";
                    }else{
                        name = "小明";
                        gender = "男";
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(name+"#"+gender);
                }
            }
        }).start();
    }
}

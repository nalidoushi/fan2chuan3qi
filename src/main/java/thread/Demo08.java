package thread;

/**
 * StringBuilder线程不安全!
 */
public class Demo08 {
    public static void main(String[] args) throws InterruptedException {
        //StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<1000;i++){
                        Thread.sleep(1);
                        sb.append("abc");
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
                    for(int i=0;i<1000;i++){
                        Thread.sleep(1);
                        sb.append("def");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
        System.out.println(sb.length());
        System.out.println(sb);
    }
}

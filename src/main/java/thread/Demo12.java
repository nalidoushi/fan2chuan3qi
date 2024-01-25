package thread;

public class Demo12 {
    private static int count = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("安琪拉加载完成..");
                    synchronized (Demo12.class) {
                        count++;
                        if(count<3){
                            Demo12.class.wait();
                        }else{
                            Demo12.class.notifyAll();
                        }
                        System.out.println("安琪拉开始游戏..");
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
                    Thread.sleep(3000);
                    System.out.println("李白加载完成..");
                    synchronized (Demo12.class) {
                        count++;
                        if(count<3){
                            Demo12.class.wait();
                        }else{
                            Demo12.class.notifyAll();
                        }
                        System.out.println("李白开始游戏..");
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
                    Thread.sleep(5000);
                    System.out.println("花木兰加载完成..");
                    synchronized (Demo12.class) {
                        count++;
                        if(count<3){
                            Demo12.class.wait();
                        }else{
                            Demo12.class.notifyAll();
                        }
                        System.out.println("花木兰开始游戏..");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

package thread;

public class MyRunnable01 implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable01..print..");
        }
    }
}

package thread;

public class MyRunnable02 implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable02..print..");
        }
    }
}

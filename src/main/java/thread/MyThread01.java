package thread;

public class MyThread01 extends Thread {
    private String msg;
    public MyThread01(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("t1 is running..."+msg);
        }
    }
}

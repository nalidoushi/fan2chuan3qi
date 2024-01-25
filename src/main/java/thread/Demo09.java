package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo09 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> lx = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(lx);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<1000;i++){
                        Thread.sleep(1);
                        list.add(i);
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
                        list.add(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
        System.out.println(list.size());
    }
}

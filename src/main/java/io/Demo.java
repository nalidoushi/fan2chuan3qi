package io;

public class Demo {
    public static void main(String[] args) {
        //当前系统时间:UTC 世界协调时:1970年元旦到该时间戳之间经过的毫秒
        long now = System.currentTimeMillis();
        System.out.println(now);

        long time = Long.MAX_VALUE;
        time = time/1000/60/60/24/365;
        System.out.println("公元:"+(1970+time));
    }
}

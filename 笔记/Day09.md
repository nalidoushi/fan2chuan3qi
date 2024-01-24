# 多线程

## 进程 线程概念

### 进程

> 操作系统中一个运行着的程序就是一个进程
>
> 操作系统可以同时运行多个程序,即多个进程,称之为多进程
>
> 多个进程之间通过抢夺CPU执行时间进行并发执行,由于CPU速度很快,看起来就像在同时执行一样

### 线程

> 一个进程里可以执行多个并行的过程,称之为线程
>
> 一个进程里可以执行多个线程称之为多线程
>
> 多个线程之间通过抢夺CPU执行时间进行并发执行,由于CPU速度很快,看起来就像在同时执行一样

## 线程创建方式

![创建线程的两种方式](images/线程/创建线程的两种方式.png)

### 创建方式1：继承线程类方式

> * 写一个类继承Thread
> * 重写其中的run方法,在其中写上线程要执行的代码
> * 创建当前线程类的对象
> * 调用其start()方法即可启动一个线程

```java
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

public class MyThread02 extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println("当前时间:"+System.currentTimeMillis());
        }
    }
}
```

```java
public class Demo01 {
    public static void main(String[] args) {
        MyThread01 t01 = new MyThread01("from 01..");
        t01.start();
        MyThread01 t02 = new MyThread01("from 02..");
        t02.start();
        MyThread02 t03 = new MyThread02();
        t03.start();
        //匿名内部类方式,快速创建线程
       new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("print from inner Thread..");
                }
            }
        }.start();

    }
}
```

### 创建方式2：实现任务接口方式

> - 写一个类实现Runnable接口，实现run()方法，定义出任务类
>
> *  创建任务类的对象
> *  创建线程对象，传入任务对象
> *  调用线程对象的start()方法，启动线程

```java
public class MyRunnable01 implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable01..print..");
        }
    }
}
public class MyRunnable02 implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println("Runnable02..print..");
        }
    }
}
```

```java
public class Demo02 {
    public static void main(String[] args) {
        MyRunnable01 r01 = new MyRunnable01();
        Thread t1 = new Thread(r01);
        t1.start();

        MyRunnable02 r02 = new MyRunnable02();
        Thread t2 = new Thread(r02);
        t2.start();
		//匿名内部类方式
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    System.out.println("Inner Runnable print..");
                }
            }
        }).start();
    }
}
```

## 线程之间的关系

> 程序从main方法启动时，本身就是启动了一个线程称之为主线程
>
> 任意线程中都可以开启新的线程
>
> 默认情况下，线程之间都是平等的，平等的抢夺cpu执行
>
> 只有程序中所有的线程都结束了，程序才会结束

```Java
package thread;
/**
 * 线程之间的关系：
 * 程序从main方法启动时，本身就是启动了一个线程称之为主线程
 * 任意线程中都可以开启新的线程
 * 默认情况下，线程之间都是平等的，平等的抢夺cpu执行
 * 只有程序中所有的线程都结束了，程序才会结束
 */
public class Demo03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"#"+t1.getName()+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1.getId()+"#"+t1.getName()+"..stop..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"#"+t1.getName()+"..start...");
                    Thread.sleep(1000 * 3);
                    System.out.println(t1.getId()+"#"+t1.getName()+"..stop..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread tx = Thread.currentThread();
        System.out.println(tx);

        System.out.println("主线程结束了..");
    }
}
```

## 线程API

> 线程优先级：
>
> 线程的优先级决定了线程抢夺CPU的概率高低。优先级范围1-10，默认为5。
>
> 守护线程：
>
> 线程分为用户线程和守护线程，线程创建出来时都为用户线程，可以将用户线程配置为守护线程。
>
> 守护线程通常都是执行用户线程的辅助任务，当程序中剩余的都是守护线程时，程序会直接结束。

![image-20240124112630669](images/线程/image-20240124112630669.png)

```java
/**
 * 线程常用API：
 * Thread.currentThread()
 * Thread.sleep()
 *
 * 需要了理解,无需练习:
 * long getId():返回该线程的标识符
 * String getName():返回该线程的名称
 * void setName(String name):设置线程的名字
 * setPriority():设置线程优先级
 * int getPriority():返回线程的优先级
 * boolean isAlive():测试线程是否处于活动状态
 * void setDaemon():设置线程为守护线程
 * boolean isDaemon():测试线程是否为守护线程
 * boolean isInterrupted():测试线程是否已经中断
 */
public class Demo04 {
    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }

    /**
     * 守护线程
     */
    public static void test03(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("用户线程在执行..");
                    Thread.sleep(3000);
                    System.out.println("用户线程执行结束..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                        System.out.println("守护进程在执行..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }

    /**
     * 测试alive
     */
    public static void test02(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread t1 = Thread.currentThread();
                    System.out.println(t1.getId()+"开始运行..");
                    Thread.sleep(3000);
                    System.out.println(t1.getId()+"运行结束..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        while(true){
            System.out.println("主线程检测到t1是否存活:"+t1.isAlive());
        }

    }

    /**
     * 测试Priority
     */
    public static void test01(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("t1");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("t2");
                }
            }
        });

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }

}

```


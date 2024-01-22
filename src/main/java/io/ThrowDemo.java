package io;

public class ThrowDemo {
    static void doCompute01(int a,int b){
        if(b==0)
            //抛出参数无效的异常
            throw new IllegalArgumentException("除数不能为0");
        int result=a/b;
        System.out.println(result);
    }
    static void doCompute02(int a,int b){
        try {
            int result = a / b;
            System.out.println(result);
        }catch (ArithmeticException e){
            //这里以后是日志记录
            System.out.println("除数不能为0");
            throw e;//抛给调用着
        }
        System.out.println("==finish==");
    }
    public static void main(String[] args) {
        doCompute01(10,0);
    }
}

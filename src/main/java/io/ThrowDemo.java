package io;

public class ThrowDemo {

    static void doCompute01(int a,int b){
        if(b==0) {
            //抛出参数无效的异常,这里用户传什么参数我们决定不了
            //只能告诉用户你传递的参数是非法的，是不合理的。
            throw new IllegalArgumentException("除数不能为0");
        }
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
            throw e;//处理以后，可以继续抛给调用着
        }
        System.out.println("==finish==");
    }

    public static void main(String[] args) {
      doCompute01(10,0);
      doCompute02(10,0);

    }
}

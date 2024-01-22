package exception;

public class NPEDemo {//NullPointerException


    public static void main(String[] args) {
        doStringOper02(null);
    }
    public static void doStringOper01(String str){
        //如下语句可能会出现空指针异常
        String result=str.toUpperCase();
        //假如上面的语句出现了异常，下面输出语句是不会执行的。
        System.out.println(result);
    }
    public static void doStringOper02(String str){
        //假如希望如下语句出现了异常，后面的语句还要继续执行。
        //此时我们可以使用try{}catch(xxx){}...对可能出现异常的语句进行处理
        String result;
        try{
            result=str.toUpperCase();
        }catch(NullPointerException e){
            System.out.println("程序中的str的值不能null");
            result=null;
        }
        //假如上面的语句出现了异常，下面输出语句是不会执行的。
        System.out.println(result);
    }
}

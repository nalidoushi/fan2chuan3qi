package exception;

public class NPEDemo {//NullPointerException


    public static void main(String[] args) {
          doConvert(null);
          System.out.println("main方法结束了");
    }
    public static String doConvert(String content){
        System.out.println(content.toLowerCase());
        return "程序正常结束";
    }
}

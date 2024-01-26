package aTest;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try{
            method1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void method1()throws Exception{
        try{
            method2();
        }catch (Exception e){
            throw new Exception("method1中异常",e);
        }
    }
    public static void method2()throws Exception{
        throw new Exception("method2中异常");
    }

}

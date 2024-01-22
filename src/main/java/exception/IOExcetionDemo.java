package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOExcetionDemo {
    public static void main(String[] args){
        FileOutputStream fos=null;
        try {
            //1.构建输出流对象(编译阶段能够检测到的异常我们通常称之为检查异常)
            fos = new FileOutputStream("./abc/f1.txt", true);
            //2.写数据到文件
            fos.write("hello".getBytes(StandardCharsets.UTF_8));
        }catch (FileNotFoundException e){
           // System.out.println("文件没找到:"+e.getMessage());
            e.printStackTrace();//打印异常栈信息(包含的异常信息会更全面)
            //return;
            System.exit(-1);
        }catch (IOException e){
            System.out.println("写数据或关闭流时出现了问题:"+e.getMessage());
        }finally {//最终执行语句，无论是否出现异常，这个代码块都会执行
            //3.释放资源(一般都会把释放资源的过程放在此代码块中)
            if(fos!=null)try{fos.close();}catch (IOException e){e.printStackTrace();}
        }
    }
}

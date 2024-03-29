package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOExcetionDemo {
    static void doWrite01(){
        FileOutputStream fos=null;
        try {
            //1.构建输出流对象(编译阶段能够检测到的异常我们通常称之为检查异常)
            fos = new FileOutputStream("./abc/f1.txt", true);
            //2.写数据到文件
            String s="hello";
            fos.write(s.getBytes(StandardCharsets.UTF_8));
        }catch (FileNotFoundException | NullPointerException e){
            // System.out.println("文件没找到:"+e.getMessage());
            e.printStackTrace();//打印异常栈信息(包含的异常信息会更全面)
            //return;//遇到return语句时，是先finally，然后再返回
            //System.exit(-1);这条语句执行时，finally不在执行
        } catch (IOException e){
            System.out.println("写数据或关闭流时出现了问题:"+e.getMessage());
        }finally {//最终执行语句，无论是否出现异常，这个代码块都会执行
            //3.释放资源(一般都会把释放资源的过程放在此代码块中)
            if(fos!=null)try{fos.close();}catch (IOException e){e.printStackTrace();}
        }
    }
    /**try...catch的自关闭特性*/
    static void doWrite02(){
        try(
           FileOutputStream fos =//这里构建对象无需手动关闭
           new FileOutputStream("./abc/f1.txt", true);
         ){
            //1.构建输出流对象(编译阶段能够检测到的异常我们通常称之为检查异常)
            //2.写数据到文件
            String s="hello";
            fos.write(s.getBytes(StandardCharsets.UTF_8));
        }catch (FileNotFoundException | NullPointerException e){
            // System.out.println("文件没找到:"+e.getMessage());
            e.printStackTrace();//打印异常栈信息(包含的异常信息会更全面)
            //return;//遇到return语句时，是先finally，然后再返回
            //System.exit(-1);这条语句执行时，finally不在执行
        } catch (IOException e){
            System.out.println("写数据或关闭流时出现了问题:"+e.getMessage());
        }
    }
    public static void main(String[] args){
           doWrite02();
    }
}

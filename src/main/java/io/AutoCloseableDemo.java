package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AutoCloseableDemo {
    public static void main(String[] args) {
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
}

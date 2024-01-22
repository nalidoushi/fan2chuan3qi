package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IOExcetionDemo {
    public static void main(String[] args){
        try {
            //1.构建输出流对象(编译阶段能够检测到的异常我们通常称之为检查异常)
            FileOutputStream fos = new FileOutputStream("./abc/f1.txt", true);
            //2.写数据到文件
            fos.write("hello".getBytes(StandardCharsets.UTF_8));
            //3.释放资源
            fos.close();
        }catch (FileNotFoundException e){
           // System.out.println("文件没找到:"+e.getMessage());
            e.printStackTrace();//打印异常栈信息(包含的异常信息会更全面)
        }catch (IOException e){
            System.out.println("写数据或关闭流时出现了问题:"+e.getMessage());
        }
    }
}

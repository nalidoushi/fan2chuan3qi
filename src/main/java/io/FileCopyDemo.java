package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制应用案例
 */
public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
        //1.创建流对象(输入流，输出流)
        FileInputStream fis=new FileInputStream("a.png");
        FileOutputStream fos=new FileOutputStream("b.png");
        //2.读写文件数据(复制)
        int data;
        while((data=fis.read())!=-1){//当读到文件尾时返回值是-1
            //将读取的数据写入到文件
            fos.write(data);
        }
        //3.释放资源(关闭流)
        fis.close();
        fos.close();
    }
}

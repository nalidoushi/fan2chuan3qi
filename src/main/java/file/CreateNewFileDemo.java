package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个空白文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前项目目录下新建一个文件:test.txt
        File file = new File("./test.txt");
        /*
            boolean exists()
            判断当前File表示的路径下是否真实存在该文件或目录，若存在则返回true
         */
        if(file.exists()){
            System.out.println("该文件已存在");
        }else{
            /*
                create:创建
             */
            file.createNewFile();//alt+enter 选择add exception....
            System.out.println("文件已创建");
        }
    }
}







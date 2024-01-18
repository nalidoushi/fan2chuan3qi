package file;

import java.io.File;

/**
 * 创建一个目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前项目目录下新建一个"demo"的目录
//        File dir = new File("./demo");
        File dir = new File("demo");

        if(dir.exists()){
            System.out.println("目录已存在");
        }else{
            /*
                make:做
                directory:目录
             */
            dir.mkdir();
            System.out.println("目录已创建!");
        }


    }
}






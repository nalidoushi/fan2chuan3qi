package file;

import java.io.File;

/**
 * 创建一个目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前项目目录下新建一个"demo"的目录
//        File dir = new File("./demo");
//        File dir = new File("demo");

        //f目录所在的目录实际上还不存在
        File dir = new File("a/b/c/d/e/f");
        if(dir.exists()){
            System.out.println("目录已存在");
        }else{
            /*
                make:做
                directory:目录
                mkdir()方法在创建目录时要求其所在的目录必须存在，否则无法创建
                mkdirs()方法如果创建的目录不存在会一起创建出来(推荐这个方法)
             */
//            dir.mkdir();
            dir.mkdirs();
            System.out.println("目录已创建!");
        }


    }
}






package file;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
    /**
     * 获取项目当前目录下的所有.xml文件
     */
    static void doListFiles01(){
        //1.获取项目的当前目录(这里的"."代表当前目录)
        File dir=new File(".");
        System.out.println(dir.getAbsolutePath());
        //2.假如不是目录则直接返回
        if(!dir.isDirectory())return;
        //3.获取满足条件的文件
        //3.1定义一个文件过滤器?(经常用于按用户需求对文件进行过滤)
        FileFilter fileFilter=new FileFilter() {
            /*此方法的作用就是用于判定文件是否满足我们的要求,满足则应返回true*/
            @Override
            public boolean accept(File file) {
                return file.isFile()&file.getName().toLowerCase().endsWith(".xml");
            }
        };
        //3.2应用过滤器获取文件
        File[] fileArray=dir.listFiles(fileFilter);
        //3.3 遍历获取的文件
        for(File file:fileArray){
            System.out.println(file.getName());
        }
    }
    /**
     * 获取项目当前目录下的所有.xml文件
     */
    static void doListFiles02(){
        //1.获取项目的当前目录(这里的"."代表当前目录)
        File dir=new File(".");
        System.out.println(dir.getAbsolutePath());
        //2.假如不是目录则直接返回
        if(!dir.isDirectory())return;
        //3.获取满足条件的文件
        //3.1定义一个文件过滤器?(经常用于按用户需求对文件进行过滤)
        FileFilter fileFilter=new FileFilter() {
            /*此方法的作用就是用于判定文件是否满足我们的要求,满足则应返回true*/
            @Override
            public boolean accept(File file) {
                return file.isFile()&file.getName().toLowerCase().endsWith(".xml");
            }
        };
        //3.2应用过滤器获取文件
        File[] fileArray=dir.listFiles(
                file->file.isFile()&
                        file.getName().toLowerCase().endsWith(".xml"));
        //3.3 遍历获取的文件
        for(File file:fileArray){
            System.out.println(file.getName());
        }
    }
    public static void main(String[] args) {
       // doListFiles01();
        doListFiles02();
    }
}

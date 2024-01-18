package file;

import java.io.File;

/**
 * 访问一个目录的子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        //访问当前项目目录下的所有子项
        File dir = new File(".");//"."就表示当前目录
        /*
            boolean isFile()
            判断当前File对象表示的是否是一个真实存在的文件，是则返回true

            boolean isDirectory()
            判断当前File对象表示的是否为一个真实存在的目录
         */
        if(dir.isDirectory()){
            /*
                File[] listFiles()
                获取当前File对象表示的目录中的所有子项。
                返回的数组中每个元素(一个File对象)就表示该目录中的一个子项
             */
            File[] subs = dir.listFiles();
            System.out.println("共"+subs.length+"个子项");
            for(File sub : subs){
                System.out.println(sub.getName());
            }
        }
    }
}

package file;

import java.io.File;

/**
 * java.io.File
 * File的每一个实例用于表示硬盘上的一个文件或目录
 * 实际上表示的是一个抽象路径。
 *
 * 使用File可以:
 * 1:访问文件或目录的属性信息(名字，大小，权限等)
 * 2:创建/删除 文件或目录
 * 3:访问一个目录的子项
 *
 * 但是不能访问文件数据
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
            File没有默认无参构造器
            创建是要指明文件或目录的所在位置(路径)

            路径有两种:
            1:绝对路径
              从系统指定的根开始逐级指明实际位置
              windows的根常见的：C:/(c盘) d:/

            2:相对路径
              常见的:
              "./":当前目录，由该程序的运行环境而定。在IDEA中执行程序时，IDEA指定"./"为当前项目目录
              类加载路径(后面学习反射知识时介绍)

         */
        //绝对路径存在跨平台问题，实际开发中不会使用
//        File file = new File("C:/Users/TEACHER/IdeaProjects/JSD2312SE/demo.txt");

        File file = new File("./demo.txt");
        //获取当前File表示的文件或目录的名字
        String name = file.getName();
        System.out.println(name);
        //获取当前File表的文件的长度(单位是字节)
        long length = file.length();
        System.out.println(length+"字节");

    }
}

# 课程目标及安排

* 查询文件夹中的所有子目录
* 文件过滤器
* 递归

# 文件过滤器的应用

## 需求

* 获取指定目录下,满足特定条件的文件(例如后缀为xml文件)

## 解决方案

* 可以使用File类型中的listFiles(FileFilter fileFilter)方法进行实现
* 为了简化代码的编写，可以在代码实现过程中使用lambda表达式

## 代码实现
* 代码实现

```java
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
        //3.2应用过滤器获取文件(应用lambda表达式)
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

```

# 递归操作实践

## 什么是递归

* 递归是一种自身调用自身的逻辑，通常用于处理一些有规律的反复执行的动作。
注意：递归应该有一个结束条件，假如没有结束条件，可能会出现无限递归，然后导致内存溢出。

## 递归应用案例分析

* 递归查询指定目录下的文件
```java
package file;

import java.io.File;

public class FileScanDemo {
    //无限递归,会出现内存溢出(栈内存溢出-StackOverflowError)
    static void doScan(){
        doScan();
    }

    /**
     * 获取指定目录以及此目录下所有子目录中的xml文件
     * @param file
     */
    static void doScanXml(File file){
        File[] files=file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                //自身调用自身
                doScanXml(f);
            }else{
                if(f.getName().endsWith(".xml"))
                System.out.println(f.getAbsolutePath());
            }
        }
    }
    public static void main(String[] args) {
        //doScan();
        doScanXml(new File("."));
    }
}

```

* 递归删除指定目录以及目录下的所有文件和目录

```java
package file;

import java.io.File;

/**
 * 思考:删除当前项目目录下的a目录
 */
public class Test3 {
    public static void main(String[] args) {
        File dir = new File("./a");
        delete(dir);
    }
    /**递归删除指定目录下的所有目录和文件*/
    public static void delete(File f){
        if(f.exists()&&f.isDirectory()){
            File[] files = f.listFiles();
            for(File subFile:files){
                if(subFile.isDirectory()){
                    delete(subFile);//递归调用
                }else{
                    subFile.delete();
                }
            }
        }
        f.delete();
    }
}

```
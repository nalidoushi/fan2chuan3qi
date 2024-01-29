package anno.service;

import anno.UseThis;
import anno.dao.MyDao;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyDaoFactory {
    private static List<Class> list = new ArrayList<>();
    static{
        try {
            //获取anno/dao目录下所有的.java文件
            URL url = MyDaoFactory.class.getClassLoader().getResource("./anno/dao");
            File dir = new File(url.toURI());
            File[] files = dir.listFiles();
            //遍历这些java文件
            for(File file : files){
                if(file.isFile() && file.getName().endsWith(".class")){
                    //截取它们文件名,拼上报名,得到类的全路径名
                    String shortName = file.getName().split("\\.")[0];
                    String fullName = "anno.dao."+shortName;
                    //反射加载这些类
                    Class<?> clz = Class.forName(fullName);
                    //存入集合
                    list.add(clz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static MyDao getDao(){
        try {
            //遍历dao包下所有类
            for(Class clz : list){
                //如果发现某个类有@UseThis,返回这个类的对象
                if(clz.isAnnotationPresent(UseThis.class)){
                    return (MyDao) clz.newInstance();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

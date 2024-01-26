package reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyDaoFactory {
    private static Properties prop = null;
    static{
        try {
            prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\TEACHER\\IdeaProjects\\JSD2312SE\\src\\main\\java\\reflect\\my.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取配置文件,根据配置文件生成对应的MyDao,返回
     */
    public static MyDao getDao(){
        try {
            //获取配置信息
            String cStr = prop.getProperty("MyDao");
            //创建该类的对象返回
            Class clz = Class.forName(cStr);
            return (MyDao) clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

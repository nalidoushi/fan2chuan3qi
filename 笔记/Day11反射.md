# 反射

## 概念

将类、方法、属性、构造器、包等和类相关的实体，抽象为相关类，

通过这些类获取信息进行操作

从而实现对类的间接控制

这样的技术称为反射

在框架级别的程序开发中非常重要

## Class类

## Package类

## Constructor类

## Field类

## Method类

## 案例

根据配置文件的配置，加载不同的类执行

```java
package reflect;

public class MyService {
    MyDao dao = MyDaoFactory.getDao();

    public void mx(){
        dao.save();
        dao.get();
    }
}
```

```properties
MyDao=reflect.SqlServerDao
```

```java
package reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyDaoFactory {
    private static Properties prop = null;
    static{
        try {
            InputStream in = MyDaoFactory.class.getResourceAsStream("/my.properties");
            prop = new Properties();
            prop.load(in);
        } catch (Exception e) {
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
```

```java
package reflect;

public interface MyDao {
    public void save();
    public void get();
}
```

```java
package reflect;

public class MySqlDao implements MyDao {
    public void save(){
        System.out.println("MySql保存数据..");
    }
    public void get(){
        System.out.println("MySql获取数据..");
    }
}
```

```java
package reflect;

public class OracleDao implements MyDao {

    @Override
    public void save() {
        System.out.println("Oracle 保存数据..");
    }

    @Override
    public void get() {
        System.out.println("Oracle 获取数据..");
    }
}
```


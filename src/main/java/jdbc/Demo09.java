package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * 批处理 - Statement方式
 * create database day17;
 * use day17;
 * create table user(id int,name varchar(20),age int);
 * insert into user values (1,'a',18);
 * insert into user values (2,'b',23);
 * insert into user values (3,'c',26);
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //1.注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
            //3.获取传输器对象
            stat = conn.createStatement();
            //4.将sql加入批
            stat.addBatch("create database day17");
            stat.addBatch("use day17");
            stat.addBatch("create table user(id int,name varchar(20),age int)");
            stat.addBatch("insert into user values (1,'a',18)");
            stat.addBatch("insert into user values (2,'b',23)");
            stat.addBatch("insert into user values (3,'c',26)");
            //5.执行批处理
            int[] results = stat.executeBatch();
            System.out.println(Arrays.toString(results));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //6.关闭资源
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    stat = null;
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }
        }
    }
}

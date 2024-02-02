package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * JDBC入门案例
 */

/**
    create database day16;
    use day16;
    create table user(id int,name varchar(255),age int);
    insert into user values (1,'aaa',18);
    insert into user values (2,'bbb',22);
    insert into user values (3,'ccc',31);
 */
public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //1.注册数据库驱动
        DriverManager.registerDriver(new Driver());
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
        //3.获取传输器
        Statement stat = conn.createStatement();
        //4.传输sql执行获取结果集
        ResultSet rs = stat.executeQuery("select * from user");
        //5.处理结果
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println(id+"#"+name+"#"+age);
        }
        //6.关闭资源
        rs.close();
        stat.close();
        conn.close();
    }
}

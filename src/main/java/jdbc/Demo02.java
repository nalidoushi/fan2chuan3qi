package jdbc;

import java.sql.*;

public class Demo02 {

    public static void main(String[] args)  {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            //DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");

            //3.获取传输器
            stat = conn.createStatement();

            //4.传输sql执行获取结果集
            rs = stat.executeQuery("select * from user");

            //5.处理结果
//        rs.next();
//        String name = rs.getString("name");
//        System.out.println(name);
//        rs.next();
//        name = rs.getString("name");
//        System.out.println(name);
//        rs.previous();
//        name = rs.getString("name");
//        System.out.println(name);
//        rs.absolute(3);
//        name = rs.getString("name");
//        System.out.println(name);
//        rs.beforeFirst();
//        rs.next();
//        name = rs.getString("name");
//        System.out.println(name);
//        rs.afterLast();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id+"#"+name+"#"+age);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //6.关闭资源
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
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

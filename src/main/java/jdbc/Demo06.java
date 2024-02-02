package jdbc;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


/**
 * PreparedStatement实现CRUD
 */
public class Demo06 {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Before
    public void before(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ps = null;
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    @Test
    public void query(){
        try {
            ps = conn.prepareStatement("select * from user where name = ?");
            ps.setString(1,"bbb");
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name+"#"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void delete(){
        try {
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1,4);
            int i = ps.executeUpdate();
            if(i<=0){
                System.out.println("删除失败!");
            }else{
                System.out.println("删除成功!影响到的行数为"+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void update(){
        try {
            ps = conn.prepareStatement("update user set age = ? where id = ?");
            ps.setInt(1,55);
            ps.setInt(2,4);
            int i = ps.executeUpdate();
            if(i<=0){
                System.out.println("新增失败!");
            }else{
                System.out.println("新增成功!影响到的行数为"+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void insert(){
        try {
            ps = conn.prepareStatement("insert into user values (?,?,?)");
            ps.setInt(1,4);
            ps.setString(2,"ddd");
            ps.setInt(3,44);
            int i = ps.executeUpdate();
            if(i<=0){
                System.out.println("新增失败!");
            }else{
                System.out.println("新增成功!影响到的行数为"+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

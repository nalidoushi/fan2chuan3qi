package jdbc;

import java.sql.*;
import java.util.Scanner;

/**
    create table user2 (id int ,username varchar(20),password varchar(40));
    insert into user2 values (1,'zs','123');
    insert into user2 values (2,'ls','abc');
    insert into user2 values (3,'ww','xyz');
 */
public class Demo04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true){
            //读取用户输入的用户名密码
            System.out.println("开始登录..");
            System.out.println("用户名:");
            String username = scanner.nextLine();
            System.out.println("密码:");
            String password = scanner.nextLine();

            //查询数据库,校验用户名密码
            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
                stat = conn.createStatement();
                rs = stat.executeQuery("select * from user2 where username = '"+username+"' and password = '"+password+"'");
                if(rs.next()){
                    //正确则登录成功,并调出登录逻辑
                    System.out.println("登录成功!");
                    break;
                }else{
                    //错误则登录失败,重新登录
                    System.out.println("登录失败!用户密码不正确!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(rs != null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        rs = null;
                    }
                }
                if(stat != null){
                    try {
                        stat.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        stat = null;
                    }
                }
                if(conn != null){
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
}

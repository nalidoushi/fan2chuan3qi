package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Demo05 {
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
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
                ps = conn.prepareStatement("select * from user2 where username=? and password=?");
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
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
                if(ps != null){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        ps = null;
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

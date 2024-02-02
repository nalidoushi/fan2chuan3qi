package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试 手动编写的连接池
 */
public class Demo07 {
    private static MyPool pool = new MyPool();

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = pool.getConnection();
            ps = conn.prepareStatement("select * from user");
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
                pool.retConn(conn);
            }
        }
    }
}

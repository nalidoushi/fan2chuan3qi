package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 批处理-PreparedStatement方式
 *
 * 只支持结构相同参数不同的sql进入一个批
 * 对于结构相同的sql,sql主干只需写一次,每次只将不同的参数加入批即可
 *
 * 向day17.user表中插入10000条数据
 */
public class Demo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            long begin = System.currentTimeMillis();
            //1.注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///day17","root","root");
            //--开启事务
            conn.setAutoCommit(false);
            //3.获取传输器
            ps = conn.prepareStatement("insert into user values (?,?,?)");
            //4.将参数加入批处理
            for(int i=1;i<=10000;i++){
                ps.setInt(1,i);
                ps.setString(2,"xx"+i);
                ps.setInt(3,18);
                ps.addBatch();
            }
            //5.传输sql执行获取结果
            int[] results = ps.executeBatch();
            System.out.println(Arrays.toString(results));
            //--提交事务
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("总共耗时:"+(end-begin)+"毫秒");
        }catch (Exception e){
            //--回滚事务
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6.关闭资源
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
    }
}

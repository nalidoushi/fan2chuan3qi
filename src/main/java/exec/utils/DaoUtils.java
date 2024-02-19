package exec.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtils {
    /**
     * 数据源
     */
    private static DataSource dataSource = new ComboPooledDataSource();

    private DaoUtils(){}

    /**
     * 获取连接
     */
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭资源
     */
    public static void close(ResultSet rs, Statement stat,Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                rs = null;
                if(stat!=null){
                    try {
                        stat.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        stat = null;
                        if(conn!=null){
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            } finally {
                                conn = null;
                            }
                        }
                    }
                }
            }
        }
    }

}

package jdbc;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 手写连接池
 */
public class MyPool implements DataSource {
    private static List<Connection> pool = new LinkedList<>();

    static{
        //启动时，初始化5个连接，存入池中
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i=0;i<5;i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     */
    @Override
    public Connection getConnection() throws SQLException {
        //如果池里不够了，再存进去3个
        if(pool.size()<=0){
            for (int i=0;i<3;i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///day16","root","root");
                pool.add(conn);
            }
        }
        //从池中取出一个连接返回
        return pool.remove(0);
    }

    /**
     * 还连接的方法
     */
    public void retConn(Connection conn){
        try {
            //要求连接不为null 且没有关闭过 ，将连接存入池中
            if(conn!=null && !conn.isClosed()){
                pool.add(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

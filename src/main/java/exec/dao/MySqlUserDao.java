package exec.dao;

import exec.domain.User;
import exec.utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlUserDao implements UserDao {

    /**
     * 根据id查找用户
     * @param id 要找的id
     * @return 找到的用户信息bean，找不到返回null
     */
    @Override
    public User findUserById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("select * from user where id = ?");
            ps.setInt(1,id);
            //传输sql执行获取结果
            rs = ps.executeQuery();
            //处理结果
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPsw(rs.getString("psw"));
                user.setRole(rs.getInt("role"));
                return user;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DaoUtils.close(rs,ps,conn);
        }
    }

    /**
     * 新增用户
     * @param user 封装了用户信息的bean
     */
    public void insertUser(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("insert into user values (?,?,?,?)");
            ps.setInt(1,user.getId());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPsw());
            ps.setInt(4,user.getRole());
            //执行sql
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            DaoUtils.close(null,ps,conn);
        }
    }

    @Override
    public User findUserByNameAndPsw(String name, String psw) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("select * from user where name = ? and psw = ?");
            ps.setString(1,name);
            ps.setString(2,psw);
            //执行sql获取结果
            rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPsw(rs.getString("psw"));
                user.setRole(rs.getInt("role"));
                return user;
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
           //关闭资源
           DaoUtils.close(rs,ps,conn);
        }
    }
}

package exec.dao;

import exec.domain.Score;
import exec.utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySqlScoreDao implements ScoreDao {
    /**
     * 根据用户id查找成绩信息
     * @param uid
     * @return
     */
    @Override
    public Score findScoreByUid(int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("select * from score where uid = ?");
            ps.setInt(1,uid);
            //查询sql获取结果
            rs = ps.executeQuery();
            //处理结果
            if(rs.next()){
                Score score = new Score();
                score.setId(rs.getInt("id"));
                score.setMath(rs.getInt("math"));
                score.setChinese(rs.getInt("chinese"));
                score.setEnglish(rs.getInt("english"));
                score.setUid(rs.getInt("uid"));
                return score;
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

    /**
     * 获取所有成绩
     */
    @Override
    public List<Score> getAllScore() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("select * from score order by math+chinese+english desc");
            //查询sql获取结果
            rs = ps.executeQuery();
            //处理结果
            List<Score> list = new ArrayList<>();
            while(rs.next()){
                Score score = new Score();
                score.setId(rs.getInt("id"));
                score.setMath(rs.getInt("math"));
                score.setChinese(rs.getInt("chinese"));
                score.setEnglish(rs.getInt("english"));
                score.setUid(rs.getInt("uid"));
                list.add(score);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            DaoUtils.close(rs,ps,conn);
        }
    }

    /**
     * 新增成绩
     */
    @Override
    public void insertScore(Score score) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("insert into score values (null,?,?,?,?)");
            ps.setInt(1,score.getMath());
            ps.setInt(2,score.getChinese());
            ps.setInt(3,score.getEnglish());
            ps.setInt(4,score.getUid());
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

    /**
     * 根据uid修改成绩
     */
    @Override
    public void updateScoreByUid(Score score) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("update score set math=?,chinese=?,english=? where uid=?");
            ps.setInt(1,score.getMath());
            ps.setInt(2,score.getChinese());
            ps.setInt(3,score.getEnglish());
            ps.setInt(4,score.getUid());
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

    /**
     * 根据id删除成绩
     */
    @Override
    public void delScore(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            //注册数据库驱动
            //获取数据库连接
            conn = DaoUtils.getConn();
            //获取传输器
            ps = conn.prepareStatement("delete from score where id = ?");
            ps.setInt(1,id);
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
}

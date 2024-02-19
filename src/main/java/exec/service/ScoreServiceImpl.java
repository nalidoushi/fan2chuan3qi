package exec.service;

import exec.dao.MySqlScoreDao;
import exec.dao.ScoreDao;
import exec.domain.Score;
import exec.exception.MsgException;

import java.util.List;

public class ScoreServiceImpl implements ScoreService{
    private ScoreDao scoreDao = new MySqlScoreDao();

    /**
     * 根据用户编号查询学生成绩
     * @param uid 用户编号
     * @return 学生成绩bean
     */
    @Override
    public Score getScore(int uid) {
        return scoreDao.findScoreByUid(uid);
    }

    /**
     * 获取所有成绩
     */
    @Override
    public List<Score> getScores() {
        return scoreDao.getAllScore();
    }

    /**
     * 新增成绩
     */
    @Override
    public void addScore(Score score) throws MsgException {
        //如果该uid的用户已有成绩，则报错
        Score findScore = scoreDao.findScoreByUid(score.getUid());
        if(findScore!=null){
            throw new MsgException("该学生成绩已存在，不能重复插入!");
        }
        //新增成绩
        scoreDao.insertScore(score);
    }

    /**
     * 根据uid修改成绩
     */
    @Override
    public void updateScore(Score score) throws MsgException {
        //查询是否有该uid的成绩
        Score findScore = scoreDao.findScoreByUid(score.getUid());
        if(findScore == null){
            throw new MsgException("该学生成绩不存在，无法修改!");
        }
        //修改成绩
        scoreDao.updateScoreByUid(score);
    }

    @Override
    public void rmScore(int id) {
        scoreDao.delScore(id);
    }
}

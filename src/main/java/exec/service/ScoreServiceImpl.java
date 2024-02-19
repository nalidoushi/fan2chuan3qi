package exec.service;

import exec.dao.MySqlScoreDao;
import exec.dao.ScoreDao;
import exec.domain.Score;

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

    @Override
    public List<Score> getScores() {
        return scoreDao.getAllScore();
    }
}

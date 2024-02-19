package exec.service;

import exec.domain.Score;
import exec.exception.MsgException;

import java.util.List;

public interface ScoreService {
    public Score getScore(int uid);
    public List<Score> getScores();
    public void addScore(Score score) throws MsgException;
    public void updateScore(Score score) throws MsgException;
    public void rmScore(int id);
}

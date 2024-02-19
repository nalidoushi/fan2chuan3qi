package exec.service;

import exec.domain.Score;

import java.util.List;

public interface ScoreService {
    public Score getScore(int uid);
    public List<Score> getScores();
}

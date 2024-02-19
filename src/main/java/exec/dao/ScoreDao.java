package exec.dao;

import exec.domain.Score;

import java.util.List;

public interface ScoreDao {
    Score findScoreByUid(int uid);
    List<Score> getAllScore();
}

package net.estemon.studio.atteros;

import java.util.List;

public interface HighScores {
    public void saveScore(int points, String name, long date);
    public List<String> scoreList(int num);
}

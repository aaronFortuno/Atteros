package net.estemon.studio.atteros;

import java.util.ArrayList;
import java.util.List;

public class HighScoresArray implements HighScores {

    private List<String> scores;

    public HighScoresArray() {
        scores = new ArrayList<String>();
        scores.add("123000 Peter");
        scores.add("123123 John");
    }

    @Override
    public void saveScore(int points, String name, long date) {
        scores.add(0, points + " " + name);
    }

    @Override
    public List<String> scoreList(int num) {
        return scores;
    }
}

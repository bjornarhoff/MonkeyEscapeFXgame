package Highscore;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;
    private String nickName;

    public Score (String nickName, int score) {
        this.nickName = nickName;
        this.score = score;
    }

    public String getNickName () {
        return nickName;
    }

    public int getScore () {
        return score;
    }

}

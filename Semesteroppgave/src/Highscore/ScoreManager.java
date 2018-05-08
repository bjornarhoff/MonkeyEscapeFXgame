package Highscore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreManager {

    // Arraylist for highscores
    private ArrayList<Score> scores;
    private static final String highscoreFile = "score.dat";

    // Input and output for saving scores
    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;

    // Method for arraylist
    public ScoreManager() {
        scores = new ArrayList<Score>();
    }

    // Method for sort scores
    public void sort () {
        CompareScore compare = new CompareScore();
        Collections.sort(scores,compare);
    }

    // Method to add scores to file
    public void addScore (String name, int score) {
        loadHighScore();
        scores.add(new Score(name,score));
        updateHighscore();
    }

    // Method for load arraylist that is in the highscore file, and put it in scores-arraylist.
    // Try - catch struktur for å forhindre at programmet kræsjer når ikke filen blir lastet
    public void loadHighScore() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(highscoreFile));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method for reading the file from score arraylist
    public void updateHighscore() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(highscoreFile));
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // getMethod for arraylist scores.
    public ArrayList<Score> getScores() {
        return scores;
    }
}

package spillet;

import java.io.*;

public class GameState {

    private File file;
    private PrintWriter pw;
    private StringBuilder sb;
    private int score;
    private int currentLevel;
    private double monkeyX;
    private double monkeyY;
    private BufferedReader br;
    private String filePath = "/Users/gautetessandbaalsrud/Documents/GitHub/progdev/Semesteroppgave/Resource/SaveFile/gameState.csv";

    public GameState()  {

        file = new File (filePath);;



    }

    public void setGameState(String save, int score, int currentLevel, double monkeyX, double monkeyY){

        try {
            pw = new PrintWriter(file);

            sb = new StringBuilder();

            sb.append(save + ",");
            sb.append(score + ",");
            sb.append(currentLevel + ",");
            sb.append(monkeyX + ",");
            sb.append(monkeyY + ",");
            sb.append("\n");

            pw.write(sb.toString());
            pw.close();


        }
        catch (FileNotFoundException e) {
            System.err.println("File not found! Make sure that pathname of file is correct");
        }

    }

    public void getGameState() {

        try {
            br = new BufferedReader(new FileReader(filePath));

            String line;

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] gameState = line.split(",");

                System.out.println(gameState[0] + " Current Score: " + gameState[1] + " Current Level: " + gameState[2]);

                setScore(Integer.parseInt(gameState[1]));

            }
        } catch (IOException e) {
            System.out.println("IOException in getGameState");
            System.out.println(e.getMessage());

        }
    }



    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public double getMonkeyX() {
        return monkeyX;
    }

    public void setMonkeyX(double monkeyX) {
        this.monkeyX = monkeyX;
    }

    public double getMonkeyY() {
        return monkeyY;
    }

    public void setMonkeyY(double monkeyY) {
        this.monkeyY = monkeyY;
    }
}

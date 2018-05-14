package spillet;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameState {

    private File file;
    private PrintWriter pw;
    private StringBuilder sb;
    private int score;
    private int currentLevel;
    private double monkeyX;
    private double monkeyY;
    private BufferedReader br;
    private ArrayList<Fruit> fruitArrayList1;
    private ArrayList<Fruit> fruitArrayList2;
    private ArrayList<Fruit> fruitArrayList3;
    private ArrayList<Fruit> fruitArrayList4;
    private String filePathTxt = "/Users/gautetessandbaalsrud/Documents/GitHub/progdev/Semesteroppgave/Resource/SaveFile/file.txt";

    public GameState()  {

        file = new File(filePathTxt);



    }

    public void setGameState(int score, int currentLevel, double monkeyX, double monkeyY,
                             ArrayList<Fruit> fruitList1, ArrayList<Fruit> fruitList2, ArrayList<Fruit> fruitList3, ArrayList<Fruit> fruitList4) {
        this.score = score;
        this.currentLevel = currentLevel;
        this.monkeyX = monkeyX;
        this.monkeyY = monkeyY;
        this.fruitArrayList1 = fruitList1;
        this.fruitArrayList2 = fruitList2;
        this.fruitArrayList3 = fruitList3;
        this.fruitArrayList4 = fruitList4;
    }

    public void saveGame() {

        try {
            pw = new PrintWriter(file);
            sb = new StringBuilder();

            sb.append(score + " ");
            sb.append(currentLevel + " ");
            sb.append(monkeyX + " ");
            sb.append(monkeyY + " ");

            sb.append("\n");

            Iterator<Fruit> fruitIterator1 = fruitArrayList1.iterator();
            while (fruitIterator1.hasNext()) {
                Fruit fruit = fruitIterator1.next();

                String fruitString = String.valueOf(fruit.exists());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator2 = fruitArrayList2.iterator();
            while (fruitIterator2.hasNext()) {
                Fruit fruit = fruitIterator2.next();

                String fruitString = String.valueOf(fruit.exists());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator3 = fruitArrayList3.iterator();
            while (fruitIterator3.hasNext()) {
                Fruit fruit = fruitIterator3.next();

                String fruitString = String.valueOf(fruit.exists());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator4 = fruitArrayList4.iterator();
            while (fruitIterator4.hasNext()) {
                Fruit fruit = fruitIterator4.next();

                String fruitString = String.valueOf(fruit.exists());
                sb.append(fruitString + " ");
            }

            pw.write(sb.toString());
            pw.close();


        } catch (FileNotFoundException e) {
            System.err.println("File not found! Make sure that pathname of file is correct");
        }

    }

    public void getGameState() {

        try {
            br = new BufferedReader(new FileReader(filePathTxt));

            String line;
            String line2;
            String line3;
            String line4;
            String line5;

            line = br.readLine();

            String[] gameState = line.split(" ");

            setScore(Integer.parseInt(gameState[1]));
            setCurrentLevel(Integer.parseInt(gameState[2]));
            setMonkeyX(Double.parseDouble(gameState[3]));
            setMonkeyY(Double.parseDouble(gameState[4]));

            System.out.println(gameState[0] + " Current Score: " + gameState[1] + " Current Level: " + gameState[2]);

            line2 = br.readLine();

            System.out.println(line2);

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

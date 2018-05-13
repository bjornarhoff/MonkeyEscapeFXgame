package spillet;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameState implements Serializable {

    private File file;
    private PrintWriter pwOne;

    private StringBuilder sbOne;
    private int score;
    private int currentLevel;
    private double monkeyX;
    private double monkeyY;
    private BufferedReader brOne;
    private ArrayList<Fruit> fruitArrayList;
    private ArrayList<Fruit> fruitArrayList2;
    private String filePathCsv = "/Users/gautetessandbaalsrud/Documents/GitHub/progdev/Semesteroppgave/Resource/SaveFile/gameState.csv";
    private String filePathSr = "/Users/gautetessandbaalsrud/Documents/GitHub/progdev/Semesteroppgave/Resource/SaveFile/outbox.ser";
    private String filePathTxt = "/Users/gautetessandbaalsrud/Documents/GitHub/progdev/Semesteroppgave/Resource/SaveFile/file.txt";

    public GameState() {

        file = new File(filePathTxt);



    }

    public void setGameState(String save, int score, int currentLevel, double monkeyX, double monkeyY, ArrayList<Fruit> fruitList) {

        try {
            pwOne = new PrintWriter(file);

            sbOne = new StringBuilder();

            sbOne.append(save + ",");
            sbOne.append(score + ",");
            sbOne.append(currentLevel + ",");
            sbOne.append(monkeyX + ",");
            sbOne.append(monkeyY + ",");

            Iterator<Fruit> fruktIterator = fruitList.iterator();
            while (fruktIterator.hasNext()) {
                Fruit fruit = fruktIterator.next();

                String fruitString = String.valueOf(fruit.exists());
                sbOne.append(fruitString + ",");
            }

            sbOne.append("\n");
            sbOne.append("HEYY");

            pwOne.write(sbOne.toString());


            pwOne.close();



        } catch (FileNotFoundException e) {
            System.err.println("File not found! Make sure that pathname of file is correct");
        }

    }

    public void getGameState() {

        try {
            brOne = new BufferedReader(new FileReader(filePathCsv));

            String line;


            while ((line = brOne.readLine()) != null) {

     /*           // use comma as separator
                String[] gameState = line.split(",");

                //  System.out.println(gameState[0] + " Current Score: " + gameState[1] + " Current Level: " + gameState[2]);

                setScore(Integer.parseInt(gameState[1]));
                setCurrentLevel(Integer.parseInt(gameState[2]));
                setMonkeyX(Double.parseDouble(gameState[3]));
                setMonkeyY(Double.parseDouble(gameState[4])); */

                System.out.println(line);

            }


        } catch (IOException e) {
            System.out.println("IOException in getGameState");
            System.out.println(e.getMessage());

        }
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void setFruit(Fruit fruit) {

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


/*
    public ArrayList<Fruit> getFruitArrayList() {
        try {
            FileInputStream fi = new FileInputStream(filePathSr);
            ObjectInputStream oi = new ObjectInputStream(fi);
            fruitArrayList2 = (ArrayList<Fruit>) oi.readObject();

            oi.close();
        } catch (IOException e) {
            System.out.println("IUN");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return fruitArrayList2;

    } */
}

package spillet;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Denne klassen lagrer statusen i spillet i form av score, currentlevel, x- og y-posisjoen til avataren samt om bananene har blitt samlet inn eller ikke.
 */
public class GameState {

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
    private String[] fruitLevelOne;
    private String[] fruitLevelTwo;
    private String[] fruitLevelThree;
    private String[] fruitLevelFour;
    private String filePath1 = "SaveFolder/SaveSlot1.txt";
    private String filePath2 = "SaveFolder/SaveSlot2.txt";
    private String filePath3 = "SaveFolder/SaveSlot3.txt";

    /**
     * Denne metoden setter tilstanden til spillet ved hvert tick i form av score, currentlevel, x- og y-posisjonen til apen og om
     * bananene er samlet inn eller ikke.
     * @param score score
     * @param currentLevel currentLevel
     * @param monkeyX x-posisjon til spiller
     * @param monkeyY x-posisjon til spiller
     * @param fruitList1 liste med frukter i level 1
     * @param fruitList2 liste med frukter i level 2
     * @param fruitList3 liste med frukter i level 3
     * @param fruitList4 liste med frukter i level 4
     */
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

    /**
     * Denne metoden lagrer gamestate i et tekstdokuemtn naar den blir paakalt, og velger hvilken fil den skal skrive til ved aa sette printwriter fra en
     * int parameter i metoden. Dette gjor at man kan lagre informasjoen som man trenger for aa gjenopprette gamestate.
     * @param i hvilken fil det skal skrives til
     */
    public void saveGame(int i) {
        try {

            if (i == 1) {
                pw = new PrintWriter(new FileOutputStream(filePath1), true);
            } else if (i == 2) {
                pw = new PrintWriter(new FileOutputStream(filePath2), true);
            } else if (i == 3) {
                pw = new PrintWriter(new FileOutputStream(filePath3), true);
            }

            br = new BufferedReader(new FileReader(filePath1));

            sb = new StringBuilder();

            sb.append(score + " ");
            sb.append(currentLevel + " ");
            sb.append(monkeyX + " ");
            sb.append(monkeyY + " ");

            sb.append("\n");

            Iterator<Fruit> fruitIterator1 = fruitArrayList1.iterator();
            while (fruitIterator1.hasNext()) {
                Fruit fruit = fruitIterator1.next();

                String fruitString = String.valueOf(fruit.getExist());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator2 = fruitArrayList2.iterator();
            while (fruitIterator2.hasNext()) {
                Fruit fruit = fruitIterator2.next();

                String fruitString = String.valueOf(fruit.getExist());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator3 = fruitArrayList3.iterator();
            while (fruitIterator3.hasNext()) {
                Fruit fruit = fruitIterator3.next();

                String fruitString = String.valueOf(fruit.getExist());
                sb.append(fruitString + " ");
            }

            sb.append("\n");
            Iterator<Fruit> fruitIterator4 = fruitArrayList4.iterator();
            while (fruitIterator4.hasNext()) {
                Fruit fruit = fruitIterator4.next();

                String fruitString = String.valueOf(fruit.getExist());
                sb.append(fruitString + " ");
            }

            pw.write(sb.toString());
            pw.close();


        } catch (FileNotFoundException e) {
            System.err.println("File not found! Make sure that pathname of file is correct");
        }
    }

    /**
     * Denne metoden leser fra filene hvor parameteren i bestemmer hvilken fil som blir lest fra.
     * Her blir score, currentlevel, x- og y-posisjonen til spilleren returnert samt String arrays med statusen til frukt i
     * alle nivaaene.
     * @param i hvilken fil det skal skrives til
     */
    public void loadGame(int i) {

        try {

            if (i == 1) {
                br = new BufferedReader(new FileReader(filePath1));
            } else if (i == 2) {
                br = new BufferedReader(new FileReader(filePath2));
            } else if (i == 3) {
                br = new BufferedReader(new FileReader(filePath3));
            }

            String line;
            String line2;
            String line3;
            String line4;
            String line5;

            line = br.readLine();

            String[] gameState = line.split(" ");

            setScore(Integer.parseInt(gameState[0]));
            setCurrentLevel(Integer.parseInt(gameState[1]));
            setMonkeyX(Double.parseDouble(gameState[2]));
            setMonkeyY(Double.parseDouble(gameState[3]));

            line2 = br.readLine();
            String[] fruitLevelOne = line2.split(" ");
            setFruitOne(fruitLevelOne);

            line3 = br.readLine();
            String[] fruitLevelTwo = line3.split(" ");
            setFruitTwo(fruitLevelTwo);

            line4 = br.readLine();
            String[] fruitLevelThree = line4.split(" ");
            setFruitThree(fruitLevelThree);

            line5 = br.readLine();
            String[] fruitLevelFour = line5.split(" ");
            setFruitFour(fruitLevelFour);

        } catch (IOException e) {
            System.out.println("IOException in getGameState");
            System.out.println(e.getMessage());

        }
    }

    /**
     * Setter score
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter score
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Getter currentlevel
     * @return currentlevel
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Setter currentlevel
     * @param currentLevel currentLevel
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Getter x-posisjonen til spilleren
     * @return monkeyX
     */
    public double getMonkeyX() {
        return monkeyX;
    }

    /**
     * Setter x-posisjonen til spilleren
     * @param monkeyX x-posisjonen til spiller
     */
    public void setMonkeyX(double monkeyX) {
        this.monkeyX = monkeyX;
    }
    /**
     * Getter y-posisjonen til spilleren
     * @return monkeyY
     */
    public double getMonkeyY() {
        return monkeyY;
    }
    /**
     * Setter y-posisjonen til spilleren
     * @param monkeyY y-posisjonen til spiller
     */
    public void setMonkeyY(double monkeyY) {
        this.monkeyY = monkeyY;
    }

    /**
     * Setter en String array for tilstanden til bananen fra tekstdokumentet i level 1
     * @param fruitLevelOne String array med fruktstatus i level 1
     */
    public void setFruitOne(String[] fruitLevelOne) {
        this.fruitLevelOne = fruitLevelOne;
    }

    /**
     * Setter en String array for tilstanden til bananen fra tekstdokumentet i level 2
     * @param fruitLevelTwo String array med fruktstatus i level 2
     */
    public void setFruitTwo(String[] fruitLevelTwo) {
        this.fruitLevelTwo = fruitLevelTwo;
    }

    /**
     * Setter en String array for tilstanden til bananen fra tekstdokumentet i level 3
     * @param fruitLevelThree String array med fruktstatus i level 3
     */
    public void setFruitThree (String [] fruitLevelThree) {
        this.fruitLevelThree=fruitLevelThree;
    }

    /**
     * Setter en String array for tilstanden til bananene fra tekstdokumentet i level 4
     * @param fruitLevelFour String array med fruktstatus i level 4
     */
    public void setFruitFour (String [] fruitLevelFour) {
        this.fruitLevelFour=fruitLevelFour;
    }

    /**
     * Getter en String array for tilsanden til bananene fra tekstdokumentet i level 1
     * @return fruitLevelOne
     */
    public String[] getFruitLevelOne() {
        return fruitLevelOne;
    }

    /**
     * Getter en String array for tilsanden til bananene fra tekstdokumentet i level 2
     * @return fruitLevelTwo
     */
    public String[] getFruitLevelTwo() {
        return fruitLevelTwo;
    }

    /**
     * Getter en String array for tilsanden til bananene fra tekstdokumentet i level 3
     * @return fruitLevelThree
     */
    public String[] getFruitLevelThree() {
        return fruitLevelThree;
    }

    /**
     * Getter en String array for tilsanden til bananene fra tekstdokumentet i level 4
     * @return fruitLevelFour
     */
    public String[] getFruitLevelFour() {
        return fruitLevelFour;
    }
}

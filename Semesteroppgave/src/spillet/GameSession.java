package spillet;

import Controller.MenuController;
import filbehandling.Filbehandling;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import spillet.Levels.LevelFour;
import spillet.Levels.LevelOne;
import spillet.Levels.LevelFour;
import spillet.Levels.LevelTwo;
import spillet.Levels.LevelThree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import static javafx.scene.paint.Color.WHITE;


public class GameSession implements Serializable {

    private MenuController controller;
    private String gameState;
    private Pane gameView;
    private ObservableList<Node> nodeList;
    public Canvas canvas;
    public AnimationTimer timer;
    private GraphicsContext gc;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Monkey monkey;
    private long timeLstFrm;
    private ArrayList<String> collision = new ArrayList<>();
    private LevelOne levelOne = new LevelOne();
    private LevelTwo levelTwo = new LevelTwo();
    private LevelFour levelFour = new LevelFour();
    private LevelThree levelThree = new LevelThree();
    private int currentLevel = 1;
    private int score = 0;
    private GameState save = new GameState();
    private static AudioClip sound = new AudioClip(GameSession.class.getResource("/Audio/sound.mp3").toString());
    private static AudioClip clip = new AudioClip(GameSession.class.getResource("/Audio/power.mp3").toString());

    /**
     * Konstruktør
     */
    public GameSession(Pane gameView, MenuController controller) {
        this.gameView = gameView;
        this.nodeList = gameView.getChildren();
        this.gameState = "running";
        this.controller = controller;

        sound.setCycleCount(AudioClip.INDEFINITE);
        sound.play();
        setScene();
        Timer();
    }

    /**
     * Animation timer
     */
    private void Timer() {
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {


                if (System.nanoTime() - timeLstFrm > 1E9 / 60) {

                    Input.Input(gameView.getScene());
                    handleGameStateInput(Input.getInput());

                    if (gameState.equals("running")) {

                        renderLevel();
                        drawScore(gc);
                        monkey.move(Input.getInput(), getGS(), collision);

                        timeLstFrm = System.nanoTime();

                        save.setGameState(score, currentLevel, monkey.getX(), monkey.getY(), levelOne.getFruitList(),
                                levelTwo.getFruitList(), levelThree.getFruitList(), levelFour.getFruitList());

                    }
                }
            }
        };
        timer.start();
    }

    /**
     * Denne metoden danner layoyt-pane som man legger canvas og dermed animasjonene på.
     *
     * @return root
     */
    public void setScene() {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        for (Node node : nodeList) {
            if (("gameCanvas").equals(node.getId())) {
                this.canvas = (Canvas) node;
            }
            setNodeVisible("gameCanvas");
        }

        /** Tegner */
        gc = canvas.getGraphicsContext2D();

        monkey = new Monkey(10, 10);
    }

    /**
     * This method iterates through the nodelist and sets the selected node to visible
     *
     * @param nodeID the fxID of the node to be set visible
     */
    private void setNodeVisible(String nodeID) {
        for (Node node : nodeList) {
            if (nodeID.equals(node.getId())) {
                node.setVisible(true);
            } else {
                node.setVisible(false);
            }
        }
    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderLevel() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.BLACK);


        if (getCurrentLevel() == 1) {
            levelIterator(levelOne.getWallList(), levelOne.getFruitList(), levelOne.getEnemyList(), levelOne.getGate(), 2, 585, 10);
            levelOne.getGate().render(gc);
        } else if (getCurrentLevel() == 2) {
            levelIterator(levelTwo.getWallList(), levelTwo.getFruitList(), levelTwo.getEnemyList(), levelTwo.getGate(), 3, 575, 550);
            levelTwo.getGate().render(gc);
        } else if (getCurrentLevel() == 3) {
            levelIterator(levelThree.getWallList(), levelThree.getFruitList(), levelThree.getEnemyList(), levelThree.getGate(), 4, 580, 595);
            levelThree.getGate().render(gc);
        } else if (getCurrentLevel() == 4) {
            levelIterator(levelFour.getWallList(), levelFour.getFruitList(), levelFour.getEnemyList(), levelFour.getGate(), 1, 10, 10);
            levelFour.getGate().render(gc);
        }

        // Tegner avatar
        monkey.render(gc);

    }


    public void levelIterator(ArrayList<Wall> wallArrayList, ArrayList<Fruit> fruitArrayList, ArrayList<Enemy> enemyArrayList, Gate gate, int level, double x, double y) {
        wallArrayList.forEach(p -> p.render(gc));
        fruitArrayList.forEach(p -> p.render(gc));
        enemyArrayList.forEach(p -> p.render(gc));
        gate.render(gc);

        collisionIterator(wallArrayList);
        fruitIterator(fruitArrayList);
        enemyIterator(enemyArrayList);
        gateIterator(gate, level, x, y);

    }

    public void gateIterator(Gate gate, int level, double x, double y) {
        if (monkey.collide(gate)) {
            setCurrentLevel(level);
            monkey.setX(x);
            monkey.setY(y);
        }
    }

    public void collisionIterator(ArrayList<Wall> wallList) {
        collision.clear();

        Iterator<Wall> hinderIterator = wallList.iterator();

        while (hinderIterator.hasNext()) {

            Wall wall = hinderIterator.next();

            if (monkey.collisionLeft(wall)) {
                collision.add("CollisionLeft");
                gc.strokeText("CollisionLeft", 150, 50);
                gc.setStroke(Color.WHITE);
            }

            if (monkey.collisionRight(wall)) {
                collision.add("CollisionRight");
                gc.strokeText("CollisionRight", 150, 100);
                gc.setStroke(Color.WHITE);
            }

            if (monkey.collisionBottom(wall)) {
                collision.add("CollisionBottom");
                gc.strokeText("CollisionBottom", 150, 150);
                gc.setStroke(Color.WHITE);
            }

            if (monkey.collisionTop(wall)) {
                collision.add("CollisionTop");
                gc.strokeText("CollisionTop", 150, 200);
                gc.setStroke(Color.WHITE);
            }
        }
    }

    public void fruitIterator(ArrayList<Fruit> fruitList) {
        Iterator<Fruit> fruktIterator = fruitList.iterator();
        while (fruktIterator.hasNext()) {
            Fruit fruit = fruktIterator.next();

            // Kollisjon med fruit, legger til +100 på score
            if (monkey.collide(fruit) && fruit.exists()) {
                fruit.kill();
                bananaSound();
                fruit.exists();
                System.out.println(fruit.toString() + fruit.exists());

                score += 100;
            }
        }
    }


    public void enemyIterator(ArrayList<Enemy> enemyList) {
        Iterator<Enemy> fiendeIterator = enemyList.iterator();
        while (fiendeIterator.hasNext()) {
            Enemy enemy = fiendeIterator.next();

            enemy.bounce();

            if (monkey.collide(enemy)) {
                score = 0;
                timer.stop();

                for (Node node : nodeList) {
                    if (("gameOver").equals(node.getId())) {
                        node.setVisible(true);
                        canvas.setVisible(false);
                    }
                }
            }
        }
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    private void bananaSound() {
        clip.play();
    }

    /**
     * Metode som tegner score på brettet
     */
    public void drawScore(GraphicsContext gc) {
        gc.strokeText("Score: " + score + "/ 500", 450.0, 50.0, 150);
        gc.setFont(new Font(30));
        gc.setStroke(WHITE);
    }

    /**
     * Arraylist for å sjekke input. Setter spillet på pause (går til menyen)
     */
    /* Gå til meny med input "p" og "ESCPAE */
    public void handleGameStateInput(ArrayList<String> input) {
        for (String string : input) {
            if ((string.equals("p") || string.equals("P") || string.equals("ESCAPE")) && gameState.equals("running")) {
                pause();
                setNodeVisible("ingameMenuButtons");
            }
        }
    }

    public void setGameState(int score, int currentLevel, double monkeyX, double monkeyY) {

        save.setScore(score);
        save.setCurrentLevel(currentLevel);
        save.setMonkeyX(monkeyX);
        save.setMonkeyY(monkeyY);
    }

    /**
     * Pause method
     */
    public void pause() {
        if (gameState.equals("running")) {
            gameState = "pause";
            sound.stop();
        } else {
            gameState = "running";
            sound.play();
        }

    }

    public void saveGame() {
        save.saveGame();
    }

    public void loadGame() {
        save.getGameState();
        System.out.println("Current score: " + save.getScore() + " Current Level: " + save.getCurrentLevel());
     //   save.getFruitArrayList();
    }


    /**
     * Get method
     */
    public GameSession getGS() {
        return this;
    }
}

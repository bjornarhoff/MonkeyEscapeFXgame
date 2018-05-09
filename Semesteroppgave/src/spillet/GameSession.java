package spillet;

import Controller.MenuController;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Iterator;

import static javafx.scene.paint.Color.WHITE;

public class GameSession {

    private MenuController controller;
    private String gameState;
    private Pane gameView;
    private ObservableList<Node> nodeList;
    public Canvas canvas;
    public AnimationTimer timer;
    private GraphicsContext gc;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Monkey player;
    private long timeLstFrm;
    private ArrayList<String> collision = new ArrayList<>();
    private LevelOne levelOne = new LevelOne();
    private LevelTwo levelTwo = new LevelTwo();
    private int score = 0;
    private int currentLevel = 1;
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
                        player.move(Input.getInput(), getGS(), collision);


                        timeLstFrm = System.nanoTime();

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
        this.canvas = new Canvas(WIDTH, HEIGHT);

        /** Tegner */
        gc = canvas.getGraphicsContext2D();

        player = new Monkey(300, 100);

    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderLevel() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);


        if (getCurrentLevel() == 1) {
            levelIterator(levelOne.getWallList(), levelOne.getFruitList(), levelOne.getEnemyList());
            levelOne.getGate().render(gc);
        } else if (getCurrentLevel() == 2) {
            levelIterator(levelTwo.getWallList(), levelTwo.getFruitList(), levelTwo.getEnemyList());
            levelTwo.getGate().render(gc);
        }

        if (player.collide(levelOne.getGate())) {
            setCurrentLevel(2);
            player.setX(10);
            player.setY(10);
        }

        if (player.collide(levelTwo.getGate())) {
            setCurrentLevel(1);
        }


        // Tegner avatar
        player.render(gc);

    }

    public void levelIterator(ArrayList<Wall> wallArrayList, ArrayList<Fruit> fruitArrayList, ArrayList<Enemy> enemyArrayList) {
        wallArrayList.forEach(p -> p.render(gc));
        fruitArrayList.forEach(p -> p.render(gc));
        enemyArrayList.forEach(p -> p.render(gc));

        collisionIterator(wallArrayList);
        fruitIterator(fruitArrayList);
        enemyIterator(enemyArrayList);
    }

    public void collisionIterator(ArrayList<Wall> wallList) {
        collision.clear();

        Iterator<Wall> hinderIterator = wallList.iterator();

        while (hinderIterator.hasNext()) {

            Wall wall = hinderIterator.next();

            if (player.collisionLeft(wall)) {
                collision.add("CollisionLeft");
            }

            if (player.collisionRight(wall)) {
                collision.add("CollisionRight");
            }

            if (player.collisionBottom(wall)) {
                collision.add("CollisionBottom");
            }

            if (player.collisionTop(wall)) {
                collision.add("CollisionTop");
            }

        }

    }

    public void fruitIterator(ArrayList<Fruit> fruitList) {
        Iterator<Fruit> fruktIterator = fruitList.iterator();
        while (fruktIterator.hasNext()) {
            Fruit fruit = fruktIterator.next();

            // Kollisjon med fruit, legger til +100 på score
            if (player.collide(fruit) && fruit.exists()) {
                fruit.kill();
                appleSound();
                fruit.exists();
                score += 100;
            }
        }
    }

    public void enemyIterator(ArrayList<Enemy> enemyList) {
        Iterator<Enemy> fiendeIterator = enemyList.iterator();
        while (fiendeIterator.hasNext()) {
            Enemy enemy = fiendeIterator.next();

            enemy.bounce();

            if (player.collide(enemy)) {
                score = 0;

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

    private void appleSound() {
        clip.play();
    }

    /**
     * Metode som tegner score på brettet
     */
    public void drawScore(GraphicsContext gc) {
        gc.strokeText("Score: " + score, 450.0, 50.0, 150);
        gc.setFont(new Font(30));
        gc.setStroke(WHITE);
    }

    /**
     * Arraylist for å sjekke input
     */
    /* Gå til meny med input "p" og "ESCPAE */
    public void handleGameStateInput(ArrayList<String> input) {
        for (String string : input) {
            if ((string.equals("p") || string.equals("P") || string.equals("ESCAPE")) && gameState.equals("running")) {
                pause();
                menu();

            }
        }
    }

    /**
     * Setter spillet på pause (går til menyen)
     */

    public void menu() {
        canvas.setVisible(false);
        controller.setMenuPage("ingameMenuButtons");
    }


    public void pause() {
        if (gameState.equals("running")) {
            gameState = "pause";
            sound.stop();
        } else {
            gameState = "running";
            sound.play();
        }

    }

    /**
     * Get metoder
     */
    public Canvas getCanvas() {
        return this.canvas;
    }


    public GameSession getGS() {
        return this;
    }
}

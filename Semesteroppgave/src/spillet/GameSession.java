package spillet;

import Controller.MenuController;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import spillet.Levels.LevelOne;
import spillet.Levels.LevelTwo;

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
    private Monkey monkey;
    private long timeLstFrm;
    private ArrayList<String> collision = new ArrayList<>();
    private LevelOne levelOne = new LevelOne();
    private LevelTwo levelTwo = new LevelTwo();
    private int currentLevel = 1;
    private int score = 0;
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
                        monkey.move(Input.getInput(), getGS(), collision);

                        //System.out.println(player.getX());
                        //System.out.println(player.getY());


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

        for (Node node : nodeList) {
            if (("gameCanvas").equals(node.getId())) {
                this.canvas = (Canvas) node;
            }
            setNodeVisible("gameCanvas");
        }


        /** Tegner */
        gc = canvas.getGraphicsContext2D();

        monkey = new Monkey(590, 590);


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
            levelIterator(levelOne.getWallList(), levelOne.getFruitList(), levelOne.getEnemyList());
            levelOne.getGate().render(gc);
        } else if (getCurrentLevel() == 2) {
            levelIterator(levelTwo.getWallList(), levelTwo.getFruitList(), levelTwo.getEnemyList());
            levelTwo.getGate().render(gc);
        }

        if (monkey.collide(levelOne.getGate())) {
            setCurrentLevel(2);
            monkey.setX(10);
            monkey.setY(10);
        }

        if (monkey.collide(levelTwo.getGate())) {
            setCurrentLevel(1);
        }


        // Tegner avatar
        monkey.render(gc);

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

            if (monkey.collisionLeft(wall)) {
                collision.add("CollisionLeft");
            }

            if (monkey.collisionRight(wall)) {
                collision.add("CollisionRight");
            }

            if (monkey.collisionBottom(wall)) {
                collision.add("CollisionBottom");
            }

            if (monkey.collisionTop(wall)) {
                collision.add("CollisionTop");
            }

        }

        // Itererer gjennom enemy
        //Iterator<Enemy> fiendeIterator = enemyList.iterator();
        Iterator<Enemy> fiendeIterator = levelOne.getEnemyList().iterator();
        while (fiendeIterator.hasNext()) {
            Enemy enemy = fiendeIterator.next();

            enemy.bounce();

            if (monkey.collide(enemy)) {
                score = 0;
                timer.stop();
                setNodeVisible("gameOver");
                sound.stop();

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
                System.out.println("DØD");
                score = 0;
            }


            if (monkey.collide(enemy)) {
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

    /**
     * Setter spillet på pause (går til menyen)
     */

    public void menu() {
        canvas.setVisible(false);
        controller.setMenuPage("ingameMenuButtons");
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


    /**
     * Get method
     */
    public GameSession getGS() {
        return this;
    }
}

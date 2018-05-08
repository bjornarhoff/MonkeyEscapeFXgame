package spillet;

import Controller.MenuController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
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
    public Canvas canvas;
    public AnimationTimer timer;
    private GraphicsContext gc;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Monkey player;
    private long timeLstFrm;
    private ArrayList<String> input = new ArrayList<>();
    private ArrayList<String> collision = new ArrayList<>();
    private ArrayList<Enemy> enemy = new ArrayList<>();
    private LevelOne levelOne = new LevelOne();
    private ArrayList<Wall> wallList = new ArrayList<>();
    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private int score = 0;
    private static AudioClip sound = new AudioClip(GameSession.class.getResource("/Audio/sound.mp3").toString());
    private static AudioClip clip = new AudioClip(GameSession.class.getResource("/Audio/power.mp3").toString());


    /**
     * Konstruktør
     */
    public GameSession(Pane gameView, MenuController controller) {
        this.gameView = gameView;
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

                    Input();
                    handleGameStateInput(input);

                    if (gameState.equals("running")) {

                        renderLevel();
                        drawScore(gc);
                        player.move(input, getGS(), collision);


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

        player = new Monkey(590, 590);

        wallList = levelOne.getWallList();
        enemy = levelOne.getEnemyList();
        fruitList = levelOne.getFruitList();


    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderLevel() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        wallList.forEach(p -> p.render(gc));
        enemy.forEach(p -> p.render(gc));
        fruitList.forEach(p -> p.render(gc));

        // Tegner avatar
        player.render(gc);


        collision.clear();

        // Itererer gjennom hinder
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

        // Itererer gjennom enemy
        Iterator<Enemy> fiendeIterator = enemy.iterator();
        while (fiendeIterator.hasNext()) {
            Enemy enemy = fiendeIterator.next();

            enemy.bounce();

            if (player.kollisjon(enemy)) {
                System.out.println("DØD");
                score = 0;
            }
        }

        // Itererer gjennom frukt
        Iterator<Fruit> fruktIterator = fruitList.iterator();
        while (fruktIterator.hasNext()) {
            Fruit fruit = fruktIterator.next();

            // Kollisjon med fruit, legger til +100 på score
            if (player.kollisjon(fruit) && fruit.exists()) {
                fruit.kill();
                appleSound();
                fruit.exists();
                score += 100;
            }
        }


        // Kollisjon med enemy
     /*   if (player.kollisjon(enemy)) {
            System.out.println("DØD");
            score=0;
        } */

        /** // Sjekker om boolean er sann, om objektet finnes
         if (eple1.exists()) {
         eple1.render(gc);
         }

         if (eple2.exists()) {
         eple2.render(gc);
         }

         if (eple3.exists()) {
         eple3.render(gc);
         }

         if (player.exists()) {
         player.render(gc);
         } */
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
     * Metode som tar key-input fra brukeren. Legger den til i arraylist og fjerner den
     */
    public void Input() {
        this.gameView.getScene().setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent e) {
                        String keyCode = e.getCode().toString();

                        if (!input.contains(keyCode)) {
                            input.add(keyCode);
                        }
                    }
                }
        );

        this.gameView.getScene().setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent e) {
                        String keyCode = e.getCode().toString();

                        input.remove(keyCode);
                    }
                }
        );
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

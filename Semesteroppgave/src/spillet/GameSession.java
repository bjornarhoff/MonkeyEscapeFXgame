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
    private Ape ape;
    private Fiende fiende;
    private Frukt eple1, eple2, eple3;
    private long timeLstFrm;
    private ArrayList<String> input = new ArrayList<>();
    private ArrayList<String> collision = new ArrayList<>();
    private LevelOne verden = new LevelOne();
    private ArrayList<Hinder> bane = new ArrayList<>();
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

                        renderVerden();
                        drawScore(gc);
                        ape.move(input, getGS(), collision);
                        fiende.bounce();

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

        ape = new Ape(590, 590);
        fiende = new Fiende(20, 440, 5, 0, 320, 400);

        eple1 = new Frukt(450, 450);
        eple2 = new Frukt(420, 100);
        eple3 = new Frukt(50, 300);

        bane = verden.getBane();


    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderVerden() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        bane.forEach(p -> p.render(gc));

        // Tegner fiende og avatar
        ape.render(gc);
        fiende.render(gc);

        collision.clear();

        Iterator<Hinder> hinderIterator = bane.iterator();

        while (hinderIterator.hasNext()) {

            Hinder hinder = hinderIterator.next();

            if (ape.collisionLeft(hinder)) {
                collision.add("CollisionLeft");
            }

            if (ape.collisionRight(hinder)) {
                collision.add("CollisionRight");
            }

            if (ape.collisionBottom(hinder)) {
                collision.add("CollisionBottom");
            }

            if (ape.collisionTop(hinder)) {
                collision.add("CollisionTop");
            }
        }

        // Kollisjon med frukt, legger til +10 på score
        if (ape.kollisjon(eple1) && eple1.status()) {
            eple1.drep();
            appleSound();
            score += 10;
        }
        if (ape.kollisjon(eple2) && eple2.status()) {
            eple2.drep();
            appleSound();
            score += 10;
        }
        if (ape.kollisjon(eple3) && eple3.status()) {
            eple3.drep();
            appleSound();
            score += 10;
        }

        // Kollisjon med fiende
        if (ape.kollisjon(fiende)) {
            System.out.println("DØD");
            score = 0;
        }

        // Sjekker om boolean er sann, om objektet finnes
        if (eple1.status()) {
            eple1.render(gc);
        }

        if (eple2.status()) {
            eple2.render(gc);
        }

        if (eple3.status()) {
            eple3.render(gc);
        }

        if (ape.status()) {
            ape.render(gc);
        }
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

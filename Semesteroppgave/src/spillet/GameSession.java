package spillet;

import Controller.MenuController;
import com.sun.glass.ui.Menu;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.ArrayList;


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
    private Image bakgrunn;
    private Image tre1, tre2, tre3, tre4, tre5, tre6, tre7, tre8, tre9, tre10, tre11, tre12, tre13, tre14, tre15;
    private long timeLstFrm;
    ArrayList<String> input = new ArrayList<>();
    private int score = 0;


    /**
     * Konstruktør
     */
    public GameSession(Pane gameView, MenuController controller) {
        this.gameView = gameView;
        this.gameState = "running";
        this.controller = controller;

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
                        ape.move(input, getGS());
                        fiende.bounce();

                        //System.out.println("X: " + ape.getX());
                        //System.out.println("Y: " + ape.getY());

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

        ape = new Ape(565, 570);
        fiende = new Fiende(20,440, 5,0,320,400);


        eple1 = new Frukt(400, 450);
        eple2 = new Frukt(450, 100);
        eple3 = new Frukt(50, 390);

        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        tre3 = new Image("spillet/tre.png");
        tre4 = new Image("spillet/tre.png");
        tre5 = new Image("spillet/tre.png");
        tre6 = new Image("spillet/tre.png");
        tre7 = new Image("spillet/tre.png");
        tre8 = new Image("spillet/tre.png");
        tre9 = new Image("spillet/tre.png");
        tre10 = new Image("spillet/tre.png");
        tre11 = new Image("spillet/tre.png");
        tre12 = new Image("spillet/tre.png");
        tre13 = new Image("spillet/tre.png");
        tre14 = new Image("spillet/tre.png");
        tre15 = new Image("spillet/tre.png");


    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderVerden() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        // Ramme
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(tre3, 0, 0, 10, HEIGHT);
        gc.drawImage(tre5, 0, 0, WIDTH, 10);
        gc.drawImage(tre6, WIDTH - 10, 0, 10, HEIGHT);
        gc.drawImage(tre7, 0, HEIGHT - 10, 575, 10);
        // Brett
        gc.drawImage(tre1, 111, 500, 10, 150);
        gc.drawImage(tre2, 0, 396, 290, 10);
        gc.drawImage(tre4, 210, 550, 110, 10);
        gc.drawImage(tre8, 200, 190, 10, 70);
        gc.drawImage(tre9, 103, 85, 10, 100);
        gc.drawImage(tre10, 280, 145, 220, 10);
        gc.drawImage(tre11, 570, 75, 10, 100);
        gc.drawImage(tre12, 510, 420, 50, 10);
        gc.drawImage(tre13, 550, 520, 100, 10);
        gc.drawImage(tre14, 400, 270, 10, 400);
        gc.drawImage(tre15, 575, 610, 10, 40);



        // Tegner fiende og avatar
        ape.render(gc);
        fiende.render(gc);

        // Kollisjon med frukt, legger til +10 på score
        if (ape.kollisjon(eple1) && eple1.status()) {
            eple1.drep();
            score+=10;
        }
        if (ape.kollisjon(eple2) && eple2.status()) {
            eple2.drep();
            score+=10;
        }
        if (ape.kollisjon(eple3) && eple3.status()) {
            eple3.drep();
            score+=10;
        }

        // Kollisjon med fiende
        if (ape.kollisjon(fiende)) {
            System.out.println("DØD");
            score=0;
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

    /** Metode som tegner score på brettet */
    public void drawScore (GraphicsContext gc) {
        gc.strokeText("Score: " + score, 450.0,50.0, 150);
        gc.setFont(new Font(30));
        gc.setStroke(Color.WHITE);
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

    /** Arraylist for å sjekke input */

    public void handleGameStateInput(ArrayList<String> input) {
        for (String string:input) {
            if (string.equals("p") || string.equals("P")) {
                menu();
                pause();

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

    public void pause () {
        if (gameState.equals("running")) {
            gameState = "pause";
        }else {
            gameState = "running";
        }

    }

    /** Get metoder */
    public Canvas getCanvas(){
        return this.canvas;
    }


    public GameSession getGS() {
        return this;
    }
}

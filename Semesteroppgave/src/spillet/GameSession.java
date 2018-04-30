package spillet;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameSession {

    private Pane gameView;
    public Canvas canvas;
    public AnimationTimer timer;
    private GraphicsContext gc;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Ape ape;
    private Frukt eple1, eple2, eple3;
    private long timeLstFrm;
    private Hinder hinder1, hinder2, hinder3, hinder4, hinder5, hinder6, hinder7, hinder8, hinder9, hinder10, hinder11, hinder12, hinder13, hinder14, hinder15;
    ArrayList<Hinder> bane = new ArrayList<>();
    ArrayList<String> input = new ArrayList<>();
    ArrayList<Boolean> collision = new ArrayList<>();
    private Verden verden = new Verden();



    /** Konstruktør */
    public GameSession(Pane gameView) {
        this.gameView = gameView;

        setScene();
        Timer();

    }

 /** Animation timer */
    private void Timer() {
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (System.nanoTime() - timeLstFrm > 1E9/60) {

                    renderVerden();
                    Input();
                    ape.move(input, getGS(), ape.getCollisionRight(), ape.getCollisionLeft(), ape.getCollisionTop(), ape.getCollisionBottom());
                    timeLstFrm = System.nanoTime();
                }
            }};
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

        eple1 = new Frukt( 450, 450);
        eple2 = new Frukt(420 ,100);
        eple3 = new Frukt( 50, 300);

        bane = verden.minVerden();


       /* hinder1 = new Hinder(111, 500, 10, 150);
        hinder2 = new Hinder(0, 396, 290, 10);
        hinder3 = new Hinder(0, 0, 10, HEIGHT);
        hinder4 = new Hinder(210, 550, 110, 10);
        hinder5 = new Hinder(0, 0, WIDTH, 10);
        hinder6 = new Hinder(WIDTH - 10, 0, 10, HEIGHT);
        hinder7 = new Hinder(0, HEIGHT - 10, 575, 10);
        hinder8 = new Hinder(200, 190, 10, 70);
        hinder9 = new Hinder(103, 85, 10, 100);
        hinder10 = new Hinder(280, 145, 220, 10);
        hinder11 = new Hinder(570, 75, 10, 100);
        hinder12 = new Hinder(510, 420, 50, 10);
        hinder13 = new Hinder(550, 520, 100, 10);
        hinder14 = new Hinder(400, 270, 10, 400);
        hinder15= new Hinder(575, 610, 10, 40);

        bane.add(hinder1);
        bane.add(hinder2);
        bane.add(hinder3);
        bane.add(hinder4);
        bane.add(hinder5);
        bane.add(hinder6);
        bane.add(hinder7);
        bane.add(hinder8);
        bane.add(hinder9);
        bane.add(hinder10);
        bane.add(hinder11);
        bane.add(hinder12);
        bane.add(hinder13);
        bane.add(hinder14);
        bane.add(hinder15);

*/
    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderVerden() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        ape.render(gc);
        bane.forEach(p -> p.render(gc));


        Iterator<Hinder> hinderIterator = bane.iterator();
        while (hinderIterator.hasNext()) {
            Hinder hinder = hinderIterator.next();

            if (ape.collisionLeft(hinder)) {
                ape.setCollisionLeft(true);
            } else {
                ape.setCollisionLeft(false);
            }

            if (ape.collisionRight(hinder)) {
                ape.setCollisionRight(true);
            } else {
                ape.setCollisionRight(false);
            }

            if (ape.collisionBottom(hinder)) {
                ape.setCollisionBottom(true);
            } else {
                ape.setCollisionBottom(false);
            }

            if (ape.collisionTop(hinder)) {
                ape.setCollisionTop(true);
            } else {
                ape.setCollisionTop(false);
            }
        }


        if (ape.kollisjon(eple1)) {
            eple1.drep();
        } if (ape.kollisjon(eple2)) {
            eple2.drep();
        } if (ape.kollisjon(eple3)) {
            eple3.drep();
        }

        if (eple1.status()) {
            eple1.render(gc);
        }

        if (eple2.status()) {
            eple2.render(gc);
        }

        if (eple3.status()) {
            eple3.render(gc);
        }

    }

     /** Metode som tar key-input fra brukeren. Legger den til i arraylist og fjerner den */
    public void Input(){
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

    /** Setter spillet på pause (går til menyen) */
    public void pause() {
        timer.stop();
        canvas.setVisible(false);
    }

    public Canvas getCanvas(){
        return this.canvas;}

    public GameSession getGS() {
        return this;
    }
}

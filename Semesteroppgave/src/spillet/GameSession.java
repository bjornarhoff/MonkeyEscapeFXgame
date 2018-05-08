package spillet;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;

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
    private ArrayList<Hinder> bane = new ArrayList<>();
    private ArrayList<String> input = new ArrayList<>();
    private LevelOne verden = new LevelOne();

    private ArrayList<String> collision = new ArrayList<>();



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
                    ape.move(input, getGS(), collision);
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

        bane = verden.getBane();

    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderVerden() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        bane.forEach(p -> p.render(gc));
        ape.render(gc);

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

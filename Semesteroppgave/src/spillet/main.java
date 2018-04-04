package spillet;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

/**
 * Launcherklasse som inneholder main-metoden og start-metoden for å danne scenen, samt animere innholdet.
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class main extends Application {

    private GraphicsContext grafikk;
    private Scene vinduInnhold;
    private Ape player;
    private Frukt eple1, eple2, eple3;
    private Image bakgrunn;
    private Image tre1, tre2, tre3, tre4, tre5, tre6;
    private double apebredde = 100;
    private double apehøyde = 100;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metoden overrider start-metoden i Application og starter vinduet og legger til innholdet.
     * @param vindu
     * @throws Exception
     */
    @Override
    public void start(Stage vindu) throws Exception {
        vindu.setTitle("Prøvespill");
        Verden banen = new Verden();
        vinduInnhold = new Scene(banen.lagVerden());

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                banen.renderVerden();
                moveApe();
            }
        };
        timer.start();

        vindu.setScene(vinduInnhold);
        vindu.show();
    }

    /**
     * Denne metoden danner layoyt-pane som man legger canvas og dermed animasjonene på.
     * @return root
     */
/*    private Parent lagVerden() {
        Pane root = new Pane();
        Canvas lerret = new Canvas(600, 600);
        grafikk = lerret.getGraphicsContext2D();

        player = new Ape("spillet/ape.png", 150, 150);
        bakgrunn = new Image("spillet/bakgrunn.png");
        eple1 = new Frukt("spillet/eple.png", 400, 450);
        eple2 = new Frukt("spillet/eple.png", 450 ,100);
        eple3 = new Frukt("spillet/eple.png", 50, 390);
        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        tre3 = new Image("spillet/tre.png");
        tre4 = new Image("spillet/tre.png");
        tre5 = new Image("spillet/tre.png");
        tre6 = new Image("spillet/tre.png");
        renderVerden();

        root.getChildren().add(lerret);

        return root;
    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
/*    public void renderVerden() {
        grafikk.clearRect(0, 0, 600, 600);
        grafikk.drawImage(bakgrunn, 0, 0, 600, 600);
        grafikk.drawImage(tre1, 60, 0, 540, 10);
        grafikk.drawImage(tre2, 590, 10, 10,590);
        grafikk.drawImage(tre3, 0, 590, 590, 10);
        grafikk.drawImage(tre4, 0, 0, 10,590);
        grafikk.drawImage(tre5, 60, 0, 540, 10);
        grafikk.drawImage(tre6, 590, 10, 10,590);
        eple1.render(grafikk, 50, 50);
        eple2.render(grafikk, 50, 50);
        eple3.render(grafikk, 50, 50);
        player.render(grafikk, apebredde, apehøyde);
    }

    /**
     * Metode som oppdaterer posisjonen til spilleren i x- og y-retning basert på tastetrykk med piltastene.
     */
    public void moveApe() {
        vinduInnhold.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    player.beveg("Opp");
                } else if (e.getCode() == KeyCode.DOWN) {
                    player.beveg("Ned");
                } else if (e.getCode() == KeyCode.LEFT) {
                    player.beveg("Venstre");
                } else if (e.getCode() == KeyCode.RIGHT) {
                    player.beveg("Høyre");
                }
            }
        });
/*
        vinduInnhold.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.DOWN) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.LEFT) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.RIGHT) {
                    player.setDeltaXY(0,0);
                }
            }
        }); */


    }



}
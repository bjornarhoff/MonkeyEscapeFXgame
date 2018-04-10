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
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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
        vinduInnhold = new Scene(lagVerden());


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                renderVerden();
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
    private Parent lagVerden() {
        Pane root = new Pane();
        Canvas lerret = new Canvas(600, 600);
        grafikk = lerret.getGraphicsContext2D();

        player = new Ape(150, 150);
        bakgrunn = new Image("spillet/bakgrunn.png");
        eple1 = new Frukt( 400, 450);
        eple2 = new Frukt(450 ,100);
        eple3 = new Frukt( 50, 390);
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
    public void renderVerden() {
        grafikk.clearRect(0, 0, 600, 600);
        grafikk.drawImage(bakgrunn, 0, 0, 600, 600);

        player.render(grafikk);

        if (player.kollisjon(eple1)) {
            eple1.drep();
        } else if (player.kollisjon(eple2)) {
            eple2.drep();
        } else if (player.kollisjon(eple3)) {
            eple3.drep();
        }

        if (eple1.finnes()) {
            eple1.render(grafikk);
        }

        if (eple2.finnes()) {
            eple2.render(grafikk);
        }

        if (eple3.finnes()) {
            eple3.render(grafikk);
        }
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
    }



}
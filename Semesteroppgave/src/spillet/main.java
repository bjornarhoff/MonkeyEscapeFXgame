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


public class main extends Application {

    private GraphicsContext grafikk;
    private Canvas lerret;
    private Pane root;
    private Scene vinduInnhold;
    private Avatar ape;
    private Image bakgrunn;
    private Image tre1;
    private Image tre2;
    private double apebredde = 100;
    private double apehøyde = 100;
    private AnimationTimer timer;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage vindu) throws Exception {
        vindu.setTitle("Prøvespill");
        vinduInnhold = new Scene(lagVerden());

        moveApe();

        vindu.setScene(vinduInnhold);
        vindu.show();
    }

    private Parent lagVerden() {
        root = new Pane();
        lerret = new Canvas(600, 600);
        grafikk = lerret.getGraphicsContext2D();


        ape = new Avatar();
        bakgrunn = new Image("spillet/bakgrunn.png");
        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        renderVerden();

        ape.setPositionX(150);
        ape.setPositionY(150);
        ape.setImage("spillet/ape.png");
        ape.render(grafikk, apebredde, apehøyde);

        root.getChildren().add(lerret);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                renderVerden();
            }
        };
        timer.start();

        return root;
    }

    public void renderVerden() {
        grafikk.clearRect(0, 0, 30, 30);
        grafikk.drawImage(bakgrunn, 0, 0, 600, 600);
        grafikk.drawImage(tre1, 400, 50, 50, 300);
        grafikk.drawImage(tre2, 50, 50, 350,50);
        ape.render(grafikk, apebredde, apehøyde);
    }

    public void moveApe() {
        vinduInnhold.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    ape.setPositionY(ape.getPositionY() - 10);
                } else if (e.getCode() == KeyCode.DOWN) {
                    ape.setPositionY(ape.getPositionY() + 10);
                } else if (e.getCode() == KeyCode.LEFT) {
                    ape.setPositionX(ape.getPositionX() - 10);
                } else if (e.getCode() == KeyCode.RIGHT) {
                    ape.setPositionX(ape.getPositionX() + 10);
                }
            }
        });
    }



}
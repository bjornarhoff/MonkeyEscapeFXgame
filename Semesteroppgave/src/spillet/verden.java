package spillet;


import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class verden {

    private GraphicsContext grafikk;
    private Canvas lerret;
    private Pane root;
    private Avatar ape;
    private Image bakgrunn;
    private Image tre1;
    private Image tre2;
    private double apebredde = 100;
    private double apehøyde = 100;
    private AnimationTimer timer;

    public void verden() {

    }

    public Parent lagVerden() {
        root = new Pane();
        lerret = new Canvas(600, 600);
        grafikk = lerret.getGraphicsContext2D();


        ape = new Avatar();
        bakgrunn = new Image("spillet/bakgrunn.png");
        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        renderVerden();

        root.getChildren().add(lerret);

/*        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                renderVerden();
            }
        };
        timer.start(); */

        return root;
    }

    public void renderVerden() {
        grafikk.clearRect(0, 0, 30, 30);
        grafikk.drawImage(bakgrunn, 0, 0, 600, 600);
        grafikk.drawImage(tre1, 400, 50, 50, 300);
        grafikk.drawImage(tre2, 50, 50, 350,50);
    }


}

package spillet;


import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Dette er et tentativt forsøk på å konstruere spillerbrettet utenfor launcherklassen "main". Det skal etterhvert
 * opprettes en del spillerbrett og det vil være veldig bedre med en klasse som genererer disse.
 *
 * @Gaute, @Eirik, @Bjørnar
 */

public class Verden {

    private GraphicsContext grafikk;
    private Canvas lerret;
    private Pane root;
    private Ape player;
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

        player = new Ape("spillet/ape.png", 150, 150);
        bakgrunn = new Image("spillet/bakgrunn.png");
        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        renderVerden();

        root.getChildren().add(lerret);

        return root;
    }

    public void renderVerden() {
        grafikk.clearRect(0, 0, 30, 30);
        grafikk.drawImage(bakgrunn, 0, 0, 600, 600);
        grafikk.drawImage(tre1, 50, 50, 50, 300);
        grafikk.drawImage(tre2, 50, 50, 350,50);
    }


}

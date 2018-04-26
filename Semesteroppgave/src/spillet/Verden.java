package spillet;


import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
    private Image tre1, tre2, tre3, tre4, tre5, tre6;
    private Frukt eple1, eple2, eple3;
    private double apebredde = 100;
    private double apehøyde = 100;
    private AnimationTimer timer;



    int [][] map = new int [][] {
            {111, 500, 10, 150},
            {0, 396, 290, 10},
            {210, 550, 110, 10}
    };

    public void verden() {


    }

    public void drawWalls (Group group) {
    }

/*    public Parent lagVerden() {
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

    public void renderVerden() {
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
*/

}

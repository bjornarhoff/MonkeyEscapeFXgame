package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.*;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Ape extends SpillObjekt {

    private double bevegelse = 5;
    private double apebredde = 50;
    private double apehøyde = 50;

    /**
     * Constructor for Ape, denne overrider konstruktøren til spillobjekt.
     *
     * @param x
     * @param y
     */
    public Ape(double x, double y) {
        super(x, y);
        Image bilde = new Image("spillet/ape.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setH(apehøyde);
        setW(apebredde);
    }

    public Rectangle2D boundaryLeft() {
        return new Rectangle2D(getX(), getY() + 5, 5, getH() - 10);
    }

    public Rectangle2D boundaryRight() {
        return new Rectangle2D(getX() + getW() - 5, getY() + 5, 5, getH() - 10);
    }

    public Rectangle2D boundaryTop() {
        return new Rectangle2D(getX() + 5, getY(), getW() - 10, 5);
    }

    public Rectangle2D boundaryBottom() {
        return new Rectangle2D(getX() + 5, getY() + getH() - 5, getW() - 10, 5);
    }

    public boolean collisionLeft(SpillObjekt s) {
        return s.objektGrense().intersects(this.boundaryLeft());
    }

    public boolean collisionRight(SpillObjekt s) {
        return s.objektGrense().intersects(this.boundaryRight());
    }

    public boolean collisionTop(SpillObjekt s) {
        return s.objektGrense().intersects(this.boundaryTop());
    }

    public boolean collisionBottom(SpillObjekt s) {
        return s.objektGrense().intersects(this.boundaryBottom());
    }

    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     */
    public void move(ArrayList<String> input, GameSession gs, ArrayList<String> collision) {

        if (input.contains("UP") && !collision.contains("CollisionTop")) {
            setY(getY() - bevegelse);

        }
        if (input.contains("DOWN") && !collision.contains("CollisionBottom")) {
            setY(getY() + bevegelse);

        }
        if (input.contains("LEFT") && !collision.contains("CollisionLeft")) {
            setX(getX() - bevegelse);

        }
        if (input.contains("RIGHT") && !collision.contains("CollisionRight")) {
            setX(getX() + bevegelse);

        }

        if (input.contains("RIGHT") && input.contains("UP") && !collision.contains("CollisionRight") && !collision.contains("CollisionRight")) {
            setX(getX() + Math.cos(bevegelse));
            setY(getY() + Math.cos(bevegelse));

        }

        if (input.contains("ESCAPE")) {
            gs.pause();
        }

    }

}










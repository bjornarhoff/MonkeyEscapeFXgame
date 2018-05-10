package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.*;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Monkey extends GameObject {

    private double dx = 5;
    private double dy = 5;
    private double playerWidth = 35;
    private double playerHeight = 40;

    /**
     * Constructor for Monkey, denne overrider konstruktøren til spillobjekt.
     *
     * @param x
     * @param y
     */
    public Monkey(double x, double y) {
        super(x, y);
        Image bilde = new Image("IMG/ape.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setH(playerHeight);
        setW(playerWidth);
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

    public boolean collisionLeft(GameObject s) {
        return s.objektGrense().intersects(this.boundaryLeft());
    }

    public boolean collisionRight(GameObject s) {
        return s.objektGrense().intersects(this.boundaryRight());
    }

    public boolean collisionTop(GameObject s) {
        return s.objektGrense().intersects(this.boundaryTop());
    }

    public boolean collisionBottom(GameObject s) {
        return s.objektGrense().intersects(this.boundaryBottom());
    }


    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     */
    public void move(ArrayList<String> input, GameSession gs, ArrayList<String> collision) {

        if (input.contains("UP") && !collision.contains("CollisionTop")) {
            setY(getY() - dy);

        }
        if (input.contains("DOWN") && !collision.contains("CollisionBottom")) {
            setY(getY() + dy);

        }
        if (input.contains("LEFT") && !collision.contains("CollisionLeft")) {
            setX(getX() - dx);

        }
        if (input.contains("RIGHT") && !collision.contains("CollisionRight")) {
            setX(getX() + dx);

        }
        if (input.contains("ESCAPE")) {
            gs.pause();
        }

    }


}










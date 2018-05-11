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

    private double playerWidth = 50;
    private double playerHeight = 50;
    Image monkeyDown = new Image("IMG/monkeyDown.png");
    Image monkeyDownLeft = new Image("IMG/monkeyDownLeft.png");
    Image monkeyDownRight = new Image("IMG/monkeyDownRight.png");
    Image monkeyLeft = new Image("IMG/monkeyLeft.png");
    Image monkeyRight = new Image("IMG/monkeyRight.png");
    Image monkeyUp = new Image("IMG/monkeyUp.png");
    Image monkeyUpLeft = new Image("IMG/monkeyUpLeft.png");
    Image monkeyUpRight = new Image("IMG/monkeyUpRight.png");
    /**
     * Constructor for Monkey, denne overrider konstruktøren til spillobjekt.
     *
     * @param x
     * @param y
     */
    public Monkey(double x, double y) {
        super(x, y);
        Image bilde = new Image("IMG/monkeydown.png");

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
        return s.boundary().intersects(this.boundaryLeft());
    }

    public boolean collisionRight(GameObject s) {
        return s.boundary().intersects(this.boundaryRight());
    }

    public boolean collisionTop(GameObject s) {
        return s.boundary().intersects(this.boundaryTop());
    }

    public boolean collisionBottom(GameObject s) {
        return s.boundary().intersects(this.boundaryBottom());
    }

    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     */
    public void move(ArrayList<String> input, GameSession gs, ArrayList<String> collision) {

        // Move Up
        if (input.contains("UP") && !input.contains("LEFT") && !input.contains("RIGHT") && !collision.contains("CollisionTop")) {
            moveAngled((Math.PI) * 3 / 2);
            setImage(monkeyUp);

        }

        // Move Down
        if (input.contains("DOWN") && !input.contains("LEFT") && !input.contains("RIGHT") && !collision.contains("CollisionBottom")) {
            moveAngled(Math.PI / 2);
            setImage(monkeyDown);
        }

        // Move Left
        if (input.contains("LEFT") && !input.contains("UP") && !input.contains("DOWN") && !collision.contains("CollisionLeft")) {
            moveAngled(Math.PI);
            setImage(monkeyLeft);
        }

        // Move Right
        if (input.contains("RIGHT") && !input.contains("UP") && !input.contains("DOWN") && !collision.contains("CollisionRight")) {
            moveAngled(0);
            setImage(monkeyRight);
        }

        // Move Up-Right
        if (input.contains("UP") && input.contains("RIGHT") && !collision.contains("CollisionRight") && !collision.contains("CollisionTop")) {
            moveAngled(Math.PI * 7 / 4);
            setImage(monkeyUpRight);
        }

        // Move Down-Right
        if (input.contains("DOWN") && input.contains("RIGHT") && !collision.contains("CollisionRight") && !collision.contains("CollisionBottom")) {
            moveAngled(Math.PI / 4);
            setImage(monkeyDownRight);
        }

        // Move Down-Left
        if (input.contains("DOWN") && input.contains("LEFT") && !collision.contains("CollisionLeft") && !collision.contains("CollisionBottom")) {
            moveAngled(Math.PI * 3 / 4);
            setImage(monkeyDownLeft);
        }

        // Move Up-left
        if (input.contains("UP") && input.contains("LEFT") && !collision.contains("CollisionLeft") && !collision.contains("CollisionTop")) {
            moveAngled(Math.PI * 5 / 4);
            setImage(monkeyUpLeft);
        }

        // Menu
        if (input.contains("ESCAPE")) {
            gs.pause();
        }
    }
}










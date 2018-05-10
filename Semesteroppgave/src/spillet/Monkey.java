package spillet;

import javafx.geometry.Point2D;
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

    private double EX;
    private double EY;
    private double playerWidth = 50;
    private double playerHeight = 50;
    private Point2D velocity = new Point2D(0, 0);



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






}










package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Ape extends SpillObjekt {

    private double bevegelse = 5;
    private double apebredde = 50;
    private double apehøyde = 50;
    private boolean collisionLeft;
    private boolean collisionRight;
    private boolean collisionTop;
    private boolean collisionBottom;


    /**
     * Constructor for Ape, denne overrider konstruktøren til spillobjekt.
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
        return new Rectangle2D(getX(),getY()+5,5,getH()-10);
    }

    public Rectangle2D boundaryRight() {
        return new Rectangle2D(getX()+getW()-5,getY()+5,5,getH()-10);
    }

    public Rectangle2D boundaryTop() {
        return new Rectangle2D(getX()+5,getY(),getW()-10,5);
    }

    public Rectangle2D boundaryBottom() {
        return new Rectangle2D(getX()+5, getY()+getH()-5, getW()-10, 5);
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

    public void setCollisionLeft(boolean collisionLeft) {
        this.collisionLeft = collisionLeft;
    }

    public void setCollisionRight(boolean collisionRight) {
        this.collisionRight = collisionRight;
    }

    public void setCollisionTop(boolean collisionTop) {
        this.collisionTop = collisionTop;
    }

    public void setCollisionBottom(boolean collisionBottom) {
        this.collisionBottom = collisionBottom;
    }


    public boolean getCollisionLeft() {
        return this.collisionLeft;
    }

    public boolean getCollisionRight() {
        return this.collisionRight;
    }

    public boolean getCollisionTop() {
        return this.collisionTop;
    }

    public boolean getCollisionBottom() {
        return this.collisionBottom;
    }



    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     *
     */
    public void move(ArrayList<String> input, GameSession gs, boolean isCollisionRight, boolean isCollisionLeft, boolean isCollisionTop, boolean isCollisionBottom) {


            if (input.contains("UP") && !isCollisionTop) {
                setY(getY() - bevegelse);

            }
            if (input.contains("DOWN") && !isCollisionBottom) {
                setY(getY() + bevegelse);

            }
            if (input.contains("LEFT") && !isCollisionLeft) {
                setX(getX() - bevegelse);

            }
            if (input.contains("RIGHT") && !isCollisionRight) {
                setX(getX() + bevegelse);

            }
            if (input.contains("ESCAPE")) {
                gs.pause();
            }



        }


    }



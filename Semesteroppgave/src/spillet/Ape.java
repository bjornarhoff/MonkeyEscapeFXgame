package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Arrays;
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
        return new Rectangle2D(getX(),getY()+5,1,getH()-10);
    }

    public Rectangle2D boundaryRight() {
        return new Rectangle2D(getX()+getW()-1,getY()+5,1,getH()-10);
    }

    public Rectangle2D boundaryTop() {
        return new Rectangle2D(getX()+5,getY(),getW()-10,1);
    }

    public Rectangle2D boundaryBottom() {
        return new Rectangle2D(getX()+getH()-5,getY(),getW()-10,1);
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
     *
     */
    public void move(ArrayList<String> input, GameSession gs) {
        if (input.contains("UP") && getY() >= -20) {
            setY(getY() - bevegelse);

        } if (input.contains("DOWN")&& getY() < gs.getCanvas().getHeight()-20) {
            setY(getY() + bevegelse);

        } if (input.contains("LEFT") && getX() >= -20) {
            setX(getX() - bevegelse);

        } if (input.contains("RIGHT") && getX() < gs.getCanvas().getWidth()-20) {
            setX(getX() + bevegelse);

        } if (input.contains("ESCAPE")) {
            gs.pause();
        }



        }


    }



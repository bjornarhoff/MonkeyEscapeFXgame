package spillet;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Ape extends SpillObjekt {

    private double bevegelse = 3;


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
        setH(100);
        setW(100);
    }


    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     *
     */
    public void move(ArrayList<String> input) {
        if (input.contains("UP") && getY() >= -20) {
            setY(getY() - bevegelse);

        } if (input.contains("DOWN")&& getY() < 530) {
            setY(getY() + bevegelse);

        } if (input.contains("LEFT") && getX() >= -20) {
            setX(getX() - bevegelse);

        } if (input.contains("RIGHT") && getX() < 530) {
            setX(getX() + bevegelse);

        } if (input.contains("ESCAPE")) {
        }

        }



    }



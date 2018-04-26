package spillet;

import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Ape extends SpillObjekt {

    private double bevegelse = 5;
    private double apebredde = 100;
    private double apehøyde = 100;


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



package spillet;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Ape extends SpillObjekt {

    private double bevegelse = 10;
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
    }

    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     * @param retning
     */
    public void beveg(String retning) {
        if (retning.equals("Opp")) {
//            addDeltaXY(0, -50);
            setY(getY() - bevegelse);
        } else if (retning.equals("Ned")) {
//            addDeltaXY(0,50);
            setY(getY() + bevegelse);
        } else if (retning.equals("Venstre")) {
//            addDeltaXY(-50,0);
            setX(getX() - bevegelse);
        } else if (retning.equals("Høyre")) {
//            addDelta(50,0);
            setX(getX() + bevegelse);
        }
    }
}

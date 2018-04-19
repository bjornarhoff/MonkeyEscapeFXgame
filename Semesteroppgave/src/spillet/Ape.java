package spillet;

import javafx.scene.image.Image;

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
        setH(100);
        setW(100);
    }


    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     * @param retning
     */
    public void beveg(String retning) {
        if (retning.equals("Opp") && getY() >= -20) {
//            addDeltaXY(0, -50);
            setY(getY() - bevegelse);
        } else if (retning.equals("Ned") && getY() < 530) {
//            addDeltaXY(0,50);
            setY(getY() + bevegelse);
        } else if (retning.equals("Venstre") && getX() >= -20) {
//            addDeltaXY(-50,0);
            setX(getX() - bevegelse);
        } else if (retning.equals("Høyre") && getX() < 530) {
//            addDelta(50,0);
            setX(getX() + bevegelse);
        }
    }
}

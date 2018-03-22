package spillet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class ape extends Avatar {

    /**
     * Constructor for ape, denne overrider konstruktøren til avatar.
     * @param filename
     * @param x
     * @param y
     */
    public ape (String filename, double x, double y) {
        super(filename, x, y);
        Image bilde = new Image(filename);
        setImage(bilde);
        setPositionY(y);
        setPositionX(x);
    }

    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
     * @param retning
     */
    public void beveg(String retning) {
        if (retning.equals("Opp")) {
            setPositionY(getPositionY() - 10);
        } else if (retning.equals("Ned")) {
            setPositionY(getPositionY() + 10);
        } else if (retning.equals("Venstre")) {
            setPositionX(getPositionX() - 10);
        } else if (retning.equals("Høyre")) {
            setPositionX(getPositionX() + 10);
        }
    }
}

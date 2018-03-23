package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for power-ups.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Frukt extends SpillObjekt {

    /**
     * Constructor for Frukt, denne overrider konstruktøren til avatar.
     * @param filename
     * @param x
     * @param y
     */
    public Frukt(String filename, double x, double y) {
        super(filename, x, y);
        Image bilde = new Image(filename);
        setImage(bilde);
        setX(x);
        setY(y);
    }


}

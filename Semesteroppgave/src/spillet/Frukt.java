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

     * @param x
     * @param y
     */
    public Frukt(double x, double y) {
        super(x, y);
        Image bilde = new Image("spillet/eple.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setW(20);
        setH(20);
    }



}

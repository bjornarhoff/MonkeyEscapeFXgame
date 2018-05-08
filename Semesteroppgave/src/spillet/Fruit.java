package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for power-ups.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Fruit extends GameObject {

    /**
     * Constructor for Fruit, denne overrider konstruktøren til avatar.
     *
     * @param x
     * @param y
     */
    public Fruit(double x, double y) {
        super(x, y);
        Image bilde = new Image("/IMG/eple.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setW(20);
        setH(20);
    }


}

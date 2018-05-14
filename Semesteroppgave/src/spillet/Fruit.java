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
        Image bilde = new Image(getClass().getResourceAsStream("/IMG/banana.png"));
        setImage(bilde);
        setX(x);
        setY(y);
        setW(32);
        setH(20);
    }


}

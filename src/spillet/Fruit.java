package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for bananer som samles for progressjon til neste level
 *
 */
public class Fruit extends GameObject {

    /**
     * Constructor for Fruit som setter bildet, x- og y-posisjon samt width og height.
     *
     * @param x x-posisjon
     * @param y y-posisjon
     */
    public Fruit(double x, double y) {
        super(x, y);
        Image bilde = new Image("/IMG/banana.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setW(32);
        setH(20);
    }
}

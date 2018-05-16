package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for bananer som må samles for å nå neste nivå.
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class Fruit extends GameObject {

    /**
     * Constructor for Fruit som setter bildet, x- og y-posisjon samt bredde og høyde.
     *
     * @param x
     * @param y
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

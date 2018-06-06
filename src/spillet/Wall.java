package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for veggene i de ulike levelene i spillet
 *
 */
public class Wall extends GameObject {


    /**
     *
     * Constructor for Wall som setter bildet, x- og y-posisjon samt width og height.
     *
     * @param x x-posisjon
     * @param y y-posisjon
     * @param w width
     * @param h height
     */
    public Wall(double x, double y, double w, double h) {
        super(x, y);
        Image bilde = new Image("IMG/woods.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setH(h);
        setW(w);

    }
}

package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for porter videre til neste level
 *
 */
public class Gate extends GameObject {


    /**
     * Constructor for Gate som setter bildet, x- og y-posisjon samt width and height.
     *
     * @param x x-posisjon
     * @param y y-posisjon
     * @param w width
     * @param h height
     */
    public Gate(double x, double y, double w, double h) {
        super(x, y);
        Image bilde = new Image("IMG/red.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setH(h);
        setW(w);
    }
}
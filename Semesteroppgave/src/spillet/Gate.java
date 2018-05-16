package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for porter fører videre til neste nivå
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class Gate extends GameObject {

    /**
     * Constructor for Gate som setter bildet, x- og y-posisjon samt bredde og høyde.
     *
     * @param x
     * @param y
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
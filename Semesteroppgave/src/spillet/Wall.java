package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for veggene i de ulike nivåene av spillet
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class Wall extends GameObject {

    /**
     * Constructor for Wall som setter bildet, x- og y-posisjon samt bredde og høyde.
     *
     * @param x
     * @param y
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

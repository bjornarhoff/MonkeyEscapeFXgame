package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for power-ups.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Fruit extends GameObject {

    /**
<<<<<<< HEAD:Semesteroppgave/src/spillet/Frukt.java
     * Constructor for Frukt, denne overrider konstruktøren til avatar.
=======
     * Constructor for Fruit, denne overrider konstruktøren til avatar.
>>>>>>> master:Semesteroppgave/src/spillet/Fruit.java
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

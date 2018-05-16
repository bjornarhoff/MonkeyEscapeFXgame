package spillet;

import javafx.scene.image.Image;

/**
 * Dette er class for bananer som må samles for å nå neste nivå.
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class Fruit extends GameObject {

    /**
<<<<<<< HEAD
<<<<<<< HEAD:Semesteroppgave/src/spillet/Frukt.java
     * Constructor for Frukt, denne overrider konstruktøren til avatar.
=======
     * Constructor for Fruit, denne overrider konstruktøren til avatar.
>>>>>>> master:Semesteroppgave/src/spillet/Fruit.java
=======
     * Constructor for Fruit som setter bildet, x- og y-posisjon samt bredde og høyde.
>>>>>>> 8d981b133820b195135f4272fac7385cb5e9ac0b
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

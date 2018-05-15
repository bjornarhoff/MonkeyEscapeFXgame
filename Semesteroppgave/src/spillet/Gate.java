package spillet;

import javafx.scene.image.Image;

public class Gate extends GameObject {

    public Gate(double x, double y, double w, double h) {
        super(x, y);
        Image bilde = new Image(Gate.class.getResource("/IMG/red.png").toString());
        setImage(bilde);
        setX(x);
        setY(y);
        setH(h);
        setW(w);
    }

}
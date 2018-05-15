package spillet;

import javafx.scene.image.Image;

public class Wall extends GameObject {

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

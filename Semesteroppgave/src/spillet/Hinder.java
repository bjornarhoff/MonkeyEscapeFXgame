package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Hinder extends SpillObjekt {

    public Hinder(double x, double y, double w, double h) {
        super(x, y);
        Image bilde = new Image("spillet/tre.png");
        setImage(bilde);
        setX(x);
        setY(y);
        setH(h);
        setW(w);

    }
}

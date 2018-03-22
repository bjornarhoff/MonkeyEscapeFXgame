package spillet;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

/**
 * Dette er superclass for spillavatarer skal arve fra. Dette inkluderer Apen, Zookeepers, power-ups osv.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Avatar {
    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
    private String filename;

    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter posisjonen til avataren.
     * @param filename
     * @param x
     * @param y
     */
    public Avatar(String filename, double x, double y)
    {
        Image bilde = new Image(filename);
        positionX = 0;
        positionY = 0;
        setImage(bilde);
        setPositionY(y);
        setPositionX(x);
    }

    /**
     * Setter image.
     * @param i
     */
    public void setImage(Image i)
    {
        image = i;
    }

    /**
     * Setter x-posisjonen til avataren
     * @param x
     */
    public void setPositionX(double x)
    {
        positionX = x;
    }

    /**
     * Setter y-posisjon til avataren
     * @param y
     */
    public void setPositionY(double y)
    {
        positionY = y;
    }

    /**
     * Getter x-posisjonen til avataren
     * @return positionX
     */
    public double getPositionX() {
        return positionX;
    }

    /**
     * Getter y-posisjon til avataren
     * @return positionY
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     * Metode for å rendere avataren med image, positionX, positionY samt tar bredde w og høyde h som parametere
     * @param gc
     * @param w
     * @param h
     */
    public void render(GraphicsContext gc, double w, double h)
    {
        gc.drawImage(image, positionX, positionY, w, h);
    }


}

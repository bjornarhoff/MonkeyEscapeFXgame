package spillet;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

/**
 * Dette er superclass for spillobjekter skal arve fra. Dette inkluderer Apen, Zookeepers, power-ups osv.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class SpillObjekt {
    private Image bilde;
    private double dX;
    private double dY;
    private double Y;
    private double X;

    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter
     * posisjonen til objektet.
     * @param filename
     * @param x
     * @param y
     */
    public SpillObjekt(String filename, double x, double y)
    {
        this.bilde = new Image(filename);
        setImage(bilde);
        Y = y;
        X = x;
    }

    /**
     * Setter image.
     * @param i
     */
    public void setImage(Image i)
    {
        this.bilde = i;
    }

    /**
     * Setter x-posisjonen til avataren
     * @param x
     */
    public void setX(double x)
    {
        X = x;
    }

    /**
     * Setter y-posisjon til avataren
     * @param y
     */
    public void setY(double y)
    {
        Y = y;
    }

    /**
     * Getter x-posisjonen til avataren
     * @return positionX
     */
    public double getX() {
        return X;
    }

    /**
     * Getter y-posisjon til avataren
     * @return positionY
     */
    public double getY() {
        return Y;
    }

    /**
     * Metode for å rendere avataren med image, positionX, positionY samt tar bredde w og høyde h som parametere
     * @param gc
     * @param w
     * @param h
     */
    public void render(GraphicsContext gc, double w, double h)
    {
        gc.drawImage(bilde, X, Y, w, h);
    }
/*
    public void setDeltaXY(double x, double y)
    {
        dX = x;
        dY = y;
    }

    public void addDeltaXY(double x, double y)
    {
        dX += x;
        dY += y;
    }

    public void oppdater(double tid)
    {
        X += dX * tid;
        Y += dY * tid;
        setX(X);
        setY(Y);
    } */


}

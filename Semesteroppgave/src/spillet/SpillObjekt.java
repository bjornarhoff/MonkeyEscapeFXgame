package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
/**
 * Dette er superclass for spillobjekter skal arve fra. Dette inkluderer Apen, Zookeepers, power-ups osv.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class SpillObjekt {
    protected Image bilde;
    private double dX;
    private double dY;
    private double Y;
    private double X;
    private double W;
    private double H;
    private boolean finnes = true;

    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter
     * posisjonen til objektet.
     * @param x
     * @param y
     */
    public SpillObjekt(double x, double y) {

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

    public void setW(double w) {
        this.W = w;
    }

    public double getW() {
        return W;
    }

    public void setH(double h) {
        this.H = h;
    }

    public double getH() {
        return H;
    }

    public void drep() {
        this.finnes = false;

    }

    public boolean status() {
        return finnes;
    }

    /**
     * Metode for å rendere avataren med image, positionX, positionY samt tar bredde w og høyde h som parametere
     * @param gc

     */
    public void render(GraphicsContext gc)
    {
        if (status()) {
            gc.drawImage(bilde, X, Y, W, H);
        }
    }

    public Rectangle2D objektGrense() {
        return new Rectangle2D(X,Y,W,H);
    }

    public boolean kollisjon(SpillObjekt s) {
        return s.objektGrense().intersects(this.objektGrense());
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

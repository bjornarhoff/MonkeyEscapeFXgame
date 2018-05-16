package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

/**
 * Dette er superclass for spillobjekter.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class GameObject implements Serializable {
    protected Image image;
    private double Y;
    private double X;
    private double W;
    private double H;
    private double DX = 7;
    private double DY = 7;
    private boolean exists = true;

    /**
     * Dette er classconstructor for spillobjekter som tar inn x- og y-posisjon
     *
     * @param x
     * @param y
     */
    public GameObject(double x, double y) {}

    /**
     * Setter image.
     *
     * @param i
     */
    public void setImage(Image i) {


        this.image = i;

    }

    /**
     * Setter x-posisjonen til spillobjektet
     *
     * @param x
     */
    public void setX(double x) {
        X = x;
    }

    /**
     * Setter y-posisjon til spillobjektet
     *
     * @param y
     */
    public void setY(double y) {
        Y = y;
    }

    /**
     * Getter x-posisjonen til spillobjektet
     *
     * @return X
     */
    public double getX() {
        return X;
    }

    /**
     * Getter y-posisjon til spillobjektet
     *
     * @return Y
     */
    public double getY() {
        return Y;
    }

    /**
     * Setter bredden til spillobjektet
     *
     * @param w
     */
    public void setW(double w) {
        this.W = w;
    }

    /**
     * Getter bredden til spillobjektet
     *
     * @return W
     */
    public double getW() {
        return W;
    }

    /**
     * Setter høyden til spillobjektet
     *
     * @param h
     */
    public void setH(double h) {
        this.H = h;
    }

    /**
     * Getter høyden til spillobjektet
     *
     * @return W
     */
    public double getH() {
        return H;
    }

    /**
     * Setter boolean for om spillobjektet finnes eller ikke.
     *
     * @param exists
     */
    public void setExist(boolean exists) {
        this.exists = exists;
    }

    /**
     * Getter boolean for om spillobjektet finnes eller ikke.
     *
     * @return exists
     */
    public boolean getExist() {
        return exists;
    }

    /**
     * Metode for å rendere spillobjektet i GraphicsContext, gitt at det finnes.
     * drawImage tar image, positionX, positionY samt tar bredde w og høyde h som parametere
     *
     * @param gc
     */
    public void render(GraphicsContext gc) {

        if (getExist()) {

            gc.drawImage(image, X, Y, W, H);
        }

    }

    /**
     * Metode som beveger spillobjektet i forskjellige retninger basert på en double som gir
     * vinklen (i radianer) objektet skal bevege seg i.
     *
     * @param angle
     */
    public void moveAngled(double angle) {
        X += DX * Math.cos(angle);
        Y += DY * Math.sin(angle);
    }

    /**
     * Metode som lager en grense rundt spillobjektet i form av en Rectangle2D baser på X- og Y-posisjonen og bredde og høyde.
     *
     */
    public Rectangle2D boundary() {
        return new Rectangle2D(X, Y, W, H);
    }

    /**
     * Metode som returnerer true hvis det er en kollisjon mellom to spillobjekter
     *
     */
    public boolean collide(GameObject s) {
        return s.boundary().intersects(this.boundary());
    }
}

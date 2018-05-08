package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

/**
 * Dette er superclass for spillobjekter skal arve fra. Dette inkluderer Apen, Zookeepers, power-ups osv.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class GameObject {
    protected Image image;
    private double Y;
    private double X;
    private double W;
    private double H;
    private boolean exists = true;

    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter
     * posisjonen til objektet.
     *
     * @param x
     * @param y
     */
    public GameObject(double x, double y) {

    }

    /**
     * Setter image.
     *
     * @param i
     */
    public void setImage(Image i) {
        this.image = i;
    }

    /**
     * Setter x-posisjonen til avataren
     *
     * @param x
     */
    public void setX(double x) {
        X = x;
    }

    /**
     * Setter y-posisjon til avataren
     *
     * @param y
     */
    public void setY(double y) {
        Y = y;
    }

    /**
     * Getter x-posisjonen til avataren
     *
     * @return positionX
     */
    public double getX() {
        return X;
    }

    /**
     * Getter y-posisjon til avataren
     *
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

    public void kill() {
        this.exists = false;

    }

    public boolean exists() {
        return exists;
    }

    /**
     * Metode for å rendere avataren med image, positionX, positionY samt tar bredde w og høyde h som parametere
     *
     * @param gc
     */
    public void render(GraphicsContext gc) {
        if (exists()) {
            gc.drawImage(image, X, Y, W, H);
        }
    }

    public Rectangle2D objektGrense() {
        return new Rectangle2D(X, Y, W, H);
    }

    public boolean kollisjon(GameObject s) {
        return s.objektGrense().intersects(this.objektGrense());
    }

}

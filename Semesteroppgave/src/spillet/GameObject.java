package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

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
    private double DX = 10;
    private double DY = 10;
    private double z = 3 / 2;
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

    public void moveAngled(double angle) {
        X += DX * Math.cos(angle);
        Y += DY * Math.sin(angle);
    }

    public Rectangle2D boundary() {
        return new Rectangle2D(X, Y, W, H);
    }

    public boolean collide(GameObject s) {
        return s.boundary().intersects(this.boundary());
    }

    public void move(ArrayList<String> input, GameSession gs, ArrayList<String> collision) {

        if (input.contains("UP") && !input.contains("LEFT") && !input.contains("RIGHT") && !collision.contains("CollisionTop")) {

            moveAngled((Math.PI) * 3 / 2);

        }

        if (input.contains("DOWN") && !input.contains("LEFT") && !input.contains("RIGHT") && !collision.contains("CollisionBottom")) {

            moveAngled(Math.PI / 2);
        }
        if (input.contains("LEFT") && !input.contains("UP") && !input.contains("DOWN") && !collision.contains("CollisionLeft")) {

            moveAngled(Math.PI);

        }
        if (input.contains("RIGHT") && !input.contains("UP") && !input.contains("DOWN") && !collision.contains("CollisionRight")) {

            moveAngled(0);
        }

        if (input.contains("UP") && input.contains("RIGHT") && !collision.contains("CollisionRight") && !collision.contains("CollisionTop")) {

            moveAngled(Math.PI * 7 / 4);

        }

        if (input.contains("DOWN") && input.contains("RIGHT") && !collision.contains("CollisionRight") && !collision.contains("CollisionBottom")) {

            moveAngled(Math.PI / 4);

        }

        if (input.contains("DOWN") && input.contains("LEFT") && !collision.contains("CollisionLeft") && !collision.contains("CollisionBottom")) {

            moveAngled(Math.PI * 3 / 4);
        }

        if (input.contains("UP") && input.contains("LEFT") && !collision.contains("CollisionLeft") && !collision.contains("CollisionTop")) {

            moveAngled(Math.PI * 5 / 4);
        }

        if (input.contains("ESCAPE")) {
            gs.pause();
        }

    }

}

package spillet;

import javafx.scene.image.Image;

/**
 * Dette er klassen som generer fiender.
 *
 */
public class Enemy extends GameObject {

    private double enemyWidth = 35;
    private double enemyHeight = 50;
    private double dx, dy, xMax, yMax, xMin, yMin;


    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter
     * posisjonen til objektet.
     *
     * @param x x-posisjon
     * @param y y-posisjon
     * @param dx bevegelse i x
     * @param dy bevegelse i y
     * @param xMax endepunktet til patruljen i x
     * @param yMax endepunktet til patruljen i y
     */
    public Enemy(double x, double y, double dx, double dy, double xMax, double yMax) {
        super(x, y);
        image = new Image("/IMG/zookeeper.png");
        setImage(image);
        setX(x);
        setY(y);
        setH(enemyHeight);
        setW(enemyWidth);
        this.dx = dx;
        this.dy = dy;
        this.xMax = xMax;
        this.yMax = yMax;
        this.xMin = x;
        this.yMin = y;
    }

    /**
     * Metode som beveger fiende, og "bouncer" mellom to x og y verdier som blir oppgitt i GameSession
     */
    public void bounce() {
        if (getX() > xMax || getX() < xMin) {
            dx = dx * -1;
        }
        if (getY() > yMax || getY() < yMin) {
            dy = dy * -1;
        }
        setX(getX() + dx);
        setY(getY() + dy);
    }
}

package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.*;

/**
 * Dette er class for avataren til spilleren.
 *
 */

public class Monkey extends GameObject {

    private double playerWidth = 40;
    private double playerHeight = 40;
    private Image monkeyDown = new Image("IMG/monkeyDown.png");
    private Image monkeyDownLeft = new Image("IMG/monkeyDownLeft.png");
    private Image monkeyDownRight = new Image("IMG/monkeyDownRight.png");
    private Image monkeyLeft = new Image("IMG/monkeyLeft.png");
    private Image monkeyRight = new Image("IMG/monkeyRight.png");
    private Image monkeyUp = new Image("IMG/monkeyUp.png");
    private Image monkeyUpLeft = new Image("IMG/monkeyUpLeft.png");
    private Image monkeyUpRight = new Image("IMG/monkeyUpRight.png");

    /**
     * Constructor for Monkey, denne overrider constructor til spillobjekt.
     *
     * @param x x-posisjon
     * @param y y-posisjon
     */
    public Monkey(double x, double y) {
        super(x, y);
    //    String s = Monkey.class.getClassLoader().getResource("package1/resources/repository/SSL-Key/cert.jks");
    //    System.out.println(inputStream);
        Image bilde = new Image(Monkey.class.getClassLoader().getResource("IMG/monkeyDown.png").toString());

        setImage(bilde);
        setX(x);
        setY(y);
        setH(playerHeight);
        setW(playerWidth);
    }

    /**
     * Returnerer en boks med grensen til left
     * @return Rectangle2D
     */
    public Rectangle2D boundaryLeft() {
        return new Rectangle2D(getX(), getY() + 10, 5, getH() - 20);
    }

    /**
     * Returnerer en boks med grensen til right
     * @return Rectangle2D
     */
    public Rectangle2D boundaryRight() {
        return new Rectangle2D(getX() + getW() - 5, getY() + 10, 5, getH() - 20);
    }

    /**
     * Returnerer en boks med grensen ovenfra
     * @return Rectangle2D
     */
    public Rectangle2D boundaryTop() {
        return new Rectangle2D(getX() + 10, getY(), getW() - 20, 5);
    }

    /**
     * Returnerer en boks med grensen nedenfra
     * @return Rectangle2D
     */
    public Rectangle2D boundaryBottom() {
        return new Rectangle2D(getX() + 10, getY() + getH() - 5, getW() - 20, 5);
    }

    /**
     * Tar inn et gameobject som parameter og returnerer true hvis det detekteres en kollisjon til left.
     * @param s objekt
     * @return Boolean
     */
    public boolean collisionLeft(GameObject s) {
        return s.boundary().intersects(this.boundaryLeft());
    }

    /**
     * Tar inn et gameobject som parameter og returnerer true hvis det detekteres en kollisjon til right.
     * @param s objekt
     * @return Boolean
     */
    public boolean collisionRight(GameObject s) {
        return s.boundary().intersects(this.boundaryRight());
    }

    /**
     * Tar inn et gameobject som parameter og returnerer true hvis det detekteres en kollisjon ovenfra.
     * @param s objekt
     * @return Boolean
     */
    public boolean collisionTop(GameObject s) {
        return s.boundary().intersects(this.boundaryTop());
    }

    /**
     * Tar inn et gameobject som parameter og returnerer true hvis det detekteres en kollisjon nedenfra.
     * @param s objekt
     * @return Boolean
     */
    public boolean collisionBottom(GameObject s) {
        return s.boundary().intersects(this.boundaryBottom());
    }


    /**
     *
     * Dette er en metode som beveger spilleren fra string-ord som kommer inn.
     * Den brukes i launcherklassen for som oppdatere posisjonen til spilleren basert fra tastetrykk med piltastene og kollison
     * i ulike retninger.
     * @param input stringliste med keyinput
     * @param gs gamesession
     * @param collision stringliste med kollisjonstatus
     */
    public void move(ArrayList<String> input, GameSession gs, ArrayList<String> collision) {

        // Move Up
        if (input.contains("UP") && !input.contains("LEFT") && !input.contains("RIGHT")) {
            setImage(monkeyUp);

            if (!collision.contains("CollisionTop")) {
                moveAngled((Math.PI) * 3 / 2);
            }
        }

        // Move Down
        if (input.contains("DOWN") && !input.contains("LEFT") && !input.contains("RIGHT")) {
            setImage(monkeyDown);

            if (!collision.contains("CollisionBottom")) {
                moveAngled(Math.PI / 2);

            }
        }

        // Move Left
        if (input.contains("LEFT") && !input.contains("UP") && !input.contains("DOWN")) {
            setImage(monkeyLeft);

            if (!collision.contains("CollisionLeft")) {
                moveAngled(Math.PI);
            }
        }

        // Move Right
        if (input.contains("RIGHT") && !input.contains("UP") && !input.contains("DOWN")) {
            setImage(monkeyRight);

            if (!collision.contains("CollisionRight")) {
                moveAngled(0);
            }
        }

        // Move Up-Right
        if (input.contains("UP") && input.contains("RIGHT")) {
            setImage(monkeyUpRight);

            if (!collision.contains("CollisionRight") && !collision.contains("CollisionTop")) {
                moveAngled(Math.PI * 7 / 4);
            } else if (!collision.contains("CollisionTop")) {
                moveAngled((Math.PI) * 3 / 2);
            } else if (!collision.contains("CollisionRight")) {
                moveAngled(0);
            }
        }

        // Move Down-Right
        if (input.contains("DOWN") && input.contains("RIGHT")) {
            setImage(monkeyDownRight);

            if (!collision.contains("CollisionRight") && !collision.contains("CollisionBottom")) {
                moveAngled(Math.PI / 4);
            } else if (!collision.contains("CollisionBottom")) {
                moveAngled(Math.PI / 2);
            } else if (!collision.contains("CollisionRight")) {
                moveAngled(0);
            }
        }

        // Move Down-Left
        if (input.contains("DOWN") && input.contains("LEFT")) {
            setImage(monkeyDownLeft);

            if (!collision.contains("CollisionLeft") && !collision.contains("CollisionBottom")) {
                moveAngled(Math.PI * 3 / 4);
            } else if (!collision.contains("CollisionBottom")) {
                moveAngled(Math.PI / 2);
            } else if (!collision.contains("CollisionLeft")) {
                moveAngled(Math.PI);
            }
        }

        // Move Up-left
        if (input.contains("UP") && input.contains("LEFT")) {
            setImage(monkeyUpLeft);

            if (!collision.contains("CollisionLeft") && !collision.contains("CollisionTop")) {
                moveAngled(Math.PI * 5 / 4);
            } else if (!collision.contains("CollisionTop")) {
                moveAngled((Math.PI) * 3 / 2);
            } else if (!collision.contains("CollisionLeft")) {
                moveAngled(Math.PI);
            }
        }

        // Menu
        if (input.contains("ESCAPE")) {
            gs.pause();
        }
    }
}










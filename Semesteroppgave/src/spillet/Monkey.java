package spillet;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.*;

/**
 * Dette er class for avataren til spilleren.
 *
 * @Gaute, @Eirik og @Bjørnar
 */

public class Monkey extends GameObject {

    private double playerWidth = 40;
    private double playerHeight = 40;
    private Image monkeyDown = new Image(Monkey.class.getResource("/IMG/monkeyDown.png").toString());
    private Image monkeyDownLeft = new Image(Monkey.class.getResource("/IMG/monkeyDownLeft.png").toString());
    private Image monkeyDownRight = new Image(Monkey.class.getResource("/IMG/monkeyDownRight.png").toString());
    private Image monkeyLeft = new Image(Monkey.class.getResource("/IMG/monkeyLeft.png").toString());
    private Image monkeyRight = new Image(Monkey.class.getResource("/IMG/monkeyRight.png").toString());
    private Image monkeyUp = new Image(Monkey.class.getResource("/IMG/monkeyUp.png").toString());
    private Image monkeyUpLeft = new Image(Monkey.class.getResource("/IMG/monkeyUpLeft.png").toString());
    private Image monkeyUpRight = new Image(Monkey.class.getResource("/IMG/monkeyUpRight.png").toString());

    /**
     * Constructor for Monkey, denne overrider konstruktøren til spillobjekt.
     *
     * @param x
     * @param y
     */
    public Monkey(double x, double y) {
        super(x, y);
        Image bilde = new Image("IMG/monkeydown.png");

        setImage(bilde);
        setX(x);
        setY(y);
        setH(playerHeight);
        setW(playerWidth);
    }

    public Rectangle2D boundaryLeft() {
        return new Rectangle2D(getX(), getY() + 10, 5, getH() - 20);
    }

    public Rectangle2D boundaryRight() {
        return new Rectangle2D(getX() + getW() - 5, getY() + 10, 5, getH() - 20);
    }

    public Rectangle2D boundaryTop() {
        return new Rectangle2D(getX() + 10, getY(), getW() - 20, 5);
    }

    public Rectangle2D boundaryBottom() {
        return new Rectangle2D(getX() + 10, getY() + getH() - 5, getW() - 20, 5);
    }

    public boolean collisionLeft(GameObject s) {
        return s.boundary().intersects(this.boundaryLeft());
    }

    public boolean collisionRight(GameObject s) {
        return s.boundary().intersects(this.boundaryRight());
    }

    public boolean collisionTop(GameObject s) {
        return s.boundary().intersects(this.boundaryTop());
    }

    public boolean collisionBottom(GameObject s) {
        return s.boundary().intersects(this.boundaryBottom());
    }

    /**
     * Dette er en metode for å bevege spilleren basert på string-nøkkelord som kommer inn.
     * Den brukes i launcherklassen for å oppdatere posisjonen til spilleren basert på tastetrykk med piltastene
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
                System.out.println(Monkey.class.getResource("/IMG/monkeyDown.png").toString());
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










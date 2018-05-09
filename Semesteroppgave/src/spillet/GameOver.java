package spillet;

import javafx.scene.image.Image;

public class GameOver extends GameObject {
    /**
     * Dette er classconstructor som tar inn pathen til bildet som skal animeres samt setter
     * posisjonen til objektet.
     *
     * @param x
     * @param y
     */

    private double WIDTH =650;
    private double HEIGHT = 650;

    public GameOver(double x, double y) {
        super(x, y);
        image = new Image("/IMG/gameover.png");
        setImage(image);
        setX(x);
        setY(y);
        setH(HEIGHT);
        setW(WIDTH);
    }




}

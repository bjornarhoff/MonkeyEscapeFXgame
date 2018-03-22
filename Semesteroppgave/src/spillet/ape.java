package spillet;

import javafx.scene.canvas.GraphicsContext;

public class ape extends Avatar {

    private double positionX;
    private double positionY;

    public ape () {
        positionX = 0;
        positionY = 0;
    }

    @Override
    public void render(GraphicsContext gc, double w, double h)
    {
        gc.drawImage(getImage(), getPositionX(), getPositionY(), w, h);
    }
}

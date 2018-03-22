package spillet;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public class Avatar {
    private Image image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;

    public Avatar()
    {
        positionX = 0;
        positionY = 0;
    }

    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPositionX(double x)
    {
        positionX = x;
    }

    public void setPositionY(double y)
    {
        positionY = y;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public Image getImage() {
        return image;
    }

    public void render(GraphicsContext gc, double w, double h)
    {
        gc.drawImage(image, positionX, positionY, w, h);
    }


}

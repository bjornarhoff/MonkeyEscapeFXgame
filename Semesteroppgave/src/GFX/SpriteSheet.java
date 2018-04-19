package GFX;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class SpriteSheet {

    private BufferedImage spriteSheet;



    public SpriteSheet (BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }



    public BufferedImage cut(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x,y,width,height);
    }
}

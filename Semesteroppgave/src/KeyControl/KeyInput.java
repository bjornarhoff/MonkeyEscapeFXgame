package KeyControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {


    private boolean [] key;
    public boolean up,down,right,left;



    public KeyInput (){
        key = new boolean[256];
    }

    public void update () {
        down = key[KeyEvent.VK_DOWN];
        up = key[KeyEvent.VK_UP];
        right = key [KeyEvent.VK_RIGHT];
        left = key [KeyEvent.VK_LEFT];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }
}

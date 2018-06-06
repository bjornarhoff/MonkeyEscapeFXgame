package spillet;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public final class Input {

    private static ArrayList<String> input = new ArrayList<>();

    public Input() {
    }
     /**
     * Metode som tar key-input fra brukeren. Legger den til i arraylist og fjerner den
     * @param scene scenen
     */
    public static void Input(Scene scene) {
        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent e) {
                        String keyCode = e.getCode().toString();

                        if (!input.contains(keyCode)) {
                            input.add(keyCode);
                        }
                    }
                }
        );

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent e) {
                        String keyCode = e.getCode().toString();

                        input.remove(keyCode);
                    }
                }
        );
    }

    public static ArrayList<String> getInput() {
        return input;
    }
}

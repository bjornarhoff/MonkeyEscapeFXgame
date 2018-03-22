package Display;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private JFrame frame;
    private Canvas canvas;

    private int width, height;
    private String title;


    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay(); // Metode-kall for å ikke vise hva som er i konstruktøren
    }


    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Får programmet til å avslutte, ikke bare vinduet
        frame.setResizable(false); // Vindu kan justeres
        frame.setLocationRelativeTo(null); // Plasserer vindu i midten av skjermen
        frame.setVisible(true); // Gjør vindu synlig. default = usynlig

        // Bruker canvas til å tegne "figurer". Definerer størrelse på canvas = størrelse på frame
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false); // Gir fokuset til selve applikasjonen, og ikke til canvas

        frame.add(canvas);
        frame.pack(); // Gjør canvas litt mindre slik at hele bildet er synlig i frame
    }

        // Get-metode for å få tak i canvas (private)
    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame () {
        return frame;
    }

}

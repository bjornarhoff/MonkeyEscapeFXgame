import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class firstTryFrame {

    public static void main(String[] args) {
        // Definerer vindu som er synlig for brukeren, kan avsluttes
        JFrame tryFrame = new JFrame("MonkeyEscape");
        tryFrame.setSize(500,500);
        tryFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tryFrame.setVisible(true);
    }
}

package spillet;

import Highscore.ScoreManager;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;


import javafx.stage.*;



/**
 * Launcherklasse som inneholder main-metoden og start-metoden for å danne scenen, samt animere innholdet.
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class main extends Application {
    
    private Scene scene;
    private Parent parent;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metoden overrider start-metoden i Application og starter vinduet og legger til innholdet.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Monkey Escape");
        primaryStage.setResizable(false);

        // Laster FXML fil
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Controller/Menu.fxml"));
        parent = loader.load();
        scene = new Scene(parent);

        // Laster CSS fil
        String css = getClass().getClassLoader().getResource("CSS/fxmlStyle.css").toString();
        parent.getStylesheets().add(css);

        // Avslutter programmet
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });

        // Setter posisjonen til vindu i senter, og fokuserer.
        primaryStage.centerOnScreen();
        primaryStage.requestFocus();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Denne metoden danner layoyt-pane som man legger canvas og dermed animasjonene på.
     * @return root
     */


    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */


    /**
     * Metode som oppdaterer posisjonen til spilleren i x- og y-retning basert på tastetrykk med piltastene.
     */


}
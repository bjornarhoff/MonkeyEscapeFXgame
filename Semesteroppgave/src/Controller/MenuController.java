package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import spillet.GameSession;


public class MenuController {



    @FXML
    private AnchorPane rootPane;
    private GameSession gs;

    @FXML
    public void newGame() {

        gs = new GameSession(rootPane);
        rootPane.getChildren().add(gs.getCanvas());

    }

    @FXML
    public void loadGame() {

        System.out.println("Load game");
    }

    @FXML
    public void exitGame() {
        System.exit(0);
    }

    @FXML
    public void saveGame() {

    }


}


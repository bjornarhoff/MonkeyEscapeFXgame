package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import spillet.GameSession;

public class MenuController {

    private GameSession gs;
    private Button NewGame;

    @FXML
    private AnchorPane rootPane;

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
    public void resumeGame() {

    }

    



}


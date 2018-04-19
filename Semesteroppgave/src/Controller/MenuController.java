package Controller;

import filbehandling.ResManager;
import filbehandling.SaveData;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import spillet.GameSession;

import static filbehandling.ResManager.*;

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


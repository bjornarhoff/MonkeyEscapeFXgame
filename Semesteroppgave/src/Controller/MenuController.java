package Controller;

import filbehandling.Filbehandling;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import spillet.GameSession;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable{

    @FXML
    private AnchorPane rootPane;

    private static GameSession gs;



    /**
     * Start menu
     */
    @FXML
    public void newGame() {
        gs = new GameSession(rootPane, this);
        //rootPane.getChildren().add(gs.getCanvas());
    }

    @FXML
    public void loadGame() {
        System.out.println("Load game");


    }

    @FXML
    public void exitGame() {
        System.out.println("Spillet er avsluttet");
        System.exit(0);
    }

    @FXML
    public void gameOver() {
        
    }

    /**
     * Pause menu
     */
    @FXML
    public void resumeGame() {
        //gs.getCanvas().setVisible(true);
        setMenuPage("gameCanvas");
        gs.pause();
    }

    @FXML
    public void saveGame() {
        System.out.println("Game saved");
        gs.loadGame();

    }



    /**
     * Pause menu
     */
    public void setMenuPage(String nodeID) {
        ObservableList<Node> list = rootPane.getChildren();

        for (Node node : list) {
            if (nodeID.equals(node.getId())) {
                node.setVisible(true);
            } else {
                node.setVisible(false);
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMenuPage("startMenuButtons");
    }
}


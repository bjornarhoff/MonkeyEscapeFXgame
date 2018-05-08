package Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import spillet.GameSession;
import spillet.Input;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController {


    @FXML
    private AnchorPane rootPane;
    @FXML
    private StackPane buttonPane;

    private static GameSession gs;


    /** Start menu */
    @FXML
    public void newGame() {
        gs = new GameSession(rootPane, this);
        rootPane.getChildren().add(gs.getCanvas());
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


    /** Pause menu */
    @FXML
    public  void resumeGame() {
        gs.getCanvas().setVisible(true);
        gs.pause();
    }

    @FXML
    public void saveGame() {
        System.out.println("Game saved");
    }



    /** Pause menu */
    public void setMenuPage(String nodeID) {
        ObservableList<Node> list = buttonPane.getChildren();

        for (Node node:list) {
            if (nodeID.equals(node.getId())) {
                node.setVisible(true);
            } else {
                node.setVisible(false);
            }
        }
    }


}


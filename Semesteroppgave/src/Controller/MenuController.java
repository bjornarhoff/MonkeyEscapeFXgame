package Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
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
    }

    public void exitGame() {
        System.out.println("Spillet er avsluttet");
        System.exit(0);
    }

    // Load game menu
    @FXML
    public void loadGame() {
        setMenuPage("loadSlot");
        System.out.println("Load game");


    }

    @FXML
    public void loadSlot1 () {
        System.out.println("slot 1 loaded");
    }
    @FXML
    public void loadSlot2 () {
        System.out.println("slot 2 loaded");
    }

    @FXML
    public void loadSlot3 () {
        System.out.println("slot 3 loaded");
    }


    @FXML
    public void gameOver() {
        
    }

    /**
     * Pause menu
     */
    @FXML
    public void resumeGame() {
        setMenuPage("gameCanvas");
        gs.pause();
    }


    // Save game menu
    @FXML
    public void saveGame() {
        setMenuPage("saveSlot");
        
    }

    @FXML
    public void saveSlot1 () {
        System.out.println("slot 1 saved");
    }

    @FXML
    public void saveSlot2 () {
        System.out.println("slot 2 saved");
    }

    @FXML
    public void saveSlot3 () {
        System.out.println("slot 3 saved");
    }



    // Back to menu buttons
    @FXML
    public void backToMenu () {
        setMenuPage("startMenuButtons");
    }

    @FXML
    public void backToPauseMenu () {
        setMenuPage("ingameMenuButtons");
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


package spillet;

import com.apple.laf.AquaButtonBorder;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;


/**
 * Launcherklasse som inneholder main-metoden og start-metoden for å danne scenen, samt animere innholdet.
 *
 * @Gaute, @Eirik og @Bjørnar
 */
public class main extends Application {

    private GraphicsContext gc;
    private Scene scene;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Ape player;
    private Frukt eple1, eple2, eple3;
    private Image bakgrunn;
    private Image tre1, tre2, tre3, tre4, tre5, tre6, tre7,tre8,tre9,tre10,tre11,tre12,tre13,tre14,tre15;
    private double apebredde = 100;
    private double apehøyde = 100;

    public static void main(String[] args) {

        Application.launch(args);

    }

    /**
     * Metoden overrider start-metoden i Application og starter vinduet og legger til innholdet.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        scene = new Scene(setScene(),WIDTH,HEIGHT, Color.BLACK);
        primaryStage.setTitle("MonkeyEscape");
        primaryStage.setResizable(false);


        Group root = new Group();
        // Close Operation
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
            }
        });



        // Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());


        Menu menu = new Menu("File");
        menu.getItems().add(new MenuItem("New Game"));
        menu.getItems().add(new MenuItem("Pause"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Save Game"));
        menu.getItems().add(new MenuItem("Exit Game"));


        // Action Handler MENU
        MenuItem newItem = new MenuItem("New Game", null);
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Action");
            }
        });

        menu.getItems().add(newItem);
        menu.getItems().add(new SeparatorMenuItem());

        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);

        primaryStage.setScene(scene);
        primaryStage.show();
    }




    /**
     * Denne metoden danner layoyt-pane som man legger canvas og dermed animasjonene på.
     * @return root
     */
    private Parent setScene() {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH,HEIGHT);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);




        /** Tegner */
        gc = canvas.getGraphicsContext2D();

        player = new Ape("spillet/ape.png", 150, 150);

        eple1 = new Frukt("spillet/eple.png", 356, HEIGHT-50);
        eple2 = new Frukt("spillet/eple.png", WIDTH-50, 70);
        eple3 = new Frukt("spillet/eple.png", 50, 35);

        tre1 = new Image("spillet/tre.png");
        tre2 = new Image("spillet/tre.png");
        tre3 = new Image("spillet/tre.png");
        tre4 = new Image("spillet/tre.png");
        tre5 = new Image("spillet/tre.png");
        tre6 = new Image("spillet/tre.png");
        tre7 = new Image("spillet/tre.png");
        tre8 = new Image("spillet/tre.png");
        tre9 = new Image("spillet/tre.png");
        tre10 = new Image("spillet/tre.png");
        tre11 = new Image("spillet/tre.png");
        tre12 = new Image("spillet/tre.png");
        tre13 = new Image("spillet/tre.png");
        tre14 = new Image("spillet/tre.png");
        tre15 = new Image("spillet/tre.png");

        renderVerden();

        pane.getChildren().add(canvas);

        // AnimationTimer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long nanoTime) {

                renderVerden();
                moveApe();
            }
        };
        timer.start();

        return pane;
    }

    /**
     * Metode som fjerner og reanimerer innholdet i scenen.
     */
    public void renderVerden() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        // Ramme
        gc.fillRect(0, 0,WIDTH,HEIGHT);
        gc.drawImage(tre3, 0, 0, 10,HEIGHT);
        gc.drawImage(tre5, 0, 0, WIDTH, 10);
        gc.drawImage(tre6, WIDTH-10, 0, 10,HEIGHT);
        gc.drawImage(tre7, 0, HEIGHT-10, 575,10);
        // Brett
        gc.drawImage(tre1, 111, 500, 10, 150);
        gc.drawImage(tre2, 0, 396, 290,10);
        gc.drawImage(tre4, 210, 550, 110, 10);
        gc.drawImage(tre8, 200, 190, 10,70);
        gc.drawImage(tre9, 103, 85, 10,100);
        gc.drawImage(tre10, 280, 145, 220,10);
        gc.drawImage(tre11, 570, 75, 10,100);
        gc.drawImage(tre12, 510, 420, 50,10);
        gc.drawImage(tre13, 550, 520, 100,10);
        gc.drawImage(tre14, 400, 270, 10,400);
        gc.drawImage(tre15, 575, 610, 10, 40);


        eple1.render(gc, 50, 50);
        eple2.render(gc, 50, 50);
        eple3.render(gc, 50, 50);
        player.render(gc, apebredde, apehøyde);
    }

    /**
     * Metode som oppdaterer posisjonen til spilleren i x- og y-retning basert på tastetrykk med piltastene.
     */
    public void moveApe() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    player.beveg("Opp");
                } else if (e.getCode() == KeyCode.DOWN) {
                    player.beveg("Ned");
                } else if (e.getCode() == KeyCode.LEFT) {
                    player.beveg("Venstre");
                } else if (e.getCode() == KeyCode.RIGHT) {
                    player.beveg("Høyre");
                }
            }
        });
/*
        vinduInnhold.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.DOWN) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.LEFT) {
                    player.setDeltaXY(0,0);
                } else if (e.getCode() == KeyCode.RIGHT) {
                    player.setDeltaXY(0,0);
                }
            }
        }); */


    }



}
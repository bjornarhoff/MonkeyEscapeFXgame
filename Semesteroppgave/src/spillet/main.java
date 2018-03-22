import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;


public class main extends Application {

    private GraphicsContext grafikk;
    private avatar sirkel;
    private Canvas lerret;
    private Pane root;
    private Rectangle rektangel;
    private Scene vinduInnhold;
    private double centerX, centerY;
    private Image alien;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage vindu) throws Exception {
        vindu.setTitle("Prøvespill");
        vinduInnhold = new Scene(lagVerden());

        vindu.setScene(vinduInnhold);
        vindu.show();

        vinduInnhold.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    sirkel.setCenterY(sirkel.getCenterY() - 10);
                } else if (e.getCode() == KeyCode.DOWN) {
                    sirkel.setCenterY(sirkel.getCenterY() + 10);
                } else if (e.getCode() == KeyCode.LEFT) {
                    sirkel.setCenterX(sirkel.getCenterX() - 10);
                } else if (e.getCode() == KeyCode.RIGHT) {
                    sirkel.setCenterX(sirkel.getCenterX() + 10);
                }
            }
        });

    }

    private Parent lagVerden() {
        root = new Pane();
        lerret = new Canvas(600, 600);
        grafikk = lerret.getGraphicsContext2D();
        alien = new Image("/alien.png");

        sirkel = new avatar();
        rektangel = new Rectangle(400, 50, 15, 400);
        rektangel.setFill(Color.ORANGE);

        sirkel.setCenterY(centerY);
        sirkel.setCenterX(centerX);
        sirkel.setRadius(10);
        sirkel.setFill(Color.RED);

        grafikk.drawImage(alien, 150, 150);



        root.getChildren().add(sirkel);
        root.getChildren().add(rektangel);
        root.getChildren().add(lerret);


        return root;
    }

    private void tegnFirkant(GraphicsContext gc) {
        gc.setFill(Color.BLUE);

    }
}
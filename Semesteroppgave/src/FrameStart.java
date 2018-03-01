import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class FrameStart extends Application implements EventHandler<KeyEvent> {

    final int WIDTH = 800;
    final int HEIGHT = 500;

    double circleRadius = 20;
    double circleY = 120;
    double circleX = 200;
    double xSpeed = 5;


    // Main metode
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeyEscape");

        // Lager scenen
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

        // Lager sirkel
        Circle circle = new Circle();

        // Setter posisjon på sirkel
        circle.setCenterX(circleX);
        circle.setCenterY(circleY);

        // Definerer radius på sirkel
        circle.setRadius(circleRadius);

        // Definerer farge på sirkel
        circle.setFill(Color.RED);


        // Legger sirkelen til i scenen
        root.getChildren().add(circle);


        // Viser scenen til brukeren
        primaryStage.show();
        primaryStage.setScene(scene);


        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long arg0) {


                circleX += xSpeed;

                if (circleX + circleRadius >= WIDTH) {
                    circleX = WIDTH - circleRadius;
                    xSpeed *= -1;
                } else if (circleX - circleRadius < 0) {
                    circleX = 0 + circleRadius;
                    xSpeed *= -1;
                }

                // RENDER
                circle.setCenterX(circleX);
            }
        };

        gameLoop.start();

    }

       @Override
        public void handle (KeyEvent arg0){

            if (arg0.getCode() == KeyCode.SPACE) {
                xSpeed *= -1;
            }
        }
    }



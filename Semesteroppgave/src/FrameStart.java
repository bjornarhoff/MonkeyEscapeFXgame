import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class FrameStart extends Application implements EventHandler<KeyEvent> {

    final int WIDTH = 800;
    final int HEIGHT = 500;

    double circleRadius = 20;
    double circleY = 120;
    double circleX = 200;
    double xSpeed = 5;


    // Main
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MonkeyEscape");

        // Scene
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

        // Draw
        Circle circle = new Circle();
        circle.setCenterX(circleX);
        circle.setCenterY(circleY);
        circle.setRadius(circleRadius);
        circle.setFill(Color.RED);


        // Legger sirkelen til i scenen
        root.getChildren().add(circle);


        // KeyEvent våkner
        final StackPane keyboardNode = new StackPane();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();
        keyboardNode.setOnKeyPressed(this);


        root.getChildren().add(keyboardNode);


        // Viser scenen til brukeren
        primaryStage.setScene(scene);
        primaryStage.show();




        // AnimationTimer (gameloop)
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


                circle.setCenterX(circleX);
            }
        };

        gameLoop.start();

    }
        // Metoden som gjør at figuren skifter retning
       @Override
        public void handle (KeyEvent arg0){

            if (arg0.getCode()==KeyCode.SPACE) {
                xSpeed*= -1;
            }
        }
    }



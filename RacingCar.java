import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacingCar extends Application {

    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 300;
    private double speed = 5.0;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        double x = 0;
        double y = WINDOW_HEIGHT / 2;

        Rectangle body = new Rectangle(x, y - 20, 40, 10);
        body.setFill(Color.SILVER);

        Polygon roof = new Polygon();
        roof.getPoints().addAll(new Double[]{
                x, y - 20,
                x + 10, y - 30,
                x + 30, y - 30,
                x + 40, y - 20
        });
        roof.setFill(Color.LIGHTBLUE);

        Circle leftWheel = new Circle(x + 10, y - 10, 5);
        Circle rightWheel = new Circle(x + 30, y - 10, 5);

        pane.getChildren().addAll(body, roof, leftWheel, rightWheel);

        Line path = new Line(0, WINDOW_HEIGHT / 2, WINDOW_WIDTH + 40, WINDOW_HEIGHT / 2);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(speed));
        pathTransition.setPath(path);
        pathTransition.setNode(pane);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);

        pathTransition.play();

        Scene scene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

        scene.setOnMousePressed(e -> pathTransition.pause());
        scene.setOnMouseReleased(e -> pathTransition.play());

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                speed -= 0.5;
                pathTransition.setDuration(Duration.seconds(speed));
            } else if (e.getCode() == KeyCode.DOWN) {
                speed += 0.5;
                pathTransition.setDuration(Duration.seconds(speed));
            }
        });

        primaryStage.setTitle("Racing Car Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

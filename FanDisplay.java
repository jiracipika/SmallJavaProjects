import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FanDisplay extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                double x = col * (WIDTH / 2);
                double y = row * (HEIGHT / 2);
                createFan(root, x, y);
            }
        }

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("X-Shaped Fans in Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createFan(Group root, double x, double y) {
        Group fanGroup = new Group();
        fanGroup.setLayoutX(x + WIDTH / 4);
        fanGroup.setLayoutY(y + HEIGHT / 4);

        Line line1 = new Line(-50, -50, 50, 50);
        Line line2 = new Line(-50, 50, 50, -50);
        line1.setStroke(Color.BLACK);
        line2.setStroke(Color.BLACK);

        Circle circle = new Circle(0, 0, 70);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        fanGroup.getChildren().addAll(circle, line1, line2);

        root.getChildren().add(fanGroup);
    }
}

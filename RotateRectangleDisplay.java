import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RotateRectangleDisplay extends Application {

    private double currentAngle = 0.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rectangle = new Rectangle(100, 50, 200, 100);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction(e -> {
            currentAngle += 15;
            rectangle.setRotate(currentAngle);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(rectangle, rotateButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotate Hollow Rectangle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

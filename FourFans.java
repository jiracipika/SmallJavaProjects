import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FourFans extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Add four fans to the grid pane
        gridPane.add(createFan(), 0, 0);
        gridPane.add(createFan(), 0, 1);
        gridPane.add(createFan(), 1, 0);
        gridPane.add(createFan(), 1, 1);

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Four Fans");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create a fan
    private GridPane createFan() {
        GridPane fanPane = new GridPane();

        Circle circle = new Circle(100, 100, 100);
        circle.setStrokeWidth(3);
        circle.setFill(null);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        fanPane.add(circle, 0, 0, 2, 2);

        Line line1 = new Line(100, 100, 100, 0);
        Line line2 = new Line(100, 100, 200, 100);
        Line line3 = new Line(100, 100, 100, 200);
        Line line4 = new Line(100, 100, 0, 100);

        fanPane.add(line1, 1, 0);
        fanPane.add(line2, 2, 1);
        fanPane.add(line3, 1, 2);
        fanPane.add(line4, 0, 1);

        return fanPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

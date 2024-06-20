import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CylinderDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        double centerX = 150;
        double centerY = 150;
        double radiusX = 50;
        double radiusY = 30;
        double height = 150;

        Ellipse topOval = new Ellipse(centerX, centerY - height / 2, radiusX, radiusY);
        topOval.setFill(Color.TRANSPARENT);
        topOval.setStroke(Color.BLACK);

        Ellipse bottomOval = new Ellipse(centerX, centerY + height / 2, radiusX, radiusY);
        bottomOval.setFill(Color.TRANSPARENT);
        bottomOval.setStroke(Color.BLACK);
        
        Double[] dashArray = {5.0, 5.0};
        bottomOval.getStrokeDashArray().addAll(dashArray);

        Line leftLine = new Line(centerX - radiusX, centerY - height / 2, centerX - radiusX, centerY + height / 2);
        Line rightLine = new Line(centerX + radiusX, centerY - height / 2, centerX + radiusX, centerY + height / 2);

        root.getChildren().addAll(topOval, bottomOval, leftLine, rightLine);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Cylinder Shape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

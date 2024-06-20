import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SmileyFace extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Face
        Circle face = new Circle(150, 150, 100);
        face.setStrokeWidth(2);
        face.setFill(null);
        face.setStroke(javafx.scene.paint.Color.BLACK);

        // Eyes
        Ellipse leftEye = new Ellipse(125, 130, 15, 15);
        Ellipse rightEye = new Ellipse(175, 130, 15, 15);

        // Mouth
        Arc mouth = new Arc(150, 180, 50, 25, 0, -180);
        mouth.setType(ArcType.OPEN);
        mouth.setStroke(javafx.scene.paint.Color.BLACK);
        mouth.setFill(null);

        pane.getChildren().addAll(face, leftEye, rightEye, mouth);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Smiley Face using JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

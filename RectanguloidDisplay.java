import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class RectanguloidDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Canvas
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Define cube coordinates
        double[] vertices = {
            100, 100, 100,  // Front top-left
            200, 100, 100,  // Front top-right
            200, 200, 100,  // Front bottom-right
            100, 200, 100,  // Front bottom-left
            100, 100, 200,  // Back top-left
            200, 100, 200,  // Back top-right
            200, 200, 200,  // Back bottom-right
            100, 200, 200   // Back bottom-left
        };

        // Define cube edges (connecting vertices)
        int[] edges = {
            0, 1, 1, 2, 2, 3, 3, 0,  // Front face
            4, 5, 5, 6, 6, 7, 7, 4,  // Back face
            0, 4, 1, 5, 2, 6, 3, 7   // Connecting lines
        };

        // Clear the canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Draw cube edges
        gc.setStroke(Color.BLACK);
        for (int i = 0; i < edges.length; i += 2) {
            double x1 = vertices[edges[i] * 3];
            double y1 = vertices[edges[i] * 3 + 1];
            double x2 = vertices[edges[i + 1] * 3];
            double y2 = vertices[edges[i + 1] * 3 + 1];
            gc.strokeLine(x1, y1, x2, y2);
        }

        // Create a scene and add the canvas to it
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("JavaFX Cube Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

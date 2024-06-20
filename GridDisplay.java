import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        int rows = 3;
        int columns = 3;
        double width = 400; // Adjust the width as needed
        double height = (width * 4) / 5; // 5:4 aspect ratio

        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(width, height);

        double cellWidth = width / columns;
        double cellHeight = height / rows;

        // Create and add rectangles to the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight);
                rectangle.setFill(Color.WHITE);
                gridPane.add(rectangle, col, row);
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("3x3 Grid (5:4 Aspect Ratio)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

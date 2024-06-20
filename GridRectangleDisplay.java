import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridRectangleDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        int rectSize = 50;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Rectangle rect = new Rectangle(rectSize, rectSize);
                rect.setStroke(Color.BLACK);  
                rect.setFill(Color.LIGHTGRAY); 
                grid.add(rect, col, row);
            }
        }

        Scene scene = new Scene(grid);
        primaryStage.setTitle("3x3 Grid of Rectangles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

import java.util.Random;

public class RandomBinaryDisplay extends Application {
    private static final int GRID_SIZE = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Random rand = new Random();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int num = rand.nextInt(2);
                
                Text text = new Text(Integer.toString(num));

                Rectangle rect = new Rectangle(30, 30);
                rect.setStroke(javafx.scene.paint.Color.BLACK);
                rect.setFill(javafx.scene.paint.Color.WHITE);

                StackPane cell = new StackPane();
                cell.getChildren().addAll(rect, text);
                
                grid.add(cell, i, j);
            }
        }

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Random Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

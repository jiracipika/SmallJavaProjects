import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TicTacToeDisplay extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe Display");

        
        GridPane grid = new GridPane();

        Image xImage = new Image("file:x.gif");
        Image oImage = new Image("file:o.gif");


        // Top row
        grid.add(new ImageView(oImage), 0, 0);  // Top left: O
        grid.add(new ImageView(xImage), 1, 0);  // Top middle: X
        grid.add(new ImageView(oImage), 2, 0);  // Top right: O

        // Middle row
        grid.add(new ImageView(xImage), 0, 1);  // Middle left: X
        grid.add(new ImageView(xImage), 2, 1);  // Middle right: X

        // Bottom row
        grid.add(new ImageView(xImage), 0, 2);  // Bottom left: X
    

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FlagsDisplay extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flags Display");

        GridPane grid = new GridPane();

        Image image1 = new Image("file:4.jpg");
        Image image2 = new Image("file:china.jpg");
        Image image3 = new Image("file:uk.jpg");
        Image image4 = new Image("file:us.jpg");

        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        grid.add(imageView1, 0, 0);
        grid.add(imageView2, 1, 0);
        grid.add(imageView3, 0, 1);
        grid.add(imageView4, 1, 1);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

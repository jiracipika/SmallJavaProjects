import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StopSignDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        Polygon octagon = createOctagon(150, 150, 100);
        octagon.setFill(Color.RED);

        // Rotate the octagon so that the flat side is on the bottom
        octagon.setRotate(22.5); // 45 degrees

        Text stopText = new Text("STOP");
        stopText.setFont(new Font(40));
        stopText.setFill(Color.WHITE);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(octagon, stopText);

        Scene scene = new Scene(stackPane, 300, 300);

        primaryStage.setTitle("STOP Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Polygon createOctagon(double centerX, double centerY, double size) {
        Polygon octagon = new Polygon();
        for (int i = 0; i < 8; i++) {
            double angle = 2.0 * Math.PI / 8 * i;
            double x = centerX + size * Math.cos(angle);
            double y = centerY + size * Math.sin(angle);
            octagon.getPoints().addAll(x, y);
        }
        return octagon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

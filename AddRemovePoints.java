import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AddRemovePoints extends Application {
    private static final double RADIUS = 5;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(event.getX(), event.getY(), RADIUS, Color.BLACK);
                circle.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.SECONDARY) {
                        pane.getChildren().remove(circle);
                    }
                });
                pane.getChildren().add(circle);
            }
        });

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Add and Remove Points");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

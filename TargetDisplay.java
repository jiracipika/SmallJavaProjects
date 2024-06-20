import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TargetDisplay extends Application {
    
    private double redCircleRadius = 100;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);
        
        Circle blueCircle = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, 50, Color.BLUE);
        Circle redCircle = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, redCircleRadius, Color.RED);

        pane.getChildren().addAll(redCircle, blueCircle);
        
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    redCircleRadius += 10;
                    break;
                case DOWN:
                    redCircleRadius -= 10;
                    break;
                default:
                    break;
            }
            redCircle.setRadius(redCircleRadius);
        });

        pane.widthProperty().addListener((obs, oldVal, newVal) -> {
            blueCircle.setCenterX(newVal.doubleValue() / 2);
            redCircle.setCenterX(newVal.doubleValue() / 2);
        });

        pane.heightProperty().addListener((obs, oldVal, newVal) -> {
            blueCircle.setCenterY(newVal.doubleValue() / 2);
            redCircle.setCenterY(newVal.doubleValue() / 2);
        });

        primaryStage.setTitle("Resizable Graphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MovableCircle extends Application {

    private double circleRadius = 50;
    private double circleCenterX = 300;
    private double circleCenterY = 200;
    private double moveBy = 10;

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(circleCenterX, circleCenterY, circleRadius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);

        Button upButton = new Button("Up");
        upButton.setOnAction(e -> {
            if (circle.getCenterY() - circleRadius - moveBy > 0) {
                circle.setCenterY(circle.getCenterY() - moveBy);
            }
        });

        Button downButton = new Button("Down");
        downButton.setOnAction(e -> {
            if (circle.getCenterY() + circleRadius + moveBy < 400) {  // Assuming 400 is the scene height
                circle.setCenterY(circle.getCenterY() + moveBy);
            }
        });

        Button leftButton = new Button("Left");
        leftButton.setOnAction(e -> {
            if (circle.getCenterX() - circleRadius - moveBy > 0) {
                circle.setCenterX(circle.getCenterX() - moveBy);
            }
        });

        Button rightButton = new Button("Right");
        rightButton.setOnAction(e -> {
            if (circle.getCenterX() + circleRadius + moveBy < 600) {  // Assuming 600 is the scene width
                circle.setCenterX(circle.getCenterX() + moveBy);
            }
        });

        VBox buttons = new VBox(10, upButton, downButton, leftButton, rightButton);

        Pane root = new Pane();
        root.getChildren().addAll(circle, buttons);
        buttons.relocate(10, 350);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Movable Circle with Boundary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

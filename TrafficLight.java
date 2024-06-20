import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application {

    private Circle redLight, yellowLight, greenLight;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        redLight = createLight(Color.RED);
        yellowLight = createLight(Color.YELLOW);
        greenLight = createLight(Color.GREEN);

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                activateLight(redLight);
                deactivateLight(yellowLight);
                deactivateLight(greenLight);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                activateLight(yellowLight);
                deactivateLight(redLight);
                deactivateLight(greenLight);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                activateLight(greenLight);
                deactivateLight(redLight);
                deactivateLight(yellowLight);
            }
        });

        VBox pane = new VBox(10);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(redLight, yellowLight, greenLight, rbRed, rbYellow, rbGreen);

        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createLight(Color color) {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(color.deriveColor(0, 1, 0.5, 1));
        return circle;
    }

    private void activateLight(Circle light) {
        light.setFill(((Color) light.getFill()).deriveColor(0, 1, 2, 1));
    }

    private void deactivateLight(Circle light) {
        light.setFill(((Color) light.getFill()).deriveColor(0, 1, 0.5, 1));
    }
}

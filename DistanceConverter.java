import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DistanceConverter extends Application {

    // Conversion: 1 mile = 1.60934 km
    private static final double MILES_TO_KM = 1.60934;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        HBox milesBox = new HBox(10);
        Label milesLabel = new Label("Miles:");
        TextField milesField = new TextField();
        milesBox.getChildren().addAll(milesLabel, milesField);

        HBox kmBox = new HBox(10);
        Label kmLabel = new Label("Kilometers:");
        TextField kmField = new TextField();
        kmBox.getChildren().addAll(kmLabel, kmField);

        root.getChildren().addAll(milesBox, kmBox);

        // Add listeners for auto conversion
        milesField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double miles = Double.parseDouble(newValue);
                kmField.setText(String.valueOf(miles * MILES_TO_KM));
            } catch (NumberFormatException e) {
                kmField.clear();
            }
        });

        kmField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double km = Double.parseDouble(newValue);
                milesField.setText(String.valueOf(km / MILES_TO_KM));
            } catch (NumberFormatException e) {
                milesField.clear();
            }
        });

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("Distance Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        HBox decimalBox = new HBox(10);
        Label decimalLabel = new Label("Decimal:");
        TextField decimalField = new TextField();
        decimalBox.getChildren().addAll(decimalLabel, decimalField);

        HBox hexBox = new HBox(10);
        Label hexLabel = new Label("Hex:");
        TextField hexField = new TextField();
        hexBox.getChildren().addAll(hexLabel, hexField);

        HBox binaryBox = new HBox(10);
        Label binaryLabel = new Label("Binary:");
        TextField binaryField = new TextField();
        binaryBox.getChildren().addAll(binaryLabel, binaryField);

        root.getChildren().addAll(decimalBox, hexBox, binaryBox);

        decimalField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int decimalValue = Integer.parseInt(newValue);
                hexField.setText(Integer.toHexString(decimalValue).toUpperCase());
                binaryField.setText(Integer.toBinaryString(decimalValue));
            } catch (NumberFormatException e) {
                hexField.clear();
                binaryField.clear();
            }
        });

        hexField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int decimalValue = Integer.parseInt(newValue, 16);
                decimalField.setText(String.valueOf(decimalValue));
                binaryField.setText(Integer.toBinaryString(decimalValue));
            } catch (NumberFormatException e) {
                decimalField.clear();
                binaryField.clear();
            }
        });

        binaryField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int decimalValue = Integer.parseInt(newValue, 2);
                decimalField.setText(String.valueOf(decimalValue));
                hexField.setText(Integer.toHexString(decimalValue).toUpperCase());
            } catch (NumberFormatException e) {
                decimalField.clear();
                hexField.clear();
            }
        });

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Number Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LabelProperties extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label demoLabel = new Label("Programming is fun");
        demoLabel.setFont(Font.font("Arial", 20));

        // Font
        ComboBox<String> fontNameComboBox = new ComboBox<>();
        fontNameComboBox.getItems().addAll(Font.getFamilies());
        fontNameComboBox.setValue("Arial"); // default
        fontNameComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateFont(demoLabel, newValue, demoLabel.getFont().getSize(), demoLabel.getFont().getStyle());
        });

        ComboBox<Integer> fontSizeComboBox = new ComboBox<>();
        for (int i = 8; i <= 72; i += 2) {
            fontSizeComboBox.getItems().add(i);
        }
        fontSizeComboBox.setValue(20);
        fontSizeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateFont(demoLabel, demoLabel.getFont().getFamily(), newValue, demoLabel.getFont().getStyle());
        });

        // Bold and Italic
        CheckBox boldCheckBox = new CheckBox("Bold");
        CheckBox italicCheckBox = new CheckBox("Italic");
        boldCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            updateFont(demoLabel, demoLabel.getFont().getFamily(), demoLabel.getFont().getSize(), getFontStyle(boldCheckBox, italicCheckBox));
        });
        italicCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            updateFont(demoLabel, demoLabel.getFont().getFamily(), demoLabel.getFont().getSize(), getFontStyle(boldCheckBox, italicCheckBox));
        });

        root.getChildren().addAll(demoLabel, fontNameComboBox, fontSizeComboBox, boldCheckBox, italicCheckBox);
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Exercise 16_14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateFont(Label label, String family, double size, String style) {
        FontWeight weight = FontWeight.NORMAL;
        FontPosture posture = FontPosture.REGULAR;

        if (style.contains("Bold")) {
            weight = FontWeight.BOLD;
        }
        if (style.contains("Italic")) {
            posture = FontPosture.ITALIC;
        }

        label.setFont(Font.font(family, weight, posture, size));
    }

    private String getFontStyle(CheckBox bold, CheckBox italic) {
        String style = "";
        if (bold.isSelected()) {
            style += "Bold";
        }
        if (italic.isSelected()) {
            style += " Italic";
        }
        return style.trim();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

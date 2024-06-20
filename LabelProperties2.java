import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class LabelProperties2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        ImageView imageView = new ImageView(new Image("file:1.png"));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Label demoLabel = new Label("Ace of Spades", imageView);
        
        ComboBox<ContentDisplay> contentDisplayComboBox = new ComboBox<>();
        contentDisplayComboBox.getItems().addAll(ContentDisplay.values());
        contentDisplayComboBox.setValue(ContentDisplay.LEFT); // default value
        contentDisplayComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            demoLabel.setContentDisplay(newValue);
        });

        Slider gapSlider = new Slider(0, 50, 5);
        gapSlider.setShowTickLabels(true);
        gapSlider.setShowTickMarks(true);
        gapSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            demoLabel.setGraphicTextGap(newValue.doubleValue());
        });

        ComboBox<Pos> alignmentComboBox = new ComboBox<>();
        alignmentComboBox.getItems().addAll(Pos.values());
        alignmentComboBox.setValue(Pos.CENTER_LEFT); // default value
        alignmentComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            demoLabel.setAlignment(newValue);
        });

        ComboBox<TextAlignment> textAlignmentComboBox = new ComboBox<>();
        textAlignmentComboBox.getItems().addAll(TextAlignment.values());
        textAlignmentComboBox.setValue(TextAlignment.LEFT); // default value
        textAlignmentComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            demoLabel.setTextAlignment(newValue);
        });

        root.getChildren().addAll(demoLabel, contentDisplayComboBox, gapSlider, alignmentComboBox, textAlignmentComboBox);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Label Properties Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

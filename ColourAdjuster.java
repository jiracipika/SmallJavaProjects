import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColourAdjuster extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label colorLabel = new Label("Show Colors");
        colorLabel.setStyle("-fx-font-size: 24;");

        HBox redSliderContainer = createSliderWithLabel("Red:");
        Slider sliderRed = (Slider) redSliderContainer.getChildren().get(1);

        HBox greenSliderContainer = createSliderWithLabel("Green:");
        Slider sliderGreen = (Slider) greenSliderContainer.getChildren().get(1);

        HBox blueSliderContainer = createSliderWithLabel("Blue:");
        Slider sliderBlue = (Slider) blueSliderContainer.getChildren().get(1);

        HBox opacitySliderContainer = createSliderWithLabel("Opacity:");
        Slider sliderOpacity = (Slider) opacitySliderContainer.getChildren().get(1);
        sliderOpacity.setValue(1.0);

        ChangeListener<Number> listener = (obs, oldVal, newVal) -> {
            double red = sliderRed.getValue();
            double green = sliderGreen.getValue();
            double blue = sliderBlue.getValue();
            double opacity = sliderOpacity.getValue();

            colorLabel.setTextFill(Color.color(red, green, blue, opacity));
        };

        sliderRed.valueProperty().addListener(listener);
        sliderGreen.valueProperty().addListener(listener);
        sliderBlue.valueProperty().addListener(listener);
        sliderOpacity.valueProperty().addListener(listener);

        root.getChildren().addAll(colorLabel, redSliderContainer, greenSliderContainer, blueSliderContainer, opacitySliderContainer);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Colour Adjuster");
        primaryStage.show();
    }

    private HBox createSliderWithLabel(String text) {
        Slider slider = new Slider(0, 1, 0);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(0.25);
        slider.setBlockIncrement(0.1);
        slider.setPadding(new Insets(0, 20, 0, 60));
        
        Label label = new Label(text);
        label.setPadding(new Insets(0, 10, 0, 0));
        
        HBox container = new HBox(label, slider);
        VBox.setMargin(container, new Insets(5, 0, 5, 10));
        
        return container;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

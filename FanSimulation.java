import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FanSimulation extends Application {

    public void start(Stage primaryStage) throws Exception {
        FanPane fanPane = new FanPane(100);
        BorderPane borderPane = new BorderPane(fanPane);
        borderPane.setTop(fanPane.hButtons);
        borderPane.setBottom(fanPane.scrollPane);
        borderPane.setStyle("-fx-border-color: black;");

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Fan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private class FanPane extends BorderPane {
        private Circle c;
        private Arc[] blades = new Arc[4];
        private double increment = 1;

        Button playPause = new Button("Resume");
        Button reverse = new Button("Reverse");

        HBox hButtons = new HBox(playPause, reverse);
        Timeline fanTimeline;

        Slider mSlider = new Slider();
        HBox scrollPane = new HBox(mSlider);

        FanPane(double radius) {
            double w = radius * 2;
            double h = radius * 2;

            c = new Circle(w / 2, h / 2, radius, Color.TRANSPARENT);
            c.setStroke(Color.BLACK);

            double bladeRadius = radius * 0.9;
            for (int i = 0; i < blades.length; i++) {
                blades[i] = new Arc(c.getCenterX(), c.getCenterY(), bladeRadius, bladeRadius, (i * 90) + 30, 35);
                blades[i].setFill(Color.RED);
                blades[i].setType(ArcType.ROUND);
            }

            Pane pane = new Pane();
            pane.getChildren().addAll(c);
            pane.getChildren().addAll(blades);
            setCenter(pane);

            KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> spin());
            fanTimeline = new Timeline(keyFrame);
            fanTimeline.setCycleCount(Timeline.INDEFINITE);

            playPause.setOnAction(e -> {
                if (fanTimeline.getStatus() == Animation.Status.RUNNING) {
                    fanTimeline.pause();
                    playPause.setText("Resume");
                } else {
                    fanTimeline.play();
                    playPause.setText("Pause");
                }
            });

            mSlider.setMin(0);
            mSlider.setMax(35);
            mSlider.valueProperty().addListener(e -> {
                final double direction = (fanTimeline.getCurrentRate() >= 0) ? 1 : -1;
                fanTimeline.setRate(mSlider.getValue() * direction);
            });

            mSlider.setMinWidth(200);
            scrollPane.setAlignment(Pos.CENTER);
            scrollPane.setPadding(new Insets(5));

            reverse.setOnAction(e -> increment *= -1);
            hButtons.setSpacing(5);
            hButtons.setAlignment(Pos.CENTER);
            hButtons.setPadding(new Insets(2, 2, 2, 2));
        }

        private void spin() {
            for (Arc blade : blades) {
                double prevStartAngle = blade.getStartAngle();
                blade.setStartAngle(prevStartAngle - increment);
            }
        }
    }
}

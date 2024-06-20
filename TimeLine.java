import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimeLine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Line Animation");
        primaryStage.show();

        Line secondsHand = new Line(150, 150, 150, 30); //
        secondsHand.setStroke(Color.BLACK); 
        root.getChildren().add(secondsHand);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(60), secondsHand);
        rotateTransition.setByAngle(360); 
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE); 

        rotateTransition.play();
    }
}

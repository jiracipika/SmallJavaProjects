import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LineDistance extends Application {

    private Circle firstPoint = null;
    private Circle secondPoint = null;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        pane.setOnMouseClicked(e -> {
            if (firstPoint == null) {
                firstPoint = createPoint(e.getX(), e.getY());
                pane.getChildren().add(firstPoint);
            } else if (secondPoint == null) {
                secondPoint = createPoint(e.getX(), e.getY());
                pane.getChildren().add(secondPoint);
                
                Line line = new Line(firstPoint.getCenterX(), firstPoint.getCenterY(), secondPoint.getCenterX(), secondPoint.getCenterY());
                pane.getChildren().add(line);
                
                double distance = Math.sqrt(Math.pow(secondPoint.getCenterX() - firstPoint.getCenterX(), 2) +
                                            Math.pow(secondPoint.getCenterY() - firstPoint.getCenterY(), 2));
                
                Text distanceText = new Text((firstPoint.getCenterX() + secondPoint.getCenterX()) / 2,
                                             (firstPoint.getCenterY() + secondPoint.getCenterY()) / 2,
                                             String.format("%.2f", distance));
                pane.getChildren().add(distanceText);
                
                firstPoint = null;
                secondPoint = null;
            }
        });
        
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Line Distance Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createPoint(double x, double y) {
        Circle circle = new Circle(x, y, 5, Color.RED);
        return circle;
    }
}

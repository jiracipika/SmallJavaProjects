import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ProgrammingLanguagesDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();

        // Swift 
        Label swiftLabel = new Label("Swift");
        swiftLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ImageView swiftImageView = new ImageView(new Image("file:swift.png")); 
        flowPane.getChildren().addAll(swiftLabel, swiftImageView);

        // C++
        Label cppLabel = new Label("C++");
        cppLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ImageView cppImageView = new ImageView(new Image("file:cpp.png"));
        flowPane.getChildren().addAll(cppLabel, cppImageView);

        // Java 
        Label javaLabel = new Label("Java");
        javaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ImageView javaImageView = new ImageView(new Image("file:java.png")); 
        flowPane.getChildren().addAll(javaLabel, javaImageView);

        Scene scene = new Scene(flowPane, 800, 400);
        primaryStage.setTitle("Programming Languages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

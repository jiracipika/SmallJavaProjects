import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Calculate extends Application {

    private TextField tf1, tf2;
    private Text operator, result;
    private RadioButton rbMultiply, rbDivide;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        HBox inputBox = new HBox(10);
        tf1 = new TextField();
        tf2 = new TextField();
        operator = new Text(" or ");
        inputBox.getChildren().addAll(tf1, operator, tf2);
        root.setTop(inputBox);

        VBox radioBox = new VBox(10);
        rbMultiply = new RadioButton("*");
        rbDivide = new RadioButton("/");
        ToggleGroup group = new ToggleGroup();
        rbMultiply.setToggleGroup(group);
        rbDivide.setToggleGroup(group);
        
        rbMultiply.setOnAction(e -> operator.setText("*"));
        rbDivide.setOnAction(e -> operator.setText("/"));

        radioBox.getChildren().addAll(rbMultiply, rbDivide);
        root.setCenter(radioBox);

        // Result Text and Calculate Button
        result = new Text();
        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(new CalculateBtHandler());
        VBox resultBox = new VBox(10, result, calculateBtn);
        root.setBottom(resultBox);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class CalculateBtHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(tf1.getText());
                double num2 = Double.parseDouble(tf2.getText());
                double answer;

                if (operator.getText().equals("*")) {
                    answer = num1 * num2;
                    result.setText(String.valueOf(answer));
                } else if (operator.getText().equals("/")) {
                    if (num2 == 0) {
                        result.setText("Error");
                        return;
                    }
                    answer = num1 / num2;
                    result.setText(String.valueOf(answer));
                }
            } catch (NumberFormatException ex) {
                result.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

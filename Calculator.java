import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField firstOperand;
    private TextField secondOperand;
    private TextField result;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        firstOperand = new TextField();
        secondOperand = new TextField();
        result = new TextField();
        result.setEditable(false);

        Label firstOperandLabel = new Label("First Operand:");
        Label secondOperandLabel = new Label("Second Operand:");
        Label resultLabel = new Label("Result:");

        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button clearButton = new Button("Clear");

        grid.add(firstOperandLabel, 0, 0);
        grid.add(firstOperand, 1, 0);
        
        grid.add(secondOperandLabel, 0, 1);
        grid.add(secondOperand, 1, 1);
        
        grid.add(resultLabel, 0, 2);
        grid.add(result, 1, 2);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addButton, subtractButton, clearButton);
        grid.add(hBox, 1, 3);

        addButton.setOnAction(e -> {
            try {
                double a = Double.parseDouble(firstOperand.getText());
                double b = Double.parseDouble(secondOperand.getText());
                result.setText(String.valueOf(a + b));
            } catch (NumberFormatException ex) {
                result.setText("Invalid Input");
            }
        });

        subtractButton.setOnAction(e -> {
            try {
                double a = Double.parseDouble(firstOperand.getText());
                double b = Double.parseDouble(secondOperand.getText());
                result.setText(String.valueOf(a - b));
            } catch (NumberFormatException ex) {
                result.setText("Invalid Input");
            }
        });

        clearButton.setOnAction(e -> {
            firstOperand.setText("");
            secondOperand.setText("");
            result.setText("");
        });

        Scene scene = new Scene(grid, 350, 200);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

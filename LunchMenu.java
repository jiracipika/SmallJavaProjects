import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LunchMenu extends Application {

    private TextArea resultTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();

        ComboBox<String> lunchMenu = new ComboBox<>();
        lunchMenu.getItems().addAll("Hot Dog", "Sandwich", "Hamburger");
        root.setTop(lunchMenu);

        resultTextArea = new TextArea();
        root.setCenter(resultTextArea);

        ToggleGroup group = new ToggleGroup();
        RadioButton coffee = new RadioButton("Coffee");
        RadioButton tea = new RadioButton("Tea");
        RadioButton pop = new RadioButton("Pop");
        coffee.setToggleGroup(group);
        tea.setToggleGroup(group);
        pop.setToggleGroup(group);
        VBox radioButtonBox = new VBox(10, coffee, tea, pop);
        radioButtonBox.setPadding(new Insets(10));
        root.setLeft(radioButtonBox);

        Button submit = new Button("Submit");
        root.setBottom(submit);
        BorderPane.setAlignment(submit, Pos.CENTER);

        submit.setOnAction(event -> calculateTotal(lunchMenu.getValue(), group));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Lunch Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateTotal(String food, ToggleGroup group) {
        double foodPrice = 0;
        double drinkPrice = 0;

        switch (food) {
            case "Hot Dog": foodPrice = 1.50; break;
            case "Sandwich": foodPrice = 2.00; break;
            case "Hamburger": foodPrice = 2.50; break;
        }

        RadioButton selectedDrink = (RadioButton) group.getSelectedToggle();
        if (selectedDrink != null) {
            switch (selectedDrink.getText()) {
                case "Coffee": drinkPrice = 1.00; break;
                case "Tea": drinkPrice = 0.75; break;
                case "Pop": drinkPrice = 1.25; break;
            }
        }

        double total = foodPrice + drinkPrice;
        resultTextArea.setText("Total is $" + total);
    }
}

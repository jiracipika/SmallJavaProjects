import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountrySelector extends Application {

    private ObservableList<String> countries = FXCollections.observableArrayList(
        "USA", "Canada", "UK", "Australia", "India", "China", "Russia", "Brazil", "South Africa", "Germany"
    );

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label lblSelectionMode = new Label("Selection Mode:");
        ComboBox<String> cbSelectionMode = new ComboBox<>();
        cbSelectionMode.getItems().addAll("Single", "Multiple");
        cbSelectionMode.setValue("Single");

        ListView<String> listView = new ListView<>(countries);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected: " + newValue);
            }
        });

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(countries.size() - 1);
        scrollBar.valueProperty().addListener((obs, oldVal, newVal) -> {
            listView.scrollTo(newVal.intValue());
        });

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(countries.size() - 1);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener((obs, oldVal, newVal) -> {
            listView.scrollTo(newVal.intValue());
        });

        cbSelectionMode.valueProperty().addListener((obs, oldVal, newVal) -> {
            if ("Single".equals(newVal)) {
                listView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
            } else if ("Multiple".equals(newVal)) {
                listView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
            }
        });

        HBox hbox = new HBox(10, lblSelectionMode, cbSelectionMode);
        VBox vboxControls = new VBox(10, hbox, listView, scrollBar, slider);
        root.getChildren().add(vboxControls);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Country Selector");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

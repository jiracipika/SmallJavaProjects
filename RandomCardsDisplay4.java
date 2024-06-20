import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardsDisplay4 extends Application {
    private static final int TOTAL_CARDS = 54;
    
    private HBox cardBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Random Cards Display");

        cardBox = new HBox(10);
        displayCards();

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayCards());

        VBox root = new VBox(10, cardBox, refreshButton);

        Scene scene = new Scene(root, 350, 150); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayCards() {
        cardBox.getChildren().clear();
        List<Integer> cards = getRandomCards(4);

        for (int cardNumber : cards) {
            Image cardImage = new Image("file:" + cardNumber + ".png");
            ImageView cardImageView = new ImageView(cardImage);
            cardBox.getChildren().add(cardImageView);
        }
    }

    private List<Integer> getRandomCards(int numberOfCards) {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cards.add(i);
        }

        Collections.shuffle(cards);

        return cards.subList(0, numberOfCards);
    }
}

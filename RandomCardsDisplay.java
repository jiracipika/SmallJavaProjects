import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardsDisplay extends Application {
    private static final int TOTAL_CARDS = 54;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Random Cards Display");

        HBox hbox = new HBox(10);

        List<Integer> cards = getThreeRandomCards();

        for (int cardNumber : cards) {
            Image cardImage = new Image("file:" + cardNumber + ".png");
            ImageView cardImageView = new ImageView(cardImage);
            hbox.getChildren().add(cardImageView);
        }

        Scene scene = new Scene(hbox, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Integer> getThreeRandomCards() {
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cards.add(i);
        }

        Collections.shuffle(cards);

        return cards.subList(0, 3);
    }
}

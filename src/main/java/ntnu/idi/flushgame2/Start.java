package ntnu.idi.flushgame2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;
import ntnu.idi.flushgame2.modules.Hand;
import ntnu.idi.flushgame2.modules.Suit;
import ntnu.idi.flushgame2.views.CardView;
import ntnu.idi.flushgame2.views.HandView;

public class Start extends Application {

  private static VBox root;
  private static DeckOfCards deck;

  @Override
  public void start(Stage stage) throws IOException {
    root = new VBox();
    root.setSpacing(20);
    root.setPadding(new Insets(40));
    root.setAlignment(Pos.TOP_CENTER);
    deck = new DeckOfCards();

    Pane cardPane = new Pane();
    root.getChildren().add(cardPane);

    Button dealButton = new Button("Deal cards");
    dealButton.setOnAction(e -> dealCards(cardPane));
    root.getChildren().add(dealButton);

    Scene scene = new Scene(root, 1000, 400);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  private static void dealCards(Pane handPane) {
    Hand hand = deck.dealHand(5);
    handPane.getChildren().clear();
    handPane.getChildren().add(HandView.getHandView(hand));

  }


  public static void main(String[] args) {
    launch();
  }
}
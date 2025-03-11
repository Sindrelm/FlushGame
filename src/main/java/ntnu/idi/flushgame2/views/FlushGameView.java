package ntnu.idi.flushgame2.views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ntnu.idi.flushgame2.Games.FlushGame;
import ntnu.idi.flushgame2.Start;
import ntnu.idi.flushgame2.modules.DeckOfCards;

public class FlushGameView {

  private static Pane handBox;
  private static DeckOfCards deck;

  public static void display() {
    deck = new DeckOfCards();
    handBox = new HBox();

    VBox flushGameBox = new VBox();
    flushGameBox.getChildren().addAll(createTitle(), handBox, createButtons());

    Start.root.getChildren().clear();
    Start.root.getChildren().addAll(flushGameBox);
  }

  public static HBox createTitle() {
    Text title = new Text("Flush Game");

    title.setFont(new Font("Arial", 50));

    HBox titlePane = new HBox();
    titlePane.getChildren().add(title);

    return titlePane;
  }

  public static HBox createButtons() {
    Button dealHandButton = new Button("Deal Hand");
    dealHandButton.setOnAction(e -> playRound());

    Button closeButton = new Button("Exit Game");
    closeButton.setOnAction(e -> closeView());

    HBox buttonsBox = new HBox();
    buttonsBox.getChildren().addAll(dealHandButton, closeButton);

    return buttonsBox;
  }

  public static void playRound() {
    deck.reShuffleCards();
    handBox.getChildren().clear();
    handBox.getChildren().add(HandView.getHandView(deck.dealHand(5)));
  }

  private static void closeView() {
    HomeView.display();
  }

}

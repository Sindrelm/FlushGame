package ntnu.idi.flushgame2.views;

import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ntnu.idi.flushgame2.Start;
import ntnu.idi.flushgame2.modules.BlackjackHand;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;

public class BlackjackView {

  private static HBox dealerHandView;
  private static HBox playerHandView;
  private static DeckOfCards deck;
  private static BlackjackHand playerHand;
  private static BlackjackHand dealerHand;

  public static void display() {

    deck = new DeckOfCards();

    playerHand = new BlackjackHand(new ArrayList<Card>());
    playerHandView = createHand();
    dealerHand = new BlackjackHand(new ArrayList<Card>());


    VBox blackJackBox = new VBox();
    blackJackBox.prefWidthProperty().bind(Start.root.widthProperty());
    blackJackBox.prefHeightProperty().bind(Start.root.heightProperty());
    blackJackBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));
    blackJackBox.setAlignment(Pos.CENTER);
    blackJackBox.setSpacing(25);

    blackJackBox.getChildren().addAll(createDealerBox(), getTitle(), playerHandView, createButtons());

    Start.root.getChildren().clear();
    Start.root.getChildren().addAll(blackJackBox);
  }

  private static void hit() {
    Card card = deck.dealCard();
    playerHand.addCard(card);
    playerHandView.getChildren().add(CardView.getCardView(card));

    if(playerHand.isBust()) {
      resultSequence("Loss");
    }
  }

  private static void stand() {
    PauseTransition wait = new PauseTransition(Duration.millis(700));

    wait.setOnFinished(event -> {
      if (dealerHand.getHandValue() < 17) {
        Card card = deck.dealCard();
        dealerHand.addCard(card);
        dealerHandView.getChildren().add(CardView.getCardView(card));

        if (!dealerHand.isBust()) {
          wait.play();
          return;
        }
      }

      if (dealerHand.isBust()) {
        resultSequence("Win");
      } else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
        resultSequence("Loss");
      } else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
        resultSequence("Win");
      } else {
        resultSequence("Draw");
      }
    });

    wait.play();
  }

  private static void resultSequence(String resultText) {
    Text title = new Text(resultText);
    Text titleAccent = new Text(resultText);
    title.setFill(Color.PURPLE);
    titleAccent.setFill(Color.CORNFLOWERBLUE);

    title.setFont(new Font("Arial Bold", 100));
    titleAccent.setFont(new Font("Arial Bold", 100));

    title.setLineSpacing(15);
    titleAccent.setLineSpacing(15);

    StackPane titlePane = new StackPane();
    titlePane.setAlignment(Pos.CENTER);

    titlePane.getChildren().addAll(titleAccent, title);
    titleAccent.setTranslateX(3.5);
    titleAccent.setTranslateY(3.5);

    Start.root.getChildren().addAll(titlePane);
    titlePane.setOnMouseClicked(e -> resetGame(titlePane));
  }

  private static void resetGame(StackPane resultPane) {
    playerHandView.getChildren().clear();
    playerHand.resetHand();
    dealerHandView.getChildren().clear();
    dealerHand.resetHand();

    Start.root.getChildren().remove(resultPane);
  }

  private static void exit() {
    HomeView.display();
  }

  private static HBox createDealerBox() {
    dealerHandView = createHand();

    HBox dealerBox = new HBox();
    dealerBox.setSpacing(80);
    dealerBox.setAlignment(Pos.CENTER);

    dealerBox.getChildren().addAll(dealerHandView, CardView.getCardBackPane());

    return dealerBox;
  }

  private static HBox createButtons() {
    Button hitButton = new Button("Hit");
    hitButton.setOnAction(e -> hit());

    Button standButton = new Button("Stand");
    standButton.setOnAction(e -> stand());

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(e -> exit());

    HBox buttonBox = new HBox();
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setSpacing(25);
    buttonBox.getChildren().addAll(hitButton, standButton, exitButton);

    return buttonBox;
  }

  private static HBox createHand() {
    HBox handBox = new HBox();

    double handBoxWidth = 348;
    double handBoxHeight = 230;

    handBox.setMaxHeight(handBoxHeight);
    handBox.setMinHeight(handBoxHeight);
    handBox.setMaxWidth(handBoxWidth);
    handBox.setMinWidth(handBoxWidth);

    handBox.setAlignment(Pos.CENTER);
    handBox.setSpacing(-75);
    handBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), new CornerRadii(10), null)));

    return handBox;

  }

  public static StackPane getTitle() {
    Text title = new Text("Blackjack");
    Text titleAccent = new Text("Blackjack");
    title.setFill(Color.DARKRED);
    titleAccent.setFill(Color.ORANGERED);

    title.setFont(new Font("Arial Bold", 40));
    titleAccent.setFont(new Font("Arial Bold", 40));

    StackPane titlePane = new StackPane();
    titlePane.setAlignment(Pos.CENTER);

    titlePane.getChildren().addAll(titleAccent, title);
    titleAccent.setTranslateX(1.2);
    titleAccent.setTranslateY(1.2);

    return titlePane;
  }

}

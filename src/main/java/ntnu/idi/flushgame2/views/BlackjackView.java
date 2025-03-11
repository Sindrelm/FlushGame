package ntnu.idi.flushgame2.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ntnu.idi.flushgame2.Start;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;

public class BlackjackView {

  private static HBox dealerHand;
  private static HBox playerHand;
  private static DeckOfCards deck;

  public static void display() {

    deck = new DeckOfCards();

    playerHand = createHand();


    VBox blackJackBox = new VBox();
    blackJackBox.prefWidthProperty().bind(Start.root.widthProperty());
    blackJackBox.prefHeightProperty().bind(Start.root.heightProperty());
    blackJackBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));
    blackJackBox.setAlignment(Pos.CENTER);
    blackJackBox.setSpacing(25);

    blackJackBox.getChildren().addAll(createDealerBox(), getTitle(), playerHand, createButtons());

    Start.root.getChildren().clear();
    Start.root.getChildren().addAll(blackJackBox);
  }

  private static void hit() {
    Card card = deck.dealCard();
    playerHand.getChildren().add(CardView.getCardView(card));
  }

  private static void exit() {
    HomeView.display();
  }

  private static HBox createDealerBox() {
    dealerHand = createHand();

    HBox dealerBox = new HBox();
    dealerBox.setSpacing(80);
    dealerBox.setAlignment(Pos.CENTER);

    dealerBox.getChildren().addAll(dealerHand, CardView.getCardBackPane());

    return dealerBox;
  }

  private static HBox createButtons() {
    Button hitButton = new Button("Hit");
    hitButton.setOnAction(e -> hit());

    Button standButton = new Button("Stand");

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

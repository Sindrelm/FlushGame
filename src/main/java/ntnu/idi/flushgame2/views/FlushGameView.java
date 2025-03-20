package ntnu.idi.flushgame2.views;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ntnu.idi.flushgame2.Games.FlushGame;
import ntnu.idi.flushgame2.Start;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;
import ntnu.idi.flushgame2.modules.Hand;
import ntnu.idi.flushgame2.modules.Suit;

public class FlushGameView {

  private static HBox handBox;
  private static DeckOfCards deck;
  private static VBox statsBox;

  public static void display() {
    deck = new DeckOfCards();
    createHandBox();
    statsBox = new VBox();

    VBox flushGameBox = new VBox();
    flushGameBox.prefWidthProperty().bind(Start.root.widthProperty());
    flushGameBox.prefHeightProperty().bind(Start.root.heightProperty());
    flushGameBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));
    flushGameBox.setAlignment(Pos.CENTER);
    flushGameBox.setSpacing(25);

    flushGameBox.getChildren().addAll(createTitle(), createDeck(), handBox, createButtons(), statsBox);

    Start.root.getChildren().clear();
    Start.root.getChildren().addAll(flushGameBox);
  }

  public static StackPane createDeck() {
    StackPane deckPane = new StackPane();
    ImageView cardBack = CardView.getCardBack();

    double heightToWidth = 63.5/88.8;

    double height = 200;
    double width = height * heightToWidth;

    deckPane.setMaxSize(width, height);
    deckPane.setMinSize(width, height);

    cardBack.setFitHeight(height);
    cardBack.setFitWidth(width);

    Rectangle clip = new Rectangle(width, height);
    clip.setArcWidth(13);
    clip.setArcHeight(13);
    cardBack.setClip(clip);

    deckPane.getChildren().add(cardBack);

    return deckPane;
  }

  private static void createStatsBox(Hand hand) {
    statsBox.getChildren().clear();
    HBox heartsBox = new HBox();

    int handSum = hand.getHand().stream()
        .mapToInt(card -> card.getValue() == 14 ? 1 : card.getValue())
        .sum();

    hand.getHand().stream()
        .filter(card -> card.getSuit() == Suit.HEARTS)
        .map(card -> new Text(" h" + card.getValue()))
        .forEach(heartsBox.getChildren()::add);

    boolean queenOfSpades = hand.getHand().stream()
        .anyMatch(card -> card.getValue() == 12 && card.getSuit() == Suit.SPADES);

    statsBox.getChildren().add(new Text("sum of hand:" + handSum));
    statsBox.getChildren().add(heartsBox);
    statsBox.getChildren().add(new Text(queenOfSpades ? "found queen of spades" : "queen of spades not found"));
  }


  private static void createHandBox() {
    handBox = new HBox();

    double handBoxWidth = 870;
    double handBoxHeight = 230;

    handBox.setMaxHeight(handBoxHeight);
    handBox.setMinHeight(handBoxHeight);
    handBox.setMaxWidth(handBoxWidth);
    handBox.setMinWidth(handBoxWidth);

    handBox.setAlignment(Pos.CENTER);

    handBox.setBorder(new Border(new BorderStroke(
        Color.web("#FFCC00"),
        BorderStrokeStyle.SOLID,
        new CornerRadii(5),
        new BorderWidths(5)
    )));
    handBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), new CornerRadii(10), null)));
  }

  public static StackPane createTitle() {
    Text title = new Text("Flush Game");
    Text titleAccent = new Text("Flush Game");
    title.setFill(Color.DARKRED);
    titleAccent.setFill(Color.ORANGERED);

    title.setFont(new Font("Arial Bold", 50));
    titleAccent.setFont(new Font("Arial Bold", 50));

    StackPane titlePane = new StackPane();
    titlePane.setAlignment(Pos.CENTER);

    titlePane.getChildren().addAll(titleAccent, title);
    titleAccent.setTranslateX(1.5);
    titleAccent.setTranslateY(1.5);

    return titlePane;
  }

  public static HBox createButtons() {
    Button dealHandButton = new Button("Deal Hand");
    dealHandButton.setOnAction(e -> playRound());

    Button closeButton = new Button("Exit Game");
    closeButton.setOnAction(e -> closeView());

    Button createWinButton = new Button("Create Win");
    createWinButton.setOnAction(e -> createWin());

    HBox buttonsBox = new HBox();
    buttonsBox.setAlignment(Pos.CENTER);
    buttonsBox.getChildren().addAll(dealHandButton, createWinButton, closeButton);

    return buttonsBox;
  }

  public static void playRound() {
    deck.reShuffleCards();
    handBox.getChildren().clear();

    Hand hand = deck.dealHand(5);
    createStatsBox(hand);
    handBox.getChildren().add(HandView.getHandView(hand));

    if (hand.isFlush()) {
      WinView.displayWinSequence();
    }
  }

  private static void closeView() {
    HomeView.display();
  }

  private static void createWin() {
    handBox.getChildren().clear();
    ArrayList<Card> cards = new ArrayList<>();
    int i = 0;
    while(i < 5) {
      cards.add(new Card(Suit.CLUBS, i + 3));
      i ++;
    }
    Hand hand = new Hand(cards);
    handBox.getChildren().add(HandView.getHandView(hand));
    if (hand.isFlush()) {
      WinView.displayWinSequence();
    }
  }
}

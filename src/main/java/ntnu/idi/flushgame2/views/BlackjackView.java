package ntnu.idi.flushgame2.views;

import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
  private static BlackjackHand dealerHand;
  private static VBox blackJackBox;
  private static HBox buttonBox;
  private static Slider betSlider;
  private static HBox middleBox;
  private static Text betSize;
  private static int currentBet;
  private static Text playerBalance;

  public static void display() {

    deck = new DeckOfCards();

    playerHandView = createHand();
    dealerHand = new BlackjackHand(new ArrayList<Card>());

    buttonBox = new HBox();
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.setSpacing(25);

    createMiddleBox();

    blackJackBox = new VBox();
    blackJackBox.prefWidthProperty().bind(Start.root.widthProperty());
    blackJackBox.prefHeightProperty().bind(Start.root.heightProperty());
    blackJackBox.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));
    blackJackBox.setAlignment(Pos.CENTER);
    blackJackBox.setSpacing(25);

    blackJackBox.getChildren().addAll(createDealerBox(), middleBox, playerHandView, createStartButtons());

    Start.root.getChildren().clear();
    Start.root.getChildren().addAll(blackJackBox);
  }

  private static void hit() {
    Card card = deck.dealCard();
    Start.player.getBlackJackHand().addCard(card);
    playerHandView.getChildren().add(CardView.getCardView(card));

    if(Start.player.getBlackJackHand().isBust()) {
      lossSequence();
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
        winSequence();
      } else if (dealerHand.getHandValue() > Start.player.getBlackJackHand().getHandValue()) {
        lossSequence();
      } else if (dealerHand.getHandValue() < Start.player.getBlackJackHand().getHandValue()) {
        winSequence();
      } else {
        drawSequence();
      }
    });

    wait.play();
  }

  private static void deal() {
    currentBet = (int) betSlider.getValue();
    betSize.setText("Bet: " + currentBet);

    createPlayButtons();
    Card dealerCard = deck.dealCard();
    dealerHand.addCard(dealerCard);
    dealerHandView.getChildren().add(CardView.getCardView(dealerCard));

    hit();
    hit();
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

  private static void winSequence() {
    Start.player.addBalance(currentBet);
    resultSequence("Win");
  }

  private static void drawSequence() {
    resultSequence("Push");
  }

  private static void lossSequence() {
    Start.player.addBalance(-currentBet);
    resultSequence("Loss");
  }

  private static void resetGame(StackPane resultPane) {
    playerHandView.getChildren().clear();
    Start.player.getBlackJackHand().resetHand();
    dealerHandView.getChildren().clear();
    dealerHand.resetHand();

    createStartButtons();
    refreshMiddleBox();

    Start.root.getChildren().remove(resultPane);
  }

  private static void exit() {
    HomeView.display();
  }

  private static HBox createDealerBox() {
    dealerHandView = createHand();

    HBox dealerBox = new HBox();
    dealerBox.setSpacing(30);
    dealerBox.setAlignment(Pos.CENTER);

    dealerBox.getChildren().addAll(dealerHandView, CardView.getCardBackPane());

    return dealerBox;
  }

  private static HBox createStartButtons() {
    Button dealButton = new Button("Deal");
    dealButton.setOnAction(e -> deal());

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(e -> exit());

    buttonBox.getChildren().clear();
    buttonBox.getChildren().addAll(createBetSlider(), dealButton, exitButton);

    return buttonBox;
  }

  private static HBox createPlayButtons() {
    Button hitButton = new Button("Hit");
    hitButton.setOnAction(e -> hit());

    Button standButton = new Button("Stand");
    standButton.setOnAction(e -> stand());

    buttonBox.getChildren().clear();
    buttonBox.getChildren().addAll(hitButton, standButton);

    return buttonBox;
  }

  private static VBox createBetSlider() {
    betSlider = new Slider();
    betSlider.setMin(0);
    betSlider.setMax(Start.player.getBalance());
    betSlider.setValue(0);
    betSlider.setBlockIncrement(25);
    betSlider.setSnapToTicks(true);

    Text valueLabel = new Text("Bet: " + (int) betSlider.getValue());
    valueLabel.setFill(Color.YELLOW);
    valueLabel.setFont(new Font("Arial Bold", 15));

    betSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
      valueLabel.setText("Verdi: " + newValue.intValue());
    });

    VBox betSliderBox = new VBox();
    betSliderBox.setAlignment(Pos.CENTER);
    betSliderBox.getChildren().addAll(betSlider, valueLabel);

    return betSliderBox;
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

  public static void refreshMiddleBox() {
    betSize.setText("Bet: ");
    playerBalance.setText("Balance: " + Start.player.getBalance());
  }

  public static void createMiddleBox() {
    middleBox = new HBox();
    middleBox.setAlignment(Pos.CENTER);
    middleBox.setSpacing(100);

    middleBox.getChildren().addAll(betSize(), getTitle(), createPlayerBalance());

  }

  private static StackPane betSize() {
    betSize = new Text("Bet:");

    StackPane betSizePane = new StackPane();
    betSizePane.getChildren().addAll(betSize);

    betSizePane.setMaxSize(200, 40);
    betSizePane.setMinSize(200, 40);

    return betSizePane;
  }

  private static StackPane createPlayerBalance() {
    playerBalance = new Text("Balance: " + Start.player.getBalance());

    StackPane balancePane = new StackPane();
    balancePane.getChildren().add(playerBalance);

    balancePane.setMaxSize(200, 40);
    balancePane.setMinSize(200, 40);

    return balancePane;
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

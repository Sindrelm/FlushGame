package ntnu.idi.flushgame2.views;

import java.util.Objects;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.Suit;

public class CardView {

  public static VBox getCardView(Card card) {

    VBox cardBox = new VBox();
    cardBox.setSpacing(10);
    setCardSize(cardBox);
    cardBox.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, new CornerRadii(5), null)));
    cardBox.getChildren().addAll(getCardTop(card), getCardMiddle(card), getCardBottom(card));


    return cardBox;
  }

  public static ImageView getCardBack() {
    ImageView image = createImageView("/ntnu/idi/flushgame2/suitImages/cardBackImage2.png");
    return image;
  }

  private static void setCardSize(VBox cardBox) {
    double heightToWidth = 63.5/88.8;

    double height = 200;
    double width = height * heightToWidth;

    cardBox.setMaxSize(width, height);
    cardBox.setMinSize(width, height);
  }

  private static HBox getCardTop(Card card) {
    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 20);

    HBox cardTop = new HBox();
    cardTop.setAlignment(Pos.CENTER_LEFT);
    cardTop.getChildren().addAll(getCardValueText(card), suitImage);

    return cardTop;
  }

  private static Text getCardValueText(Card card) {
    Text cardValueText = new Text(getCardValueString(card.getValue()));
    cardValueText.setFont(new Font("Arial", 20));

    return cardValueText;
  }

  private static String getCardValueString(int value) {
    String valueString = null;
    if (value > 1 && value < 11) {
     valueString = "" + value;
    }
    else if (value == 14) {
      valueString = "A";
    }
    else if (value == 13) {
      valueString = "K";
    }
    else if (value == 12) {
      valueString = "Q";
    }
    else if (value == 11) {
      valueString = "J";
    }
    return valueString;
  }

  private static StackPane getCardMiddle(Card card) {
    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 120);

    StackPane cardMiddle = new StackPane();
    cardMiddle.getChildren().add(suitImage);

    return cardMiddle;
  }

  private static HBox getCardBottom(Card card) {
    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 20);

    HBox cardBottom = new HBox();
    cardBottom.setAlignment(Pos.CENTER_RIGHT);
    cardBottom.getChildren().addAll(getCardValueText(card), suitImage);

    return cardBottom;
  }

  public static ImageView getSuitImage(Suit suit) {
    ImageView suitImage = null;
    if(suit == Suit.CLUBS) {
      suitImage = createImageView("/ntnu/idi/flushgame2/suitImages/clubsImage.png");
    }
    else if(suit == Suit.HEARTS) {
      suitImage = createImageView("/ntnu/idi/flushgame2/suitImages/heartsImage.png");
    }
    else if(suit == Suit.DIAMONDS) {
      suitImage = createImageView("/ntnu/idi/flushgame2/suitImages/diamondsImage.png");

    }
    else if (suit == Suit.SPADES) {
      suitImage = createImageView("/ntnu/idi/flushgame2/suitImages/spadesImage.png");
    }
    return suitImage;
  }

  private static ImageView createImageView(String suitImageLocation) {
    return new ImageView(new Image(
        Objects.requireNonNull(CardView.class.getResourceAsStream(suitImageLocation))));
  }

  private static void setImageSize(ImageView image, double size) {
    image.setFitWidth(size);
    image.setFitHeight(size);
  }
}

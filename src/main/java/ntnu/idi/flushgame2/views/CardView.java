package ntnu.idi.flushgame2.views;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
    cardBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
    cardBox.getChildren().addAll(getCardTop(card), getCardMiddle(card), getCardBottom(card));


    return cardBox;
  }

  private static void setCardSize(VBox cardBox) {
    double heightToWidth = 63.5/88.8;

    double height = 200;
    double width = height * heightToWidth;

    cardBox.setMaxSize(width, height);
    cardBox.setMinSize(width, height);
  }

  private static HBox getCardTop(Card card) {
    Text cardValueText = new Text("" + card.getValue());
    cardValueText.setFont(new Font("Arial", 20));

    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 20);

    HBox cardTop = new HBox();
    cardTop.setAlignment(Pos.CENTER_LEFT);
    cardTop.getChildren().addAll(cardValueText, suitImage);

    return cardTop;
  }

  private static StackPane getCardMiddle(Card card) {
    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 120);

    StackPane cardMiddle = new StackPane();
    cardMiddle.getChildren().add(suitImage);

    return cardMiddle;
  }

  private static HBox getCardBottom(Card card) {
    Text cardValueText = new Text("" + card.getValue());
    cardValueText.setFont(new Font("Arial", 20));

    ImageView suitImage = getSuitImage(card.getSuit());
    setImageSize(suitImage, 20);

    HBox cardBottom = new HBox();
    cardBottom.setAlignment(Pos.CENTER_RIGHT);
    cardBottom.getChildren().addAll(cardValueText, suitImage);

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
    return new ImageView(new Image(CardView.class.getResourceAsStream(suitImageLocation)));
  }

  private static void setImageSize(ImageView image, double size) {
    image.setFitWidth(size);
    image.setFitHeight(size);
  }
}

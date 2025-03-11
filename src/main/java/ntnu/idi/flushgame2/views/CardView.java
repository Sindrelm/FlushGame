package ntnu.idi.flushgame2.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ntnu.idi.flushgame2.modules.Suit;

public class CardView {

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
}

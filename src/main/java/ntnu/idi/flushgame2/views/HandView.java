package ntnu.idi.flushgame2.views;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.FlushHand;

public class HandView {

  public static HBox getHandView(FlushHand hand) {
    HBox handBox = new HBox();
    handBox.setAlignment(Pos.CENTER);
    handBox.setSpacing(18);

    for (Card card : hand.getHand()) {
      handBox.getChildren().add(CardView.getCardView(card));
    }

    return handBox;
  }
}

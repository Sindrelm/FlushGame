package ntnu.idi.flushgame2.views;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.Hand;

public class HandView {

  public static HBox getHandView(Hand hand) {
    HBox handBox = new HBox();
    handBox.setAlignment(Pos.CENTER);
    handBox.setSpacing(18);

    for (Card card : hand.getHand()) {
      handBox.getChildren().add(CardView.getCardView(card));
    }

    return handBox;
  }
}

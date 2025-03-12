package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;

public class BlackjackHand extends Hand{

  public BlackjackHand(ArrayList<Card> hand) {
    super(hand);
  }

  public void addCard(Card card) {
    hand.add(card);
  }

  public void resetHand() {
    hand.clear();
  }

  public int getHandValue() {
    int handValue = 0;
    for (Card card : hand) {
      handValue += card.getValue();
    }
    return handValue;
  }

  public boolean isBust() {
    return getHandValue() > 21;
  }
}

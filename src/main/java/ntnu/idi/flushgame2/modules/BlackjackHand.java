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
    int aceCount = 0;
    for (Card card : hand) {
      if (card.getValue() == 14) {
        handValue += 11;
        aceCount ++;
      }
      else if (card.getValue() > 9) {
        handValue += 10;
      }
      else {
        handValue += card.getValue();
      }
    }

    while (handValue > 21 && aceCount > 0) {
      handValue -= 10;
      aceCount --;
    }

    return handValue;
  }

  public boolean isBust() {
    return getHandValue() > 21;
  }

  public boolean isBlackjack() {
    return (getHandValue() == 21 && hand.size() == 2);
  }
}

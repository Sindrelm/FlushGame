package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;

public class FlushHand extends Hand{


  public FlushHand(ArrayList<Card> hand) {
    super(hand);
  }

  public boolean isFlush() {
    int clubs = 0;
    int hearts = 0;
    int diamonds = 0;
    int spades = 0;

    for (Card card : hand) {
      Suit suit = card.getSuit();
      if (suit == Suit.CLUBS) {
        clubs ++;
      }
      else if (suit == Suit.HEARTS) {
        hearts ++;
      }
      else if (suit == Suit.DIAMONDS) {
        diamonds ++;
      }
      else if (suit == Suit.SPADES) {
        spades ++;
      }
    }
    if (diamonds >=5 || hearts >= 5 || clubs >= 5 || spades >= 5) {
      return true;
    }
    return false;
  }
}

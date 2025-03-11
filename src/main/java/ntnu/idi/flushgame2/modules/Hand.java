package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;

public class Hand {

  private ArrayList<Card> hand;

  public Hand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public boolean isFlush() {
    Suit previousSuit = hand.getFirst().getSuit();
    Suit currentSuit;

    for (Card card : hand) {
      currentSuit = card.getSuit();
      if (currentSuit != previousSuit) {
        return false;
      }
      previousSuit = currentSuit;
    }

    return true;
  }

  public ArrayList<Card> getHand() {
    return hand;
  }

}

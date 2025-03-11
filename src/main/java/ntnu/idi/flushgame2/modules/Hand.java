package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;

public abstract class Hand {

  public ArrayList<Card> hand;

  public Hand(ArrayList<Card> hand) {
    this.hand = hand;
  }

  public ArrayList<Card> getHand() {
    return hand;
  }



}

package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;

public class CardPlayer {

  Hand hand;
  double balance;

  public CardPlayer() {
    balance = 500;
  }

  public void setBlackJackHand() {
    hand = new BlackjackHand(new ArrayList<>());
  }

  public void setFlushHand() {
    hand = new FlushHand(new ArrayList<>());
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void addBalance(double amount) {
    balance += amount;
  }

  public Hand getHand() {
    return hand;
  }

  public BlackjackHand getBlackJackHand() {
    return (BlackjackHand) hand;
  }

  public double getBalance() {
    return balance;
  }


}

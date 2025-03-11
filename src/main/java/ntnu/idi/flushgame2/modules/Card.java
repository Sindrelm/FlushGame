package ntnu.idi.flushgame2.modules;

public class Card {

  private int value;
  private Suit suit;

  public Card(Suit suit, int value) {
    verifyValue(value);

    this.value = value;
    this.suit = suit;
  }

  private void verifyValue(int value) {
    if(value < 2 || value > 14) {
      throw new IllegalArgumentException("Card value must be between 2 and 14");
    }
  }

  public Suit getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }
}

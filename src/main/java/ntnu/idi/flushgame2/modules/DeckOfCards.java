package ntnu.idi.flushgame2.modules;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

  private ArrayList<Card> deck;

  public DeckOfCards() {
    deck = new ArrayList<>();
    createCards();
  }

  public void reShuffleCards() {
    deck.clear();
    createCards();
  }

  private void createCards() {
    createCardsOfSuit(Suit.CLUBS);
    createCardsOfSuit(Suit.SPADES);
    createCardsOfSuit(Suit.DIAMONDS);
    createCardsOfSuit(Suit.HEARTS);
  }

  private void createCardsOfSuit(Suit suit) {
    for (int value = 2; value <= 14; value ++) {
      deck.add(new Card(suit, value));
    }
  }

  public ArrayList<Card> getDeck() {
    return deck;
  }

  public Hand dealHand(int handSize) {
    Random random = new Random();
    ArrayList<Card> cards = new ArrayList<>();

    for(int n = 0; n < handSize; n++) {
      Card card = getDeck().get(random.nextInt(deck.size()));
      cards.add(card);
      deck.remove(card);
    }

    return new FlushHand(cards);
  }

  public Card dealCard() {
    Random random = new Random();
    Card card = getDeck().get(random.nextInt(deck.size()));
    deck.remove(card);
    return card;
  }
}

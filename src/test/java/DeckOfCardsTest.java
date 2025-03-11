import java.util.ArrayList;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

  DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    //arrange
    deckOfCards = new DeckOfCards();
  }

  @Test
  void testCreateDeck() {
    //act
    ArrayList<Card> deck = deckOfCards.getDeck();
    //assert
    assertEquals(52, deck.size());
  }

  @Test
  void testDealHand() {
    //assert1
    for (int i = 0; i < 1000; i++) {
      assertDoesNotThrow(() -> deckOfCards.dealHand(5));
      deckOfCards.reShuffleCards();
    }
    //act
    deckOfCards.dealHand(52);
    //assert2
    assertEquals(0, deckOfCards.getDeck().size());
  }


}

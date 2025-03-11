import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CardTest {

  Card card;

  @BeforeEach
  public void setUp() {
    // arrange
    card = new Card(Suit.CLUBS, 14);
  }

  @Test
  public void testInvalidCardValue() {
    // act and assert
    assertThrows(IllegalArgumentException.class, () -> new Card(Suit.CLUBS, 1));
    assertThrows(IllegalArgumentException.class, () -> new Card(Suit.CLUBS, 15));
  }

  @Test
  public void testGetSuit() {
    // act
    Suit suit = card.getSuit();
    // assert
    assertEquals(Suit.CLUBS, suit);
  }

  @Test
  public void testGetValue() {
    // act
    int value = card.getValue();
    // assert
    assertEquals(14, value);
  }

}

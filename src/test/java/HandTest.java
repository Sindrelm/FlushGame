import java.util.ArrayList;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.Hand;
import ntnu.idi.flushgame2.modules.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

  @Test
  void testCheckForFlush() {
    //arrange
    ArrayList<Card> cards1 = new ArrayList<>();
    cards1.add(new Card(Suit.CLUBS, 2));
    cards1.add(new Card(Suit.CLUBS, 3));
    cards1.add(new Card(Suit.CLUBS, 4));
    Hand hand1 = new Hand(cards1);

    ArrayList<Card> cards2 = new ArrayList<>();
    cards2.add(new Card(Suit.HEARTS, 2));
    cards2.add(new Card(Suit.HEARTS, 3));
    cards2.add(new Card(Suit.DIAMONDS, 4));
    Hand hand2 = new Hand(cards2);

    //act
    boolean flush = hand1.isFlush();
    boolean notFlush = hand2.isFlush();

    //assert
    assertTrue(flush);
    assertFalse(notFlush);
  }

}

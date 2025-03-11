package ntnu.idi.flushgame2;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.Suit;
import ntnu.idi.flushgame2.modules.BlackjackHand;

public class BlackJackTest {

  BlackjackHand hand;

  @BeforeEach
  void setUp() {
    hand = new BlackjackHand(new ArrayList<Card>());
  }

  @Test
  void testAddCard() {
    //act
    hand.addCard(new Card(Suit.CLUBS, 4));
    //assert
    assertEquals(1, hand.getHand().size());
  }

  @Test
  void testGetHandValue() {
    //arrange
    hand.addCard(new Card(Suit.CLUBS, 10));
    hand.addCard(new Card(Suit.CLUBS, 9));
    //assert
    assertEquals(19, hand.getHandValue());
  }

  @Test
  void testIsBust(){
    //arrange
    hand.addCard(new Card(Suit.CLUBS, 13));
    hand.addCard(new Card(Suit.CLUBS, 9));
    //assert
    assertTrue(hand.isBust());
  }

}

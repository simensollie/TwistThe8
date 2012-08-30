package TwistThe8;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	Deck deck;
	Deck deck2;
	
	@Test
	public void testDeck() {
		deck = new Deck(true);
		assertTrue(deck.isEmpty());
	}

	@Test
	public void testFillDeck() {
		deck = new Deck(null);
		deck.fillDeck();
		assertEquals(52, deck.cardsLeft());
	}

	@Test
	public void testTakeCard() {
		deck = new Deck(null);
		deck.addCard(new Card("Spar", 13));
		assertEquals("Spar Kong", deck.takeCard().toString());
	}

	@Test
	public void testAddCard() {
		deck = new Deck(null);
		Card card = new Card("Hjerter", 5);
		deck.addCard(card);
		assertEquals(card, deck.topCard());
	}

	@Test
	public void testTopCard() {
		deck = new Deck(null);
		deck.fillDeck();
		assertEquals("Spar Kong", deck.topCard().toString());
	}

	@Test
	public void testCardsLeft() {
		deck = new Deck(null);
		assertEquals(0, deck.cardsLeft());
		
		deck.fillDeck();
		assertEquals(52, deck.cardsLeft());
	}

	@Test
	public void testIsEmpty() {
		deck = new Deck(null);
		assertTrue(deck.isEmpty());
		
		deck.fillDeck();
		assertFalse(deck.isEmpty());
	}

	@Test
	public void testRemoveCard() {
		deck = new Deck(null);
		deck.fillDeck();
		deck.removeCard(8);
		assertEquals(51, deck.cardsLeft());
	}

}

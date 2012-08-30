package TwistThe8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jon Stødle
 * @author Simen Sollie
 * @since 2012-08-27
 */

public class Deck {
	private String[] suits;
	private ArrayList<Card> cardDeck;
	
	public Deck(Boolean fillUpDeck){
		cardDeck = new ArrayList<Card>();
		suits = new String[]{"Kløver", "Hjerter", "Ruter", "Spar"};
		
		if (fillUpDeck) fillDeck();
	}
	
	public void fillDeck(){
		//if (cardDeck.size() > 0) return;
		
		for (int i = 0; i < suits.length; i++){
			for (int j = 1; j <= 13; j++){
				cardDeck.add(new Card(suits[i], j));
			}
		}
	}
	
	public void shuffleCards(){
		Collections.shuffle(cardDeck);
	}
	
	public Card takeCard(){
		if (isEmpty()) return null;
		return cardDeck.remove(cardDeck.size() - 1);
	}
	
	public void addCard(Card paramCard){
		cardDeck.add(paramCard);
	}
	
	public Card topCard(){
		if(cardDeck.isEmpty()) return null;
		return cardDeck.get(cardDeck.size() - 1);
	}
	
	public int cardsLeft(){
		return cardDeck.size();
	}
	
	public Boolean isEmpty(){
		return cardDeck.size() <= 0;
	}
	
	public void removeCard(int paramIndex){
		/*Card remCard = null;
		for (Card card : cardDeck)
			if (card.getSuit().equals(suits) && card.getFace() == remFace)
				remCard = card;
		cardDeck.remove(remCard);
		*/
		if (paramIndex > cardsLeft()) throw new IndexOutOfBoundsException("Det er kun " + cardsLeft() + " igjen i stokken");
		else cardDeck.remove(paramIndex);
		
	}
}
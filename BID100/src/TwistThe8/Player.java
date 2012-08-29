package TwistThe8;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	String name;
	ArrayList<Card> hand;
	
	public Player(String playerName){
		name = playerName;
		hand = new ArrayList<Card>();
	}
	
	public void giveCard(Card givenCard){
		if (givenCard != null) hand.add(givenCard);
	}
	
	public String toString(){
		String outString = name;
		
		Iterator<Card> handIterator = hand.iterator();
		while (handIterator.hasNext()) {
			Card card = (Card) handIterator.next();
			outString += "\n" + card.toString();
		}
		
		return outString;
	}
}

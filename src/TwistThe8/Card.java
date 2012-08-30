package TwistThe8;

/**
 * @author Jon Stødle
 * @author Simen Sollie
 * @since 2012-08-27
 */

public final class Card {
	private String suit;
	private int face;
	
	public Card(String paramSuit, int paramNumber){
		if (paramSuit != "Kløver" && paramSuit != "Hjerter" && paramSuit != "Spar" && paramSuit != "Ruter")
			throw new IllegalArgumentException("Du har ikke lov å bruke joker!");
		suit = paramSuit;
		
		if (paramNumber < 1 || paramNumber > 13)
			throw new IllegalArgumentException("Det nummeret er ikke i en vanlig kortstokk");
		face = paramNumber;
	}

	public String getSuit() {
		return suit;
	}

	public int getFace() {
		return face;
	}
	
	public String toString(){
		String strFace = Integer.toString(face);
		
		if (face == 1) {
			strFace = "Ess";
		} else if (face == 11) {
			strFace = "Knekt";
		} else if (face == 12) {
			strFace = "Dame";
		} else if (face == 13) {
			strFace = "Kong";
		}
		
		return suit + " " + strFace;
	}
	
	public boolean equals(Object o) {
		Card c;
		
		if (o instanceof Card) {
			c = (Card)o;
			if (suit.equals(c.getSuit()) && face == c.getFace()) return true;
		}
		
		return false;
	}
}

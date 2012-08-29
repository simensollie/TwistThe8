package TwistThe8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
	ArrayList<Player> players = new ArrayList<Player>();
	Deck freshDeck = new Deck(true);
	Deck playedDeck = new Deck(false);
	Player winner = null;
	
	final String CARD_ON_TABLE = "Kortet er på bordet er %s og det er %s sin tur...";
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}
	
	public Game(){
		Scanner gameScanner = new Scanner(System.in);
		
		System.out.println("VELKOMMEN TIL VRI ÅTTER!");
		
		System.out.println("\n\nHvor mange skal spille?");
		addPlayers(gameScanner.nextInt());
		
		System.out.println("\n" + players.size() + " spillere lagt til.");
		System.out.println("\n\nKort deles ut...");
		dealCards();
		
		Iterator<Player> gameIterator = players.iterator();
		while (winner == null){
			Player currentPlayer = gameIterator.next();
			System.out.println(String.format(CARD_ON_TABLE, playedDeck.topCard(),currentPlayer.getName()));
			Iterator<Card> cardIterator = currentPlayer.getHand().iterator();
			int cardNo = 0;
			while(cardIterator.hasNext()){
				System.out.println(String.format("%s: %s", cardNo++, cardIterator.next()));
			}
			System.out.println("Velg et kort å spille...");
			int selectedAction = gameScanner.nextInt();
			playedDeck.addCard(currentPlayer.takeCard(selectedAction));
			if(!gameIterator.hasNext()) gameIterator = players.iterator();
		}
		
		gameScanner.close();
	}
	
	public void addPlayers(int playerCount){
		Scanner addPlayerScanner = new Scanner(System.in);
		
		for (int i = 0; i < playerCount; i++){
			System.out.println("Navn på spiller " + Integer.toString(i + 1));
			players.add(new Player(addPlayerScanner.nextLine()));
		}
		
		addPlayerScanner.close();
	}
	
	public void dealCards(){
		freshDeck.shuffleCards();
		
		for (int i = 0; i < 5; i++){
			Iterator<Player> dealCardsIterator = players.iterator();
			
			while (dealCardsIterator.hasNext()){
				dealCardsIterator.next().addCard(freshDeck.takeCard());
			}
		}
		
		playedDeck.addCard(freshDeck.takeCard());
	}
}

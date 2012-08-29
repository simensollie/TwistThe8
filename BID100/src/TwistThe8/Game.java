package TwistThe8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game {
	ArrayList<Player> players = new ArrayList<Player>();
	Deck freshDeck = new Deck(true);
	Deck playedDeck = new Deck(false);
	Player winner = null;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Game();
	}
	
	public Game(){
		Scanner gameScanner = new Scanner(System.in);
		
		System.out.println("Velkommen til VRI ÅTTER!");
		
		System.out.println("\n\nHvor mange skal spille?");
		int playerCount = gameScanner.nextInt();
		addPlayers(playerCount);
		
		System.out.println("\n" + players.size() + " spillere lagt til.");
		System.out.println("Kort deles ut...");
		dealCards();
		
		Iterator<Player> gameIterator = players.iterator();
		while (winner == null){
			System.out.println("\nKortet på bordet er " + playedDeck.topCard() + " og det er " + gameIterator.next().name + " sin tur...");
			
		}
	}
	
	public void addPlayers(int playerCount){
		Scanner addPlayerScanner = new Scanner(System.in);
		
		for (int i = 0; i < playerCount; i++){
			System.out.println("Navn på spiller " + Integer.toString(i + 1));
			String playerName = addPlayerScanner.nextLine();
			players.add(new Player(playerName));
		}
		
		addPlayerScanner.close();
	}
	
	public void dealCards(){
		Iterator<Player> playerIterator = players.iterator();
		
		for (int i = 0; i < 5; i++){
			while (playerIterator.hasNext()){
				playerIterator.next().hand.add(freshDeck.takeCard());
			}
		}
		
		playedDeck.addCard(freshDeck.takeCard());
	}
}

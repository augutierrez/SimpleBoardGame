//Antonio Gutierrez
//BlackJack

import java.util.*;

public class BlackJack{
	private DeckOfCards deck;
	

	public BlackJack(){
		deck = new DeckOfCards();
		deck.shuffle();

	}
	// HIT TWICE for beginning hand!
	public void hitIt2(Hand player){
		Card x = deck.deal();
		player.hit(x);
		Card y = deck.deal();
		player.hit(y);
		player.getValue();

		Scanner scan = new Scanner(System.in);
		// checks x card
		if (x.getValue() == 1){
			System.out.println("You got an ACE, would you prefer the value 1 or 11? (Type 1 or 11)");
			int answer = scan.nextInt();
			if (answer == 11){
				x.setValue(11);
			}
		}
		if (x.getValue() >= 10){
			x.setValue(10);
		}
		//checks y card
		if (y.getValue() == 1){
			System.out.println("You got an ACE, would you prefer the value 1 or 11? (Type 1 or 11)");
			int answer = scan.nextInt();
			if (answer == 11){
				y.setValue(11);
			}
		}
		if (y.getValue() >= 10){
			y.setValue(10);
		}
	}

	// hit once
	public void hitIt(Hand player){
		Card x = deck.deal();	
		player.hit(x);
	}
	

	public static void main(String[] args){
		BlackJack game = new BlackJack();
		Scanner scan = new Scanner(System.in);

		//array list of the number of players.
		ArrayList <Hand> players = new ArrayList<Hand>();
		System.out.println("How many players are playing the game?");
		int number = scan.nextInt();

		for (int x = 0; x < number; x++){
			Hand temporary = new Hand();
			players.add(temporary);
		}
		
		

		System.out.println("Welcome to BlackJack, serving first hand.");

		//CURRENT player turn!
		int player = 1;

		// number of players who lost
		int lost = 0;

		//initializing index for forloop
		int index;
	
		for (index = 0; index < players.size(); index++){
			System.out.println("Player " + player + " turn.");
			game.hitIt2(players.get(index));
			
		// while loop start
			int input = 1;
			while (input == 1){
				System.out.println("Your hand: ");
				
				System.out.println(players.get(index).getValue());
				System.out.println("What would you like to do? \n 1) Hit \n 2) Stand");
				input = scan.nextInt();

				if (input == 1){
					game.hitIt(players.get(index));
				}
					if (players.get(index).getValue2() > 21){
						System.out.println("Bust! Player " + player + " has gone over 21! You're out!");
						players.get(index).setValue(-1);
						input = 2;
						lost++;
					}
					if (players.get(index).getValue2() == 21){
						players.get(index).toString();
						System.out.println("Black Jack!");
						input = 2;
						index = players.size();
						
					}
					if (lost + 1 == players.size()){
						index = players.size();
					}
			}
			player++;
		}
		
	// This code determine the WINNER :
		int winner = 0;
		// Im assuming first player is the winner at first
		for (int b = 1; b < players.size(); b++){
			if (players.get(b).getValue2() > players.get(b-1).getValue2()){
				winner = b;
			}
		}
		int end = 1;
		int Winner = winner + 1;
		for (int c = Winner; c < players.size(); c++){
			if (players.get(winner).getValue2() == players.get(c).getValue2()){
				System.out.println("There was a tie! Play again to get a winner!");
				end = 0;
				break;
			}
		}
		while (end == 1){
			System.out.println("Player " + Winner + " won!");
			end = 0;
		}
	}
}
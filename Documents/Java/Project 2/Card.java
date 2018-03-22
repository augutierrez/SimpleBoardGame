import java.util.*;
//Cards
//Antonio Gutierrez

public class Card{
	//4 French suits
	public final static int CLUBS = 0, DIAMONDS = 1, HEARTS = 2, SPADES = 3;
	// non-numeric cards
	public final static int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
	
	// the suit of the card
	private final int suit;

	// the value of the card
	private int value;

	//constructor
	public Card(int Value, int Suit){
		this.value = Value;
		this.suit = Suit;
	}

	public int getSuit(){
		return suit;
	}

	// this is useful since we are using numbers to assign suits
	public String stringSuit(){
		switch (suit){
			case CLUBS: return "Clubs";
			case DIAMONDS: return "Diamonds";
			case HEARTS: return "Hearts";
			case SPADES: return "Spades";
			default: return "Invalid card!";
		}
	}

	public int getValue(){
		return this.value;
	}

	public int getValue2(){
		return this.value;
	}

	public void setValue(int x){
		value = x;
	}
	
	// useful since there are non-numeric cards
	public String stringValue(){
		switch (value){
			case -1: return "nothing";
			case 1: return "Ace";
			case 2: return "2";
			case 3: return "3";
			case 4: return "4";
			case 5: return "5";
			case 6: return "6";
			case 7: return "7";
			case 8: return "8";
			case 9: return "9";
			case 10: return "10";
			case 11: return "Jack";
			case 12: return "Queen";
			case 13: return "King";
			default: return "Invalid card!";
		}
	}

	public String toString(){
		return stringValue() + " of " + stringSuit();
	}
}
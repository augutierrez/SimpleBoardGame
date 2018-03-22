import java.util.*;

public class DeckOfCards{

	private ArrayList <Card> deck; // initiating the array/ deck
	private int usedCards; 

	//creating the 52 cards
	public DeckOfCards(){
		
		deck = new ArrayList<Card>(52);

		for(int x = 0; x <= 3; x++){//suits
			for(int y = 1; y <= 13; y++){//value
				deck.add( new Card(y, x));	
			}
		} 
		usedCards = 0;
	}

	//shuffling to random order
	public void shuffle() {
		Random rand = new Random();
		Collections.shuffle(deck,rand);
	}

	public boolean hasMoreCards(){
		if (usedCards < 52){
			return true;
		}
		else{
			return false;
		}
	}

	public int getNumCardsInDeck(){
		int count = 52 - usedCards;
		return count;
	}

	public Card deal(){
		Card x = deck.get(0);	
		deck.remove(0);
		return x;
	}
}
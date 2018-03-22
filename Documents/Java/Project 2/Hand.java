import java.util.*;

public class Hand{
	private ArrayList <Card> hand; //cards that the player gets

	public Hand(){
		//shuffles deck for random order of cards
		hand = new ArrayList <Card>();
		//deck.shuffle();
	}

	public void hit(Card x){
		hand.add(x);
	}

	public int getValue(){
		int value = 0;
		for (int x = 0; x < hand.size(); x++){
			value = value + hand.get(x).getValue();
			System.out.println(hand.get(x));
		}
		return value;
	}

	//for the end
	public int getValue2(){
		int value = 0;
		for (int x = 0; x < hand.size(); x++){
			value = value + hand.get(x).getValue2();
		}
		return value;
	}

	public void setValue(int Val){
		for (int y = 0; y < hand.size(); y++){
			hand.get(y).setValue(Val);
		}
	}

	public Hand Stand(){
		return null;
	}

	public String toString(){
		return hand.toString();
	}
}
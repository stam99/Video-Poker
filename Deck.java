// Create a Deck out of Card.

import java.util.Arrays;
import java.util.Collections;

public class Deck {

		private Card[] cards;
		private int top; // The index on the top of the deck

		public Deck() { // Creates new 52 card deck array
				cards = new Card[52];
	        	int k = 0;
	        	for (int i = 1; i <= 4; i++) { // Creating 52 new cards here
	            	for (int j = 1; j <= 13; j++) {
	                	cards[k] = new Card(i, j);
	                	k++;
	            	}
	        	}
	        	top = -1;
		}

		public void shuffle() { // Shuffles the deck 1000 times
			for (int i = 0; i < 1000; i++) {
	            int rand = (int)Math.floor(Math.random() * 51);
	            int otherRand = (int)Math.floor(Math.random() * 51);
	            Card temp = cards[rand];
	            cards[rand] = cards[otherRand];
	            cards[otherRand] = temp;
	        }
		}

		public Card deal() { // Deals the top cards of the deck
        top++;
        return cards[top];
    }

    public int getTop() { // Returns the index of top
        return top;
    }

    public void resetDeck() { // Shuffles the deck and resets top
        shuffle();
        top = -1;
    }
}

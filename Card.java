// Creates a Card.

public class Card implements Comparable<Card> {

		private int suit;
		private int rank;

		public Card(int s, int r) { // Make a card with suit and rank
				suit = s;
	      rank = r;
		}

		public int compareTo(Card c) { // Compares the rank of cards
	    	int result = 0;
	      if (c.rank == this.rank) { // If equals, break rank with higher suit
	          if (c.suit < this.suit) {
	              result = 1;
	          }
	          if (c.suit > this.suit) {
	              result = -1;
	          }
	      }
	      else if (c.rank < this.rank) {
	          result = 1;
	      }
	      else {
	          result = -1;
	      }
	      return result;
		}

		public String toString() { 
				String print = String.valueOf(rank);
				switch (rank) {
						case 1: print = "Ace";
								break;
						case 11: print = "Jack";
								break;
						case 12: print = "Queen";
								break;
						case 13: print = "King";
								break;
				}
				switch (suit) {
		        case 1: print += " of Clubs | ";
		            break;
		        case 2: print += " of Diamonds | ";
		            break;
		        case 3: print += " of Hearts | ";
		            break;
		        case 4: print += " of Spades | ";
		            break;
		    }
		    return print;
		}

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}

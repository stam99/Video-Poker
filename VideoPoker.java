// Plays Video Poker!

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class VideoPoker {

		private Player p;
		private Deck cards;
	  private Scanner input;
	  private boolean testing;

		public VideoPoker() {
				p = new Player();
	      cards = new Deck();
	      input = new Scanner(System.in);
	      testing = false;
		}

		public void play() {
	  		System.out.println("Welcome to Video Poker!");
	      System.out.println("Your tokens: " + p.getBankroll());
	      cards.shuffle(); // Shuffle cards.
	      char keepPlay = 'y';

	        // While the player wants to keep playing, set up game:
	      while (keepPlay == 'y') {
		    		System.out.println("How much do you want to bet? (1 to 5)");
		        int choice = input.nextInt();
		        p.bets((double) choice); // Get bet
		        p.dealNewHand(cards); // Deal hand
		        p.sortHand();
		        System.out.println(p.printHand());

		        // Exchanging the cards
		        System.out.println("How many cards do you want to exchange?");
		        int cardsToExchange = input.nextInt();
		        if (cardsToExchange != 0) { // If player wants to swap cards ...
		        		int exchanged = 0;
		        		for (int i = 0; i < p.getHand().size(); i++) {
		            		System.out.println("Swap card #" + (i + 1) + "? (y/n)");
		            		char decideToExchange = input.next().charAt(0);
		            		if (decideToExchange == 'y') {
		                		p.redraw(i - exchanged, cards.deal()); // Swap here
		                    exchanged++;
		                }
										if (exchanged == cardsToExchange) {
		                    break;
		                }
		            }
		            p.sortHand();
		            System.out.println(p.printHand()); // And give back new hand
		        }
		        // Check the hand
		        System.out.println(checkHand(p.getHand()));

		        // If player still has money left, ask if want to play more
		        if (p.getBankroll() > 0) {
		            System.out.println("You now have: " + p.getBankroll());
		            System.out.println("Play again? (y/n)");
		            keepPlay = input.next().charAt(0);
		            p.getHand().clear();
		            cards.resetDeck(); // ... Reset the deck
		        }
		            // If player has no money left, exit game.
		        else {
		            System.out.println("You have no money.");
		            keepPlay = 'n';
		        }
		    }
				System.out.println("Thanks for playing!");
		}

    // Scores and reports hand, ** NEED TO REFACTOR **
    public String checkHand(ArrayList<Card> hand) {
				Collections.sort(hand);
		    String print = "";
				if (royalFlush(hand)) {
		    		print = "You got a ROYAL FLUSH! WOW!";
		    		p.winnings(250.0);
		    }
		    else if (straightFlush(hand)) {
		        print = "You got a Straight FLUSH!";
		        p.winnings(50.0);
		    }
		    else if (fourKind(hand)) {
		        print = "You got a four of a kind!";
		        p.winnings(25.0);
		    }
		    else if (fullHouse(hand)) {
		        print = "You got a full house!";
		        p.winnings(9.0);
		    }
		    else if (flush(hand)) {
		        print = "You got a flush!";
		        p.winnings(6.0);
		    }
		    else if (straight(hand)) {
		        print = "You got a straight!";
		        p.winnings(4.0);
		    }
		    else if (threeKind(hand)) {
		        print = "You got a three of a kind!";
		        p.winnings(3.0);
		    }
		    else if (twoPairs(hand)) {
		        print = "You got two pairs.";
		        p.winnings(2.0);
		    }
		    else if (onePair(hand)) {
		        print = "You got one pair.";
		        p.winnings(1.0);
		    }
		    else {
		        print = "You got ... nothing. Sorry!";
		    }
		    return print;
		}

    // Check if hand is a royal flush
    public boolean royalFlush(ArrayList<Card> hand) {
        if (flush(hand) == true && straight(hand) == true
            && hand.get(0).getRank() + hand.get(1).getRank() == 11) {
            return true;
        }
        else {
            return false;
        }
    }
    // Check if hand is a straight flush
    public boolean straightFlush(ArrayList<Card> hand) {
        if (flush(hand) == true && straight(hand) == true) {
            return true;
        }
        return false;
    }
    // Check if hand is a four of a kind
    public boolean fourKind(ArrayList<Card> hand) {
        if (hand.get(0).getRank() == hand.get(3).getRank() ||
           hand.get(1).getRank() == hand.get(4).getRank()) {
            return true;
        }
        return false;
    }
    // Check if hand is a full house
    public boolean fullHouse(ArrayList<Card> hand) {
        if (hand.get(0).getRank() == hand.get(2).getRank() &&
           hand.get(3).getRank() == hand.get(4).getRank()) {
            return true;
        }
        if (hand.get(0).getRank() == hand.get(1).getRank() &&
           hand.get(2).getRank() == hand.get(4).getRank()) {
            return true;
        }
        return false;
    }
    // Check if hand is a flush
    public boolean flush(ArrayList<Card> hand) {
        int suit = hand.get(0).getSuit();
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
    }
    // Check if hand is a straight flush
    public boolean straight(ArrayList<Card> hand) {
        int rank = hand.get(0).getRank();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() != rank) {
                return false;
            }
            else if (hand.get(i).getRank() == 1 && hand.get(1).getRank() == 10){
                rank = 10;
            }
            else {
                rank++;
            }
        }
        return true;
    }
    // Check if hand has a three of a kind
    public boolean threeKind(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 2; i++) {
            if (hand.get(i).getRank() == hand.get(i+2).getRank()) {
                return true;
            }
        }
        return false;
    }
    // Check if hand has two pairs
    public boolean twoPairs(ArrayList<Card> hand) {
        int match = 0;
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i+1).getRank()) {
                match++;
            }
        }
        if (match == 2) {
            return true;
        }
        return false;
    }
    // Check if hand has one pair
    public boolean onePair(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getRank() == hand.get(i + 1).getRank()) {
                return true;
            }
        }
        return false;
    }
}

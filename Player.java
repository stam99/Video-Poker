// Creates a player.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Player {

		private ArrayList<Card> hand; // the player's cards
		private double bankroll;
	  private double bet;
	  private Scanner input;

		public Player() { // Creates a new player
		    bankroll = 10.0; // Player starts with 10 tokens
	      hand = new ArrayList<Card>();
		}

		public void addCard(Card c) { // Adds a card to hand
		    hand.add(c);
		}

		public void removeCard(Card c) { // Removes a card from hand
		    hand.remove(c);
	    }

    public void bets(double amt) { // Subtracts the amount bet from bankroll
        bet = amt;
        bankroll = bankroll - bet;
    }

    public void winnings(double odds) { // Multiply winnings from bet and adds
        bankroll += bet * odds;         // to bankroll
    }

    public double getBankroll() { // Returns bankroll
        return bankroll;
    }

    public void redraw(int index, Card newCard) { // Exchanges card from hand
        removeCard(hand.get(index));
        addCard(newCard);
    }

    public String printHand() { // Easily prints every element in current hand
        String print = "Your current cards are: ";
        for (Card element : hand) {
            print += element.toString();
        }
        return print;
    }

    public void dealNewHand(Deck cards) { // Deals a new hand from the deck
        for (int i = 0; i < 5; i++) {
            Card newCard = cards.deal();
            addCard(newCard);
        }
    }

    public void sortHand() { // Easily sorts current hand
        Collections.sort(hand);
    }

    public ArrayList<Card> getHand() { // Returns hand
        return hand;
    }
}

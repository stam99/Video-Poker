Video Poker!
_____________________
Instructions for running code in terminal:

javac VideoPokerTester.java . 
java VideoPokerTester . 

_____________________
Rules:
Video poker is a popular online single player casino game. The objective of the game is to acquire a certain set of cards that will yield a winning hand.

Each player starts off with an initial 10 tokens, and will bet a certain amount of tokens (1-5) each round. That amount will be subtracted from your total amount of tokens. The player then receives 5 cards from a regular 52-card deck, and has the option to exchange any one of the cards (or all of them) for another.

After you exchange your cards, the game will display your final hand and calculate the highest winning hand combination. That winning hand combination will yield a payout, which is multiplied by the amount that you initially bet at the beginning of the game. The game will keep going until the player runs out of money or decides to quit the game.

_____________________
Design choice:
I chose Java as the language of choice because it offers good class abstraction. I split the game into individual components: cards, deck, player, and the video poker game itself. Implementing the Card class as Comparable is important for the game to sort cards. The deck was implemented with an array of 52 cards, which allowed for easy lookup access. The player's hand was a dynamic ArrayList of Cards as cards in the hand were constantly being exchanged. The play() method in VideoPoker.java is the poker game itself. It is implemented with a while loop, and every iteration of the while loop is one round of Video Poker.

Given more time, I would have added more code to check for illegal input (ex: inputting a character when an int argument is demanded, or betting more money than the player has). I would have also made test cases to test custom-made poker hands, and refactored the code in the checkHand() method in VideoPoker.java to make the method and the methods below it more readable.
 
Thank you for playing!

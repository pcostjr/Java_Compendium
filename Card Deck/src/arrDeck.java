/** arr_Deck.java
 * Author: Peter Costantino
 * Created: 12.05.2025
 * Last Updated: 10.30.2025
 * Description: A simple class that makes a deck of cards using an array.
 */
import java.util.Random;

public class arrDeck
{
    // INSTANCE VARIABLES
    private Card[] deck;
    private final Random shuffler;
    private final int DECK_SIZE = 52;

    // CONSTRUCTOR
    public arrDeck() {
        // generate an empty array of 52 indexes
        deck = new Card[DECK_SIZE];
        // initialize a new Random object
        shuffler = new Random();
    }

    // populate a fresh deck of cards
    public void populateDeck() {
        int idx = 0;
        for(int suit = 1; suit <= 4; suit++) {
            for(int face = 1; face <= 13; face++) {
                // create a new card with the current face and suit values
                deck[idx] = new Card(face, suit);
                idx++;
            }
        }
    }


    // randomly shuffle the deck
    // there are better ways to do this, but this one
    // swaps values in the deck at random
    public void shuffleDeck() {
        for(int i = 0; i < DECK_SIZE; i++) {
            // choose a new random position within the length of the deck
            int newPos = shuffler.nextInt(DECK_SIZE);

            // swap the two locations around
            Card temp = deck[i];
            deck[i] = deck[newPos];
            deck[newPos] = temp;
        }
    }

    public String toString() {
        String strDeck = "";
        for(int i = 0; i < DECK_SIZE; i++) {
            strDeck += deck[i].toString() + "\n";
        }
        return strDeck;
    }

    // select a specific card from the deck
    // does not remove from the array
    public Card selectCard(int target) {
        return deck[target];
    }

    public int getDeckSize() {
        return DECK_SIZE;
    }





}

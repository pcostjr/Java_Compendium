/** Card.java
 * Author: Peter Costantino
 * Created: 12.5.22
 * Last Updated: 12.5.22
 * Description: A simple card in java that contains a face, a suit, and a toString method.
 * The face and suit are immutable after object creation, but the position can be changed.
 */
public class Card
{

    private final String[] suits = {null, "♠", "♥", "♣", "♦"};
    private final String[] faces = {null,"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private final int face;
    private final int suit;

    //Class Constructor
    // Suit Key:
    // 1 = Spades 2 = Hearts
    // 3 = Clubs 4 = Diamonds
    // Face Key:
    // A = 1, King = 13
    // Checking is handled by Deck class
    public Card(int face, int suit) {
        this.face = face;
        this.suit = suit;
    }

    //getter method instantiation
    public int getFace() {
        return face;
    }

    public int getSuit() {
        return suit;
    }

    // 1 = Spade 2 = Heart
    // 3 = Club 4 = Diamond
    public String toString() {
        return faces[face] + " of " + suits[suit];
    }
}

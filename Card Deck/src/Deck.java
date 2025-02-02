/** Deck.java
 * Author: Peter Costantino
 * Created: 12.5.22
 * Last Updated: 12.5.22
 * Description: A simple card deck that generates an unsorted deck of cards.
 */
import java.util.ArrayList;
public class Deck
{
    private ArrayList<Card> carddeck;
    //class constructor
    public Deck() {
        carddeck = new ArrayList<Card>();
        for(int o = 1; o <= 4; o++) {
            for(int i = 1; i <= 13; i++) {
                carddeck.add(new Card(i,o,-1));
            }
        }
    }

    public String toString() {
        String builder = "Card Deck: \n";
        for(Card card : carddeck) {
            builder = builder + card.toString() + "\n";
        }
        return builder;

    }

}

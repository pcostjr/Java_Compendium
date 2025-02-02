//Mortimore Snerd
//1/14/1917
// .

import java.util.Scanner;

public class gameOfCutText
{

    public static void main(String[] args)
    {
        Card[] cardDeck = new Card[52];
        cardDeck = initDeck(cardDeck);
        dumpDeck(cardDeck);
        cardDeck = popDeck(cardDeck);
        dumpDeck(cardDeck);
        cardDeck = randomizeDeck(cardDeck);
        dumpDeck(cardDeck);
        cardDeck = shuffleDeck(cardDeck);
        dumpDeck(cardDeck);
    }

    public static Card[] initDeck(Card[] deck)
    {
        for (int i = 0; i < deck.length; i++)
            deck[i] = new Card();
        return deck;
    }

    public static Card[] popDeck(Card[] deck)
    {
        int intIndex = 0;
        for (int intSuit = 0; intSuit < 4; intSuit++)
            for (int intFace = 0; intFace < 13; intFace++)
            {
                intIndex = intSuit * 13 + intFace;
                deck[intIndex].setFace(intFace);
                deck[intIndex].setSuit(intSuit);
            }
        return deck;
    }

    public static void dumpDeck (Card[] deck)
    {
        char[] chrSuits = {'♥', '♦', '♣', '♠'};
        char[] chrFace = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

        for (int i = 0; i < deck.length; i++)
            System.out.println (chrFace[deck[i].getFace()] + "\t\t" + chrSuits[deck[i].getSuit()] + "\t\t" + deck[i].getPos());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static Card[] randomizeDeck(Card[] deck)
    {
        boolean cardFound;
        int randPos;
        for (int i = 0; i < deck.length; i++)
        {
            cardFound = false;
            while (!cardFound)
            {
                randPos = (int) (Math.random() * deck.length);
                if (deck[randPos].getPos() < 0)
                {
                    deck[randPos].setPos(i);
                    cardFound = true;
                }
            }
        }
        return deck;
    }

    public static Card[] shuffleDeck(Card[] deck)
    {
        boolean cardSwap;
        cardSwap = true;
        Card tempCard;
        while (cardSwap)
        {
            cardSwap = false;
            for (int i = 0; i < deck.length - 1; i++)
            {
                if (deck[i].getPos() > deck[i + 1].getPos())
                {
                    tempCard = deck[i];
                    deck[i] = deck[i + 1];
                    deck[i + 1] = tempCard;
                    cardSwap = true;
                }
            }
        }
        return deck;
    }
}

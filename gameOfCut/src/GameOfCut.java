import java.util.Random;   //Importing Random
class GameOfCut1
{
    int intIndex;
    int intRandPos;

    static CardClass[] Deck = new CardClass[52];

    public static void main(String[] args)
    {
        final int intDeckSize = 52; int intCardPos = 0;                  //Int
        CardClass[] Deck = new CardClass[intDeckSize];               //Allowing to be able to switch between classes
        Random rand = new Random();                              //Random number gen.
        for (int i = 0; i < intDeckSize; i++)                       //Loop for the deck
            Deck[i] = new CardClass();
        for (int intSuits = 0; intSuits < 4; intSuits++)            //Loop to pass through the suits
            for (int intFace = 0; intFace < 13; intFace++)          // Loop to pass through the faces
            {
                intCardPos = 13 * intSuits + intFace;            //Finding the cards position
                Deck[intCardPos].setSuit(intSuits);               //Setting up the suits
                Deck[intCardPos].setFace(intFace);                //Setting up the faces
            }

        int intRandomIndex;                                       //Setting up the random
        for (int i = 0; i < intDeckSize; i++)                     //For loop
        {
            boolean bolCardSet = false;                         //Boolean to false
            while (! bolCardSet)                                //While loop to randomize
            {
                intRandomIndex = rand.nextInt(intDeckSize);           //Randomizing the index
                if (Deck [intRandomIndex].getpos() < 0)              //If statement to randomize the positions
                {
                    Deck [intRandomIndex].setPos(i);                 //Allowing the deck to set up the positions
                    bolCardSet = true;                                //Boolean set to true
                }
            }
        }

        boolean bolSwap = true;                             //Boolean set to true
        {
            CardClass tempCard;                             //Temp holding place
            while (bolSwap)                                 //While loop to shuffle
            {
                bolSwap = false;                                 //Setting boolean false
                for (int i = 0; i < 51; i += 1)                  //i+= 1; i++; i=i+1; are all the same
                {
                    if (Deck[i].getpos() > Deck[i + 1].getpos())
                    {
                        tempCard = Deck[i];                       //Using the temp in the deck
                        Deck[i] = Deck[i + 1];               //Sorting the deck
                        Deck[i + 1] = tempCard;              //Shuffling the deck
                        bolSwap = true;                      //Makes boolean true
                    }
                }
            }

        }
        dumpDeck(Deck);                                     //Dropping the Deck randomly
        playGame(Deck);                                     //Opening the Game
    }

    public static void dumpDeck(CardClass[] Deck)
    {
        for (int i = 0; i < Deck.length; i++)             //For loop to pass through the array
        {
            System.out.print("card " + i + ": " + Deck[i].getFace());         //Printing out the position of cards
            if ((Deck[i].getFace() >= 1) & (Deck[i].getFace() < 10))             //If else ladder used to get the faces
                System.out.print(Deck[i].getFace() + 1);
            if (Deck[i].getFace() == 0)                            //If the face is 0
                System.out.print(" A ");                            //An A will appear for the Ace
            else if (Deck[i].getFace() == 10)                    //If the face is 11
                System.out.print(" J ");                           //A J will appear for the Jack
            else if (Deck[i].getFace() == 11)                     //If the face is 11
                System.out.print(" Q ");                            //A Q will appear for the Queen
            else if (Deck[i].getFace() == 12)                     //If the face is 12
                System.out.print(" K ");                            //A K will appear for the King
            if (Deck[i].getSuit() == 0)                           //If the face is 0
                System.out.println(" of ♥ ");                     //A heart will appear
            else if (Deck[i].getSuit() == 1)                      //If the face is 1
                System.out.println(" of ♠ ");                     //A Club will appear
            else if (Deck[i].getSuit() == 2)                     //If the face is 2
                System.out.println(" of ♦ ");                     //A Diamond will appear
            else if (Deck[i].getSuit() == 3)                     //If the face is 3
                System.out.println(" of ♣ ");                    //A Spade will appear
        }
    }

    public static void playGame(CardClass[] Deck)             //playGame
    {
        int Player1pos;                                       //int for player 1 position
        int Player2pos;                                       //int for player 2 position
        CardClass Player1card = new CardClass();             //Player 1 card
        CardClass Player2card = new CardClass();            //Player 2 card

        Random rand = new Random();                          //Random number generator

        Player1pos = rand.nextInt(51);                                   //Random for player 1 card
        Player2pos = rand.nextInt(52 - Player1pos) + Player1pos;         //Random for player 2 card
        Player1card = Deck[Player1pos];                                 //Allowing Player 1 card pulled from deck
        Player2card = Deck[Player2pos];                                 //Allowing Player 2 card pulled from deck
        System.out.println(Player1pos + " " + Player2pos);              //Printing out card positions
        System.out.println("Player1card : " + Player1card.getFace() + " " + Player1card.getSuit() + " " + Player1card.getpos());        //Showing the face suit and position of the card player 1 draws
        System.out.println("Player2card : " + Player2card.getFace() + " " + Player2card.getSuit() + " " + Player2card.getpos());        //Showing the face suit and position of the card player 1 draws
        if(Player1card.getFace() > Player2card.getFace())           //Telling the game that if the face of the card is > player 2's face
            System.out.println("Player 1 wins");                     //Printing out if player 1 wins
        else if(Player1card.getFace() < Player2card.getFace())          //Telling the game that if the face of the card is < player 1's face
            System.out.println("Player 2 wins");                  //Printing out if player 2 wins
        else
            System.out.println("Draw");                      //Printing out if there is a draw
    }
}




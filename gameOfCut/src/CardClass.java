public class CardClass
{
    private int intSuit;
    private int intFace;
    private int intPos;

    public CardClass()          //Constructor
    {
        intSuit = 0;
        intFace = 0;                // Set Face Value
        intPos = -1;                //Card does not have position in deck
    }

    public int getSuit()   //Accessor
    {
        return intSuit;
    }

    public void setSuit(int suitValue)       //Mutator
    {
        intSuit = suitValue;
    }

    public int getFace()   //Accessor
    {
        return intFace;
    }
    public void setFace(int FaceValue)        //Mutator
    {
        intFace = FaceValue;
    }

    public int getpos()   //Accessor
    {
        return intPos;
    }
    public void setPos (int PosValue)        //Mutator
    {
        intPos = PosValue;
    }
}

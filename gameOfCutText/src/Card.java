public class Card
{
    private int intPos;
    private int intFace;
    private int intSuit;

    public Card()
    {
        intPos = -1;
        intFace = 0;
        intSuit = 0;
    }

    public int getPos()
    {
        return intPos;
    }

    public void setPos(int intPos)
    {
        this.intPos = intPos;
    }

    public int getFace()
    {
        return intFace;
    }

    public void setFace (int intFace)
    {
        this.intFace = intFace;
    }

    public int getSuit()
    {
        return intSuit;
    }

    public void setSuit(int intSuit)
    {
        this.intSuit = intSuit;
    }
}

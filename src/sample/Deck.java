package sample;
import java.util.Stack;

public class Deck {
    private Card [] pile;
    private Stack<Card> deck;
    private Stack<Card> discardPile;


    public Deck(int num_of_decks)
    {
        if (num_of_decks < 1)
        {
            System.out.println("INVALID CHOICE");
        }
        pile = new Card[52*num_of_decks];
        initPile();

        for (Card card : pile)
        {
            System.out.println(card);
        }
    }

    private void initPile()
    {
        for (int i = 0; i < pile.length; i++)
        {
            for (Rank value : Rank.values())
            {
                pile[i] = new Card(value);
            }
        }

    }

    public Deck(){
        this(1);
    }


    public void createDeck()
    {

    }
}

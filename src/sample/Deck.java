package sample;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private Card [] pile;
    private Stack<Card> deck;
    private int numberOfDecks;
    private Stack<Card> discardPile;


    public Deck(int num_of_decks)
    {
        deck = new Stack<>();
        discardPile = new Stack<>();
        if (num_of_decks < 1)
        {
            System.out.println("INVALID CHOICE");
        }
        numberOfDecks = num_of_decks;
        pile = new Card[52*num_of_decks];

        System.out.println(pile.length);
        initPile();
        shuffle();
        createDeck();
    }

    private void initPile()
    {
        for (int i = 0, j = 0; i < pile.length; i++,j++)
        {
            if (j >= Rank.values().length)
            {
                j = 0;
            }
            pile[i] = new Card(Rank.values()[j]);
        }
    }

    public Deck(){
        this(1);
    }

    public void shuffle()
    {
        Random rand = new Random();
        for (int i = 0; i < 100; i++)
        {
            int val1 = rand.nextInt(52);
            int val2 = rand.nextInt(52);

            swap(val1,val2);
        }
    }


    public void swap(int x1, int x2)
    {
        Card temp = pile[x1];
        pile[x1] = pile[x2];
        pile[x2] = temp;
    }


    public void createDeck()
    {
        for (Card card : pile)
        {
            deck.push(card);
        }
    }

    public int size()
    {
        return 52*numberOfDecks;
    }

    public Card get(int index)
    {
        //todo does not catch out of bounds
        return pile[index];
    }

    public Card getNextCard()
    {

        Card nextCard = deck.pop();
        discardPile.push(nextCard);
        //nextCard.showBack();
        return nextCard;



    }


    public boolean isEmpty()
    {
        System.out.println(deck.isEmpty());
        return deck.isEmpty();
    }

    public Card peek()
    {
        return deck.peek();
    }
}

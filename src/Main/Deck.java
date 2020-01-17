package Main;
import java.util.ArrayList;
import java.util.Random;

public class Deck
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	//Constructor
    public Deck()
    {
    	for (int i = 0; i < 4; i++)
    	{
            for (int j = 0; j < 13; j++)
            {
            	cards.add(new Card(i, j));
            }
        }
    }
    
    public Card draw()
    {
    	Random rand = new Random();
       	int randomCard = rand.nextInt((cards.size()));
    	Card drawCard = cards.get(randomCard);
    	//System.out.println("DREW: " + cards.get(randomCard).toString());
    	cards.remove(randomCard);
    	return drawCard;
    }
    
    public void printDeck()
    {
    	for(int i = 0; i < cards.size(); i++)
		{
			System.out.println(cards.get(i).toString());
		}
    }
}

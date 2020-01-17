package Main;
import java.util.Arrays;

public class Hand
{
	private Card[] cards = new Card[5];
	private int handRank;
	private int tieBreakerValue1;
	private int tieBreakerValue2;
	private String handOwnerName;
	
	private static String[] rank = { "High Card",
									      "Pair",
									 "Two Pairs",
							   "Three of a kind",
							          "Straight",
							          	 "Flush",
							        "Full House",
								"Four of a kind",
								"Straight Flush"};

	//Constructor
	public Hand(Deck deck, String handOwnerName)
	{
		this.handOwnerName = handOwnerName;
		for(int i = 0; i < 5; i++)
		{
			//draw card from deck
			this.cards[i] = deck.draw();
			
		}
		rankHand(this.cards);
	}
	
	//Test Constructor
	public Hand(String[] handString, String handOwnerName)
	{
		try
		{
			this.handOwnerName = handOwnerName;
			for(int i = 0; i < handString.length; i++)
			{
				cards[i] = new Card(handString[i]);
			}
			rankHand(this.cards);
	    }
		catch (NullPointerException e){
	        System.out.println("A complete hand of five cards was not created.");
	        System.exit(0);
	    }
		
	}
		
	public void printHand()
	{
		System.out.println("----------------------");
		System.out.println(handOwnerName + "hand:");
		System.out.println("----------------------");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(cards[i].valueToString() + " of " +
								cards[i].suitToString());
		}
	}

	public Card[] getCards()
	{
		return this.cards;
	}
	
	public int getHandRank()
	{
		return this.handRank;
	}
	
	public int getTieBreakerValue1()
	{
		return tieBreakerValue1;
	}
	
	public int getTieBreakerValue2()
	{
		return tieBreakerValue2;
	}
	
	public String handRankToString()
	{
		return rank[handRank];
	}
	
	public String getHandOwnerName()
	{
		return handOwnerName;
	}
		
	/**************************************************
	 * Calculate rank/value of hand according to the
	 * following rules where straight flush is highest
	 * and high card is lowest:
	 * 
	 * 
	 * 8) Straight flush: straight & a flush
	 * 7) 4 of a kind: 4x same value
	 * 6) Full house: 3 of a kind & pair
	 * 5) Flush: 5x same suit
	 * 4) Straight: 5 in a row of inc/dec value by 1
	 * 3) 3 of a kind: 3x same value
	 * 2) Two pair: two different pairs
	 * 1) Pair: 2x same value
	 * 0) High card: highest value in hand
	 **************************************************/
	
	private void rankHand(Card[] hand)
	{
		if(straightFlush(hand))
	    {
			this.handRank = 8;
	    }
		else if(fourOfKind(hand))
	    {
			this.handRank = 7;
	    }
		else if(fullHouse(hand))
	    {
			this.handRank = 6;
	    }
		else if(flush(hand))
	    {
			this.handRank = 5;
	    }
		else if(straight(hand))
	    {
			this.handRank = 4;
	    }
		else if(threeOfKind(hand))
	    {
			this.handRank = 3;
	    }
		else if(twoPair(hand))
	    {
			this.handRank = 2;
	    }
		else if(pair(hand))
	    {
			this.handRank = 1;
	    }
		else
	    {
			this.handRank = 0;
	    }
		
		
	}
	
	public boolean straightFlush(Card[] hand)
	{
		if(straight(hand) && flush(hand))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean fourOfKind(Card[] hand)
	{
		int duplicateCard = 1;

		for(int i = 0; i < 2; i++)
		{
			for(int j = i + 1; j < hand.length; j++)
			{
				if(hand[i].getValue() == hand[j].getValue())
				{
					duplicateCard++;
					if(duplicateCard == 4)
					{
						tieBreakerValue1 = hand[i].getValue();
						return true;
					}
				}
			}
			
			if(duplicateCard > 1)
			{
				break;
			}
		}
		return false;
		
	}
	
	public boolean fullHouse(Card[] hand)
	{		
		Arrays.sort(hand);
		int a = hand[0].getValue(),
		    b = hand[1].getValue(),
		    c = hand[2].getValue(),
		    d = hand[3].getValue(),
		    e = hand[4].getValue();
		
		if( ((a == b) && (a == c)) && (d == e) )				
		{
			tieBreakerValue1 = a;
			return true;
		}
		else if( (a == b) && ((c == d) && (c == e)) )
		{
			tieBreakerValue1 = d;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean flush(Card[] hand)
	{
		@SuppressWarnings("unused")
		boolean sameSuit = false;
					    
	    for (int i = 0; i < 4; i++)
	    {
	        if(hand[i].getSuit() == hand[i + 1].getSuit())
	        {
	            sameSuit = true;
	        }else
	    	{
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public boolean straight(Card[] hand)
	{
		@SuppressWarnings("unused")
		boolean consecutiveValues = false;
		
		Arrays.sort(hand);
			    
	    for (int i = 0; i < 4; i++)
	    {
	        if(hand[i].getValue() - 1 == hand[i + 1].getValue())
	        {
	            consecutiveValues = true;
	        }else
	    	{
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public boolean threeOfKind(Card[] hand)
	{
		int duplicateCard;

		for(int i = 0; i < 3; i++)
		{
			duplicateCard = 1;
			for(int j = i + 1; j < hand.length; j++)
			{
				if(hand[i].getValue() == hand[j].getValue())
				{
					duplicateCard++;
					if(duplicateCard == 3)
					{
						tieBreakerValue1 = hand[i].getValue();
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean twoPair(Card[] hand)
	{
		int pairs = 0;
		int duplicateCard;

		for(int i = 0; i < 4; i++)
		{
			duplicateCard = 1;
			for(int j = i + 1; j < hand.length; j++)
			{
				if(hand[i].getValue() == hand[j].getValue())
				{
					duplicateCard++;
					if(duplicateCard > 2)
					{
						return false;
					}
					pairs++;
					if(pairs == 2)
					{
						tieBreakerValue2 = hand[i].getValue();
						if(tieBreakerValue1 < tieBreakerValue2)
						{
							int temp = tieBreakerValue1;
							tieBreakerValue1 = tieBreakerValue2;
							tieBreakerValue2 = temp;
						}
						return true;
					}
					tieBreakerValue1 = hand[i].getValue();
				}
			}
		}
		return false;
	}
	
	public boolean pair(Card[] hand)
	{
		int duplicateCard;

		for(int i = 0; i < 4; i++)
		{
			duplicateCard = 1;
			for(int j = i + 1; j < hand.length; j++)
			{
				if(hand[i].getValue() == hand[j].getValue())
				{
					duplicateCard++;
					if(duplicateCard == 2)
					{
						tieBreakerValue1 = hand[i].getValue();
						return true;
					}
										
				}
			}
		}
		return false;
	}
		
	public Card[] sortedHand()
	{
		Card[] sortedCards = cards;
		Arrays.sort(sortedCards);
		return sortedCards;
	}
	
}

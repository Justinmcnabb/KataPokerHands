package Main;

public class CompareHands
{
	private Hand hand1;
	private Hand hand2;
	private String result;

	//Constructor
	public CompareHands(Hand hand1, Hand hand2)
	{
		this.hand1 = hand1;
		this.hand2 = hand2;
		handCompare();
	}
	
	public String getResult()
	{
		return result;
	}
	
	private void handCompare()
	{
		//check to see if hand 1 rank type beats hand 2
		if(hand1.getHandRank() > hand2.getHandRank())
		{
			//hand 1 wins with "WIN-CASE-HERE"
			result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
		}
		//check to see if hand 1 rank type beats hand 2
		else if(hand1.getHandRank() < hand2.getHandRank())
		{
			//hand 2 wins with "WIN-CASE-HERE"
			result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
		}
		//check to see if rank is equal
		else if(hand1.getHandRank() == hand2.getHandRank())
		{
			//call tie breaker
			tieBreaker();
		}
	}

	private void tieBreaker()
	{
		if(hand1.handRankToString() == "Straight Flush")
		{
			straightDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Four of a kind")
		{
			xOfKindDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Full House")
		{
			xOfKindDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Flush")
		{
			highCardDeterminingFactor();			
		}
		else if(hand1.handRankToString() == "Straight")
		{
			straightDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Three of a kind")
		{
			xOfKindDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Two Pairs")
		{
			twoPairDeterminingFactor();
		}
		else if(hand1.handRankToString() == "Pair")
		{
			pairDeterminingFactor();
		}
		else
		{
			highCardDeterminingFactor();
		}
	}
	
	private void highCardDeterminingFactor()
	{
		for(int i = 0; i < 5; i++)
		{
			if(hand1.sortedHand()[i].getValue() > hand2.sortedHand()[i].getValue())
			{
				result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString() + ": "
						+ hand1.sortedHand()[i].valueToString();
				break;
			}
			else if(hand1.sortedHand()[i].getValue() < hand2.sortedHand()[i].getValue())
			{
				result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString() + ": "
						+ hand2.sortedHand()[i].valueToString();
				break;
			}
			else if((i == 4) && (hand1.sortedHand()[i].getValue() == hand2.sortedHand()[i].getValue()))
			{
				result = "Tie";
			}
		}
	}
	
	private void straightDeterminingFactor()
	{
		if(hand1.sortedHand()[0].getValue() > hand2.sortedHand()[0].getValue())
		{
			result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
		}
		else if(hand1.sortedHand()[0].getValue() < hand2.sortedHand()[0].getValue())
		{
			result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
		}
		else
		{
			result = "Tie";
		}
	}
	
	private void xOfKindDeterminingFactor()
	{
		if(hand1.getTieBreakerValue1() > hand2.getTieBreakerValue1())
		{
			result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
		}
		else
		{
			result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
		}
	}
	
	private void twoPairDeterminingFactor()
	{
		if(hand1.getTieBreakerValue1() > hand2.getTieBreakerValue1())
		{
			result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
		}
		else if(hand1.getTieBreakerValue1() < hand2.getTieBreakerValue1())
		{
			result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
		}
		else if(hand1.getTieBreakerValue1() == hand2.getTieBreakerValue1())
		{
			if(hand1.getTieBreakerValue2() > hand2.getTieBreakerValue2())
			{
				result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
			}
			else if(hand1.getTieBreakerValue2() < hand2.getTieBreakerValue2())
			{
				result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
			}
			else if(hand1.getTieBreakerValue2() == hand2.getTieBreakerValue2())
			{
				int highCardHand1 = 0;
				int highCardHand2 = 0;
				for(int i = 0; i < 5; i++)
				{
					if(hand1.sortedHand()[i].getValue() != hand1.getTieBreakerValue1())
					{
						if(hand1.sortedHand()[i].getValue() != hand1.getTieBreakerValue2())
						{
							highCardHand1 = hand1.sortedHand()[i].getValue();
						}
					}
					else if(hand2.sortedHand()[i].getValue() != hand1.getTieBreakerValue1())
					{
						if(hand2.sortedHand()[i].getValue() != hand1.getTieBreakerValue2())
						{
							highCardHand2 = hand2.sortedHand()[i].getValue();
						}
					}
				}
				
				if(highCardHand1 > highCardHand2)
				{
					result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
				}
				else if(highCardHand1 < highCardHand2)
				{
					result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
				}else
				{
					result = "Tie";
				}
			}
		}
	}
	
	private void pairDeterminingFactor()
	{
		if(hand1.getTieBreakerValue1() > hand2.getTieBreakerValue1())
		{
			result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
		}
		else if(hand1.getTieBreakerValue1() < hand2.getTieBreakerValue1())
		{
			result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
		}
		else if(hand1.getTieBreakerValue1() == hand2.getTieBreakerValue1())
		{
			int[] highCardHand1 = new int[3];
			int[] highCardHand2 = new int[3];
			int j = 0,
			    k = 0;
			for(int i = 0; i < 5; i++)
			{
				if(hand1.sortedHand()[i].getValue() != hand1.getTieBreakerValue1())
				{
					highCardHand1[j] = hand1.sortedHand()[i].getValue();
					j++;
				}
				
				if(hand2.sortedHand()[i].getValue() != hand2.getTieBreakerValue1())
				{
					highCardHand2[k] = hand2.sortedHand()[i].getValue();
					k++;
				}
			}
			
			for(int i = 0; i < 3; i++)
			{
				if(highCardHand1[i] > highCardHand2[i])
				{
					result = hand1.getHandOwnerName() + " wins. - with " + hand1.handRankToString();
				}
				else if(highCardHand1[i] < highCardHand2[i])
				{
					result = hand2.getHandOwnerName() + " wins. - with " + hand2.handRankToString();
				}
				else if((i == 4) && (highCardHand1[i] < highCardHand2[i]))
				{
					result = "Tie";
				}
			}
		}
	}
	
	
	
}

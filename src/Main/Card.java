package Main;

public class Card implements Comparable<Card>
{
	private int value;
	private int suit;
		
	private static String[] suits = {"clubs", "diamonds", "hearts", "spades"};
	private static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	//Constructor
	public Card(int suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	//Test constructor
	public Card(String card)
	{
		String tempValue,
			   tempSuit;
		try
		{
			tempValue = card.substring(0, 1);
			tempSuit = card.substring(1, 2);
			switch (tempSuit)
			{ 
	        case "C": 
	            suit = 0; 
	            break; 
	        case "D": 
	        	suit = 1; 
	            break; 
	        case "H": 
	        	suit = 2; 
	            break; 
	        case "S": 
	        	suit = 3; 
	            break; 
	        default:
	        	System.out.println("Invalid suit entered");
	        	System.exit(0);
	        }
			
			switch (tempValue)
			{ 
	        case "2": 
	            value = 0; 
	            break; 
	        case "3": 
	        	value = 1; 
	            break; 
	        case "4": 
	        	value = 2; 
	            break; 
	        case "5": 
	        	value = 3; 
	            break;
	        case "6": 
	        	value = 4; 
	            break;
	        case "7": 
	        	value = 5; 
	            break;
	        case "8": 
	        	value = 6; 
	            break;
	        case "9": 
	        	value = 7; 
	            break;
	        case "T": 
	        	value = 8; 
	            break;
	        case "J": 
	        	value = 9; 
	            break;
	        case "Q": 
	        	value = 10; 
	            break;
	        case "K": 
	        	value = 11; 
	            break;
	        case "A": 
	        	value = 12; 
	            break;
	        default:
	        	System.out.println("Invalid value entered");
	        	System.exit(0);
	        }
	    }
		catch (StringIndexOutOfBoundsException e){
	        System.out.println("A card was incorrectly entered.");
	        System.exit(0);
	    }
		
		
	}
	
	@Override
	public int compareTo(Card compareCard)
	{
		int compareValue = ((Card) compareCard).getValue(); 
		
		//ascending order
		return compareValue - this.value;
	}
	
	public String valueToString()
	{
		return values[value];
	}

	public String suitToString()
	{
		return suits[suit];
	}

	public int getSuit() {
		return suit;
	}


	public int getValue() {
		return value;
	}

	
	
}

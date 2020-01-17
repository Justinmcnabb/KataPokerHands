package Main;

import Test.CompareHandsTest;

public class Main
{

	public static void main(String[] args)
	{		
		//JUnit tests
		CompareHandsTest test = new CompareHandsTest();
		test.testCompareHands();
		
		//create a deck of 52 cards
		Deck deck = new Deck();
		
		//draw hands from deck
		Hand black = new Hand(deck, "Black");
		Hand white = new Hand(deck, "White");
		
		System.out.println("-------------------------------");
		System.out.println("      RANDOM HAND RESULTS");
		System.out.println("-------------------------------");
		
		//compare hands
		CompareHands compare = new CompareHands(black, white);
		System.out.println(compare.getResult());

	}

}

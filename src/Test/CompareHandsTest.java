package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import Main.CompareHands;
import Main.Hand;

public class CompareHandsTest
{
	//test fixtures for test 1
	final String[] blackHand1 = {"2H", "3D", "5S", "9C", "KD"};
	final String[] whiteHand1 = {"2C", "3H", "4S", "8C", "AH"};
	//test fixtures for test 2
	final String[] blackHand2 = {"2H", "4S", "4C", "2D", "4H"};
	final String[] whiteHand2 = {"2S", "8S", "AS", "QS", "3S"};
	//test fixtures for test 3
	final String[] blackHand3 = {"2H", "3D", "5S", "9C", "KD"};
	final String[] whiteHand3 = {"2C", "3H", "4S", "8C", "KH"};
	//test fixtures for test 4
	final String[] blackHand4 = {"2H", "3D", "5S", "9C", "KD"};
	final String[] whiteHand4 = {"2D", "3H", "5C", "9S", "KH"};
	
	//hand rank tests
	final String[] testStraightFlush = {"TH", "JH", "QH", "KH", "AH"};
	final String[] testFourOfKind = {"2C", "2H", "2S", "2D", "5S"};
	final String[] testFullHouse = {"5C", "8H", "5S", "5D", "8S"};
	final String[] testFlush = {"2H", "4H", "3H", "5H", "7H"};
	final String[] testStraight = {"4C", "3H", "5S", "2D", "6S"};
	final String[] testThreeOfKind = {"8C", "4H", "4H", "4D", "2S"};
	final String[] testTwoPair = {"8C", "8D", "2H", "4D", "4S"};
	final String[] testPair = {"3H", "JH", "3S", "KH", "AH"};

	//player hands
	Hand black1 = new Hand(blackHand1, "Black");
	Hand white1 = new Hand(whiteHand1, "White");
	Hand black2 = new Hand(blackHand2, "Black");
	Hand white2 = new Hand(whiteHand2, "White");
	Hand black3 = new Hand(blackHand3, "Black");
	Hand white3 = new Hand(whiteHand3, "White");
	Hand black4 = new Hand(blackHand4, "Black");
	Hand white4 = new Hand(whiteHand4, "White");
		
	CompareHands compareHands1,
				 compareHands2,
				 compareHands3,
				 compareHands4;
	
	@Test
	public void testCompareHands()
	{
		System.out.println("-------------------------------");
		System.out.println("          TEST RESULTS");
		System.out.println("-------------------------------");
		
		compareHands1 = new CompareHands(black1, white1);
		System.out.println(compareHands1.getResult());
		assertEquals("White wins. - with High Card: Ace", compareHands1.getResult());
		
		compareHands2 = new CompareHands(black2, white2);
		System.out.println(compareHands2.getResult());
		assertEquals("Black wins. - with Full House", compareHands2.getResult());
		
		compareHands3 = new CompareHands(black3, white3);
		System.out.println(compareHands3.getResult());
		assertEquals("Black wins. - with High Card: 9", compareHands3.getResult());
		
		compareHands4 = new CompareHands(black4, white4);
		System.out.println(compareHands4.getResult());
		assertEquals("Tie", compareHands4.getResult());
		
	}
	
	@Test
	public void testStraightFlush()
	{
		Hand testStraightFlushHand = new Hand(testStraightFlush, "test");
		assertTrue("Straight flush test failed", testStraightFlushHand.straightFlush(testStraightFlushHand.getCards()));
	}
	
	@Test
	public void testFourOfKind()
	{
		Hand testFourOfKindHand = new Hand(testFourOfKind, "test");
		assertTrue("Four of a kind test failed", testFourOfKindHand.fourOfKind(testFourOfKindHand.getCards()));
	}
	
	@Test
	public void testFullHouse()
	{
		Hand testFullHouseHand = new Hand(testFullHouse, "test");
		assertTrue("Full house test failed", testFullHouseHand.fullHouse(testFullHouseHand.getCards()));
	}
	
	@Test
	public void testFlush()
	{
		Hand testFlushHand = new Hand(testFlush, "test");
		assertTrue("Flush test failed", testFlushHand.flush(testFlushHand.getCards()));
	}
	
	@Test
	public void testStraight()
	{
		Hand testStraightHand = new Hand(testStraight, "test");
		assertTrue("Straight test failed", testStraightHand.straight(testStraightHand.getCards()));
	}
	
	@Test
	public void testThreeOfKind()
	{
		Hand testThreeOfKindHand = new Hand(testThreeOfKind, "test");
		assertTrue("Three of a kind test failed", testThreeOfKindHand.threeOfKind(testThreeOfKindHand.getCards()));
	}
	
	@Test
	public void testTwoPair()
	{
		Hand testTwoPairHand = new Hand(testTwoPair, "test");
		assertTrue("Two pair test failed", testTwoPairHand.twoPair(testTwoPairHand.getCards()));
	}
	
	@Test
	public void testPair()
	{
		Hand testPairHand = new Hand(testPair, "test");
		assertTrue("Pair test failed", testPairHand.pair(testPairHand.getCards()));
	}
		
}

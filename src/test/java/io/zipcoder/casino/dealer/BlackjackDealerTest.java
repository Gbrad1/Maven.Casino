package io.zipcoder.casino.dealer;
import io.zipcoder.casino.card.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class BlackjackDealerTest {
    private static final Logger LOGGER = Logger.getLogger(BlackjackDealerTest.class.getName());

    BlackjackDealer blackjackDealer = new BlackjackDealer();

    @Test
    public void hitTest() {
        Card c = new Card("Hearts", 3);
        LOGGER.info("" + blackjackDealer.getHand());
        blackjackDealer.hit(c);
        LOGGER.info("" + blackjackDealer.getHand());

        Integer expected = 1;
        Integer actual = blackjackDealer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Card c = new Card("Spades", 10);
        Card c1 = new Card("Diamonds", 7);
        LOGGER.info("" + blackjackDealer.getHand());
        blackjackDealer.hit(c);
        blackjackDealer.hit(c1);
        LOGGER.info("" + blackjackDealer.getHand());

        Integer expected = 2;
        Integer actual = blackjackDealer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore12WithTwoAcesTest() {
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Diamonds", 1);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 12;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore16WithAceAsSecondCardTest() {
        Card c1 = new Card("Hearts", 5);
        Card c2 = new Card("Diamonds", 1);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 16;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore16WithAceAsFirstCardTest() {
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Diamonds", 5);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 16;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithJackTest() {
        Card c1 = new Card("Hearts", 11);
        Card c2 = new Card("Diamonds", 4);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithQueenTest() {
        Card c1 = new Card("Hearts", 12);
        Card c2 = new Card("Diamonds", 4);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithKingTest() {
        Card c1 = new Card("Hearts", 13);
        Card c2 = new Card("Diamonds", 4);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithNonFaceNonAceTest() {
        Card c1 = new Card("Hearts", 5);
        Card c2 = new Card("Diamonds", 4);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 9;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkForBlackjackWithJackTest() {
        Card c1 = new Card("Clubs", 1);
        Card c2 = new Card("Diamonds", 11);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 21;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkForBlackjackWithQueenTest() {
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Diamonds", 12);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 21;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkForBlackjackWithKingTest() {
        Card c1 = new Card("Spades", 1);
        Card c2 = new Card("Clubs", 13);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Integer expected = 21;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkForBlackjackUsingMethodTest() {
        Card c1 = new Card("Spades", 1);
        Card c2 = new Card("Clubs", 13);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        Assert.assertTrue(blackjackDealer.checkBlackjack());
    }

    @Test
    public void toStringTest() {
        Card c1 = new Card("Spades", 1);
        Card c2 = new Card("Clubs", 13);
        blackjackDealer.hit(c1);
        blackjackDealer.hit(c2);

        String expected = "Dealer's cards are Ace of ♠  King of ♣  and his score is 21";
        String actual = blackjackDealer.toString();

        Assert.assertEquals(expected, actual);
    }
}

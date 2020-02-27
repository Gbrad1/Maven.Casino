package io.zipcoder.casino.player;
import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;
import io.zipcoder.casino.game.BlackjackTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class BlackjackPlayerTest {
    private static final Logger LOGGER = Logger.getLogger(BlackjackPlayerTest.class.getName());

    Player player = new Player("Matt", 31);
    Hand hand = new Hand();
    BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);

    @Test
    public void getPlayerTest() {
        LOGGER.info("" + player.getName());
    }

    @Test
    public void hitTest() {
        Card c = new Card("Hearts", 3);
        LOGGER.info("" + blackjackPlayer.getHand());
        blackjackPlayer.hit(c);
        LOGGER.info("" + blackjackPlayer.getHand());

        Integer expected = 1;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Card c = new Card("Spades", 10);
        Card c1 = new Card("Diamonds", 7);
        LOGGER.info("" + blackjackPlayer.getHand());
        blackjackPlayer.hit(c);
        blackjackPlayer.hit(c1);
        LOGGER.info("" + blackjackPlayer.getHand());

        Integer expected = 2;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore12Test() {
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Diamonds", 1);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 12;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore16WithAceAsSecondCardTest() {
        Card c1 = new Card("Hearts", 5);
        Card c2 = new Card("Diamonds", 1);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 16;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScore16WithAceAsFirstCardTest() {
        Card c1 = new Card("Hearts", 1);
        Card c2 = new Card("Diamonds", 5);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 16;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithJackTest() {
        Card c1 = new Card("Hearts", 11);
        Card c2 = new Card("Diamonds", 4);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithQueenTest() {
        Card c1 = new Card("Hearts", 12);
        Card c2 = new Card("Diamonds", 4);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithKingTest() {
        Card c1 = new Card("Hearts", 13);
        Card c2 = new Card("Diamonds", 4);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 14;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreWithNonFaceNonAceTest() {
        Card c1 = new Card("Hearts", 5);
        Card c2 = new Card("Diamonds", 4);
        blackjackPlayer.hit(c1);
        blackjackPlayer.hit(c2);

        Integer expected = 9;
        Integer actual = blackjackPlayer.getScore();

        Assert.assertEquals(expected, actual);
    }

}



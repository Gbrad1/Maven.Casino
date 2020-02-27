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

    @

}



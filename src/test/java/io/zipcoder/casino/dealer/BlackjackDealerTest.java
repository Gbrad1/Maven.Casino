package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class BlackjackDealerTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackDealerTest.class.getName());

    Player player = new Player("April", 45);
    Hand hand = new Hand();
    BlackjackDealer blackjackDealer = new BlackjackDealer();

    @Test
    public void getDealerTest() {

    }

    @Test
    public void stayOn17() {
        Card c = new Card("Hearts", 10);
        Card c1 = new Card("Diamond", 7);
        blackjackDealer.hit(c);
        blackjackDealer.hit(c1);

        Integer expected = 17;
        Integer actual = blackjackDealer.getScore();

        Assert.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }


}

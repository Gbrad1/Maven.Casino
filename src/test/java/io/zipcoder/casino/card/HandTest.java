package io.zipcoder.casino.card;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.game.GoFish;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HandTest {
    @Test
    public void handConstructorTest(){
        Hand hand = new Hand();
        Assert.assertTrue(hand.getHand().isEmpty());
    }

    @Test
    public void handSetterTest(){
        Hand hand = new Hand();
        Card c1 = new Card("Hearts", 10);
        Card c2 = new Card("Clubs", 5);
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(c1);
        expected.add(c2);
        hand.setHand(expected);
        Assert.assertEquals(expected, hand.getHand());
    }
}
